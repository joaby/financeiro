package dao;

import modelo.Aluno;

public class AlunoJPADAO extends GenericJPADAO<Aluno> implements AlunoDAO{
	
	public AlunoJPADAO(){
		this.persistentClass = Aluno.class;
	}

}
