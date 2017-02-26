package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Mes;
import modelo.ReceitaLivro;

public class ReceitaLivroJPADAO extends GenericJPADAO<ReceitaLivro> implements ReceitaLivroDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaLivroJPADAO(){
		this.persistentClass = ReceitaLivro.class;
	}

	@Override
	public List<ReceitaLivro> buscarPorAno(int ano) {
		Query query = getEm().createNamedQuery("ReceitaLivro.buscarPorAno");
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public List<ReceitaLivro> buscarPorMesAno(Mes mes, int ano) {
		Query query = getEm().createNamedQuery("ReceitaLivro.buscarPorMesAno");
		query.setParameter("mes", mes);
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public Double soma(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaLivro.soma");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		Double soma = (Double) query.getSingleResult();
		return soma;
	}

}
