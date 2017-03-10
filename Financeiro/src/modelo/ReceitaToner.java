package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaToner.buscarPorAno", 
			query="SELECT rt FROM ReceitaToner rt WHERE rt.ano = :ano"),
	@NamedQuery(name="ReceitaToner.buscarPorMesAno", 
			query="SELECT rt FROM ReceitaToner rt WHERE rt.mes = :mes AND rt.ano = :ano"),
	@NamedQuery(name="ReceitaToner.soma", 
			query="SELECT SUM(rt.valor) FROM ReceitaToner rt WHERE rt.mes = :mes AND rt.ano = :ano")
})
public class ReceitaToner extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	
	public ReceitaToner(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
