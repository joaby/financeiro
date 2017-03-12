package dao;

import java.util.List;

import modelo.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno>{
	
	public int somar();
	public List<Aluno> buscarPorSexo(char sexo);
	public List<Aluno> buscarPorAtivo();
	public List<Aluno> buscarPorInativo();
	public Aluno buscarPorNome(String nome);

}
