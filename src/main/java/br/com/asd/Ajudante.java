package br.com.asd;

import java.util.Optional;
import java.util.Random;

public class Ajudante extends Thread {
    private int numeroAjudante;

    public Ajudante(int numeroAjudante) {
        this.numeroAjudante = numeroAjudante;
    }

    public int colocarAgua(int capacidadeCaneca) {
        int aguaColocada = EstadoAplicacao.colocarAgua(capacidadeCaneca);
        System.out.printf("Ajudante n. %s -> colocou: %s. Balde -> Volume: %s.%n ", numeroAjudante, capacidadeCaneca, EstadoAplicacao.getVolumeBaldeAgua());
        return aguaColocada;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (EstadoAplicacao.getVolumeBaldeAgua() > 100) {
                    EstadoAplicacao.normalizarVolumeAgua();
                    System.out.printf("Balde transbordou. Ajudantes aguardando!%n");
                    Thread.sleep(2000);
                }

                this.colocarAgua(3);
                Thread.sleep(1000 + new Random().nextInt(3000));

                if (EstadoAplicacao.getVolumeBaldeAgua() <= 0) {
                        Thread.currentThread().interrupt();
                }

            }
        } catch (InterruptedException ex) {
            System.out.println("Aplicação Ajudante finalizada.");
        }

    }
}
