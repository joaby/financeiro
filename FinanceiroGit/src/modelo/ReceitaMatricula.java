package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReceitaMatricula extends Receita{
	
	@ManyToOne
	private Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
