/**
 * @author Equipa5
 * Descricao da classe utilizadores:
 */
package doacoes;

/**
 *
 */

public class Utilizador {

	private String nome;
	private String email;
	private String password;


	public Utilizador() {

	}

	/**
	 * @param nome
	 * @param email
	 * @param password
	 */

	public Utilizador(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
