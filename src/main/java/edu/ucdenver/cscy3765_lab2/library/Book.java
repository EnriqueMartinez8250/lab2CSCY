package edu.ucdenver.cscy3765_lab2.library;

import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate publicationDate;
    private String[] otherTitles;
    private int numOfPages;
    private String author;


    public Book(String title, LocalDate publicationDate, String[] otherTitles, int numOfPages, String author){
        this.title = title;
        this.publicationDate = publicationDate;
        this.otherTitles = otherTitles;
        this.numOfPages = numOfPages;
        this.author = author;
    }

    public String toString(){

//        String otherT = "";
//        for (String i: otherTitles) {
//            otherT += ("   a.k.a:" + i + "\n");
//        }

        // Hint generate a string and concatenate. You can also use StringBuilder if you want to.
        return "Book: " + title + " with " + numOfPages + " pages published on " + publicationDate + " written by " +
                author + "\n" /*+ otherT */;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String[] getOtherTitles() {
        return otherTitles;
    }
    public void setOtherTitles(String[] otherTitles) {
        this.otherTitles = otherTitles;
    }
    public int getNumOfPages() {
        return numOfPages;
    }
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
    public String getAuthor() {
        return author;
    }
}