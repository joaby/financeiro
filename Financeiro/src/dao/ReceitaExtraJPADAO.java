package dao;

import modelo.ReceitaExtra;

public class ReceitaExtraJPADAO extends GenericJPADAO<ReceitaExtra> implements ReceitaExtraDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaExtraJPADAO(){
		this.persistentClass = ReceitaExtra.class;
	}

}
