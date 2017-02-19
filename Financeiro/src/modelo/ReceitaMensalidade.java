package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaMensalidade.buscarPorData", 
			query="SELECT rm FROM ReceitaMensalidade rm WHERE rm.data >= :dataInicial AND rm.data <= :dataFinal"),
})
public class ReceitaMensalidade extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	
	public ReceitaMensalidade(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
