import artist.Artist;
import media.MediaCD;
import media.MediaDVD;

import java.util.*;

public class MediaCatalog {
    Map<Integer, MediaCD> cdCatalog = new HashMap<>();
    Map<Integer, MediaDVD> dvdCatalog = new HashMap<>();

    public MediaCatalog() {
    }

    public MediaCatalog(Map<Integer, MediaCD> cdCatalog, Map<Integer, MediaDVD> dvdCatalog) {
        this.cdCatalog = cdCatalog;
        this.dvdCatalog = dvdCatalog;
    }

    public void registerMedia(Scanner sc) {
        int op;
        Random rd = new Random();

        do {
            System.out.println("Digite o tipo de midia: ([1]: CD / [2]: DVD)");
            op = sc.nextInt();

            if (op == 1) {
                MediaCD cd = new MediaCD();
                insertIntoCDCatalog(cd.registerCD(sc), rd.nextInt(100000, 999998), getArtistName(sc));
            } else if (op == 2) {
                MediaDVD dvd = new MediaDVD();
                insertIntoDVDCatalog(dvd.registerDVD(sc), rd.nextInt(100000, 999998), getArtistName(sc));
            } else
                System.out.println("Opcao invalida!");
        } while (op != 1 && op != 2);
    }

    private boolean mediaHasSameName(String name) {
        for(MediaCD cd : cdCatalog.values()) {
            if(cd.getName().equals(name))
                return true;
        }

        for(MediaDVD dvd : dvdCatalog.values()) {
            if(dvd.getName().equals(name))
                return true;
        }

        return false;
    }

    private void insertIntoCDCatalog(MediaCD mediaCD, int cod, String artistName) {
        if (artistName == null) {
            System.out.println("ERRO: Nao existe nenhum artista cadastrado com esse nome!");
            return;
        }

        if(mediaHasSameName(mediaCD.getName())) {
            System.out.println("Ja existe uma midia cadastrada com esse nome!");
            return;
        }

        mediaCD.setArtistName(artistName);

        cdCatalog.put(cod, mediaCD);
        System.out.println("CD cadastrado com sucesso!");
    }

    private void insertIntoDVDCatalog(MediaDVD mediaDVD, int cod, String artistName) {
        if (artistName == null) {
            System.out.println("ERRO: Nao existe nenhum artista cadastrado com esse nome!");
            return;
        }

        if(mediaHasSameName(mediaDVD.getName())) {
            System.out.println("Ja existe uma midia cadastrada com esse nome!");
            return;
        }

        mediaDVD.setArtistName(artistName);

        dvdCatalog.put(cod, mediaDVD);
        System.out.println("DVD cadastrado com sucesso!");
    }

