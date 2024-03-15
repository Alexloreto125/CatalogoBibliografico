package org.example;

import org.apache.commons.io.FileUtils;
import org.example.catalogo.CollezioneEditoriale;
import org.example.catalogo.Libri;
import org.example.catalogo.Riviste;
import org.example.catalogo.salvati.FilesMain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.catalogo.Libri.accediLibri;
import static org.example.catalogo.Libri.aggiungiLibro;
import static org.example.catalogo.Riviste.accediRiviste;
import static org.example.catalogo.Riviste.aggiungiRivista;


public class Application {
        public static List<Libri> listaLibri = new ArrayList<>();
      public  static List<Riviste> listaRiviste = new ArrayList<>();



    public static void main(String[] args) {
        caricaLibri();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Benvenuto nel catalogo di libri e riviste!");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Accedi ai libri");
            System.out.println("2. Accedi alle riviste");
            System.out.println("3. Aggiungi libro");
            System.out.println("4. Aggiungi rivista");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            scanner.nextLine();

            switch (scelta) {
                case 1:
                    accediLibri(listaLibri);

                    break;
                case 2:
                    accediRiviste(listaRiviste);
                    break;
                case 3:
                    aggiungiLibro(listaLibri);
                    break;
                case 4:
                    aggiungiRivista(listaRiviste);
                    break;
                case 5:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Opzione non valida, riprova.");
               }
             }
         }


    public static void salvaLibri() {

        File fileLibri = new File("src/main/java/org/example/catalogo/salvati/fileLibri.txt");
        try {

            if (!fileLibri.exists()) {
                fileLibri.createNewFile();
            }

            StringBuilder content = new StringBuilder();
            for (Libri libro : listaLibri) {
                content.append(libro.getIsbn()).append(",").append(libro.getTitolo()).append(",").append(libro.getGenere()).append(",")
                        .append(libro.getAutore()).append(",").append(libro.getNumberOfPages()).append(",").append(libro.getYearOfPublication()).append("\n");
            }


            FileUtils.writeStringToFile(fileLibri, content.toString(), "UTF-8");

            System.out.println("Libri salvati correttamente.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei libri: " + e.getMessage());
        }
    }

    public static void caricaLibri() {
        File fileLibri = new File("src/main/java/org/example/catalogo/salvati/fileLibri.txt");

        try {
            List<String> letturaLibri = FileUtils.readLines(fileLibri, StandardCharsets.UTF_8);
            for (String lettura : letturaLibri) {
                String[] parti = lettura.split(",");
                if (parti.length == 6) {
                    listaLibri.add(new Libri(parti[0], parti[1], parti[2], parti[3], Integer.parseInt(parti[4]), Integer.parseInt(parti[5])));
                }
            }
            System.out.println("Libri caricati correttamente.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento dei libri: " + e.getMessage());
        }
    }

}

