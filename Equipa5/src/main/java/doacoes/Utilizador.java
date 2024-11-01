package doacoes;

import java.util.ArrayList;

public class Utilizador {
	private String email;
    private String password;
    private ArrayList<String> recebidos;
    private ArrayList<String> doacoes;
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<String> solicitacoes;


public Utilizador(String email, String password) {
    this.email = email;
    this.password = password;
    recebidos = new ArrayList<>();
    doacoes = new ArrayList<>();
    equipamentos = new ArrayList<>();
    solicitacoes = new ArrayList<>();
    
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public ArrayList<String> getRecebidos() {
    return recebidos;
}

public void adicionarRecebido(String recebido) {
    recebidos.add(recebido);
}
    
public ArrayList<String> getDoacoes() {
        return doacoes;
    }

public void adicionarDoacao(String doacao) {
        doacoes.add(doacao);
}

public ArrayList<Equipamento> getEquipamento() {
    return equipamentos;
}

public void setEquipamento(Equipamento equipamento) {
    equipamentos.add(equipamento);
}

public ArrayList<String> getSolicitacoes() {
    return solicitacoes;
}

public void adicionarSolicitacao(String solicitacao) {
    solicitacoes.add(solicitacao);
}
    
} // end class



