package assistenciatech;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;



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
			System.out.println("7 - Atualizar status da ordem");
			System.out.println("0 - Sair");
			
			System.out.println("Escolha uma opção:");
			
			try {
				int opcao = scanner.nextInt();
				scanner.nextLine();
			
			
			switch (opcao) {
			
				case 0: {
					continuar = false;
					break;
				}
			
				
				case 1: {
					
					String nome;
					
					while (true) {
						System.out.println("Digite o nome do cliente:");
						nome = scanner.nextLine();
						
						if(nome.trim().isEmpty()) {
							System.out.println("O nome não pode ficar vazio.");
						} else if (nome.matches(".*\\d.*")) {
							System.out.println("O nome não pode conter números.");
						} else {
							break;
						}
					}

				    String cpf;
				    
				    while (true) {
				    	System.out.println("Digite o CPF:");
				    	cpf = scanner.nextLine();
				    	
				    	if(cpf.trim().isEmpty()) {
				    		System.out.println("O CPF não pode ficar vazio.");
				    	} else if (!cpf.matches("\\d{11}")) {
				    		System.out.println("O CPF deve conter 11 dígitos.");
				    	} else if (!validarCPF(cpf)) {
				    		System.out.println("CPF inválido.");
				    	} else {
				    		break;
				    	}
				    }

				   String telefone;
				   
				   while (true) {
					   System.out.println("Digite o telefone:");
					   telefone = scanner.nextLine();
					   
					   if(telefone.matches("\\d{10}|\\d{11}")) {
						   break;
					   } else {
						   System.out.println("O telefone deve conter 10 ou 11 dígitos.");
					   }
				   }

				    String email;
				    
				    while (true) {
				    	System.out.println("Digite o e-mail:");
				    	email = scanner.nextLine();
				    	
				    	if(email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
				    		break;
				    	} else {
				    		System.out.println("Digite um e-mail válido.");
				    	}
				    }

				    Cliente cliente = new Cliente(nome, cpf, telefone, email);

				    assistencia.adicionarCliente(cliente);
				    
					break;
				
				}
				
				case 2: {
					
					String nome;

					while (true) {
					    System.out.println("Digite o nome do técnico:");
					    nome = scanner.nextLine();

					    if (nome.trim().isEmpty()) {
					        System.out.println("O nome não pode ficar vazio.");
					    } else if (nome.matches(".*\\d.*")) {
					        System.out.println("O nome não pode conter números.");
					    } else {
					        break;
					    }
					}
					
					String cpf;

					while (true) {
					    System.out.println("Digite o CPF:");
					    cpf = scanner.nextLine();

					    if (cpf.trim().isEmpty()) {
					        System.out.println("O CPF não pode ficar vazio.");
					    } else if (!cpf.matches("\\d{11}")) {
					        System.out.println("O CPF deve conter 11 dígitos.");
					    } else if (!validarCPF(cpf)) {
					        System.out.println("CPF inválido.");
					    } else {
					        break;
					    }
					}
					
					String especialidade;

					while (true) {
					    System.out.println("Digite a especialidade:");
					    especialidade = scanner.nextLine();

					    if (especialidade.trim().isEmpty()) {
					        System.out.println("A especialidade não pode ficar vazia.");
					    } else {
					        break;
					    }
					}
					
					Tecnico tecnico = new Tecnico(nome, cpf, especialidade);
					
					assistencia.adicionarTecnico(tecnico);
					
					break;
				
				}
				
				case 3: {
					
					if(!assistencia.temClientes()) {
						System.out.println("Cadastre pelo menos um cliente antes de abrir uma ordem de serviço.");
						break;
					}
					
					if(!assistencia.temTecnicos()) {
						System.out.println("Cadastre pelo menos um técnico antes de abrir uma ordem de serviço.");
						break;
					}
					
					System.out.println("===== NOVA ORDEM DE SERVIÇO =====");
					
					System.out.println("Digite o número da ordem (ou 0 para cancelar):");
					
					int numero;
					boolean cancelar = false;
					
					while (true) {
						try {
							numero = scanner.nextInt();
							scanner.nextLine();
							
							if(numero == 0) {
								cancelar = true;
								break;
							}
							
							if(numero < 0) {
								System.out.println("Número da ordem inválido.");
								continue;
							}
							
							break;
							
						} catch (InputMismatchException e) {
							System.out.println("Digite apenas números.");
							scanner.nextLine();
						}
					}
					
					if (cancelar) {
						System.out.println("Abertura de ordem cancelada.");
						break;
					}
					
					System.out.println("Digite a descrição do problema:");
					String descricaoProblema = scanner.nextLine();
					
					System.out.println("Digite o equipamento:");
					String equipamento = scanner.nextLine();
					
					String status = escolherStatus(scanner);
					
					LocalDate data = LocalDate.now();
					
					System.out.println("===== CLIENTES =====");
					assistencia.listarClientes();
					
					System.out.println("Digite o número do cliente:");
					int indiceCliente = scanner.nextInt();
					scanner.nextLine();
					
					if(indiceCliente <= 0) {
						System.out.println("Número de cliente inválido.");
						break;
					}
					
					Cliente cliente = assistencia.buscarCliente(indiceCliente - 1);
					
					if(cliente == null) {
						System.out.println("Cliente não encontrado.");
						break;
					}
					
					System.out.println("===== TÉCNICOS =====");
					assistencia.listarTecnicos();
					
					System.out.println("Digite o número do técnico:");
					int indiceTecnico = scanner.nextInt();
					scanner.nextLine();
					
					if(indiceTecnico <= 0) {
						System.out.println("Número de técnico inválido.");
						break;
					}
					
					Tecnico tecnico = assistencia.buscarTecnico(indiceTecnico - 1);
					
					if(tecnico == null) {
						System.out.println("Técnico não encontrado.");
						break;
					}
					
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
				
				case 7: {
					System.out.println("===== ATUALIZAR STATUS DA ORDEM =====");
					
					assistencia.listarOrdens();
					
					System.out.println("Digite o número da ordem que deseja atualizar: ");
					int numero = scanner.nextInt();
					scanner.nextLine();
					
					OrdemServico ordem = assistencia.buscarOrdemPorNumero(numero);
					
					if	(ordem == null) {
						System.out.println("Ordem não encontrada.");
					
						break;
					}
					
					String status = escolherStatus(scanner);
					ordem.setStatus(status);
					System.out.println("Status atualizado com sucesso!");
					
					break;
				}
					
			}
				
			} catch(InputMismatchException e) {
				System.out.println("Digite apenas números.");
				scanner.nextLine();
			}
				
			}
				}


	public static boolean validarCPF(String cpf) {
		
		if (todosDigitosIguais(cpf)) {
			return false;
		}
		
		int soma = 0;
		
		for (int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}
		
		int resto = soma % 11;
		int primeiroDigito = (resto < 2) ? 0 : 11 - resto;
		
		
		if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
			return false;
		}
		
		soma = 0;
		
		for (int i = 0; i < 10; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		
		resto = soma % 11;
		int segundoDigito = (resto < 2) ? 0 : 11 - resto;
		
		if (segundoDigito != Character.getNumericValue(cpf.charAt(10))) {
			return false;
		}
		
		return true;
	}
	
	public static boolean todosDigitosIguais(String cpf) {
		for (int i = 1; i < cpf.length(); i++) {
			if(cpf.charAt(i) != cpf.charAt(0)) {
				return false;
			}
		}
		return true;
	}
	
	public static String escolherStatus(Scanner scanner) {
		
		String status;

		while (true) {
		    System.out.println("===== STATUS DA ORDEM =====");
		    System.out.println("1 - Aberta");
		    System.out.println("2 - Em andamento");
		    System.out.println("3 - Aguardando peça");
		    System.out.println("4 - Concluída");

		    System.out.println("Escolha o status:");

		    int opcaoStatus = scanner.nextInt();
		    scanner.nextLine();

		    switch(opcaoStatus) {
		        case 1:
		            status = "Aberta";
		            break;
		        case 2:
		            status = "Em andamento";
		            break;
		        case 3:
		            status = "Aguardando peça";
		            break;
		        case 4:
		            status = "Concluída";
		            break;
		        default:
		            System.out.println("Opção de status inválida.");
		            continue;
		    }
		    return status;
		}
		
		
	}
		
}


