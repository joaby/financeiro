package controle;

import java.io.Serializable;

import dao.AlunoDAO;
import dao.AlunoJPADAO;
import dao.UsuarioDAO;
import dao.UsuarioJPADAO;
import modelo.Aluno;
import modelo.Usuario;

public class UsuarioBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public UsuarioBean(){
		
	}
	
	public void cadastrar(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioJPADAO();
			Usuario u = usuarioDAO.find(this.usuario.getNome());
			if(u == null){
				usuarioDAO.save(this.usuario);
				displayInfoMessageToUser("Cadastrado com sucesso!");
				this.usuario = new Usuario();
			}
			else{
				displayErrorMessageToUser("Usuário já cadastrado!");
				this.usuario = new Usuario();
			}
		} catch (Exception e) {
			displayErrorMessageToUser("Erro no cadastramento!");
			this.usuario = new Usuario();
		}
	}
	
	public void atualizar(){
		UsuarioDAO usuarioDAO = new UsuarioJPADAO();
		usuarioDAO.save(this.usuario);
		displayInfoMessageToUser("Atualizado com sucesso!");
		this.usuario = new Usuario();
	}
	
	public void excluir(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioJPADAO();
			usuarioDAO.delete(usuario);
			displayInfoMessageToUser("Excluido com sucesso!");
			this.usuario = new Usuario();
		} catch (Exception e) {
			displayErrorMessageToUser("Erro ao excluir!");
		}
	}
}
