package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Mes;
import modelo.ReceitaFarda;

public class ReceitaFardaJPADAO extends GenericJPADAO<ReceitaFarda> implements ReceitaFardaDAO{
	
	public ReceitaFardaJPADAO(){
		this.persistentClass = ReceitaFarda.class;
	}

	@Override
	public List<ReceitaFarda> buscarPorAno(int ano) {
		Query query = getEm().createNamedQuery("ReceitaFarda.buscarPorAno");
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public List<ReceitaFarda> buscarPorMesAno(Mes mes, int ano) {
		Query query = getEm().createNamedQuery("ReceitaFarda.buscarPorMesAno");
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	@Override
	public Double soma(Mes mes, int ano) {
		Query query = getEm().createNamedQuery("ReceitaFarda.soma");
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		return (Double) query.getSingleResult();
	}

}
