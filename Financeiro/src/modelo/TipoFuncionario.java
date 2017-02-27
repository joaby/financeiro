package modelo;

public enum TipoFuncionario {
	
	DIRETOR("Diretor"), COORDENADOR("Coordenador"), PROFESSOR("Professor"), MERENDEIRA("Merendeira"), ZELADOR("Zelador"), PORTEIRO("Porteiro"), OUTRO("Outro");
	
	private String descricao;
	
	TipoFuncionario(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
