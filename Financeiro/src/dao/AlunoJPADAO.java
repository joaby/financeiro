package dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Aluno;

public class AlunoJPADAO extends GenericJPADAO<Aluno> implements AlunoDAO{
	
	public AlunoJPADAO(){
		this.persistentClass = Aluno.class;
	}

	@Override
	public List<Aluno> buscarPorSexo(char sexo) {
		TypedQuery<Aluno> query = getEm().createNamedQuery("Aluno.buscarPorSexo", Aluno.class);
		query.setParameter("sexo", sexo);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorAtivo() {
		Query query = getEm().createNamedQuery("Aluno.buscarPorAtivo");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorInativo() {
		Query query = getEm().createNamedQuery("Aluno.buscarPorInativo");
		return query.getResultList();
	}

	@Override
	public Aluno buscarPorNome(String nome) {
		Query query = getEm().createNamedQuery("Aluno.buscarPorNome");
		query.setParameter("nome", nome);
		return (Aluno) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarPorNomeInicial(String nome) {
		Query query = getEm().createNamedQuery("Aluno.buscarPorNomeInicial");
		query.setParameter("nome","%"+nome+"%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorNomeParcial(String nome) {
		Query query = getEm().createNamedQuery("Aluno.buscarPorNomeParcial");
		query.setParameter("nome","%"+nome+"%");
		return query.getResultList();
	}

}
