package fag;

import java.util.Scanner;

import fag.objetos.Hotel;

public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Hóspede");
            System.out.println("3. Cadastrar Reserva");
            System.out.println("4. Relatório de Ocupação");
            System.out.println("5. Relatório de Histórico de Reservas");
            System.out.println("6. Sair");
            
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcao) {
                case 1:
                    System.out.print("Número do quarto: ");
                    String numero = scanner.nextLine();
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double precoDiario = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, precoDiario);
                    break;
                    
                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nome = scanner.nextLine();
                    hotel.cadastrarHospede(nome);
                    break;
                    
                case 3:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Data de check-in (DD/MM/AAAA): ");
                    String dataCheckin = scanner.nextLine();
                    System.out.print("Data de check-out (DD/MM/AAAA): ");
                    String dataCheckout = scanner.nextLine();
                    System.out.print("Tipo de quarto: ");
                    String tipoQuarto = scanner.nextLine();
                    System.out.print("Número de quartos: ");
                    int numeroQuartos = scanner.nextInt();
                    hotel.cadastrarReserva(nomeHospede, dataCheckin, dataCheckout, tipoQuarto, numeroQuartos);
                    break;

                case 4:
                    hotel.relatorioOcupacao();
                    break;

                case 5:
                    System.out.print("Nome do hóspede para ver histórico: ");
                    String nomeHistorico = scanner.nextLine();
                    hotel.relatorioHistoricoReservas(nomeHistorico);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}