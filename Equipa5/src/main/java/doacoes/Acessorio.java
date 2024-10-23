package doacoes;

public class Acessorio extends Equipamento {
	private String tipoAcessorio;
	private String informacao;
	public Acessorio(String nome, String ano, String modelo, String estadoConservacao, String tipoAcessorio, String informacao) {
		super(nome, ano, modelo, estadoConservacao);
		this.tipoAcessorio = tipoAcessorio;
		this.informacao = informacao;
		
	}
	public String getTipo() {
		return tipoAcessorio;
	}
	public void setTipo(String tipoAcessorio) {
		this.tipoAcessorio = tipoAcessorio;
	}
	public String getInformacao() {
		return informacao;
	}
	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	
	@Override
	public String toString() {
		return ", Tipo de Acessório: " + tipoAcessorio + ", Informação : " + informacao;
	}

	
	
}
