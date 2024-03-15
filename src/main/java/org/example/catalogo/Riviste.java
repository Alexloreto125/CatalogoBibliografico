package org.example.catalogo;

import java.util.List;
import java.util.Scanner;


public class Riviste extends CollezioneEditoriale{

    Periodicita periodicita;

    public String getTitolo() {
        return titolo;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }


    public Riviste(String isbn, String titolo, int numberOfPages, int yearOfPublication,Periodicita periodicita) {
        super(isbn, titolo, numberOfPages, yearOfPublication);
        this.periodicita = periodicita;
    }


    public static void accediRiviste(List<Riviste> listaRiviste) {
        System.out.println("Elenco delle riviste:");
        for (Riviste rivista : listaRiviste) {
            System.out.println(rivista.getTitolo() + " - " + rivista.getPeriodicita());
        }
    }

    public static void aggiungiRivista(List<Riviste> listaRiviste) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il codice isbn della Rivista: ");
        String isbn = scanner.nextLine();

        System.out.print("Inserisci il titolo della Rivista: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci il numero delle pagine della Rivista: ");
        int numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci l'anno di pubblicazione della Rivista: ");
        int yearOfPublication = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci la periodicita della Rivista: ");
        String periodicitaScan= scanner.nextLine();
        Periodicita periodicita = Periodicita.valueOf(periodicitaScan.toLowerCase());

        listaRiviste.add(new Riviste(isbn,titolo,numberOfPages,yearOfPublication,periodicita));


        System.out.println("Rivista aggiunto con successo!");
    }

}
