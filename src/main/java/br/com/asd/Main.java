package br.com.asd;

public class Main {
    public synchronized static void main(String[] args) throws InterruptedException {
        Lavador lavador = new Lavador();
        Ajudante ajudante1 = new Ajudante(1);
        Ajudante ajudante2 = new Ajudante(2);
        Ajudante ajudante3 = new Ajudante(3);

        lavador.start();
        ajudante1.start();
        ajudante2.start();
        ajudante3.start();

        long startTime = System.currentTimeMillis();
        boolean continuar = true;

        while (continuar) {
            if (EstadoAplicacao.getVolumeBaldeAgua() <= 0) {
                System.out.println("Balde vazio");
                ajudante1.interrupt();
                ajudante2.interrupt();
                ajudante3.interrupt();
                lavador.interrupt();
                continuar = false;
            } else if (EstadoAplicacao.getVolumeBaldeAgua() > 100) {
                EstadoAplicacao.normalizarVolumeAgua();
                System.out.printf("Balde transbordou. Ajudantes aguardando!%n");
                synchronized (ajudante1) {
                    ajudante1.wait(20000);
                    ajudante2.wait(20000);
                    ajudante3.wait(20000);
                }
            } else if (System.currentTimeMillis() - startTime > 120000) {
                continuar = false;
            }


        }
    }

}