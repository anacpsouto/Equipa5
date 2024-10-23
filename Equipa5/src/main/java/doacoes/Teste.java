package doacoes;


import java.util.List;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		GerirUtilizador g = new GerirUtilizador();
		while (true) {
			System.out.println("""
					\n
					1. Registar
					2. Login
					3. Sair
					""");
			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 3)
				break;

			switch (opcao) {
			case 1 -> {
				System.out.println("Email:");
				String email = sc.nextLine();
				System.out.println("Pass:");
				String pass = sc.nextLine();
				g.adicionarUtilizador(email, pass);
			}
			case 2 -> {
				System.out.println("Email:");
				String email = sc.nextLine();
				System.out.println("Pass:");
				String pass = sc.nextLine();
				if (g.pesquisar(email, pass) != null) {
					int opcaomenu2 = 0;
					while (true) {
						System.out.println("""
								\n
								1. Adicionar Equipamento
								2. Ver Equipamentos
								3. Pesquisar utilizador por email
								4. Solicitar equipamento
								5. Ver solicitações
								6. Logout
								"""); // adicionar opção de pesquisar equipamento por tipo?
						opcaomenu2 = sc.nextInt();
						sc.nextLine();

						if (opcaomenu2 == 6)
							break;

						switch (opcaomenu2) {

						case 1 -> {
							System.out.println("Nome do equipamento:");
							String nome = sc.nextLine();
							System.out.println("Ano do equipamento:");
							String ano = sc.nextLine();
							System.out.println("Modelo do equipamento: ");
							String modelo = sc.nextLine();
							System.out.println("Estado de conservação do equipamento: ");
							String estadoConservacao = sc.nextLine();

							System.out.println("É um computador ou um acessório? 1 para computador, 2 para acessório");
							int tipoEscolha = sc.nextInt();

							if (tipoEscolha == 1) {

								System.out.println("Tipo de computador (portátil ou desktop): ");
								String tipoComputador = sc.nextLine();

								System.out.println("Ram:");
								String ram = sc.nextLine();

								System.out.println("Disco:");
								String disco = sc.nextLine();

								System.out.println("Processador:");
								String processador = sc.nextLine();

								Computador equipamento = new Computador(nome, ano, modelo, estadoConservacao,
										tipoComputador, ram, disco, processador);
								g.adicionarEquipamento(email, pass, equipamento);
							}

							if (tipoEscolha == 2) {
								System.out.println("Tipo de acessório:");
								String tipoAcessorio = sc.nextLine();

								System.out.println("Alguma informação importante sobre o acessório:");
								String informacao = sc.nextLine();

								Acessorio equipamento = new Acessorio(nome, ano, modelo, estadoConservacao,
										tipoAcessorio, informacao);
								g.adicionarEquipamento(email, pass, equipamento);
							}

						}
						case 2 -> g.mostrarEquipamentos(email, pass);

						case 3 -> {
							System.out.println("Email do Utilizador:");
							String emailUtilizador = sc.nextLine();
							Utilizador u = g.pesquisarUtilizadorPorEmail(emailUtilizador);
							if (u != null) {
								System.out.println("Utilizador encontrado: " + u.getEmail());
								g.mostrarEquipamentos(u.getEmail(), u.getPassword());
							} else {
								System.out.println("Utilizador não encontrado.");
							}
						}
						case 4 -> {
							System.out.println("Email do dono do equipamento:");
							String emailDono = sc.nextLine();
							System.out.println("Nome do equipamento:");
							String equipamentoSolicitado = sc.nextLine();
							g.solicitarEquipamento(emailDono, equipamentoSolicitado);
						}

						case 5 -> g.verSolicitacoes(email, pass);

						}

					}

				} else {
					System.out.println("Login falhado");
				}
			}
			}
		}
	}
} // falta fazer com que ao aceitar uma solicitação, o equipamento vá para o array
	// de recebidos e a informação da doação vá para o array das doações
