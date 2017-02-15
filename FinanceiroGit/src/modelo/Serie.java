package modelo;

public enum Serie {
	ANO_1("1� ano"), ANO_2("2� ano"), ANO_3("3� ano"), ANO_4("4� ano"), ANO_5("5� ano"), 
	ANO_6("6� ano"), ANO_7("7� ano"), ANO_8("8� ano"), ANO_9("9� ano"), INFANTIL_2("Infantil II"), 
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
