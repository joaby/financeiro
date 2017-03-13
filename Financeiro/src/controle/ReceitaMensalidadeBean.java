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
import dao.ReceitaMatriculaDAO;
import dao.ReceitaMatriculaJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaMatricula;
import modelo.ReceitaMensalidade;
import modelo.Serie;

@ManagedBean
@ViewScoped
public class ReceitaMensalidadeBean extends AbstractBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ReceitaMensalidade mensalidade;
	private List<ReceitaMensalidade> mensalidades;
	private List<Aluno> alunos;
	private float receitaTotal;
	private Serie serie;
	private Mes mes;
	private int ano;
	private List<Mes> meses;
	private List<Serie> series;
	
	public ReceitaMensalidadeBean(){
		this.meses = Arrays.asList(Mes.values());
		this.series = Arrays.asList(Serie.values());
		this.setMensalidade(new ReceitaMensalidade());
		this.setMensalidades(new ArrayList<ReceitaMensalidade>());
		this.setAlunos(new ArrayList<Aluno>());
	}

	public void cadastrar(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		Aluno a = alunoDAO.buscarPorNome(this.mensalidade.getAluno().getNome());
		if(a != null){
			try {
				ReceitaMatriculaDAO mDAO = new ReceitaMatriculaJPADAO();
				ReceitaMatricula rm = mDAO.buscarPorAluno(a, this.mensalidade.getAno());
				this.mensalidade.setMatricula(rm);
				this.mensalidade.setAluno(a);
				ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
				rmDAO.save(this.mensalidade);
				displayInfoMessageToUser("Cadastrado com sucesso");
				this.mensalidade = new ReceitaMensalidade();
			} catch (Exception e) {
				displayErrorMessageToUser("Aluno ainda não matriculado nesse ano");
				this.mensalidade = new ReceitaMensalidade();
			}
		}else{
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
			this.mensalidade = new ReceitaMensalidade();
		}	
	}
	
	public void selecionarParaAtualizar(ReceitaMensalidade rm){
		this.mensalidade = rm;
		RequestContext.getCurrentInstance().execute("PF('edit').show()");
	}
	
	public void atualizar(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		rmDAO.save(this.mensalidade);
		displayInfoMessageToUser("Atualizado com sucesso");
		this.mensalidade = new ReceitaMensalidade();
	}
	
	public void excluir(ReceitaMensalidade rm){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		rmDAO.delete(rm);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.mensalidades.remove(rm);
	}
	
	public void buscarTodos(){
		this.mensalidades = new ArrayList<ReceitaMensalidade>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.find();
		this.receitaTotal = somaReceitaTotal(this.mensalidades);
	}
	
	public void buscarPorAno(){
		this.mensalidades = new ArrayList<ReceitaMensalidade>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.mensalidades);
	}
	
	public void buscarPorMesAno(){
		this.mensalidades = new ArrayList<ReceitaMensalidade>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.mensalidades);
	}
	
	public void buscarPorSerie(){
		this.mensalidades = new ArrayList<ReceitaMensalidade>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorSerie(this.serie, this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.mensalidades);
	}
	
	public void buscarPorNaoPagante(){
		this.alunos = new ArrayList<Aluno>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.alunos = rmDAO.buscarPorNaoPagante(this.mes, this.ano);
	}
	
	public List<String> buscarTodosAlunos(String query){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		List<String> nomes =  alunoDAO.buscarPorNomeInicial(query.toUpperCase());
		return nomes;
	}
	
	public int sortBySerie(Serie a, Serie b){
		return a.compareTo(b);
	}
	
	public int sortByNome(String n1, String n2){
		return n1.compareTo(n2);
	}
	
	public float somaReceitaTotal(List<ReceitaMensalidade> mensalidades){
		float total = 0;
		for(ReceitaMensalidade mensalidade : mensalidades){
			total += mensalidade.getValor();
		}
		return total;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
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

	public ReceitaMensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(ReceitaMensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}

	public List<ReceitaMensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<ReceitaMensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	public List<Mes> getMeses() {
		return meses;
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
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
