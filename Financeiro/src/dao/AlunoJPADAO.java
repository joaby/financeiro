package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Aluno;

public class AlunoJPADAO extends GenericJPADAO<Aluno> implements AlunoDAO{
	
	public AlunoJPADAO(){
		this.persistentClass = Aluno.class;
	}

	@Override
	public int somar() {
		Query query = getEm().createNamedQuery("Aluno.somar");
		return (Integer) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorSexo(char sexo) {
		Query query = getEm().createNamedQuery("Aluno.buscarPorSexo");
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

	

}
