package fag.objetos;

import java.util.ArrayList;
import java.util.List;

public class Hospede {
    private String nome;
    private List<Reserva> reservas;

    public Hospede(String nome) {
        this.nome = nome;
        this.reservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}