package br.com.asd;

import java.util.ArrayList;
import java.util.List;

public class ThreadMestra extends Thread {
    public List<Thread> listaAjudantes;
    public List<Thread> listaLavadores;

    public ThreadMestra() {
        listaAjudantes = new ArrayList<>();
        listaLavadores = new ArrayList<>();

    }

    public int getVolumeBaldeAgua() {
        return EstadoAplicacao.getVolumeBaldeAgua();
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();

            for (Thread ajudante : listaAjudantes) {
                ajudante.start();
            }

            for (Thread lavador : listaLavadores) {
                lavador.start();
            }

            boolean continuar = true;


            while (continuar) {
                int volumeAtual=EstadoAplicacao.getVolumeBaldeAgua();
                if (volumeAtual > 10) {
                    System.out.println("Balde transbordou");
                    EstadoAplicacao.normalizarVolumeAgua();
                    for (Thread ajudante : listaAjudantes) {
                        ajudante.wait(2000);
                    }
                    System.out.println("Balde transbordou. Ajudantes aguardando!");
//                    Thread.sleep(2000);
                } else if (EstadoAplicacao.getVolumeBaldeAgua() <= 0) {
//                    System.out.println("Balde vazio");
                    for (Thread ajudante : listaAjudantes) {
                        ajudante.interrupt();
                    }
                    for (Thread lavador : listaLavadores) {
                        lavador.interrupt();
                    }

                    continuar = false;
                } else if (System.currentTimeMillis() - startTime > 120000) {

                    for (Thread ajudante : listaAjudantes) {
                        ajudante.interrupt();
                    }
                    for (Thread lavador : listaLavadores) {
                        lavador.interrupt();
                    }

                    continuar = false;
                }
            }

            System.out.println("Aplicação finalizada.");
        } catch (InterruptedException ex) {
            System.out.println("Aplicação finalizada.");
        }
    }
}
