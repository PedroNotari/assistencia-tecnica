package assistenciatech.model;

import java.util.Objects;

public class Tecnico {

	private String nome;
	private String cpf;
	private String especialidade;

public Tecnico(String nome, String cpf, String especialidade) {
	this.nome = nome;
	this.cpf = cpf;
	this.especialidade = especialidade;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getEspecialidade() {
	return especialidade;
}

public void setEspecialidade(String especialidade) {
	this.especialidade = especialidade;
}

@Override

public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null || getClass() != obj.getClass()) {
		return false;
	}
	Tecnico outro = (Tecnico) obj;
	return cpf.equals(outro.getCpf());
}
@Override

public int hashCode() {
	return Objects.hash(cpf);
}

}
