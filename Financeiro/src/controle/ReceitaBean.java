package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import dao.ReceitaDAO;
import dao.ReceitaJPADAO;
import modelo.Mes;
import modelo.Receita;
import modelo.ReceitaExtra;
import modelo.ReceitaLivro;
import modelo.ReceitaMatricula;
import modelo.ReceitaMensalidade;

@ManagedBean
public class ReceitaBean extends AbstractBean{
	
	private List<Receita> receitas;
	private List<ReceitaExtra> receitaExtras;
	private List<ReceitaLivro> receitaLivros;
	private List<ReceitaMatricula> receitaMatriculas;
	private List<ReceitaMensalidade> receitaMensalidades;
	private List<Mes> meses;
	private int ano;
	private Mes mes;
	private float receitaTotal;
	
	
	
	public ReceitaBean(){
		this.receitas = new ArrayList<Receita>();
		this.receitaExtras = new ArrayList<ReceitaExtra>();
		this.receitaLivros = new ArrayList<ReceitaLivro>();
		this.receitaMatriculas = new ArrayList<ReceitaMatricula>();
		this.receitaMensalidades = new ArrayList<ReceitaMensalidade>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void buscarTodos(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.find();
		this.receitaTotal = somaReceitaTotal(this.receitas);
 	}
	
	public void buscarPorAno(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.buscarPorAno(this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitas);
	}
	
	public void buscarPorMesAno(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.buscarPorMesAno(this.mes, this.ano);
		this.receitaTotal = somaReceitaTotal(this.receitas);
	}
	
	public float somaReceitaTotal(List<Receita> r){
		float total = 0;
		for(Receita re : r){
			total += re.getValor();
		}
		return total;
	}
	
	public List<Receita> getReceitas() {
		return receitas;
	}
	
	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
	
	public List<ReceitaExtra> getReceitaExtras() {
		return receitaExtras;
	}
	
	public void setReceitaExtras(List<ReceitaExtra> receitaExtras) {
		this.receitaExtras = receitaExtras;
	}
	
	public List<ReceitaLivro> getReceitaLivros() {
		return receitaLivros;
	}
	
	public void setReceitaLivros(List<ReceitaLivro> receitaLivros) {
		this.receitaLivros = receitaLivros;
	}
	
	public List<ReceitaMatricula> getReceitaMatriculas() {
		return receitaMatriculas;
	}
	
	public void setReceitaMatriculas(List<ReceitaMatricula> receitaMatriculas) {
		this.receitaMatriculas = receitaMatriculas;
	}
	
	public List<ReceitaMensalidade> getReceitaMensalidades() {
		return receitaMensalidades;
	}
	
	public void setReceitaMensalidades(List<ReceitaMensalidade> receitaMensalidades) {
		this.receitaMensalidades = receitaMensalidades;
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

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
	}
	
	

}
