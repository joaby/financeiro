package dao;

import java.util.List;
import javax.persistence.Query;

import modelo.Aluno;
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
	public ReceitaMatricula buscarPorAluno(Aluno aluno, int ano) {
		Query query = getEm().createNamedQuery("ReceitaMatricula.buscarPorAluno");
		query.setParameter("aluno", aluno);
		query.setParameter("ano", ano);
		return (ReceitaMatricula) query.getSingleResult();
	}

}
