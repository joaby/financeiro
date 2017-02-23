package modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Receita.buscarPorAno", 
			query="SELECT r FROM Receita r WHERE r.ano = :ano"),
	@NamedQuery(name="Receita.buscarPorMesAno", 
			query="SELECT r FROM Receita r WHERE r.mes = :mes AND r.ano = :ano")
})
public class Receita {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private long id;
	private String descricao;
	private float valor;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private int ano;

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

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
