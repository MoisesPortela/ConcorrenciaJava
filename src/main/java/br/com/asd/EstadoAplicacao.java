package br.com.asd;

public class EstadoAplicacao {
    private static int volumeBaldeAgua = 5;


    public static int getVolumeBaldeAgua() {
        return volumeBaldeAgua;
    }

    public static void normalizarVolumeAgua() {
        volumeBaldeAgua = 100;
    }

    public static int retirarAgua(int capacidadeCaneca) {
        int volumeRetirado = 0;

        if (volumeBaldeAgua < capacidadeCaneca) {
            volumeRetirado = volumeBaldeAgua;
            volumeBaldeAgua = 0;
        } else {
            volumeRetirado = capacidadeCaneca;
            volumeBaldeAgua -= capacidadeCaneca;
        }

        return volumeRetirado;
    }

    public static int colocarAgua(int capacidadeCaneca) {
        int volumeColocado = 0;

        if (volumeBaldeAgua + capacidadeCaneca > 100) {
            volumeColocado = 100 - volumeBaldeAgua;
            volumeBaldeAgua = 100;
        } else {
            volumeColocado = capacidadeCaneca;
            volumeBaldeAgua += capacidadeCaneca;

        }
        return volumeColocado;

    }

}
