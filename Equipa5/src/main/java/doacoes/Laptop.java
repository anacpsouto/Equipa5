package doacoes;

public class Laptop {
	private String placa;
	private String processador;
	private String cpu;
	private int ano;
	private int memoria;
	
	public Laptop( String placa, String processador, String cpu, int ano, int memoria) {
		this.placa = placa;
		this.processador = processador;
		this.cpu = cpu;
		this.ano = ano;
		this.memoria = memoria;
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

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
}
