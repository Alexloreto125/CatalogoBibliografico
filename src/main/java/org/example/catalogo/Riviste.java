package org.example.catalogo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.example.Application.caricaRiviste;
import static org.example.Application.salvaRiviste;


public class Riviste extends CollezioneEditoriale {

    Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }


    @Override
    public String toString() {
        return "Riviste{" +
                "ISBN=" + isbn +
                ", Titolo='" + titolo + '\'' +
                ", Periodicita='" + periodicita + '\'' +
                '}';
    }

    private void ricercaRivisteToString() {
        System.out.println("IBSN: " + this.getIsbn() + "\n" +
                "Titolo: " + this.getTitolo() + "\n" +
                "Numero di pagine: " + this.getNumberOfPages() + "\n" +
                "Anno di pubblicazione: " + this.getYearOfPublication() + "\n" +
                "Periodicita: " + getPeriodicita());
    }


    public Riviste(String isbn, String titolo, int numberOfPages, int yearOfPublication, Periodicita periodicita) {
        super(isbn, titolo, numberOfPages, yearOfPublication);
        this.periodicita = periodicita;
    }


    public static void accediRiviste(List<Riviste> listaRiviste, Scanner scanner) {

        System.out.println("Elenco delle riviste:");
        for (Riviste rivista : listaRiviste) {
            System.out.println(rivista);
        }

        while (true) {
            System.out.println("Benvenuto nel catalogo delle Riviste");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi Rivista");
            System.out.println("2. Ricerca Rivista tramite ISBN");
            System.out.println("3. Ricerca Rivista tramite Anno di pubblicazione");
            System.out.println("4. Rimuovi Rivista");
            System.out.println("5. Esci");
            System.out.println("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    aggiungiRivista(listaRiviste);
                    break;
                case 2:
                    ricercaRivistaPerIsbn(listaRiviste, scanner);
                    break;
                case 3:
                    ricercaRivistePerAnno(listaRiviste, scanner);
                    break;
                case 4:
                    rimuoviRivista(listaRiviste, scanner);
                    break;
                case 5:

                    return;
                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }

    }

    public static void aggiungiRivista(List<Riviste> listaRiviste) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il codice isbn della Rivista: ");
        String isbn = scanner.nextLine();

        System.out.print("Inserisci il titolo della Rivista: ");
        String titolo = scanner.nextLine();


        int numberOfPages = 0;
        while (true) {
            System.out.print("Inserisci il numero delle pagine della Rivista: ");
            String numero = scanner.nextLine();

            try {
                numberOfPages = Integer.parseInt(numero);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Non hai inserito un numero");
            }

        }

        int yearOfPublication = 0;
        while (true) {
            System.out.print("Inserisci l'anno di pubblicazione della Rivista: ");
            String anno = scanner.nextLine();
            try {
                yearOfPublication = Integer.parseInt(anno);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Non hai inserito un numero");
            }
        }

        Periodicita periodicita = null;
        while (periodicita==null) {
            System.out.println("Seleziona la periodicità della Rivista:");
            System.out.println("1. Settimanale");
            System.out.println("2. Mensile");
            System.out.println("3. Semestrale");
            System.out.print("Scelta: ");



        try {


            int scelta = Integer.parseInt(scanner.nextLine());


            switch (scelta) {

                case 1:
                    periodicita = Periodicita.settimanale;
                    break;
                case 2:
                    periodicita = Periodicita.mensile;
                    break;
                case 3:
                    periodicita = Periodicita.semestrale;
                    break;
                default:
                    System.out.println("Opzione non valida, si prega di riprovare.");

            }


        } catch (NumberFormatException e) {
            System.out.println("Errore: Inserisci un numero valido!");
        }
    }
                listaRiviste.add(new Riviste(isbn, titolo, numberOfPages, yearOfPublication, periodicita));
                System.out.println("Rivista aggiunto con successo!");
                salvaRiviste();
                accediRiviste(listaRiviste,scanner);
    }

    public static void rimuoviRivista(List<Riviste> listaRiviste, Scanner scanner) {
        System.out.println("Inserisci il codice isbn della Rivista da rimuovere");
        String isbn = scanner.nextLine();

        Iterator<Riviste> iterator = listaRiviste.iterator();
        while (iterator.hasNext()) {

            Riviste riviste = iterator.next();
            if (isbn.equals(riviste.isbn)) {
                iterator.remove();
                System.out.println("Rivista rimossa correttamente");
                salvaRiviste();
                return;
            }
        }
        System.out.println("Nessuna rivista trovata");

    }

    public static void ricercaRivistaPerIsbn(List<Riviste> listaRiviste, Scanner scanner) {
        System.out.println("Inserisci il codice isbn del libro da cercare");
        String isbn = scanner.nextLine();

        for (Riviste riviste : listaRiviste) {
            if (isbn.equals(riviste.getIsbn())) {
                riviste.ricercaRivisteToString();
                System.out.println("---------------------------------------------");
            }
        }


        System.out.println("Nessuna Rivista trovata");
    }

    public static void ricercaRivistePerAnno(List<Riviste> listaRiviste, Scanner scanner) {
        System.out.println("Inserisci l'anno di pubblicazione della Rivista da cercare");
        int yearOfPubblication = Integer.parseInt(scanner.nextLine());
        System.out.println("Queste sono le riviste trovate in base all'anno di pubblicazione: ");

        for (Riviste riviste : listaRiviste) {
            if (yearOfPubblication == riviste.getYearOfPublication()) {
                riviste.ricercaRivisteToString();
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("Nessuna Rivista trovata");

            }
        }


    }

}
