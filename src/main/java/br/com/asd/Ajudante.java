package br.com.asd;

import java.util.Random;

public class Ajudante extends Thread {
    private int numeroAjudante;

    public Ajudante(int numeroAjudante) {
        this.numeroAjudante = numeroAjudante;
    }

    public int colocarAgua(int capacidadeCaneca) {
        int aguaColocada = EstadoAplicacao.colocarAgua(capacidadeCaneca);
        System.out.printf("Ajudante n. %s -> colocou: %s. Balde -> Volume: %s.%n ", numeroAjudante, aguaColocada, EstadoAplicacao.getVolumeBaldeAgua());
        return aguaColocada;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (EstadoAplicacao.getVolumeBaldeAgua() >= 100) {
                    System.out.printf("Balde transbordou. Ajudante n. %s aguardando 2s !%n", numeroAjudante);
                    Thread.sleep(2000);
                } else {
                    Thread.sleep(1000 + new Random().nextInt(3000));
                    this.colocarAgua(3);
                }

            }
        } catch (InterruptedException ex) {
            System.out.println("Aplicação Ajudante finalizada.");
        }

    }
}
