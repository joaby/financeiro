package controle;

import java.util.ArrayList;
import java.util.Date;
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
	private float receitaTotal;
	private Date dataInicial;
	private Date dataFinal;
	
	
	public ReceitaMensalidadeBean(){
		this.receitaMensalidade = new ReceitaMensalidade();
		this.receitas = new ArrayList<ReceitaMensalidade>();
		buscarTodos();
	}

	public void cadastrar(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		Aluno a = alunoDAO.find(receitaMensalidade.getAluno().getNome());
		if(a != null){
			ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
			rmDAO.save(this.receitaMensalidade);
			displayInfoMessageToUser("Cadastrado com sucesso");
			this.receitaMensalidade = new ReceitaMensalidade();
		}else{
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
		}	
	}
	
	public void excluir(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		rmDAO.delete(this.receitaMensalidade);
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void buscarTodos(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.receitas = rmDAO.find();
		for(ReceitaMensalidade rm : receitas){
			this.receitaTotal += rm.getValor();
		}
	}
	
	public String buscarPorData(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.receitas = rmDAO.buscarPorData(this.dataInicial, this.dataInicial);
		System.out.println(" tamanho de receita:"+receitas.size());
		return "mostrar_consulta";
	}
	
	public String buscarPorMes(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.receitas = rmDAO.buscarPorMes(this.dataInicial, this.dataInicial);
		System.out.println(" tamanho de receita:"+receitas.size());
		return "mostrar_consulta";
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
