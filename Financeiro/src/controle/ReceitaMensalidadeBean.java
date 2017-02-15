package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.ReceitaMensalidade;

@ManagedBean
public class ReceitaMensalidadeBean extends AbstractBean{
	
	private ReceitaMensalidade receitaMensalidade;
	private List<ReceitaMensalidade> receitas;
	private Aluno aluno;
	
	public ReceitaMensalidadeBean(){
		this.receitaMensalidade = new ReceitaMensalidade();
		this.receitas = new ArrayList<ReceitaMensalidade>();
		this.setAluno(new Aluno());
		buscarTodos();
	}

	public void cadastrar(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		rmDAO.save(this.receitaMensalidade);
		displayInfoMessageToUser("Cadastrado com sucesso");
		this.receitaMensalidade = new ReceitaMensalidade();
	}
	
	public void buscarTodos(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.receitas = rmDAO.find();
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
	
	public ReceitaMensalidade getReceitaMensalidade() {
		return receitaMensalidade;
	}

	public void setReceitaMensalidade(ReceitaMensalidade receitaMensalidade) {
		this.receitaMensalidade = receitaMensalidade;
	}

	public List<ReceitaMensalidade> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<ReceitaMensalidade> receitas) {
		this.receitas = receitas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
