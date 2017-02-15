package dao;

import modelo.Aluno;

public class AlunoJPADAO extends GenericJPADAO<Aluno> implements AlunoDAO{
	
	private static final long serialVersionUID = 1L;
	
	public AlunoJPADAO(){
		this.persistentClass = Aluno.class;
	}

}
