package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMatriculaDAO;
import dao.ReceitaMatriculaJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaMatricula;
import modelo.Serie;

@ManagedBean
public class ReceitaMatriculaBean extends AbstractBean{
	
	private ReceitaMatricula matricula;
	private List<ReceitaMatricula> matriculas;
	private float receitaTotal;
	private List<Mes> meses;
	private int ano;
	private Serie serie;
	private List<Serie> series;
	private Aluno aluno;
	private Mes mes;

	public ReceitaMatriculaBean(){
		this.matricula = new ReceitaMatricula();
		this.aluno = new Aluno();
		this.matriculas = new ArrayList<ReceitaMatricula>();
		this.setMeses(Arrays.asList(Mes.values()));
		this.setSeries(Arrays.asList(Serie.values()));
	}
	
	public void cadastrar(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		Aluno a = alunoDAO.find(matricula.getAluno().getNome());
		if(a != null){
			ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
			rmDAO.save(this.matricula);
			displayInfoMessageToUser("Cadastrado com sucesso");
			this.matricula = new ReceitaMatricula();
		}else{
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
		}	
		
	}
	
	public void excluir(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		rmDAO.delete(this.matricula);
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void buscarTodos(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		this.matriculas = rmDAO.find();
		this.receitaTotal = somaReceitaTotal(this.matriculas);
	}
	
	public void buscarPorAno(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		this.matriculas = rmDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.matriculas);
	}
	
	public void buscarPorSerie(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		this.matriculas = rmDAO.buscarPorSerie(this.serie, this.ano);
		this.receitaTotal = somaReceitaTotal(this.matriculas);
	}
	
	public ReceitaMatricula buscarPorAluno(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		return rmDAO.buscarPorAluno(this.aluno, this.ano);
	}
	
	public List<String> buscarTodosAlunos(String query){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		List<Aluno> alunos =  alunoDAO.find();
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i< alunos.size(); i++){
			if(alunos.get(i).getNome().startsWith(query)){
				nomes.add(alunos.get(i).getNome());
			}	
		}
		return nomes;
	}
	
	public float somaReceitaTotal(List<ReceitaMatricula> matriculas){
		float total = 0;
		for(ReceitaMatricula matricula : matriculas){
			total += matricula.getValor();
		}
		return total;
	}
	
	public ReceitaMatricula getMatricula() {
		return matricula;
	}

	public void setMatricula(ReceitaMatricula matricula) {
		this.matricula = matricula;
	}

	public List<ReceitaMatricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<ReceitaMatricula> matriculas) {
		this.matriculas = matriculas;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

	public List<Mes> getMeses() {
		return meses;
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

}
