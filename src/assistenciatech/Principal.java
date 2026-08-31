package assistenciatech;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		AssistenciaTecnica assistencia = new AssistenciaTecnica();
		
		boolean continuar = true;
		
		while (continuar) {
			System.out.println("===== ASSISTÊNCIA TÉCNICA =====");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar técnico");
			System.out.println("3 - Abrir ordem de serviço");
			System.out.println("4 - Listar clientes");
			System.out.println("5 - Listar técnicos");
			System.out.println("6 - Listar ordens");
			System.out.println("0 - Sair");
			
			System.out.println("Escolha uma opção:");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			
				case 0:
					continuar = false;
					break;
				
				case 1:
					System.out.println("Digite o nome do cliente:");
				    String nome = scanner.nextLine();

				    System.out.println("Digite o CPF:");
				    String cpf = scanner.nextLine();

				    System.out.println("Digite o telefone:");
				    String telefone = scanner.nextLine();

				    System.out.println("Digite o e-mail:");
				    String email = scanner.nextLine();

				    Cliente cliente = new Cliente(nome, cpf, telefone, email);

				    assistencia.adicionarCliente(cliente);
				    
					break;
					
				case 4:
					assistencia.listarClientes();
					break;
			}
				}
		}

	
	}
