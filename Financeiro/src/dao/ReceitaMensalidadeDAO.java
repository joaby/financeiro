package dao;

import java.util.List;

import modelo.Mes;
import modelo.ReceitaMensalidade;

public interface ReceitaMensalidadeDAO extends GenericDAO<ReceitaMensalidade>{
	
	public List<ReceitaMensalidade> buscarPorMes(Mes mes);
	public List<ReceitaMensalidade> buscarPorAno(int ano);
	public List<ReceitaMensalidade> buscarPorMesAno(Mes mes, int ano);

}
