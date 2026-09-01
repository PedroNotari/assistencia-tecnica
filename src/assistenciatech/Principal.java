package assistenciatech;
import java.time.LocalDate;
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
			
				case 0: {
					continuar = false;
					break;
				}
				
				case 1: {
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
				
				}
				
				case 2: {
					System.out.println("Digite o nome do técnico:");
					String nome = scanner.nextLine();
					
					System.out.println("Digite o CPF:");
					String cpf = scanner.nextLine();
					
					System.out.println("Digite a especialidade:");
					String especialidade = scanner.nextLine();
					
					Tecnico tecnico = new Tecnico(nome, cpf, especialidade);
					
					assistencia.adicionarTecnico(tecnico);
					
					break;
				
				}
				
				case 3: {
					System.out.println("===== NOVA ORDEM DE SERVIÇO =====");
					
					System.out.println("Digite o número da ordem:");
					int numero = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Digite a descrição do problema:");
					String descricaoProblema = scanner.nextLine();
					
					System.out.println("Digite o equipamento:");
					String equipamento = scanner.nextLine();
					
					System.out.println("Digite o status:");
					String status = scanner.nextLine();
					
					LocalDate data = LocalDate.now();
					
					System.out.println("===== CLIENTES =====");
					assistencia.listarClientes();
					
					System.out.println("Digite o número do cliente:");
					int indiceCliente = scanner.nextInt();
					scanner.nextLine();
					
					Cliente cliente = assistencia.buscarCliente(indiceCliente - 1);
					
					System.out.println("===== TÉCNICOS =====");
					assistencia.listarTecnicos();
					
					System.out.println("Digite o número do técnico:");
					int indiceTecnico = scanner.nextInt();
					scanner.nextLine();
					
					Tecnico tecnico = assistencia.buscarTecnico(indiceTecnico - 1);
					
					OrdemServico ordem = new OrdemServico(
					numero,
					descricaoProblema,
					equipamento,
					status,
					data,
					cliente,
					tecnico
					);
					
					assistencia.adicionarOrdemServico(ordem);
					System.out.println("Ordem de serviço criada com sucesso!");
					
					break;
				}
					
				case 4: {
					assistencia.listarClientes();
					break;
				
				}
				
				case 5: {
					assistencia.listarTecnicos();
					break;
					
				}
				
				case 6: {
					assistencia.listarOrdens();
					break;
					
				}
				
			}
				}
		}

	
	}
