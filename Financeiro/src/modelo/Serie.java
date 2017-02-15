package modelo;

public enum Serie {
	ANO_1("1º ano"), ANO_2("2º ano"), ANO_3("3º ano"), ANO_4("4º ano"), ANO_5("5º ano"), 
	ANO_6("6º ano"), ANO_7("7º ano"), ANO_8("8º ano"), ANO_9("9º ano"), INFANTIL_2("Infantil II"), 
	INFANTIL_3("Infantil III"), INFANTIL_4("Infantil IV"), INFANTIL_5("Infantil V");
	
	private String curso;
	
	Serie(String curso){
		this.setCurso(curso);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
