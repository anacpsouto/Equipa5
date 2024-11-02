package doacoes;

public class Equipamento {
	private String nome;
	private String ano;
	private String modelo;
	private String estadoConservacao;
	public Equipamento(String nome, String ano, String modelo, String estadoConservacao) {
		this.nome = nome;
		this.ano = ano;
		this.modelo = modelo;
		this.estadoConservacao = estadoConservacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getEstadoConservacao() {
		return estadoConservacao;
	}
	public void setEstadoConservacao(String estadoConservacao) {
		this.estadoConservacao = estadoConservacao;
	}	

} // end class
