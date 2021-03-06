package dao;

import java.util.List;
import modelo.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno>{
	
	public List<Aluno> buscarPorSexo(char sexo);
	public List<Aluno> buscarPorAtivo();
	public List<Aluno> buscarPorInativo();
	public Aluno buscarPorNome(String nome);
	public List<String> buscarPorNomeInicial(String nome);
	public List<Aluno> buscarPorNomeParcial(String nome);

}
