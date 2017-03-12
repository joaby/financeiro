package modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaMensalidade.buscarPorMesAno", 
			query="SELECT rm FROM ReceitaMensalidade rm WHERE rm.mes = :mes AND rm.ano = :ano"),
	@NamedQuery(name="ReceitaMensalidade.buscarPorAno", 
			query="SELECT rm FROM ReceitaMensalidade rm WHERE rm.ano = :ano"),
	@NamedQuery(name="ReceitaMensalidade.buscarPorNaoPagante", 
			query="SELECT a FROM Aluno a WHERE a NOT IN (SELECT rm.aluno FROM ReceitaMensalidade rm WHERE rm.mes = :mes AND rm.ano = :ano) AND a.ativo = true"),
	@NamedQuery(name="ReceitaMensalidade.buscarPorSerie", 
			query="SELECT rm FROM ReceitaMensalidade rm WHERE rm.matricula.serie = :serie AND rm.mes = :mes AND rm.ano = :ano"),
	@NamedQuery(name="ReceitaMensalidade.soma", 
			query="SELECT SUM(rm.valor) FROM ReceitaMensalidade rm WHERE rm.mes = :mes AND rm.ano = :ano")
})

public class ReceitaMensalidade extends Receita{
	
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private ReceitaMatricula matricula;
	
	public ReceitaMensalidade(){
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ReceitaMatricula getMatricula() {
		return matricula;
	}

	public void setMatricula(ReceitaMatricula matricula) {
		this.matricula = matricula;
	}

}
