package org.example.catalogo;

public abstract class CollezioneEditoriale {

    public String isbn;
    public String titolo;
    private int numberOfPages;
    private int yearOfPublication;

    public CollezioneEditoriale(String isbn, String titolo, int numberOfPages, int yearOfPublication) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
    }



    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }


}
