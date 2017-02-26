package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.ReceitaDAO;
import dao.ReceitaExtraDAO;
import dao.ReceitaExtraJPADAO;
import dao.ReceitaJPADAO;
import dao.ReceitaLivroDAO;
import dao.ReceitaLivroJPADAO;
import dao.ReceitaMatriculaDAO;
import dao.ReceitaMatriculaJPADAO;
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Mes;
import modelo.Receita;
import modelo.ReceitaUnica;

@ManagedBean
public class ReceitaBean extends AbstractBean{
	
	private List<Receita> receitas;
	private List<ReceitaUnica> receitaUnica;
	private List<Mes> meses;
	private int ano;
	private Mes mes;
	private double receitaTotal;
	
	
	
	public ReceitaBean(){
		this.receitas = new ArrayList<Receita>();
		this.setReceitaUnica(new ArrayList<ReceitaUnica>());
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void buscarTodos(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.find();
		
 	}
	
	public void buscarPorAno(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.buscarPorAno(this.ano);
		
	}
	
	public void buscarPorMesAno(){
		ReceitaDAO rDAO = new ReceitaJPADAO();
		this.receitas = rDAO.buscarPorMesAno(this.mes, this.ano);
		
	}
	
	public void somaReceita(){
		ReceitaUnica ru = new ReceitaUnica();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		Double somaMensa = rmDAO.soma(this.mes, this.ano);
		if(somaMensa == null){somaMensa = new Double(0);}
		ru.setTotal(somaMensa);
		ru.setNome("Mensalidade");
		this.receitaUnica.add(ru);
		ru = new ReceitaUnica();
		
		ReceitaMatriculaDAO rmatDAO = new ReceitaMatriculaJPADAO();
		Double somaMatri = rmatDAO.soma(this.mes, this.ano);
		if(somaMatri == null){somaMatri = new Double(0);}
		ru.setTotal(somaMatri);
		ru.setNome("Matricula");
		this.receitaUnica.add(ru);
		ru = new ReceitaUnica();
		
		ReceitaLivroDAO rlDAO = new ReceitaLivroJPADAO();
		Double somaLivro = rlDAO.soma(this.mes, this.ano);
		if(somaLivro == null){somaLivro = new Double(0);}
		ru.setTotal(somaLivro);
		ru.setNome("Livro");
		this.receitaUnica.add(ru);
		ru = new ReceitaUnica();
		
		ReceitaExtraDAO reDAO = new ReceitaExtraJPADAO();
		Double somaExtra = reDAO.soma(this.mes, this.ano);
		if(somaExtra == null){somaExtra = new Double(0);}
		ru.setTotal(somaExtra);
		ru.setNome("Extra");
		this.receitaUnica.add(ru);
		ru = new ReceitaUnica();
		
		this.receitaTotal = somaMatri.doubleValue() + somaExtra.doubleValue() + somaLivro.doubleValue() + somaMensa.doubleValue();
	}
	
	public double somaReceitaTotal(List<ReceitaUnica> r){
		double total = 0;
		for(ReceitaUnica re : r){
			total = total + re.getTotal().doubleValue();
		}
		return total;
	}
	
	public List<Receita> getReceitas() {
		return receitas;
	}
	
	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
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

	public double getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(double receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

	public List<ReceitaUnica> getReceitaUnica() {
		return receitaUnica;
	}

	public void setReceitaUnica(List<ReceitaUnica> receitaUnica) {
		this.receitaUnica = receitaUnica;
	}
	
	

}
