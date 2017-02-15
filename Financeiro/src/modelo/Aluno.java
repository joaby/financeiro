package modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	private String nome;
	@Enumerated(EnumType.STRING)
	private Serie serie;
	
	public Aluno(){
		
	}
	
    public Aluno(String nome, Serie serie) {
		super();
		this.nome = nome;
		this.serie = serie;
	}
	
    public String getNome() {
		return nome;
	}
	
    public void setNome(String nome) {
		this.nome = nome;
	}
	
    public Serie getSerie() {
		return serie;
	}
	
    public void setSerie(Serie serie) {
		this.serie = serie;
	}	

}
