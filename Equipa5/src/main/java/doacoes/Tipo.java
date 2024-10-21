/**
 * 
 */
package doacoes;

import java.util.ArrayList;
/**
 * 
 */
public class Tipo  {
	private List <Desktops> listaDesktop;
	private List <Laptops> listaLaptop;
	private List <Monitores> listaMonitor;
	private List <Ratos> listaRato;
	private List <Calculadoras> listaCalculadora;
	private List <Fones> listaFone;
	private List <Teclados> listaTeclado;
	
	public GerirTipo() {
		listaDesktop = new ArrayList<>();
		listaLaptop = new ArrayList<>();
		listaMonitor = new ArrayList<>();
		listaRato = new ArrayList<>();
		listaCalculadora = new ArrayList<>();
		listaFone = new ArrayList<>();
		listaTeclado = new ArrayList<>();
		
	
	
	
	public void adicionaDesktop(Desktop novoDesktop) {
		listaDesktops.add(novoDesktop);
	    }
		public void adicionaLaptop(Laptop novoLaptop) {
			listaUtilizadores.add(novoUtilizador);
		}
	public void adicionaMonitor(Monitor novoMonitor) {
			listaLaptops.add(novoLaptop);
		}
	public void adicionaRato(Rato novoRato) {
		listaURatos.add(novoRato);
	}
	public void adicionaCalculadora(Calculadora novoCalculadora) {
		listaCalculadora.add(novoalculadora);
	}
	public void adicionaFone(Fone novoFone) {
		listaFones.add(novoFone);
	}
	public void adicionaTeclado(Teclado novoTeclado) {
		listaTeclados.add(novoTeclado);
	}
	
}
