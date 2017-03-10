package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.UsuarioDAO;
import dao.UsuarioJPADAO;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarios = new ArrayList<Usuario>();
	}

	public void buscarTodos() {
		this.usuarios = new ArrayList<Usuario>();
		UsuarioDAO usuarioDAO = new UsuarioJPADAO();
		this.usuarios = usuarioDAO.find();
	}

	public void cadastrar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioJPADAO();
			Usuario u = usuarioDAO.find(this.usuario.getNome());
			if (u == null) {
				usuarioDAO.save(this.usuario);
				displayInfoMessageToUser("Cadastrado com sucesso!");
				this.usuario = new Usuario();
			} else {
				displayErrorMessageToUser("Usuário já cadastrado!");
				this.usuario = new Usuario();
			}
		} catch (Exception e) {
			displayErrorMessageToUser("Erro no cadastramento!");
			this.usuario = new Usuario();
		}
	}

	public void atualizar() {
		UsuarioDAO usuarioDAO = new UsuarioJPADAO();
		usuarioDAO.save(this.usuario);
		displayInfoMessageToUser("Atualizado com sucesso!");
		this.usuario = new Usuario();
	}

	public void excluir(Usuario u) {
		UsuarioDAO usuarioDAO = new UsuarioJPADAO();
		usuarioDAO.delete(u);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.usuarios.remove(u);
	}

	public int sortByNome(String n1, String n2) {
		return n1.compareTo(n2);
	}
	
	public int sortByEmail(String e1, String e2) {
		return e1.compareTo(e2);
	}
	
	public int sortByLogin(String l1, String l2) {
		return l1.compareTo(l2);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}