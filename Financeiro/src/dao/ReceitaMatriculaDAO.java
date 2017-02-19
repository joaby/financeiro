package dao;

import java.util.Date;
import java.util.List;

import modelo.ReceitaMatricula;

public interface ReceitaMatriculaDAO extends GenericDAO<ReceitaMatricula>{
	
	public List<ReceitaMatricula> buscarPorData(Date inicio, Date fim);

}
