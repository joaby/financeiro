package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DespesaFuncionario extends Despesa{
	
	@ManyToOne
	private Funcionario funcionario;
	
	public DespesaFuncionario(){
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
