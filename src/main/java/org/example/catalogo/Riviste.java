package org.example.catalogo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.example.Application.salvaLibri;
import static org.example.Application.salvaRiviste;


public class Riviste extends CollezioneEditoriale{

    Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }
    private void ricercaRivisteToString() {
        System.out.println("IBSN: "+ this.getIsbn()+ "\n"+
                "Titolo: " + this.getTitolo() + "\n" +
                "Numero di pagine: " + this.getNumberOfPages() + "\n" +
                "Anno di pubblicazione: " + this.getYearOfPublication()); ;;
    }


    public Riviste(String isbn, String titolo, int numberOfPages, int yearOfPublication,Periodicita periodicita) {
        super(isbn, titolo, numberOfPages, yearOfPublication);
        this.periodicita = periodicita;
    }


    public static void accediRiviste(List<Riviste> listaRiviste, Scanner scanner) {
        System.out.println("Elenco delle riviste:");
        for (Riviste rivista : listaRiviste) {
            System.out.println(rivista.getTitolo() + " - " + rivista.getPeriodicita());
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
                    ricercaRivistaPerIsbn(listaRiviste,scanner);
                    break;
                case 3:
                    ricercaRivistePerAnno(listaRiviste,scanner);
                    break;
                case 4:
                    rimuoviRivista(listaRiviste,scanner);
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

        System.out.print("Inserisci il numero delle pagine della Rivista: ");
        int numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci l'anno di pubblicazione della Rivista: ");
        int yearOfPublication = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci la periodicita della Rivista: ");
        String periodicitaScan= scanner.nextLine();
        Periodicita periodicita = Periodicita.valueOf(periodicitaScan.toLowerCase());

        listaRiviste.add(new Riviste(isbn,titolo,numberOfPages,yearOfPublication,periodicita));


        System.out.println("Rivista aggiunto con successo!");
        salvaRiviste();
    }

    public static void rimuoviRivista(List<Riviste> listaRiviste, Scanner scanner){
        System.out.println("Inserisci il codice isbn del libro da rimuovere");
        String isbn= scanner.nextLine();

        Iterator<Riviste> iterator= listaRiviste.iterator();
        while (iterator.hasNext()) {

            Riviste riviste= iterator.next();
            if (isbn.equals(riviste.isbn)){
                iterator.remove();
                System.out.println("Rivista rimossa correttamente");
                salvaRiviste();
                return;
            }
        }
        System.out.println("Nessuna rivista trovata");

    }

    public static void ricercaRivistaPerIsbn(List<Riviste> listaRiviste,Scanner scanner) {
        System.out.println("Inserisci il codice isbn del libro da cercare");
        String isbn = scanner.nextLine();

        for (Riviste riviste : listaRiviste) {
            if (isbn.equals(riviste.getIsbn())) {
                riviste.ricercaRivisteToString();
            }
        }


        System.out.println("Nessun libro trovato");
    }



}
