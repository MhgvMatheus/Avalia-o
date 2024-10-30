package fag.objetos;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Hospede> hospedes;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        hospedes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(String numero, String tipo, double precoDiario) {
        Quarto quarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(quarto);
    }

    public void cadastrarHospede(String nome) {
        Hospede hospede = new Hospede(nome);
        hospedes.add(hospede);
    }

    public void cadastrarReserva(String nomeHospede, String dataCheckin, String dataCheckout, String tipoQuarto, int numeroQuartos) {
        Hospede hospede = hospedes.stream().filter(h -> h.getNome().equals(nomeHospede)).findFirst().orElse(null);
        if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }

        List<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto q : quartos) {
            if (q.getTipo().equals(tipoQuarto) && q.isDisponibilidade()) {
                quartosDisponiveis.add(q);
            }
        }

        if (quartosDisponiveis.size() < numeroQuartos) {
            System.out.println("Não há quartos disponíveis do tipo solicitado.");
            return;
        }

        Reserva reserva = new Reserva(hospede, dataCheckin, dataCheckout, tipoQuarto, numeroQuartos);
        reservas.add(reserva);
        hospede.getReservas().add(reserva);

        for (int i = 0; i < numeroQuartos; i++) {
            quartosDisponiveis.get(i).setDisponibilidade(false);
        }
    }

    public void relatorioOcupacao() {
        int ocupadosSolteiro = 0;
        int ocupadosCasal = 0;
        int ocupadosSuite = 0;

        for (Quarto q : quartos) {
            if (!q.isDisponibilidade()) {
                switch (q.getTipo()) {
                    case "solteiro":
                        ocupadosSolteiro++;
                        break;
                    case "casal":
                        ocupadosCasal++;
                        break;
                    case "suite":
                        ocupadosSuite++;
                        break;
                }
            }
        }

        System.out.println("Relatório de Ocupação:");
        System.out.println("Solteiro: " + ocupadosSolteiro);
        System.out.println("Casal: " + ocupadosCasal);
        System.out.println("Suite: " + ocupadosSuite);
    }

    public void relatorioHistoricoReservas(String nomeHospede) {
        Hospede hospede = hospedes.stream().filter(h -> h.getNome().equals(nomeHospede)).findFirst().orElse(null);
        if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }

        System.out.println("Histórico de Reservas de " + nomeHospede + ":");
        for (Reserva r : hospede.getReservas()) {
            System.out.println("Data de Check-in: " + r.getDataCheckin() + ", Data de Check-out: " + r.getDataCheckout() +
                               ", Tipo de Quarto: " + r.getTipoQuarto() + ", Número de Quartos: " + r.getNumeroQuartos());
        }
    }
}