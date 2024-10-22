package doacoes;

public class Acessorio extends Equipamento {
	private String tipoAcessorio;
	public Acessorio(String tipoAcessorio,String modelo,Tipo tipo, String estado, int ano) {
		super(ano, estado, tipo, modelo);
		this.tipoAcessorio = tipoAcessorio;
	}
	public String getTipoAcessorio() {
		return tipoAcessorio;
	}
	public void setTipoAcessorio(String tipoAcessorio) {
		this.tipoAcessorio = tipoAcessorio;
	}
	
}
