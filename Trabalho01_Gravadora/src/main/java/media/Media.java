package media;

import java.util.Scanner;

public class Media {
    protected String name;
    protected float price;
    protected String artistName;

    public Media() {}

    public Media(String name, float price, String artistName) {
        this.name = name;
        this.price = price;
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    protected void registerMedia(Scanner sc) {
        System.out.println("*------- CADASTRO DE MIDIA -------*");

        System.out.println("Digite o nome: ");
        this.name = sc.next();

        System.out.println("Digite o preco: ");
        this.price = sc.nextFloat();
    }
}
