package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
	
	@Id
	private String cpf;
	private String nome;
	
	public Professor(){
		
	}
	
	public Professor(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
