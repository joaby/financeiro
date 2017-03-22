package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Aluno.somar", 
			query="SELECT COUNT(a) FROM Aluno a WHERE a.ativo = true"),
	@NamedQuery(name="Aluno.buscarPorSexo", 
			query="SELECT a FROM Aluno a WHERE a.sexo = :sexo AND a.ativo = true"),
	@NamedQuery(name="Aluno.buscarPorAtivo", 
			query="SELECT a FROM Aluno a WHERE a.ativo = true"),
	@NamedQuery(name="Aluno.buscarPorInativo", 
			query="SELECT a FROM Aluno a WHERE a.ativo = false"),
	@NamedQuery(name="Aluno.buscarPorNome", 
			query="SELECT a FROM Aluno a WHERE a.nome = :nome"),
	@NamedQuery(name="Aluno.buscarPorNomeInicial", 
			query="SELECT a.nome FROM Aluno a WHERE a.nome LIKE :nome AND a.ativo = true"),
	@NamedQuery(name="Aluno.buscarPorNomeParcial", 
			query="SELECT a FROM Aluno a WHERE a.nome LIKE :nome")
	
})
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(unique=true, nullable = false)
	private String nome;
	private char sexo;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private boolean ativo;
	
	public Aluno(){
		this.ativo = true;
	}
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}
	
    public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
}
