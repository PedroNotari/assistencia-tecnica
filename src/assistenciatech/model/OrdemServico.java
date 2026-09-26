package assistenciatech.model;
import java.time.LocalDate;

public class OrdemServico {
	
	private int numero;
	private String descricaoProblema;
	private String equipamento;
	private StatusOS status;
	private LocalDate dataAbertura;
	private Cliente cliente;
	private Tecnico tecnico;


public OrdemServico(int numero, String descricaoProblema, String equipamento, StatusOS status,LocalDate dataAbertura, Cliente cliente, Tecnico tecnico) {
	this.numero = numero;
	this.descricaoProblema = descricaoProblema;
	this.equipamento = equipamento;
	this.status = status;
	this.dataAbertura = dataAbertura;
	this.cliente = cliente;
	this.tecnico = tecnico;
}


public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getDescricaoProblema() {
	return descricaoProblema;
}

public void setDescricaoProblema(String descricaoProblema) {
	this.descricaoProblema = descricaoProblema;
}

public String getEquipamento() {
	return equipamento;
}

public void setEquipamento(String equipamento) {
	this.equipamento = equipamento;
}

public StatusOS getStatus() {
	return status;
}

public LocalDate getDataAbertura() {
	return dataAbertura;
}

public void setDataAbertura(LocalDate dataAbertura) {
	this.dataAbertura = dataAbertura;
}

public void setStatus(StatusOS status) {
	this.status = status;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Tecnico getTecnico() {
	return tecnico;
}

public void setTecnico(Tecnico tecnico) {
	this.tecnico = tecnico;
}

}
