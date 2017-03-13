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
import dao.ReceitaTonerDAO;
import dao.ReceitaTonerJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaToner;

@ManagedBean
@ViewScoped
public class ReceitaTonerBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ReceitaToner receitaToner;
	private List<ReceitaToner> receitasTones;
	private List<Mes> meses;
	private Mes mes;
	private int ano;
	private float receitaTotal;
	
	public ReceitaTonerBean(){
		this.receitaToner = new ReceitaToner();
		this.receitasTones = new ArrayList<ReceitaToner>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void cadastrar(){
		try {
			AlunoDAO aDAO = new AlunoJPADAO();
			Aluno a = aDAO.buscarPorNome(this.receitaToner.getAluno().getNome());
			this.receitaToner.setAluno(a);
			ReceitaTonerDAO rtDAO = new ReceitaTonerJPADAO();
			rtDAO.save(this.receitaToner);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.receitaToner = new ReceitaToner();
		} catch (Exception e) {
			displayErrorMessageToUser("Aluno ainda não cadastrado!");
		}
	}
	
	public void selecionarParaAtualizar(ReceitaToner r){
		this.receitaToner = r;
		RequestContext.getCurrentInstance().execute("PF('edit').show()");
	}
	
	public void atualizar(){
		ReceitaTonerDAO rtDAO = new ReceitaTonerJPADAO();
		rtDAO.save(this.receitaToner);
		displayInfoMessageToUser("Atualizado com sucesso!");
		this.receitaToner = new ReceitaToner();
	}
	
	public void excluir(ReceitaToner r){
		ReceitaTonerDAO rtDAO = new ReceitaTonerJPADAO();
		rtDAO.delete(r);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.receitasTones.remove(r);
	}
	
	public void buscarPorAno(){
		this.receitasTones = new ArrayList<ReceitaToner>();
		ReceitaTonerDAO rtDAO = new ReceitaTonerJPADAO();
		this.receitasTones = rtDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitasTones);
	}
	
	public void buscarPorMesAno(){
		this.receitasTones = new ArrayList<ReceitaToner>();
		ReceitaTonerDAO rtDAO = new ReceitaTonerJPADAO();
		this.receitasTones = rtDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitasTones);
	}
	
	public List<String> buscarTodosAlunos(String query){
		AlunoDAO alunoDAO = new AlunoJPADAO();
		List<String> nomes =  alunoDAO.buscarPorNomeInicial(query.toUpperCase());
		return nomes;
	}
	
	public float somaReceitaTotal(List<ReceitaToner> rt){
		float total = 0;
		for(ReceitaToner r : rt){
			total += r.getValor();
		}
		return total;
	}
	
	
	public ReceitaToner getReceitaToner() {
		return receitaToner;
	}
	public void setReceitaToner(ReceitaToner receitaToner) {
		this.receitaToner = receitaToner;
	}
	public List<ReceitaToner> getReceitasTones() {
		return receitasTones;
	}
	public void setReceitasTones(List<ReceitaToner> receitasTones) {
		this.receitasTones = receitasTones;
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
