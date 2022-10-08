package br.com.asd;

public class EstadoAplicacao {
    private static int volumeBaldeAgua = 0;


    public static int getVolumeBaldeAgua() {
        return volumeBaldeAgua;
    }

    public static void normalizarVolumeAgua() {
        volumeBaldeAgua = 100;
    }

    public static int retirarAgua(int capacidadeCaneca) {
        int novoVolume;

        if (volumeBaldeAgua < capacidadeCaneca) {
            volumeBaldeAgua = 0;
            novoVolume = volumeBaldeAgua;
        } else {
            volumeBaldeAgua -= capacidadeCaneca;
            novoVolume = volumeBaldeAgua;
        }

        return novoVolume;
    }

    public static int colocarAgua(int capacidadeCaneca) {
        int novoVolume;

        if (volumeBaldeAgua + capacidadeCaneca > 100) {

            volumeBaldeAgua = 100;
            novoVolume = volumeBaldeAgua;

        } else {
            volumeBaldeAgua += capacidadeCaneca;
            novoVolume = volumeBaldeAgua;

        }
        return novoVolume;

    }

}
