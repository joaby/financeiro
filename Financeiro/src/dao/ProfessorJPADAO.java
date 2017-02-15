package dao;

import modelo.Professor;

public class ProfessorJPADAO extends GenericJPADAO<Professor> implements ProfessorDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ProfessorJPADAO(){
		this.persistentClass = Professor.class;
	}

}
