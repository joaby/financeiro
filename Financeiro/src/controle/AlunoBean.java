package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.Serie;

@ManagedBean
@ViewScoped
public class AlunoBean extends AbstractBean{
	
	private Aluno aluno;
	private List<Aluno> alunos;
	private Mes mes;
	private int ano;
	private List<Mes> meses;
	
	public AlunoBean(){
		this.meses = Arrays.asList(Mes.values());
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
		buscarTodos();
	}
	
	public void buscarTodos(){
		this.alunos = new ArrayList<Aluno>();
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
				this.aluno = new Aluno();
			}
		} catch (Exception e) {
			displayErrorMessageToUser("Erro no cadastramento!");
			this.aluno = new Aluno();
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
	
	public void buscarPorNaoPagante(){
		this.alunos = new ArrayList<Aluno>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.alunos = rmDAO.buscarPorNaoPagante(this.mes, this.ano);
	}
	
	public int sortBySerie(Serie a, Serie b){
		return a.compareTo(b);
	}
	
	public int sortByNome(String n1, String n2){
		return n1.compareTo(n2);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Mes> getMeses() {
		return meses;
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}
	
	

}
