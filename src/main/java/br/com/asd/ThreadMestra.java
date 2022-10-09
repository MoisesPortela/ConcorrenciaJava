package br.com.asd;

public class ThreadMestra extends Thread {
    @Override
    public synchronized void run() {
        Lavador lavador = new Lavador();
        Ajudante ajudante1 = new Ajudante(1);
        Ajudante ajudante2 = new Ajudante(2);
        Ajudante ajudante3 = new Ajudante(3);


        boolean continuar = true;
        int volumeBalde = EstadoAplicacao.getVolumeBaldeAgua();

        try {
            lavador.start();
            ajudante1.start();
            ajudante2.start();
            ajudante3.start();
            long startTime = System.currentTimeMillis();
            while (continuar) {
                Thread.sleep(100);
                volumeBalde = EstadoAplicacao.getVolumeBaldeAgua();

                if (volumeBalde <= 0) {
                    synchronized (ajudante1) {
                        ajudante1.interrupt();
                        ajudante2.interrupt();
                        ajudante3.interrupt();
                        lavador.interrupt();
                    }

                    System.out.println("Balde vazio");
                    continuar = false;

                } else if (System.currentTimeMillis() - startTime >= 120000) {
                    synchronized (ajudante1) {
                        ajudante1.interrupt();
                        ajudante2.interrupt();
                        ajudante3.interrupt();
                        lavador.interrupt();
                    }

                    System.out.println("Tempo dos ajudantes excedido!");
                    continuar = false;
                }
            }
        } catch (Exception ex) {
            System.out.println("Aplicação finalizada");
        }
    }

}
