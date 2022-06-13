package artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Band {
    private String name;
    private int numOfMembers;

    public Band() {}

    public Band(String name, int numOfMembers) {
        this.name = name;
        this.numOfMembers = numOfMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfMembers() {
        return numOfMembers;
    }

    public void setNumOfMembers(int numOfMembers) {
        this.numOfMembers = numOfMembers;
    }

    public Band registerBand(Scanner sc) {
        System.out.println("Digite o nome: ");
        this.name = sc.next();

        System.out.println("Digite o numero de membros: ");
        this.numOfMembers = sc.nextInt();

        return this;
    }
}
