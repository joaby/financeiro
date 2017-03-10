package dao;

import java.util.List;

import modelo.Mes;
import modelo.ReceitaToner;

public interface ReceitaTonerDAO  extends GenericDAO<ReceitaToner>{
	
	public List<ReceitaToner> buscarPorAno(int ano);
	public List<ReceitaToner> buscarPorMesAno(Mes mes, int ano);
	public Double soma(Mes mes, int ano);

}
