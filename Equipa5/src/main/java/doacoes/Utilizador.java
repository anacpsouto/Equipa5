package doacoes;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Utilizador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private List <String> recebidos;
	private List <String> doacoes;
	private List <Equipamento> equipamentos;
	private List <String> solicitacoes;

	public Utilizador(String email, String password) {
		this.email = email;
		this.password = password;
		recebidos = new ArrayList<>();
		doacoes = new ArrayList<>();
		equipamentos = new ArrayList<>();
		solicitacoes = new ArrayList<>();

	}

	public void adicionarRecebido(String recebido) {
		recebidos.add(recebido);
	}

	public void adicionarDoacao(String doacao) {
		doacoes.add(doacao);
	}
	
	public void adicionarSolicitacao(String solicitacao) {
		solicitacoes.add(solicitacao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<String> getRecebidos() {
		return recebidos;
	}

	public void setRecebidos(List<String> recebidos) {
		this.recebidos = recebidos;
	}

	public List<String> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<String> doacoes) {
		this.doacoes = doacoes;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Equipamento equipamento) {
		this.equipamentos = equipamentos;
	}

	public List<String> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<String> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	
	
} // end class
