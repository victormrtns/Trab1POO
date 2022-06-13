package media;

import java.util.Objects;
import java.util.Scanner;

public class MediaCD extends Media {
    private int tracksNumber;

    public MediaCD(){super();}
    public MediaCD(int tracksNumber) {
        super();
        this.tracksNumber = tracksNumber;
    }

    public int getTracksNumber() {
        return tracksNumber;
    }

    public void setTracksNumber(int tracksNumber) {
        this.tracksNumber = tracksNumber;
    }

    public MediaCD registerCD(Scanner sc) {
        super.registerMedia(sc);

        System.out.println("Digite o numero de faixas: ");
        this.tracksNumber = sc.nextInt();

        return this;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nPreco: " + price + "\nNumero de faixas: " + tracksNumber + "\nNome do artista: " + artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaCD mediaCD = (MediaCD) o;
        return tracksNumber == mediaCD.tracksNumber;
    }
}
