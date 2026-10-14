package assistenciatech.model;

import java.util.Objects;

public class Cliente {

		private String nome;
		private String cpf;
		private String telefone;
		private String email;
		
public Cliente(String nome, String cpf, String telefone, String email) {
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.email = email;


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

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override

public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null || getClass() != obj.getClass()) {
		return false;
	}
	Cliente outro = (Cliente) obj;
	return cpf.equals(outro.getCpf());
}
@Override

public int hashCode() {
	return Objects.hash(cpf);
}
}
