/**
 * 
 */
package doacoes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

public class Teste {

	public static void main(String[] args) {
		// GerirDoacoes gd = new GerirDoacoes();

		Scanner sc = new Scanner(System.in);

		int resp = -1;

		while(resp != 0) {
			try {
				do {
					System.out.println("Olá! Qual ação deseja realizar? \n" 
									+ "(1) Realizar Registro \n" 
									+ "(2) Realizar Login \n"
									+ "(0) Sair da aplicação.");

					resp = sc.nextInt();

				} while (resp < 1 && resp > 2);
			}
			catch(InputMismatchException e){
				System.out.println("ERRO. \n"
						+ "Inserçao invalida. Tente novamente digitando o número "
						+ "que está ao lado da açao que deseja realizar.");			
			}
			System.out.println(resp);
		}
		
		sc.nextLine();
		
		System.out.println(resp);

		sc.close();

	}// end of main

}// end of class
