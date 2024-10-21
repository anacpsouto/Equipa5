/**
 * 
 */
package doacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

public class GerirDoacoes {
	private List <Utilizador> listaUtilizadores;
	
	
	public GerirDoacoes() {
		listaUtilizadores = new ArrayList<>();
	}
	
	
	public void adicionarUtilizador(Utilizador novoUtilizador) {
		listaUtilizadores.add(novoUtilizador);
	}
	
	public boolean verificarExistenciaEmail(String email) {
		for(Utilizador ut : listaUtilizadores) {
			if(ut.getEmail().equals(email)) {
				return true;
			}
		}//end for
		return false;
	}
	
	public boolean verificarQualidadeSenha(String password) {
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[az])(?=.*[AZ])"
				+ "(?=.*[@#$%&+])"
				+ "(?=\\\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();			
	}
	
	public void registrar(String nome, String email, String password) {
		boolean emailExiste = verificarExistenciaEmail(email);
		if(emailExiste == true) {
			System.out.println("Este e-mail já se encontra cadastrado.");
			return;
		}

		boolean senhaValida = verificarQualidadeSenha(password);
		if(senhaValida == false) {
			System.out.println("A sua senha precisa conter: \n "
					+ "- Pelo menos 8 caracteres. \n"
					+ "- Pelo menos 1 número. \n"
					+ "- Pelo menos 1 letra minúscula. \n"
					+ "- Pelo menos 1 letra maiúscula. \n"
					+ "- Pelo menos 1 carácter especial (@#$%&+).");
			return;
		}

		adicionarUtilizador(new Utilizador(nome, email, password));
		//Encriptar senha.
		//Salvar no banco de dados.
	}
	
	public void login(String email, String password) {
		boolean emailExiste = verificarExistenciaEmail(email);
	}
	
}
