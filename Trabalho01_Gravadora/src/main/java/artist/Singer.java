package artist;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Singer {
    private String name;
    private int careerTime;


    public Singer (){}
    public Singer(String name, int careerTime) {
        this.name = name;
        this.careerTime = careerTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCareerTime() {
        return careerTime;
    }

    public void setCareerTime(int careerTime) {
        this.careerTime = careerTime;
    }

    public Singer registerSinger(Scanner sc) {
        System.out.println("Digite o nome: ");
        this.name = sc.next();

        System.out.println("Digite o tempo de carreira: ");
        this.careerTime = sc.nextInt();

        return this;
    }
}
