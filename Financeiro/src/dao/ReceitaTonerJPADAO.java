package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Mes;
import modelo.ReceitaToner;

public class ReceitaTonerJPADAO extends GenericJPADAO<ReceitaToner> implements ReceitaTonerDAO{
	
	public ReceitaTonerJPADAO(){
		this.persistentClass = ReceitaToner.class;
	}

	@Override
	public List<ReceitaToner> buscarPorAno(int ano) {
		Query query = getEm().createNamedQuery("ReceitaToner.buscarPorAno");
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public List<ReceitaToner> buscarPorMesAno(Mes mes, int ano) {
		Query query = getEm().createNamedQuery("ReceitaToner.buscarPorMesAno");
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	@Override
	public Double soma(Mes mes, int ano) {
		Query query = getEm().createNamedQuery("ReceitaToner.soma");
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		return (Double) query.getSingleResult();
	}

}
