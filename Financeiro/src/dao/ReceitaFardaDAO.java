package dao;

import java.util.List;
import modelo.Mes;
import modelo.ReceitaFarda;

public interface ReceitaFardaDAO extends GenericDAO<ReceitaFarda>{
	
	public List<ReceitaFarda> buscarPorAno(int ano);
	public List<ReceitaFarda> buscarPorMesAno(Mes mes, int ano);
	public Double soma(Mes mes, int ano);

}
