package dao;

import modelo.Despesa;

public class DespesaJPADAO extends GenericJPADAO<Despesa> implements DespesaDAO{
	
	private static final long serialVersionUID = 1L;
	
	public DespesaJPADAO(){
		this.persistentClass = Despesa.class;
	}

}
