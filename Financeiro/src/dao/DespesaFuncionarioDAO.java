package dao;

import java.util.List;

import modelo.DespesaFuncionario;
import modelo.Mes;

public interface DespesaFuncionarioDAO extends GenericDAO<DespesaFuncionario>{
	
	public List<DespesaFuncionario> buscarPorMesAno(Mes mes, int ano);

}
