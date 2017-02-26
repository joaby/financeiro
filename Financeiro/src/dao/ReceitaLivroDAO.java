package dao;

import java.util.List;

import modelo.Mes;
import modelo.ReceitaLivro;

public interface ReceitaLivroDAO extends GenericDAO<ReceitaLivro>{
	
	public List<ReceitaLivro> buscarPorAno(int ano);
	public List<ReceitaLivro> buscarPorMesAno(Mes mes, int ano);
	public Double soma(Mes mes, int ano);

}
