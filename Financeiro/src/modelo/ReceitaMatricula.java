package modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaMatricula.buscarPorAno", 
			query="SELECT rm FROM ReceitaMatricula rm WHERE rm.ano = :ano"),
	@NamedQuery(name="ReceitaMatricula.buscarPorSerie", 
			query="SELECT rm FROM ReceitaMatricula rm WHERE rm.ano = :ano AND rm.serie = :serie"),
	@NamedQuery(name="ReceitaMatricula.buscarPorAluno", 
			query="SELECT rm FROM ReceitaMatricula rm WHERE rm.aluno = :aluno AND rm.ano = :ano"),
	@NamedQuery(name="ReceitaMatricula.soma", 
			query="SELECT SUM(rm.valor) FROM ReceitaMatricula rm WHERE rm.mes = :mes AND rm.ano = :ano")
})
public class ReceitaMatricula extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	@Enumerated(EnumType.STRING)
	private Serie serie;
	
	public ReceitaMatricula(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}
