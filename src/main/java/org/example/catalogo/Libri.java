package org.example.catalogo;

import org.example.catalogo.salvati.FilesMain;

import java.util.List;
import java.util.Scanner;

import static org.example.Application.salvaLibri;
import static org.example.catalogo.Riviste.accediRiviste;
import static org.example.catalogo.Riviste.aggiungiRivista;

public class Libri extends CollezioneEditoriale {

    public String autore;
    public String genere;

    public Libri(String isbn, String titolo, String genere, String autore,int numberOfPages, int yearOfPublication) {
        super(isbn, titolo, numberOfPages, yearOfPublication);
        this.autore = autore;
        this.genere = genere;
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

    public static void accediLibri(List<Libri> listaLibri) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Elenco dei libri:");
        for (Libri libro : listaLibri) {
            System.out.println(libro.getTitolo() + " - " + libro.getAutore());
        }

        while (true) {
            System.out.println("Benvenuto nel catalogo di libri e riviste!");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Rimuovi un libro");
            System.out.println("2. Torna indietro");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            scanner.nextLine();

            switch (scelta) {
                case 1:
                    accediLibri(listaLibri);

                    break;
                case 2:

                return;
                default:
                    System.out.println("Opzione non valida, riprova.");
            }
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

}

