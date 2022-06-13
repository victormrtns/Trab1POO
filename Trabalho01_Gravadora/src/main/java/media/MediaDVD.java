package media;

import java.util.Scanner;

public class MediaDVD extends Media {
    private int duration;

    public MediaDVD() {
        super();
    }

    public MediaDVD(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MediaDVD registerDVD(Scanner sc) {
        super.registerMedia(sc);

        System.out.println("Digite a duracao: ");
        this.duration = sc.nextInt();

        return this;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nPreco: " + price + "\nDuracao: " + duration + "\nNome do artista: " + artistName;
    }
}
