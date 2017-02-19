package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import modelo.ReceitaMensalidade;

public class ReceitaMensalidadeJPADAO extends GenericJPADAO<ReceitaMensalidade> implements ReceitaMensalidadeDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMensalidadeJPADAO(){
		this.persistentClass = ReceitaMensalidade.class;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorData(Date inicio, Date fim) {
		Query query = getEm().createNamedQuery("ReceitaMensalidade.buscarPorData");
		query.setParameter("dataInicial", inicio, TemporalType.DATE);
		query.setParameter("dataFinal", fim, TemporalType.DATE);
		return query.getResultList();
		
	}

	@Override
	public List<ReceitaMensalidade> buscarPorMes(Date inicio, Date fim) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<ReceitaMensalidade> c = cb.createQuery(ReceitaMensalidade.class);
		Root<ReceitaMensalidade> rm = c.from(ReceitaMensalidade.class);
		c.select(rm);
		
		Predicate p = cb.between(rm.<Date>get("data"), inicio, fim);
		c.where(p);
		
		TypedQuery<ReceitaMensalidade> query = getEm().createQuery(c);
		List<ReceitaMensalidade> m = query.getResultList();
		return m;
	}
	
	


}
