package org.example.catalogo;

import org.example.catalogo.salvati.FilesMain;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.example.Application.*;
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

    public static void accediLibri(List<Libri> listaLibri, Scanner scanner) {
        caricaLibri();
        System.out.println("Elenco dei libri:");
        for (Libri libro : listaLibri) {
            System.out.println(libro.getTitolo() + " - " + libro.getAutore());
        }

        while (true) {
            System.out.println("Benvenuto nel catalogo di libri");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Rimuovi Libro");
            System.out.println("2. Esci");
            System.out.print("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            scanner.nextLine();

            switch (scelta) {
                case 1:
                    rimuoviLibro(listaLibri,scanner);
                    break;
                case 2:

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


}
