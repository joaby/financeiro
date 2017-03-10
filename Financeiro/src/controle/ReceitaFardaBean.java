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
import dao.ReceitaFardaDAO;
import dao.ReceitaFardaJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.ReceitaFarda;

@ManagedBean
@ViewScoped
public class ReceitaFardaBean extends AbstractBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private ReceitaFarda receitaFarda;
	private List<ReceitaFarda> receitasFardas;
	private List<Mes> meses;
	private Mes mes;
	private int ano;
	private float receitaTotal;
	
	public ReceitaFardaBean(){
		this.receitaFarda = new ReceitaFarda();
		this.receitasFardas = new ArrayList<ReceitaFarda>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void cadastrar(){
		try {
			ReceitaFardaDAO rfDAO = new ReceitaFardaJPADAO();
			rfDAO.save(this.receitaFarda);
			displayInfoMessageToUser("Cadastrado com sucesso");
			this.receitaFarda = new ReceitaFarda();
		} catch (Exception e) {
			displayInfoMessageToUser("Aluno ainda não cadastrado!");
		}
		
	}
	
	public void selecionarParaAtualizar(ReceitaFarda r){
		this.receitaFarda = r;
		RequestContext.getCurrentInstance().execute("PF('edit').show()");
	}
	
	public void atualizar(){
		ReceitaFardaDAO rfDAO = new ReceitaFardaJPADAO();
		rfDAO.save(this.receitaFarda);
		displayInfoMessageToUser("Atualizado com sucesso");
		this.receitaFarda = new ReceitaFarda();
	}
	
	public void excluir(ReceitaFarda r){
		ReceitaFardaDAO rfDAO = new ReceitaFardaJPADAO();
		rfDAO.delete(r);
		displayInfoMessageToUser("Excluido com sucesso");
		this.receitasFardas.remove(r);
	}
	
	public void buscarPorAno(){
		this.receitasFardas = new ArrayList<ReceitaFarda>();
		ReceitaFardaDAO rfDAO = new ReceitaFardaJPADAO();
		this.receitasFardas = rfDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitasFardas);
	}
	
	public void buscarPorMesAno(){
		this.receitasFardas = new ArrayList<ReceitaFarda>();
		ReceitaFardaDAO rfDAO = new ReceitaFardaJPADAO();
		this.receitasFardas = rfDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitasFardas);
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
	
	public float somaReceitaTotal(List<ReceitaFarda> rf){
		float total = 0;
		for(ReceitaFarda r : rf){
			total += r.getValor();
		}
		return total;
	}
	
	
	public ReceitaFarda getReceitaFarda() {
		return receitaFarda;
	}
	public void setReceitaFarda(ReceitaFarda receitaFarda) {
		this.receitaFarda = receitaFarda;
	}
	public List<ReceitaFarda> getReceitasFardas() {
		return receitasFardas;
	}
	public void setReceitasFardas(List<ReceitaFarda> receitasFardas) {
		this.receitasFardas = receitasFardas;
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
