package assistenciatech;
import java.util.ArrayList;

public class AssistenciaTecnica {
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<OrdemServico> ordens;
	
	public AssistenciaTecnica() {
		
		clientes = new ArrayList<>();
		tecnicos = new ArrayList<>();
		ordens = new ArrayList<>();

	}
	
	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void adicionarTecnico(Tecnico tecnico) {
		tecnicos.add(tecnico);
	}
	
	public void adicionarOrdemServico(OrdemServico ordem) {
		ordens.add(ordem);
	}
	
	public void listarClientes() {
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println((i + 1) + " - " + clientes.get(i).getNome());
	}
	}
	
	public void listarTecnicos() {
		
		for (int i = 0; i < tecnicos.size(); i++) {
			System.out.println((i + 1) + " - " + tecnicos.get(i).getNome());
	}
	}
	
	public void listarOrdens() {
		
		for (OrdemServico ordem : ordens) {
			System.out.println("===== ORDEM DE SERVIÇO =====");
	        System.out.println("Número: " + ordem.getNumero());
	        System.out.println("Problema: " + ordem.getDescricaoProblema());
	        System.out.println("Equipamento: " + ordem.getEquipamento());
	        System.out.println("Status: " + ordem.getStatus());
	        System.out.println("Data: " + ordem.getDataAbertura());
	        System.out.println("Cliente: " + ordem.getCliente().getNome());
	        System.out.println("Técnico: " + ordem.getTecnico().getNome());
	        System.out.println("============================");
		}
	}
	
	public Cliente buscarCliente(int indice) {
		if(indice < 0 || indice >= clientes.size()) {
			return null;
		}
		
		return clientes.get(indice);
	}

	public Tecnico buscarTecnico(int indice) {
		if(indice < 0 || indice >= tecnicos.size()) {	
			return null;
		}
	
		return tecnicos.get(indice);
	}

	public boolean temClientes() {
		return !clientes.isEmpty();
	}
	
	public boolean temTecnicos() {
		return !tecnicos.isEmpty();
	}

}