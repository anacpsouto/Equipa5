/**
 * 
 */
package doacoes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

public class GerirDoacoes {
	private List <Utilizador> listaUtilizadores;
	
	
	public GerirDoacoes() {
		listaUtilizadores = new ArrayList<>();
	}
	
	
	
	public void adicionaUtilizador(Utilizador novoUtilizador) {
		listaUtilizadores.add(novoUtilizador);
	}

}
