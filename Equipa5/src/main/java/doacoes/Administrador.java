/**
 * 
 */
package doacoes;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
	private String nome;
    private List<Doador> doadores;
    private List<Doacao> doacoes;

    /**
     * Construtor da classe Administrador.
     */
    public Administrador(String nome) {
        this.nome = nome;
        this.doadores = new ArrayList<>();
        this.doacoes = new ArrayList<>();
    }

    /**
     * Adiciona um novo doador.
     */
    public void adicionarDoador(Doador doador) {
        doadores.add(doador);
    }

    /**
     * Remove um doador.
     */
    public void removerDoador(Doador doador) {
        doadores.remove(doador);
    }

    /**
     * Regista uma nova doação.
     */
    public void registarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }

    /**
     * Verifica as doações feitas.
     */
    public List<Doacao> verificarDoacoes() {
        return doacoes;
    }

    /**
     * Gera um relatório com todos os doadores e as suas doações.
     */
    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder("Relatório de Doadores e Doações:\n");
        for (Doador doador : doadores) {
            relatorio.append(doador.toString()).append("\n");
        }
        for (Doacao doacao : doacoes) {
            relatorio.append(doacao.toString()).append("\n");
        }
        return relatorio.toString();
    }

    /**
     * Obtém o nome do administrador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do administrador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de doadores.
     */
    public List<Doador> getDoadores() {
        return doadores;
    }
    
    /**
     * Obtém a lista de doações.
     */
    public List<Doacao> getDoacoes() {
    	return doacoes;
    }
    // Adicionar métodos necessários para o administrador
    // ex: gerirDoacoes, verificarDoacoes, etc.


}
