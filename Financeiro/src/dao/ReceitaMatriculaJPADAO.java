package dao;

import java.util.List;
import javax.persistence.Query;
import modelo.Mes;
import modelo.ReceitaMatricula;
import modelo.Serie;

public class ReceitaMatriculaJPADAO extends GenericJPADAO<ReceitaMatricula> implements ReceitaMatriculaDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMatriculaJPADAO(){
		this.persistentClass = ReceitaMatricula.class;
	}

	@Override
	public List<ReceitaMatricula> buscarPorAno(int ano) {
		Query query = getEm().createNamedQuery("ReceitaMatricula.buscarPorAno");
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public List<ReceitaMatricula> buscarPorSerie(Serie serie, int ano) {
		Query query = getEm().createNamedQuery("ReceitaMatricula.buscarPorSerie");
		query.setParameter("serie", serie);
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public ReceitaMatricula buscarPorAluno(long idAluno, int ano) {
		Query query = getEm().createNamedQuery("ReceitaMatricula.buscarPorAluno");
		query.setParameter("idAluno", idAluno);
		query.setParameter("ano", ano);
		return (ReceitaMatricula) query.getSingleResult();
	}

	@Override
	public Double soma(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMatricula.soma");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		Double soma = (Double) query.getSingleResult();
		return soma;
	}

}
