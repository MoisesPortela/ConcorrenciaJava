package br.com.asd;

import java.util.Random;

public class Lavador extends Thread {
    public Lavador() {

    }

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
                this.retirarAgua(10);
                Thread.sleep(2000 + new Random().nextInt(3000));
            }
        } catch (InterruptedException ex) {
            System.out.println("Aplicação Lavador finalizada.");
        }
    }
}
