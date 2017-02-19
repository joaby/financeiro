package dao;

import java.util.Date;
import java.util.List;

import modelo.ReceitaMensalidade;

public interface ReceitaMensalidadeDAO extends GenericDAO<ReceitaMensalidade>{
	
	public List<ReceitaMensalidade> buscarPorData(Date inicio, Date fim);
	public List<ReceitaMensalidade> buscarPorMes(Date inicio, Date fim);

}
