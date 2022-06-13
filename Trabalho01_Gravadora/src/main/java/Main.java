import artist.Artist;
import artist.Band;
import artist.Singer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        MediaCatalog catalog = new MediaCatalog();

        do {
            System.out.println("*-------- SISTEMA GRAVADORA --------*");
            System.out.println("-------------------------------------");
            System.out.println("| Digite | Para                     |");
            System.out.println("| 1.     | Cadastrar midia          |");
            System.out.println("| 2.     | Cadastrar artista        |");
            System.out.println("| 3.     | Consultar midia          |");
            System.out.println("| 4.     | Listar todas as midias   |");
            System.out.println("| 5.     | Remover midia            |");
            System.out.println("| 6.     | Listar a posicao da midia|");
            System.out.println("| 7.     | Sair                     |");
            System.out.println("-------------------------------------");
            System.out.println("*-----------------------------------*");

            System.out.println("Digite uma opcao:");
            op = sc.nextInt();

            switch(op) {
                case 1:
                    catalog.registerMedia(sc);
                    break;
                case 2:
                    int artistType;

                    System.out.println("Digite o tipo de artista: [1]: Cantor / [2]: Banda");

                    do {
                        artistType = sc.nextInt();

                        if(artistType == 1) {
                            Singer singer = new Singer();
                            Artist.insertIntoSingers(singer.registerSinger(sc));
                        } else if (artistType == 2) {
                            Band band = new Band();
                            Artist.insertIntoBands(band.registerBand(sc));
                        } else {
                            System.out.println("Opcao invalida!");
                        }
                    } while(artistType != 1 && artistType != 2);
                    break;
                case 3:
                    Object o = catalog.searchMedia(sc);
                    if(o == null)
                        System.out.println("Nao foi possivel encontrar a midia!");

                    System.out.println(o);
                    break;
                case 4:
                    catalog.listAllMedias();
                    break;
                case 5:
                    catalog.removeMedia(sc);
                    break;
                case 6:
                    catalog.getMediaIndex(sc);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }

        } while (op != 7);
    }
}