    private String getArtistName(Scanner sc) {
        String name = "";
        int op;

        System.out.println("Digite o tipo de artista: [1]: Cantor / [2]: Banda");

        do {
            op = sc.nextInt();

            if (op == 1) {
                System.out.println("Digite o nome do cantor: ");
                name = sc.next();

                if (Artist.existsSingerWithName(name))
                    return name;

                return null;
            } else if (op == 2) {
                System.out.println("Digite o nome da banda: ");
                name = sc.next();

                if (Artist.existsBandWithName(name))
                    return name;

                return null;
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (op != 1 && op != 2);

        return name;
    }

    public void listAllMedias() {
        if (!cdCatalog.isEmpty())
            System.out.println("*-------- CATALOGO DE CD'S -------*");

        for (Integer key : cdCatalog.keySet()) {
            System.out.println("Codigo de barras: " + key);
            System.out.println(cdCatalog.get(key).toString());
        }

        if (!dvdCatalog.isEmpty())
            System.out.println("*-------- CATALOGO DE DVD'S -------*");

        for (Integer key : dvdCatalog.keySet()) {
            System.out.println("Codigo de barras: " + key);
            System.out.println(dvdCatalog.get(key).toString());
        }
    }

    public Object searchMedia(Scanner sc) {
        int op, cod;
        String name;

        System.out.println("Digite:\n[1] - Pesquisar por codigo\n[2] - Pesquisar por nome");

        do {
            op = sc.nextInt();

            if (op == 1) {
                System.out.println("Digite o codigo: ");
                cod = sc.nextInt();

                MediaCD cd = cdCatalog.get(cod);

                //Procurar por código
                if (cd != null) {
                    return cd;
                } else {
                    MediaDVD dvd = dvdCatalog.get(cod);
                    return dvd;
                }
            } else if (op == 2) {
                System.out.println("Digite o nome: ");
                name = sc.next();

                sc.nextLine();

                //Procurar por nome
                for (Integer key : cdCatalog.keySet()) {
                    if (cdCatalog.get(key).getName().equals(name)) {
                        return cdCatalog.get(key);
                    }

                }
                for (Integer key : dvdCatalog.keySet()) {
                    if (dvdCatalog.get(key).getName().equals(name)) {
                        return dvdCatalog.get(key);
                    }
                }

            } else {
                System.out.println("Opcao invalida!");
            }
        } while (op != 1 && op != 2);

        return null;
    }

    public void removeMedia(Scanner sc) {
        int op;
        System.out.println("Digite qual midia deseja remover:\n[1] - CD \n[2] - DVD");
        System.out.print("Digite: ");

        do {
            op = sc.nextInt();

            if(op == 1) {
                removeCD(sc);
            } else if(op == 2) {
                removeDVD(sc);
            } else {
                System.out.println("Operacao invalida!");
            }
        } while (op != 1 && op != 2);
    }

    private void removeCD(Scanner sc) {

        if(cdCatalog.isEmpty()) {
            System.out.println("Nao ha CD's cadastrados no sistema!");
            return;
        }

        MediaCD found = (MediaCD) searchMedia(sc);

        if (found != null) {
            for (Integer key : cdCatalog.keySet())
                if (cdCatalog.get(key).getName().equals(found.getName()))
                    cdCatalog.remove(key);

            System.out.println("CD removido com sucesso!");
            return;
        }

        System.out.println("ERRO: Nao foi possivel remover essa CD!");
    }

    private void removeDVD(Scanner sc) {

        if(dvdCatalog.isEmpty()) {
            System.out.println("Nao ha DVD's cadastrados no sistema!");
            return;
        }

        MediaDVD found = (MediaDVD) searchMedia(sc);

        if(found != null) {
            for(Integer key : dvdCatalog.keySet())
                if(dvdCatalog.get(key).getName().equals(found.getName()))
                    dvdCatalog.remove(key);

            System.out.println("DVD removido com sucesso!");
            return;
        }

        System.out.println("ERRO: Nao foi possivel remover essa DVD!");
    }

    public void getMediaIndex(Scanner sc) {
        System.out.println("Digite o tipo de midia:");
        System.out.println("[1] - CD");
        System.out.println("[2] - DVD");
        int op = 0;
        do{
            op = sc.nextInt();
            if(op != 1 && op!=2){
                System.out.println("Opcao Invalida. Digite novamente: ");
            }
        }while(op!=1 && op!=2);

        if(op == 2) {
            MediaDVD mediaDVD = (MediaDVD) searchMedia(sc);
            int cont = 0;
            if (mediaDVD != null) {
                for (Integer key : dvdCatalog.keySet()) {
                    if (dvdCatalog.get(key).getName().equals(mediaDVD.getName())) {
                        System.out.println("Indice da midia no catalogo: " + (cont + 1));
                        return;
                    }
                    else cont++;
                }
            }

            System.out.println("ERRO: DVD nao encontrado!");
        }

        if(op == 1) {
            MediaCD mediaCD = (MediaCD) searchMedia(sc);
            int cont = 0;
            if (mediaCD != null) {
                for (Integer key : cdCatalog.keySet()) {
                    if (cdCatalog.get(key).getName().equals(mediaCD.getName())) {
                        System.out.println("Indice da midia no catalogo: " + (cont + 1));
                        return;
                    }
                    else cont++;
                }

            }
            System.out.println("ERRO: CD nao encontrado!");
        }

    }
}

