package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaMensalidade;

@ManagedBean
public class ReceitaMensalidadeBean extends AbstractBean{
	
	private ReceitaMensalidade mensalidade;
	private List<ReceitaMensalidade> mensalidades;
	private float receitaTotal;
	private Mes mes;
	private int ano;
	private List<Mes> meses;
	
	
	public ReceitaMensalidadeBean(){
		this.meses = Arrays.asList(Mes.values());
		this.setMensalidade(new ReceitaMensalidade());
		this.setMensalidades(new ArrayList<ReceitaMensalidade>());
		buscarTodos();
	}

	public void cadastrar(){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		Aluno a = alunoDAO.find(mensalidade.getAluno().getNome());
		if(a != null){
			ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
			rmDAO.save(this.mensalidade);
			displayInfoMessageToUser("Cadastrado com sucesso");
			this.mensalidade = new ReceitaMensalidade();
		}else{
			displayErrorMessageToUser("Aluno não cadastrado! Cadastre o aluno e tente novamente.");
		}	
	}
	
	public void excluir(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		rmDAO.delete(this.mensalidade);
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void buscarTodos(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.find();
		for(ReceitaMensalidade mensalidade : mensalidades){
			this.receitaTotal += mensalidade.getValor();
		}
	}
	
	public String buscarPorAno(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorAno(this.ano);
		return "mostrar_consulta";
	}
	
	public String buscarPorMes(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorMes(this.mes);
		return "mostrar_consulta";
	}
	
	public String buscarPorMesAno(){
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.mensalidades = rmDAO.buscarPorMesAno(this.mes, this.ano);
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

}
