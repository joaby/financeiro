package dao;

import modelo.DespesaFuncionario;

public class DespesaFuncionarioJPADAO extends GenericJPADAO<DespesaFuncionario> implements DespesaFuncionarioDAO{
	
	public DespesaFuncionarioJPADAO(){
		this.persistentClass = DespesaFuncionario.class;
	}
}
