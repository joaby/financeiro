package dao;

import modelo.ReceitaLivro;

public class ReceitaLivroJPADAO extends GenericJPADAO<ReceitaLivro> implements ReceitaLivroDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaLivroJPADAO(){
		this.persistentClass = ReceitaLivro.class;
	}

}
