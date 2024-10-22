package doacoes;

public class Monitor extends Equipamento {
	private int dimensao;
	private int hertz;
	private int temporesposta;
	private String marca;
	
	public Monitor(int dimensao, int hertz,String ano, int temporesposta, String marca,int estado, Tipo tipo, String modelo) {
		super(estado, ano, tipo, modelo);
		this.dimensao = dimensao;
		this.hertz = hertz;
		this.temporesposta = temporesposta;
		this.marca = marca;
	}

	public int getDimensao() {
		return dimensao;
	}
	      
	public void setDimensao(int dimensao) {
		this.dimensao = dimensao;
	}

	public int getHertz() {
		return hertz;
	}

	public void setHertz(int hertz) {
		this.hertz = hertz;
	}
	public int getTemporesposta() {
		return temporesposta;
	}

	public void setTemporesposta(int temporesposta) {
		this.temporesposta = temporesposta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
