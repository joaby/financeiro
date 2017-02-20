package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMatriculaDAO;
import dao.ReceitaMatriculaJPADAO;
import modelo.Aluno;
import modelo.ReceitaMatricula;

@ManagedBean
public class ReceitaMatriculaBean extends AbstractBean{
	
	private ReceitaMatricula matricula;
	private List<ReceitaMatricula> matriculas;
	private float receitaTotal;
	
	public ReceitaMatriculaBean(){
		this.matricula = new ReceitaMatricula();
		this.matriculas = new ArrayList<ReceitaMatricula>();
		buscarTodos();
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
		for(ReceitaMatricula rm : this.matriculas){
			this.setReceitaTotal(this.getReceitaTotal() + rm.getValor());
		}
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

}
