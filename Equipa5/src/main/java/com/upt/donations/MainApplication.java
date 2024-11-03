package com.upt.donations;

import com.upt.donations.model.*;
import com.upt.donations.utils.DonationUtil;
import com.upt.donations.utils.EquipmentUtil;
import com.upt.donations.utils.UserUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
	private static final UserUtil USER_UTIL = new UserUtil();
	private static final EquipmentUtil EQUIPMENT_UTIL = new EquipmentUtil();
	private static final DonationUtil DONATION_UTIL = new DonationUtil();
	private static User currentUser = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (currentUser == null) {
				showMainMenu(scanner);
			} else if (currentUser.getUserType() == UserType.DONOR) {
				showDonorMenu(scanner);
			} else if (currentUser.getUserType() == UserType.RECIPIENT) {
				showRecipientMenu(scanner);
			} else {
				break;
			}
		}
	}

	private static void showMainMenu(Scanner scanner) {
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Exit");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1 -> registerUser(scanner);
		case 2 -> loginUser(scanner);
		case 3 -> System.exit(0);
		default -> System.out.println("Invalid choice. Please try again.");
		}
	}

	private static void registerUser(Scanner scanner) {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		System.out.print("Enter type (DONOR or RECIPIENT): ");
		UserType userType = UserType.valueOf(scanner.nextLine().toUpperCase());

		User user = new User(name, email, password, userType);
		USER_UTIL.registerUser(user);
	}

	private static void loginUser(Scanner scanner) {
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		currentUser = USER_UTIL.authenticateUser(email, password);
		if (currentUser == null) {
			System.out.println("Invalid credentials. Please try again.");
		} else {
			System.out.println("Login successful! Welcome, " + currentUser.getName());
		}
	}

	private static void showDonorMenu(Scanner scanner) {
		System.out.println("1. Add Equipment");
		System.out.println("2. Search Equipment");
		System.out.println("3. Edit Equipment");
		System.out.println("4. Delete Equipment");
		System.out.println("5. Register Donation");
		System.out.println("6. Search Donation");
		System.out.println("7. Logout");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1 -> addEquipment(scanner);
		case 2 -> searchEquipment(scanner);
		case 3 -> editEquipment(scanner);
		case 4 -> deleteEquipment(scanner);
		case 5 -> registerDonation(scanner);
		case 6 -> searchDonationsByUser(scanner);
		case 7 -> {
			currentUser = null;
			System.out.println("Logged out successfully.");
		}
		default -> System.out.println("Invalid choice. Please try again.");
		}
	}

	private static void showRecipientMenu(Scanner scanner) {
		System.out.println("1. View All Donations");
		System.out.println("2. Search Donations By Donor");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1 -> viewAllDonations();
		case 2 -> searchDonationsByUser(scanner);
		default -> System.out.println("Invalid choice!");
		}
	}

	private static void addEquipment(Scanner scanner) {
        if (currentUser.getUserType() != UserType.DONOR) {
            System.out.println("Only donors can add equipments.");
            return;
        }
        System.out.print("Enter equipment name: ");
        String name = scanner.nextLine();
        System.out.print("Enter equipment category: ");
        String category = scanner.nextLine();

        Equipment equipment = new Equipment(name, category, currentUser);
        EQUIPMENT_UTIL.saveEquipment(equipment);
    }

	private static void searchEquipment(Scanner scanner) {
        System.out.print("Enter equipment name to search: ");
        String equipmentName = scanner.nextLine();
        List<Equipment> equipmentsFound = EQUIPMENT_UTIL.searchEquipments(equipmentName);

        if (!equipmentsFound.isEmpty()) {
            EQUIPMENT_UTIL.searchEquipments(equipmentName).forEach(equipment -> System.out.println(equipment.toString()));
        } else {
            System.out.println("Equipments not found.");
        }
    }

    private static void editEquipment(Scanner scanner) {
        System.out.print("Enter equipment name to edit: ");
        String equipmentName = scanner.nextLine();
        List<Equipment> equipmentForEdition = EQUIPMENT_UTIL.searchEquipments(equipmentName);

        if (!equipmentForEdition.isEmpty()) {
            System.out.print("Enter the new equipment name: ");
            String newEquipmentName = scanner.nextLine();
            equipmentForEdition.get(0).setName(newEquipmentName);
            System.out.print("Enter the new equipment category: ");
            String newCategoryName = scanner.nextLine();
            equipmentForEdition.get(0).setCategory(newCategoryName);

            EQUIPMENT_UTIL.updateEquipment(equipmentForEdition.get(0));
        } else {
            System.out.println("Equipment not found.");
        }
    }

    private static void deleteEquipment(Scanner scanner) {
        System.out.print("Enter equipment name to delete: ");
        String equipmentName = scanner.nextLine();
        List<Equipment> equipmentForDeletion = EQUIPMENT_UTIL.searchEquipments(equipmentName);

        if (!equipmentForDeletion.isEmpty()) {
            EQUIPMENT_UTIL.deleteEquipment(equipmentForDeletion.get(0));
        } else {
            System.out.println("Equipment not found.");
        }
    }

    private static void registerDonation(Scanner scanner) {
        Donation donation = new Donation(new Date(), DonationStatus.PENDING, currentUser);

        System.out.print("Enter equipment name to include in the donation (comma-separated): ");
        String[] equipmentNames = scanner.nextLine().split(",");

        for (String equipmentName : equipmentNames) {
            donation.getEquipments().add(EQUIPMENT_UTIL.searchEquipments(equipmentName).get(0));
        }

        DONATION_UTIL.saveDonation(donation);
    }

    private static void searchDonationsByUser(Scanner scanner) {
        System.out.print("Enter donor name to search your donations: ");
        String donorName = scanner.nextLine();
        User userDonations = USER_UTIL.searchUserByName(donorName);
        DONATION_UTIL.getDonationsByUserId(userDonations.getId())
                .forEach(donation -> System.out.println(donation.toString()));
    }

    private static void viewAllDonations() {
        DONATION_UTIL.getAllDonations().forEach(donation -> System.out.println(donation.toString()));
    }

}
