package assistenciatech.ui;
import java.time.LocalDate;
import java.util.Scanner;

import assistenciatech.model.Cliente;
import assistenciatech.model.OrdemServico;
import assistenciatech.model.Tecnico;
import assistenciatech.service.AssistenciaTecnica;
import assistenciatech.model.StatusOS;

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
					cadastrarCliente(scanner, assistencia);
					break;
				
				}
				
				case 2: {
					cadastrarTecnico(scanner, assistencia);
					break;
				}
				
				case 3: {
					abrirOrdemServico(scanner, assistencia);
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
					atualizarStatusOrdem(scanner, assistencia);
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
	
	public static StatusOS escolherStatus(Scanner scanner) {
		
		StatusOS status;

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
		            status = StatusOS.ABERTA;
		            break;
		        case 2:
		            status = StatusOS.EM_ANDAMENTO;
		            break;
		        case 3:
		            status = StatusOS.AGUARDANDO_PECA;
		            break;
		        case 4:
		            status = StatusOS.CONCLUIDA;
		            break;
		        default:
		            System.out.println("Opção de status inválida.");
		            continue;
		    }
		    return status;
		}
		
		
	}
	
	private static void cadastrarCliente(Scanner scanner, AssistenciaTecnica assistencia) {
		
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
	    	} else if (assistencia.cpfClienteJaCadastrado(cpf)) {
	    		System.out.println("CPF já existe.");
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
	    
	}

	private static void cadastrarTecnico(Scanner scanner, AssistenciaTecnica assistencia) {
		
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
		    } else if (assistencia.cpfTecnicoJaCadastrado(cpf)) {
		    	System.out.println("CPF já existe.");
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
	
	}

	private static void abrirOrdemServico(Scanner scanner, AssistenciaTecnica assistencia) {
		
		if(!assistencia.temClientes()) {
			System.out.println("Cadastre pelo menos um cliente antes de abrir uma ordem de serviço.");
			return;
		}
		
		if(!assistencia.temTecnicos()) {
			System.out.println("Cadastre pelo menos um técnico antes de abrir uma ordem de serviço.");
			return;
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
		    return;
		}		
	
		System.out.println("Digite a descrição do problema:");
		String descricaoProblema = scanner.nextLine();

		System.out.println("Digite o equipamento:");
		String equipamento = scanner.nextLine();

		StatusOS status = escolherStatus(scanner);

		LocalDate data = LocalDate.now();
		
		System.out.println("===== CLIENTES =====");
		assistencia.listarClientes();

		System.out.println("Digite o número do cliente:");
		int indiceCliente = scanner.nextInt();
		scanner.nextLine();

		if(indiceCliente <= 0) {
		    System.out.println("Número de cliente inválido.");
		    return;
		}

		Cliente cliente = assistencia.buscarCliente(indiceCliente - 1);

		if(cliente == null) {
		    System.out.println("Cliente não encontrado.");
		    return;
		}

		System.out.println("===== TÉCNICOS =====");
		assistencia.listarTecnicos();

		System.out.println("Digite o número do técnico:");
		int indiceTecnico = scanner.nextInt();
		scanner.nextLine();

		if(indiceTecnico <= 0) {
		    System.out.println("Número de técnico inválido.");
		    return;
		}

		Tecnico tecnico = assistencia.buscarTecnico(indiceTecnico - 1);

		if(tecnico == null) {
		    System.out.println("Técnico não encontrado.");
		    return;
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
				
	}

	private static void atualizarStatusOrdem(Scanner scanner, AssistenciaTecnica assistencia) {
		
		System.out.println("===== ATUALIZAR STATUS DA ORDEM =====");

	    assistencia.listarOrdens();

	    System.out.println("Digite o número da ordem que deseja atualizar: ");
	    int numero = scanner.nextInt();
	    scanner.nextLine();

	    OrdemServico ordem = assistencia.buscarOrdemPorNumero(numero);

	    if (ordem == null) {
	        System.out.println("Ordem não encontrada.");
	        return;
	    }

	    StatusOS status = escolherStatus(scanner);
	    ordem.setStatus(status);
	    System.out.println("Status atualizado com sucesso!");

	}
	
}