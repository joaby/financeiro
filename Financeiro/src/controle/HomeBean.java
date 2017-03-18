package controle;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.DespesaDAO;
import dao.DespesaJPADAO;
import dao.ReceitaDAO;
import dao.ReceitaJPADAO;
import modelo.Mes;

@ManagedBean
@ViewScoped
public class HomeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nomeUsuario;
	private Double despesaTotal;
	private Double receitaTotal;
	private Double saldo;
	private Mes mesAtual;
	private int anoAtual;
	
	public HomeBean(){
		this.despesaTotal = new Double(0);
		this.receitaTotal = new Double(0);
		this.saldo = new Double(0);
		buscarNomeUsuario();
		this.setAnoAtual(pegarAnoAtual());
		this.setMesAtual(pegarMesAtual());
		buscarDespesaReceitaTotal();
	}
	
	public void buscarNomeUsuario(){
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.nomeUsuario = (String) sessao.getAttribute("nome");
	}
	
	public void buscarDespesaReceitaTotal(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(false);
		Mes mes  = pegarMesAtual();
		int ano = pegarAnoAtual();
		DespesaDAO dDAO = new DespesaJPADAO();
		Double d = dDAO.soma(mes, ano);
		if(d != null){ 
			this.despesaTotal = d;
		}
		ReceitaDAO rDAO = new ReceitaJPADAO();
		Double r = rDAO.soma(mes, ano);
		if(r != null){
			this.receitaTotal = r;
		}
		
		this.saldo = receitaTotal - despesaTotal;
	}
	
	public int pegarAnoAtual() {
		Calendar cal = Calendar.getInstance();
		int ano = cal.get(Calendar.YEAR);
		return ano;
	}

	public Mes pegarMesAtual() {
		Calendar cal = Calendar.getInstance();
		int mes = cal.get(Calendar.MONTH);
		switch (mes) {
		case 0:
			return Mes.JANEIRO;
		case 1:
			return Mes.FEVEREIRO;
		case 2:
			return Mes.MARCO;
		case 3:
			return Mes.ABRIL;
		case 4:
			return Mes.MAIO;
		case 5:
			return Mes.JUNHO;
		case 6:
			return Mes.JULHO;
		case 7:
			return Mes.AGOSTO;
		case 8:
			return Mes.SETEMBRO;
		case 9:
			return Mes.OUTUBRO;
		case 10:
			return Mes.NOVEMBRO;
		case 11:
			return Mes.DEZEMBRO;
		default:
			return Mes.JANEIRO;
		}
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Double getDespesaTotal() {
		return despesaTotal;
	}

	public void setDespesaTotal(Double despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

	public Double getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(Double receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

	public int getAnoAtual() {
		return anoAtual;
	}

	public void setAnoAtual(int anoAtual) {
		this.anoAtual = anoAtual;
	}

	public Mes getMesAtual() {
		return mesAtual;
	}

	public void setMesAtual(Mes mesAtual) {
		this.mesAtual = mesAtual;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
