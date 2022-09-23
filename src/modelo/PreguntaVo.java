package modelo;

public class PreguntaVo {
	
	private int Id;
	private int nivel;
	private int rCorrecta;
	private String pregunta;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getrCorrecta() {
		return rCorrecta;
	}
	public void setrCorrecta(int rCorrecta) {
		this.rCorrecta = rCorrecta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	

}
