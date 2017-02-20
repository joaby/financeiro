package dao;


import java.util.List;

import javax.persistence.Query;

import modelo.Mes;
import modelo.ReceitaMensalidade;


public class ReceitaMensalidadeJPADAO extends GenericJPADAO<ReceitaMensalidade> implements ReceitaMensalidadeDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMensalidadeJPADAO(){
		this.persistentClass = ReceitaMensalidade.class;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorMes(Mes mes) {
		return null;	
	}

	@Override
	public List<ReceitaMensalidade> buscarPorAno(int ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReceitaMensalidade> buscarPorMesAno(Mes mes, int ano) {
		Query query = getEm().createNamedQuery ("ReceitaMensalidade.buscarPorMesAno");
		query.setParameter ("mes", mes) ;
		query.setParameter("ano", ano);
		List<ReceitaMensalidade> mensalidades = query.getResultList();
		return mensalidades;
	}

}
