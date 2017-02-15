package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Receita {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private long id;
	private String descricao;
	private float valor;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Receita(){
		
	}
	
	public Receita(String descricao, float valor, Date data) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public Receita(long id, String descricao, float valor, Date data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
}
