package dao;

import modelo.ReceitaMatricula;

public class ReceitaMatriculaJPADAO extends GenericJPADAO<ReceitaMatricula> implements ReceitaMatriculaDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMatriculaJPADAO(){
		this.persistentClass = ReceitaMatricula.class;
	}

}
