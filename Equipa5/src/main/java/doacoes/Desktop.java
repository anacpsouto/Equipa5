package doacoes;

public class Desktop extends Computador {
	private String placa;
	private String processador;
	private int disco;
	private int ram;
	
	public Desktop( String placa, String processador, int disco, int ram) {
		this.placa = placa;
		this.processador = processador;
		this.disco = disco;
		this.ram = ram;
		}

	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public int getDisco() {
		return disco;
	}

	public void setDisco(int disco) {
		this.disco = disco;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
}
