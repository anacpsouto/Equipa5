package doacoes;

public class Equipamento {

    private int estado;
    private String ano;
    private Tipo tipo;
    public Equipamento(int estado, String ano, Tipo tipo) {
        this.estado = estado;
        this.ano = ano;
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if(estado >= 0 && estado <= 10) {
            this.estado = estado;
        } else {
            System.out.println("Estado inválido. O valor deve ser entre 0 e 10.");
        }
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        if (ano.matches("\\d{4}")) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido. Deve ser um ano de 4 dígitos.");
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /*
    @Override
    public String toString() {
        return "Equipamento [estado=" + estado + ", ano=" + ano + ", tipo=" + tipo + "]";
    }
    */

}
