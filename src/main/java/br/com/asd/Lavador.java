package br.com.asd;

import java.util.Random;

public class Lavador extends Thread {
    private int contadorLavagens;

    public Lavador() {
        this.contadorLavagens = 0;
    }

    private int retirarAgua(int capacidadeCaneca) {
        int aguaRetirada = EstadoAplicacao.retirarAgua(capacidadeCaneca);
        System.out.printf("Lavador -> retirou: %s. Balde -> Volume: %s.%n ", aguaRetirada, EstadoAplicacao.getVolumeBaldeAgua());
        return aguaRetirada;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);

            while (true) {
                if (EstadoAplicacao.getVolumeBaldeAgua() > 0) {
                    this.retirarAgua(10);
                    this.contadorLavagens++;
                }

                Thread.sleep(2000 + new Random().nextInt(5000));
            }
        } catch (InterruptedException ex) {
            System.out.println("Aplicação Lavador finalizada.");
            if (contadorLavagens == 1) {
                System.out.printf("Lavador lavou %s vez.%n", contadorLavagens);
            } else {
                System.out.printf("Lavador lavou %s vezes.%n", contadorLavagens);
            }
        }
    }
}
