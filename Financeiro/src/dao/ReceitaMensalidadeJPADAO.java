package dao;


import java.util.List;

import javax.persistence.Query;

import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaMensalidade;
import modelo.Serie;


public class ReceitaMensalidadeJPADAO extends GenericJPADAO<ReceitaMensalidade> implements ReceitaMensalidadeDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMensalidadeJPADAO(){
		this.persistentClass = ReceitaMensalidade.class;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorAno(int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.buscarPorAno");
		query.setParameter("ano", ano);
		List<ReceitaMensalidade> mensalidades = query.getResultList();
		return mensalidades;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorMesAno(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.buscarPorMesAno");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		List<ReceitaMensalidade> mensalidades = query.getResultList();
		return mensalidades;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorSerie(Serie serie, Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.buscarPorSerie");
		query.setParameter ("serie", serie) ;
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		List<ReceitaMensalidade> mensalidades = query.getResultList();
		return mensalidades;
	}

	@Override
	public List<Aluno> buscarPorNaoPagante(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.buscarPorNaoPagante");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		List<Aluno> alunos = query.getResultList();
		return alunos;
	}

	@Override
	public float soma(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.soma");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		float soma = (Float) query.getSingleResult();
		return soma;
	}

}
