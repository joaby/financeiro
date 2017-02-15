package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;


import dao.AlunoDAO;
import dao.AlunoJPADAO;

import modelo.Aluno;
import modelo.Serie;

@ManagedBean
public class AlunoBean extends AbstractBean{
	
	private Aluno aluno;
	private List<Serie> series = Arrays.asList(Serie.values());
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public AlunoBean(){
		this.aluno = new Aluno();
		buscarTodos();
	}
	
	public void buscarTodos(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		this.alunos = alunoDAO.find();
	}
	
	public void cadastrar(){
		try {
			AlunoDAO alunoDAO = new AlunoJPADAO();
			Aluno a = alunoDAO.find(this.aluno.getNome());
			if(a == null){
				alunoDAO.save(this.aluno);
				displayInfoMessageToUser("Cadastrado com sucesso!");
				this.aluno = new Aluno();
			}
			else{
				displayErrorMessageToUser("Aluno já cadastrado!");
			}
		} catch (Exception e) {
			displayErrorMessageToUser("Erro no cadastramento!");
		}
	}
	
	public void excluir(){
		try {
			AlunoDAO alunoDAO = new AlunoJPADAO();
			alunoDAO.delete(aluno);
			displayInfoMessageToUser("Excluido com sucesso!");
			this.aluno = new Aluno();
		} catch (Exception e) {
			displayErrorMessageToUser("Erro ao excluir!");
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
