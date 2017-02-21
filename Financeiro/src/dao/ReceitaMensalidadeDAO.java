package dao;

import java.util.List;

import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaMensalidade;
import modelo.Serie;

public interface ReceitaMensalidadeDAO extends GenericDAO<ReceitaMensalidade>{
	
	public List<ReceitaMensalidade> buscarPorAno(int ano);
	public List<ReceitaMensalidade> buscarPorMesAno(Mes mes, int ano);
	public List<ReceitaMensalidade> buscarPorSerie(Serie serie, Mes mes, int ano);
	public List<Aluno> buscarPorNaoPagante(Mes mes, int ano);

}
