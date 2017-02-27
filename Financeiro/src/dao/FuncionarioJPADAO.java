package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Funcionario;
import modelo.TipoFuncionario;

public class FuncionarioJPADAO extends GenericJPADAO<Funcionario> implements FuncionarioDAO{
	
	private static final long serialVersionUID = 1L;
	
	public FuncionarioJPADAO(){
		this.persistentClass = Funcionario.class;
	}

	@Override
	public List<Funcionario> buscarPorTipo(TipoFuncionario tipo) {
		Query query = getEm().createNamedQuery("Funcionario.buscarPorTipo");
		query.setParameter("tipo", tipo);
		return query.getResultList();
	}

}
