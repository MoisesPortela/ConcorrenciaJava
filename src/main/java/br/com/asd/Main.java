package br.com.asd;

public class Main {
    public static void main(String[] args) {
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
                continuar = false;
            } else if (System.currentTimeMillis() - startTime > 120000) {
                continuar = false;
            }
        }
    }

}