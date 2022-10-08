package br.com.asd;

import java.util.Random;

public class Lavador extends Thread {
    private int retirarAgua(int capacidadeCaneca) {
        int aguaRetirada = EstadoAplicacao.retirarAgua(capacidadeCaneca);
        System.out.printf("Lavador -> retirou: %s. Balde -> Volume: %s.%n ", capacidadeCaneca, EstadoAplicacao.getVolumeBaldeAgua());
        return aguaRetirada;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);

            while (true) {
                this.retirarAgua(20);
                Thread.sleep(new Random().nextInt(4000));
            }
        } catch (InterruptedException ex) {
            System.out.println("Aplicação Lavador finalizada.");
        }
    }
}
