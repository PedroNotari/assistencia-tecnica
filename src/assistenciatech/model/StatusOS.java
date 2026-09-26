package assistenciatech.model;

public enum StatusOS {

	ABERTA,
	EM_ANDAMENTO,
	AGUARDANDO_PECA,
	CONCLUIDA;
	
	@Override
	public String toString() {
		switch (this) {
		case ABERTA: return "Aberta";
		case EM_ANDAMENTO: return "Em andamento";
		case AGUARDANDO_PECA: return "Aguardando peça";
		case CONCLUIDA: return "Concluída";
		default: return super.toString();
		}
	}
}
