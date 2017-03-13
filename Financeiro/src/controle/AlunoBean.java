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
import dao.ReceitaMensalidadeDAO;
import dao.ReceitaMensalidadeJPADAO;
import modelo.Aluno;
import modelo.Mes;
import modelo.Serie;

@ManagedBean
@ViewScoped
public class AlunoBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private List<Aluno> alunos;
	private Mes mes;
	private int ano;
	private List<Mes> meses;
	private char sexo;
	private Integer totalAlunos;

	public AlunoBean() {
		this.meses = Arrays.asList(Mes.values());
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
	}

	public void buscarAtivos() {
		this.alunos = new ArrayList<Aluno>();
		AlunoDAO alunoDAO = new AlunoJPADAO();
		this.alunos = alunoDAO.buscarPorAtivo();
	}

	public void buscarInativos() {
		this.alunos = new ArrayList<Aluno>();
		AlunoDAO alunoDAO = new AlunoJPADAO();
		this.alunos = alunoDAO.buscarPorInativo();
	}

	public void buscarPorSexo() {
		this.alunos = new ArrayList<Aluno>();
		AlunoDAO alunoDAO = new AlunoJPADAO();
		this.alunos = alunoDAO.buscarPorSexo(this.sexo);
	}

	public void somarAtivos() {
		AlunoDAO alunoDAO = new AlunoJPADAO();
		this.totalAlunos = alunoDAO.somar();
	}

	public void cadastrar() {
		try {
			AlunoDAO alunoDAO = new AlunoJPADAO();
			alunoDAO.save(this.aluno);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.aluno = new Aluno();
		}catch (Exception e) {
        	displayErrorMessageToUser("Aluno já existe");
        }
	}
	
	public void selecionarParaAtualizar(Aluno a){
		this.aluno = a;
		RequestContext.getCurrentInstance().execute("PF('edit').show()");
	}

	public void atualizar() {
		AlunoDAO alunoDAO = new AlunoJPADAO();
		alunoDAO.save(this.aluno);
		displayInfoMessageToUser("Atualizado com sucesso!");
		this.aluno = new Aluno();
	}

	public void excluir(Aluno a) {
		AlunoDAO alunoDAO = new AlunoJPADAO();
		alunoDAO.delete(a);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.alunos.remove(a);
	}

	public void buscarPorNaoPagante() {
		this.alunos = new ArrayList<Aluno>();
		ReceitaMensalidadeDAO rmDAO = new ReceitaMensalidadeJPADAO();
		this.alunos = rmDAO.buscarPorNaoPagante(this.mes, this.ano);
	}

	public int sortBySerie(Serie a, Serie b) {
		return a.compareTo(b);
	}

	public int sortByNome(String n1, String n2) {
		return n1.compareTo(n2);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

	public List<Mes> getMeses() {
		return meses;
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Integer getTotalAlunos() {
		return totalAlunos;
	}

	public void setTotalAlunos(Integer totalAlunos) {
		this.totalAlunos = totalAlunos;
	}

}
