package fag.objetos;

public class Quarto {
    private String numero;
    private String tipo;
    private double precoDiario;
    private boolean disponibilidade;

    public Quarto(String numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponibilidade = true; 
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}