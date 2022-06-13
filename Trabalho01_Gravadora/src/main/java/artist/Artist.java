package artist;

import java.util.ArrayList;
import java.util.Iterator;

public class Artist {
    private static final ArrayList<Singer> singers = new ArrayList<>();
    private static final ArrayList<Band> bands = new ArrayList<>();

    public Artist() {}

    public static boolean existsSingerWithName(String name) {
        Iterator<Singer> singerIterator = singers.iterator();

        while(singerIterator.hasNext())
            if(singerIterator.next().getName().equals(name))
                return true;

        return false;
    }

    public static void insertIntoSingers(Singer singer) {
        if(!existsSingerWithName(singer.getName()) && !existsBandWithName(singer.getName())) {
            singers.add(singer);
            System.out.println("Cantor cadastrado com sucesso!");
            return;
        }

        System.out.println("ERRO: Ja existe um artista cadastrado com esse nome!");
    }

    public static boolean existsBandWithName(String name) {
        Iterator<Band> bandIterator = bands.iterator();

        while(bandIterator.hasNext())
            if(bandIterator.next().getName().equals(name))
                return true;

        return false;
    }

    public static void insertIntoBands(Band band) {
        if(!existsSingerWithName(band.getName()) && !existsBandWithName(band.getName())) {
            bands.add(band);
            System.out.println("Banda cadastrada com sucesso!");
            return;
        }

        System.out.println("ERRO: Ja existe um artista cadastrado com esse nome!");
    }
}
