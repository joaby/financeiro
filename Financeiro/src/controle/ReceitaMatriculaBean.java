package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMatriculaDAO;
import dao.ReceitaMatriculaJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.ReceitaMatricula;

@ManagedBean
public class ReceitaMatriculaBean extends AbstractBean{
	
	private ReceitaMatricula receitaMatricula;
	private List<ReceitaMatricula> receitasMatriculas;
	private float receitaTotal;
	private Date dataInicial;
	private Date dataFinal;
	
	public ReceitaMatriculaBean(){
		this.receitaMatricula = new ReceitaMatricula();
		this.receitasMatriculas = new ArrayList<ReceitaMatricula>();
		buscarTodos();
	}
	
	public void cadastrar(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		Aluno a = alunoDAO.find(receitaMatricula.getAluno().getNome());
		if(a != null){
			ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
			rmDAO.save(this.receitaMatricula);
			displayInfoMessageToUser("Cadastrado com sucesso");
			this.receitaMatricula = new ReceitaMatricula();
		}else{
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
		}	
		
	}
	
	public void excluir(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		rmDAO.delete(this.receitaMatricula);
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void buscarTodos(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		this.receitasMatriculas = rmDAO.find();
		for(ReceitaMatricula rm : this.receitasMatriculas){
			this.setReceitaTotal(this.getReceitaTotal() + rm.getValor());
		}
	}
	
	public String buscarPorData(){
		ReceitaMatriculaDAO rmDAO = new ReceitaMatriculaJPADAO();
		this.receitasMatriculas = rmDAO.buscarPorData(this.dataInicial, this.dataInicial);
		return "consulta_matricula";
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
	
	public ReceitaMatricula getReceitaMatricula() {
		return receitaMatricula;
	}
	public void setReceitaMatricula(ReceitaMatricula receitaMatricula) {
		this.receitaMatricula = receitaMatricula;
	}
	public List<ReceitaMatricula> getReceitasMatriculas() {
		return receitasMatriculas;
	}
	public void setReceitasMatriculas(List<ReceitaMatricula> receitasMatriculas) {
		this.receitasMatriculas = receitasMatriculas;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

}
