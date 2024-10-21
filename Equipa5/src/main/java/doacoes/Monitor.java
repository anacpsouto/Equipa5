package doacoes;

public class Monitor extends Equipamento {
	private int dimensao;
	private int hertz;
	private int temporesposta;
	private int ano;
	private String marca;
	
	public Monitor(int dimensao, int hertz,int ano, int temporesposta, String marca) {
		this.dimensao = dimensao;
		this.hertz = hertz;
		this.ano = ano;
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

	public int getAno() {
		return ano;
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

	public void setAno(int ano) {
		this.ano = ano;
	}
	

}
