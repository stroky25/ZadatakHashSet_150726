import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class EvidencijaKorisnika {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //   ArrayList<Polaznik> listaPolaznika = new ArrayList<>();
        //   HashSet<Polaznik> listaPolaznika = new HashSet<>();
             TreeSet<Polaznik> listaPolaznika = new TreeSet<>();

        int izbor;
        do{
            System.out.println("\n--- EVIDENCIJA POLAZNIKA ---");
            System.out.println("1. Unos novog polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraživanje po e-mail adresi");
            System.out.println("0. Izlaz");
            System.out.print("Odaberite opciju: ");

            izbor = sc.nextInt();
            sc.nextLine();

            switch (izbor) {

                case 1:
                    unosPolaznika(sc,listaPolaznika);
                    break;
                case 2:
                    ispisPolaznika(sc,listaPolaznika);
                    break;
                case 3:
                    pretrazivanjePolaznika(sc,listaPolaznika);
                    break;
                case 0:
                    System.out.println("Kraj programa.");
                    break;
                default:
                    System.out.println("Neispravan odabir.");
            }



        } while (izbor != 0);

        sc.close();

    }
    //public static void unosPolaznika(Scanner sc, HashSet<Polaznik> listaPolaznika) {
    public static void unosPolaznika(Scanner sc, TreeSet<Polaznik> listaPolaznika) {
        System.out.print("Ime: ");
        String ime = sc.nextLine();

        System.out.print("Prezime: ");
        String prezime = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();
        Polaznik novi = new Polaznik(ime, prezime, email);
        if (listaPolaznika.add(novi)) {
            System.out.println("Polaznik uspješno dodan.");
        } else {
            System.out.println("Polaznik s tom e-mail adresom već postoji.");
        }

    }
    //public static void ispisPolaznika(Scanner sc, HashSet<Polaznik> listaPolaznika) {
    public static void ispisPolaznika(Scanner sc, TreeSet<Polaznik> listaPolaznika) {
        if (listaPolaznika.isEmpty()) {
            System.out.println("Nema unesenih polaznika.");
        } else {
            System.out.println("\nPopis polaznika:");
            for (Polaznik p : listaPolaznika) {
                System.out.println(p);
            }
        }
    }
    //public static void pretrazivanjePolaznika(Scanner sc, HashSet<Polaznik> listaPolaznika) {
    public static void pretrazivanjePolaznika(Scanner sc, TreeSet<Polaznik> listaPolaznika) {
        System.out.print("Unesite e-mail za pretragu: ");
        String trazeniEmail = sc.nextLine();

        boolean pronaden = false;

        for (Polaznik p : listaPolaznika) {
            if (p.getEmail().equalsIgnoreCase(trazeniEmail)) {
                System.out.println("Polaznik pronađen:");
                System.out.println(p);
                pronaden = true;
                break;
            }
        }

        if (!pronaden) {
            System.out.println("Polaznik nije pronađen.");
        }
    }

}
