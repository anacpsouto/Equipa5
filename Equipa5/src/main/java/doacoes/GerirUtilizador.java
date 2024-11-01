package doacoes;

import java.util.ArrayList;
import java.util.Scanner;

public class GerirUtilizador {
	private ArrayList<Utilizador> utilizadores;
	
	public GerirUtilizador() {
        utilizadores = new ArrayList<>();
    }
	
	public void adicionarUtilizador(String email, String pass) {
        if (checkPassword(pass)) {
            Utilizador u = new Utilizador(email, pass);
            utilizadores.add(u);
        } else {
            System.out.println("Palavra pass tem ter 7 caracteres um mauiusculo e um especial ");
        }
    }
	
	public Utilizador pesquisar(String email, String pass) {
        for (Utilizador u : utilizadores) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }
	
	public void adicionarEquipamento(String email, String pass, Equipamento equipamento) {
        Utilizador u = pesquisar(email, pass);
        if (u != null) {
            u.setEquipamento(equipamento);
        }
    }

    public void mostrarEquipamentos(String email, String pass) {
        Utilizador u = pesquisar(email, pass);
        if (u != null) {
            for (Equipamento equipamento : u.getEquipamento()) {
                System.out.println("Nome: " + equipamento.getNome() + ", Ano: " + equipamento.getAno() + ", Modelo: " + equipamento.getModelo() + ", Estado: " + equipamento.getEstadoConservacao() + equipamento.toString());
            }
        }
    }
    
    public boolean checkPassword(String password) {
        if (password.length() < 6 || password.length() > 12) {
            return false;
        } else {
            if (password.equals(password.toLowerCase())) {
                return false;
            } else {
                if (password.matches("[a-zA-Z0-9]*")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Utilizador pesquisarUtilizadorPorEmail(String email) {
        for (Utilizador u : utilizadores) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
    
    public void solicitarEquipamento(String emailDono, String equipamentoSolicitado) {
        Utilizador dono = pesquisarUtilizadorPorEmail(emailDono);

        if (dono != null) {
            for (Equipamento equipamento : dono.getEquipamento()) {
                if (equipamento.getNome().equalsIgnoreCase(equipamentoSolicitado)) {
                    dono.adicionarSolicitacao("Solicitação para o equipamento: " + equipamentoSolicitado);
                    System.out.println("Solicitação enviada.");
                    return;
                }
            }
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Utilizador dono não encontrado.");
        }
    }
    
    // falta metodo para ver solicitações
    
    public void verSolicitacoes(String email, String pass) {
        Utilizador u = pesquisar(email, pass);
        if (u != null) {
            if (u.getSolicitacoes().isEmpty()) {
                System.out.println("Não há solicitações pendentes.");
            } else {
                Scanner sc = new Scanner(System.in);
                for (String solicitacao : new ArrayList<>(u.getSolicitacoes())) {
                    System.out.println(solicitacao);
                    System.out.println("Aceitar a solicitação? (sim/nao)");
                    String resposta = sc.nextLine();
                    if (resposta.equalsIgnoreCase("sim")) {
                        
                            // Solicitação normal
                            String[] parts = solicitacao.split(": ");
                            String nomeEquipamento = parts[1];
                            Equipamento equipamentoARemover = null;
                            for (Equipamento equipamento : u.getEquipamento()) {
                                if (equipamento.getNome().equalsIgnoreCase(nomeEquipamento)) {
                                    equipamentoARemover = equipamento;
                                    break;
                                }
                            }
                            if (equipamentoARemover != null) {
                                u.getEquipamento().remove(equipamentoARemover);
                                System.out.println("Solicitação aceita e equipamento removido.");
                            }
                        
                        u.getSolicitacoes().remove(solicitacao);
                        break;
                    }
                
                    else if (resposta.equalsIgnoreCase("nao")) {
                        System.out.println("Solicitação rejeitada.");
                        u.getSolicitacoes().remove(solicitacao);
                        break;
                    } else {
                        System.out.println("Resposta inválida.");
                    }
                }
            }
        } else {
            System.out.println("Utilizador não encontrado.");
        }
    }
    
    /**
    public void adicionarRecebido (String email, String pass, Equipamento equipamento) {
    	Utilizador u = pesquisar(email, pass);
        if (u != null) {
            u.adicionarRecebido(equipamento);
        }
        
    public void adicionarDoacao (String email, String pass, Equipamento equipamento) {
    	Utilizador u = pesquisar(email, pass);
        if (u != null) {
            u.adicionarDaocao(equipamento);
        }
    */
    
    

}
