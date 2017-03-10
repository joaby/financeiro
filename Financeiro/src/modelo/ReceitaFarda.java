package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaFarda.buscarPorAno", 
			query="SELECT rf FROM ReceitaFarda rf WHERE rf.ano = :ano"),
	@NamedQuery(name="ReceitaFarda.buscarPorMesAno", 
			query="SELECT rf FROM ReceitaFarda rf WHERE rf.mes = :mes AND rf.ano = :ano"),
	@NamedQuery(name="ReceitaFarda.soma", 
			query="SELECT SUM(rf.valor) FROM ReceitaFarda rf WHERE rf.mes = :mes AND rf.ano = :ano")
})
public class ReceitaFarda extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	
	public ReceitaFarda(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
