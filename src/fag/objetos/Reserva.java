package fag.objetos;

public class Reserva {
    private Hospede hospede;
    private String dataCheckin;
    private String dataCheckout;
    private String tipoQuarto;
    private int numeroQuartos;

    public Reserva(Hospede hospede, String dataCheckin, String dataCheckout, String tipoQuarto, int numeroQuartos) {
        this.hospede = hospede;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.tipoQuarto = tipoQuarto;
        this.numeroQuartos = numeroQuartos;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public String getDataCheckin() {
        return dataCheckin;
    }

    public String getDataCheckout() {
        return dataCheckout;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }
}