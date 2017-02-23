package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ReceitaLivroDAO;
import dao.ReceitaLivroJPADAO;
import modelo.Mes;
import modelo.ReceitaLivro;

@ManagedBean
public class ReceitaLivroBean extends AbstractBean{
	
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
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		rlDAO.save(this.receitaLivro);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}
	
	public void excluir(){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		rlDAO.delete(this.receitaLivro);;
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void buscarTodos(){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.find();
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
	}
	
	public void buscarPorAno(){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
	}
	
	public void buscarPorMesAno(){
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		this.receitaLivros = rlDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitaLivros);
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
