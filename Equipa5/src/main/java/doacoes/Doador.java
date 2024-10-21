/**
 * 
 */
package doacoes;

/**
 * 
 */
public class Doador {
	
	private String nomedoador;
	private String equipamento;
	private String dataEq;
	private String tipo;
	
	public Doador(String nomedoador,String equipamento,String dataEq,String tipo ) {
		this.nomedoador=nomedoador;
		this.equipamento=equipamento;
		this.dataEq=dataEq;
		this.tipo=tipo;
		
	}
	public String getNomedoador() {
		return nomedoador;
	}
	
	public void setNomedoador(String nomedoador) {
		this.nomedoador = nomedoador;
	}
	
	public String getEquipamento() {
		return equipamento;
	}
	
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	
	public String getDataEq() {
		return dataEq;
	}
	
	public void setDataEq(String dataEq) {
		this.dataEq = dataEq;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	@Override
	public String toString() {
		return "Doador [nomedoador=" + nomedoador + ", equipamento=" + equipamento + ", dataEq=" + dataEq + ", tipo=" + tipo
				+ "]";
	}

}
