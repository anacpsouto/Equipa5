/**
 * 
 */
package doacoes;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class Tipo  {
	private List<Desktop> listaDesktop;
	private List<Laptop> listaLaptop;
	private List<Monitor> listaMonitor;
	private List<Acessorio> listaRato;
	private List<Acessorio> listaCalculadora;
	private List<Acessorio> listaFone;
	private List<Acessorio> listaTeclado;
	
	public Tipo() {
		listaDesktop = new ArrayList<>();
		listaLaptop = new ArrayList<>();
		listaMonitor = new ArrayList<>();
		listaRato = new ArrayList<>();
		listaCalculadora = new ArrayList<>();
		listaFone = new ArrayList<>();
		listaTeclado = new ArrayList<>();
	}

	public void adicionaDesktop(Desktop novoDesktop) {
		listaDesktop.add(novoDesktop);
	    }
		public void adicionaLaptop(Laptop novoLaptop) {
			listaLaptop.add(novoLaptop);
		}
	public void adicionaMonitor(Monitor novoMonitor) {
			listaMonitor.add(novoMonitor);
		}
	public void adicionaRato(Acessorio novoRato) {
		
		listaRato.add(novoRato);
	}
	public void adicionaCalculadora(Acessorio novoCalculadora) {
		listaCalculadora.add(novoCalculadora);
	}
	public void adicionaFone(Acessorio novoFone) {
		listaFone.add(novoFone);
	}
	public void adicionaTeclado(Acessorio novoTeclado) {
		listaTeclado.add(novoTeclado);
	}
}
