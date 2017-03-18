package dao;

import java.util.List;

import modelo.Mes;
import modelo.ReceitaMatricula;
import modelo.Serie;

public interface ReceitaMatriculaDAO extends GenericDAO<ReceitaMatricula>{
	
	public List<ReceitaMatricula> buscarPorAno(int ano);
	public List<ReceitaMatricula> buscarPorSerie(Serie serie, int ano);
	public ReceitaMatricula buscarPorAluno(long idAluno, int ano);
	public Double soma(Mes mes, int ano);

}
