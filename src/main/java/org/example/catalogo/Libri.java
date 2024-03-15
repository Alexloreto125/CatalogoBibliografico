package org.example.catalogo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.example.Application.*;

public class Libri extends CollezioneEditoriale {

    public String autore;
    public String genere;

    public Libri(String isbn, String titolo, String genere, String autore,int numberOfPages, int yearOfPublication) {
        super(isbn, titolo, numberOfPages, yearOfPublication);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "ISBN='"+isbn+"' "+
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '\'' +
                ", titolo='" + titolo + '\'' +
                '}';
    }

        public void ricercaToString(){
        System.out.println("IBSN: "+ this.getIsbn()+ "\n"+
                "Titolo: " + this.getTitolo() + "\n" +
                "Autore: " + this.getAutore() + "\n" +
                "Genere: " + this.getGenere() + "\n" +
                "Numero di pagine: " + this.getNumberOfPages() + "\n" +
                "Anno di pubblicazione: " + this.getYearOfPublication()); ;
        }



    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public static void accediLibri(List<Libri> listaLibri, Scanner scanner) {
//        caricaLibri();
        System.out.println("Elenco dei libri:");
        for (Libri libro : listaLibri) {
            System.out.println(libro);
        }

        while (true) {
            System.out.println("Benvenuto nel catalogo di libri");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Rimuovi Libro");
            System.out.println("3. Ricerca libro tramite ISBN");
            System.out.println("4. Ricerca libro tramite Anno di pubblicazione");
            System.out.println("5. Ricerca libro tramite Autore");
            System.out.println("6. Esci");
            System.out.println("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    aggiungiLibro(listaLibri);
                    break;
                case 2:
                    rimuoviLibro(listaLibri,scanner);
                    break;

                case 3:
                    ricercaIsbn(listaLibri,scanner);
                    break;

                case 4:
                    ricercaPerAnno(listaLibri,scanner);
                    break;
                case 5:
                    ricercaPerAutore(listaLibri,scanner);
                    break;

                case 6:

                    System.out.println("Arrivederci!");
                    return;

                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }

    }
    public static void aggiungiLibro(List<Libri> listaLibri) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Inserisci il codice isbn del libro: ");
        String isbn = scanner.nextLine();

        System.out.print("Inserisci il titolo del libro: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci il genere del libro: ");
        String genere = scanner.nextLine();


        System.out.print("Inserisci l'autore del libro: ");
        String autore = scanner.nextLine();

        System.out.print("Inserisci il numero delle pagine del libro: ");
        int numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci l'anno di pubblicazione del libro: ");
        int yearOfPublication = Integer.parseInt(scanner.nextLine());


        listaLibri.add(new Libri(isbn,titolo,genere,autore,numberOfPages,yearOfPublication));

        System.out.println("Libro aggiunto con successo!");
       salvaLibri();
    }

    public static void rimuoviLibro(List<Libri> listaLibri, Scanner scanner){
        System.out.println("Inserisci il codice isbn del libro da rimuovere");
        String isbn= scanner.nextLine();

        Iterator<Libri> iterator= listaLibri.iterator();
        while (iterator.hasNext()) {

            Libri libro= iterator.next();
            if (isbn.equals(libro.isbn)){
                iterator.remove();
                System.out.println("Libro rimosso correttamente");
                salvaLibri();
                return;
            }
        }
        System.out.println("Nessun libro trovato");

    }

    public static void ricercaIsbn(List<Libri> listaLibri,Scanner scanner) {
        System.out.println("Inserisci il codice isbn del libro da cercare");
        String isbn = scanner.nextLine();

        for (Libri libro : listaLibri) {
            if (isbn.equals(libro.getIsbn())) {
                libro.ricercaToString();
            }
        }


        System.out.println("Nessun libro trovato");
    }

    public static void ricercaPerAnno(List<Libri> listaLibri,Scanner scanner){
        System.out.println("Inserisci l'anno di pubblicazione del libro da cercare");
        int yearOfPubblication= Integer.parseInt(scanner.nextLine());
                System.out.println("Questi sono i libri trovati in base all'anno di pubblicazione: ");

        for (Libri libro : listaLibri) {
            if (yearOfPubblication==libro.getYearOfPublication()) {
                libro.ricercaToString();
                System.out.println("---------------------------------------------");
            }
        }


        System.out.println("Nessun libro trovato");

    }

    public static void ricercaPerAutore(List<Libri> listaLibri,Scanner scanner){
        System.out.println("Inserisci l'autore del libro da cercare");
        String autore= scanner.nextLine();
        System.out.println("Questi sono i libri trovati in base all'autore:  ");

        for (Libri libro : listaLibri) {
            if (autore.equals(libro.getAutore())) {
                libro.ricercaToString();
                System.out.println("---------------------------------------------");
            }
        }


        System.out.println("Nessun libro trovato");


    }



}
