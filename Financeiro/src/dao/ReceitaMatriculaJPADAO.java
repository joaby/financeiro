package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import modelo.ReceitaMatricula;

public class ReceitaMatriculaJPADAO extends GenericJPADAO<ReceitaMatricula> implements ReceitaMatriculaDAO{
	
	private static final long serialVersionUID = 1L;
	
	public ReceitaMatriculaJPADAO(){
		this.persistentClass = ReceitaMatricula.class;
	}

	@Override
	public List<ReceitaMatricula> buscarPorData(Date inicio, Date fim) {
		Query query = getEm().createNamedQuery("ReceitaMatricula.buscarPorData");
		query.setParameter("dataInicial", inicio, TemporalType.DATE);
		query.setParameter("dataFinal", fim, TemporalType.DATE);
		return query.getResultList();
	}

}
