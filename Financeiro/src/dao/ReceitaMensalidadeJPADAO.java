package dao;

import modelo.ReceitaMensalidade;

public class ReceitaMensalidadeJPADAO extends GenericJPADAO<ReceitaMensalidade> implements ReceitaMensalidadeDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMensalidadeJPADAO(){
		this.persistentClass = ReceitaMensalidade.class;
	}

}
