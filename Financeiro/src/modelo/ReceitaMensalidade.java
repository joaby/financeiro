package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaMensalidade.buscarPorMesAno", 
			query="SELECT rm FROM ReceitaMensalidade rm WHERE rm.mes = :mes AND rm.ano = :ano"),
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
