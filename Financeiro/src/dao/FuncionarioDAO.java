package dao;

import java.util.List;

import modelo.Funcionario;
import modelo.TipoFuncionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario>{
	
	public List<Funcionario> buscarPorTipo(TipoFuncionario tipo);

}
