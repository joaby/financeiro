package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.DespesaAguaDAO;
import dao.DespesaAguaJPADAO;
import modelo.DespesaAgua;
import modelo.Mes;

@ManagedBean
@ViewScoped
public class DespesaAguaBean extends AbstractBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private DespesaAgua despesaAgua;
	private List<DespesaAgua> despesasAguas;
	private List<Mes> meses;
	private Mes mes;
	private int ano;
	private float despesaTotal;
	
	public DespesaAguaBean(){
		this.despesaAgua = new DespesaAgua();
		this.despesasAguas = new ArrayList<DespesaAgua>();
		this.meses = Arrays.asList(Mes.values());
	}
	
	public void cadastrar(){
		DespesaAguaDAO dDAO = new DespesaAguaJPADAO();
		dDAO.save(this.despesaAgua);
		displayInfoMessageToUser("Cadastrado com sucesso!");
		this.despesaAgua = new DespesaAgua();
		
	}
	
	public void buscarPorAno(){
		this.despesasAguas = new ArrayList<DespesaAgua>();
		DespesaAguaDAO dDAO = new DespesaAguaJPADAO();
		this.despesasAguas = dDAO.buscarPorAno(this.ano);
		this.despesaTotal = somaDespesaTotal(this.despesasAguas);
	}
	
	public void buscarPorMesAno(){
		this.despesasAguas = new ArrayList<DespesaAgua>();
		DespesaAguaDAO dDAO = new DespesaAguaJPADAO();
		this.despesasAguas = dDAO.buscarPorMesAno(this.mes, this.ano);
		this.despesaTotal = somaDespesaTotal(this.despesasAguas);
	}
	
	public float somaDespesaTotal(List<DespesaAgua> d){
		float total = 0;
		for(int i = 0; i < d.size(); i++){
			total += d.get(i).getValor();
		}
		return total;
	}
	
	public DespesaAgua getDespesaAgua() {
		return despesaAgua;
	}
	public void setDespesaAgua(DespesaAgua despesaAgua) {
		this.despesaAgua = despesaAgua;
	}
	public List<DespesaAgua> getDespesasAguas() {
		return despesasAguas;
	}
	public void setDespesasAguas(List<DespesaAgua> despesasAguas) {
		this.despesasAguas = despesasAguas;
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
	public float getDespesaTotal() {
		return despesaTotal;
	}
	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}
	
	

}
