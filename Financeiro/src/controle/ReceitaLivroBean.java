package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaLivroDAO;
import dao.ReceitaLivroJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaLivro;

@ManagedBean
@ViewScoped
public class ReceitaLivroBean extends AbstractBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ReceitaLivro receitaLivro;
	private List<ReceitaLivro> receitaLivros;
	private List<Mes> meses;
	private Mes mes;
	private int ano;
	private float receitaTotal;
	
	
	public ReceitaLivroBean(){
		this.receitaLivro = new ReceitaLivro();
		this.receitaLivros = new ArrayList<ReceitaLivro>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void cadastrar(){
		try {
			ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
			rlDAO.save(this.receitaLivro);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.receitaLivro = new ReceitaLivro();
		} catch (javax.persistence.EntityNotFoundException e) {
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
		}	
	}
	
	public void selecionarParaAtualizar(ReceitaLivro rl){
		this.receitaLivro = rl;
		RequestContext.getCurrentInstance().execute("PF('edit').show()");
	}
	
	public void atualizar(){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		rlDAO.save(this.receitaLivro);
		displayInfoMessageToUser("Atualizado com sucesso!");
		this.receitaLivro = new ReceitaLivro();
	}
	
	public void excluir(ReceitaLivro rl){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		rlDAO.delete(rl);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.receitaLivros.remove(rl);
	}
	
	public void buscarTodos(){
		this.receitaLivros = new ArrayList<ReceitaLivro>();
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.find();
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
	}
	
	public void buscarPorAno(){
		this.receitaLivros = new ArrayList<ReceitaLivro>();
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
	}
	
	public void buscarPorMesAno(){
		this.receitaLivros = new ArrayList<ReceitaLivro>();
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
	}
	
	public List<String> buscarTodosAlunos(String query){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		List<Aluno> alunos =  alunoDAO.find();
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i< alunos.size(); i++){
			if(alunos.get(i).getNome().startsWith(query.toUpperCase())){
				nomes.add(alunos.get(i).getNome());
			}	
		}
		return nomes;
	}
	
	public float somaReceitaTotal(List<ReceitaLivro> rl){
		float total = 0;
		for(ReceitaLivro r : rl){
			total += r.getValor();
		}
		return total;
	}
	
	public ReceitaLivro getReceitaLivro() {
		return receitaLivro;
	}
	
	public void setReceitaLivro(ReceitaLivro receitaLivro) {
		this.receitaLivro = receitaLivro;
	}
	
	public List<ReceitaLivro> getReceitaLivros() {
		return receitaLivros;
	}
	
	public void setReceitaLivros(List<ReceitaLivro> receitaLivros) {
		this.receitaLivros = receitaLivros;
	}
	
	public List<Mes> getMeses() {
		return meses;
	}
	
	public void setMeses(List<Mes> meses) {
		this.meses = meses;
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
	
	public float getReceitaTotal() {
		return receitaTotal;
	}
	
	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

}
