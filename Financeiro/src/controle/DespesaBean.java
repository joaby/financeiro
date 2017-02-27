package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.DespesaDAO;
import dao.DespesaJPADAO;
import modelo.Despesa;
import modelo.Mes;

@ManagedBean
public class DespesaBean extends AbstractBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Despesa despesa;
	private List<Despesa> despesas;
	private Mes mes;
	private List<Mes> meses;
	private int ano;
	private float despesaTotal;
	
	public DespesaBean(){
		this.despesa = new Despesa();
		this.despesas = new ArrayList<Despesa>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void cadastrar(){
		DespesaDAO dDAO = new DespesaJPADAO();
		dDAO.save(this.despesa);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}
	
	public void buscarTodos(){
		DespesaDAO dDAO = new DespesaJPADAO();
		this.despesas = dDAO.find();
	}
	
	
	public Despesa getDespesa() {
		return despesa;
	}
	
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
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
	
	public float getDespesaTotal() {
		return despesaTotal;
	}
	
	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

}
