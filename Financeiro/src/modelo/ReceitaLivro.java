package modelo;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ReceitaLivro.buscarPorAno", 
			query="SELECT rl FROM ReceitaLivro rl WHERE rl.ano = :ano"),
	@NamedQuery(name="ReceitaLivro.buscarPorMesAno", 
			query="SELECT rl FROM ReceitaLivro rl WHERE rl.mes = :mes AND rl.ano = :ano"),
	@NamedQuery(name="ReceitaLivro.soma", 
			query="SELECT SUM(rl.valor) FROM ReceitaLivro rl WHERE rl.mes = :mes AND rl.ano = :ano")
})
public class ReceitaLivro extends Receita{
	
	
}
