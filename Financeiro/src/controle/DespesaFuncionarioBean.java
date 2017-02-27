package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.DespesaFuncionarioDAO;
import dao.DespesaFuncionarioJPADAO;
import modelo.DespesaFuncionario;

@ManagedBean
public class DespesaFuncionarioBean extends AbstractBean{
	
	private DespesaFuncionario despesaFuncionario;
	private List<DespesaFuncionario> despesaFuncionarios;
	private int despesaTotal;
	
	public DespesaFuncionarioBean(){
		this.despesaFuncionario = new DespesaFuncionario();
		this.despesaFuncionarios = new ArrayList<DespesaFuncionario>();
	}
	
	public void cadastrar(){
		DespesaFuncionarioDAO dDAO = new DespesaFuncionarioJPADAO();
		dDAO.save(this.despesaFuncionario);
		displayInfoMessageToUser("Cadastrado com sucesso!");
		this.despesaFuncionario = new DespesaFuncionario();
	}
	
	public void excluir(){
		DespesaFuncionarioDAO dDAO = new DespesaFuncionarioJPADAO();
		dDAO.delete(this.despesaFuncionario);;
		displayInfoMessageToUser("Excluido com sucesso!");
		this.despesaFuncionario = new DespesaFuncionario();
	}
	
	public void buscarTodos(){
		this.despesaFuncionarios = new ArrayList<DespesaFuncionario>();
		DespesaFuncionarioDAO dDAO = new DespesaFuncionarioJPADAO();
		this.despesaFuncionarios = dDAO.find();
	}
	
	public DespesaFuncionario getDespesaFuncionario() {
		return despesaFuncionario;
	}
	public void setDespesaFuncionario(DespesaFuncionario despesaFuncionario) {
		this.despesaFuncionario = despesaFuncionario;
	}
	public List<DespesaFuncionario> getDespesaFuncionarios() {
		return despesaFuncionarios;
	}
	public void setDespesaFuncionarios(List<DespesaFuncionario> despesaFuncionarios) {
		this.despesaFuncionarios = despesaFuncionarios;
	}
	public int getDespesaTotal() {
		return despesaTotal;
	}
	public void setDespesaTotal(int despesaTotal) {
		this.despesaTotal = despesaTotal;
	}
	
	

}
