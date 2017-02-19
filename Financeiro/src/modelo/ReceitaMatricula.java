package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaMatricula.buscarPorData", query="SELECT rm FROM ReceitaMatricula rm WHERE rm.data BETWEEN :dataInicial AND :dataFinal")
})
public class ReceitaMatricula extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	
	public ReceitaMatricula(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
