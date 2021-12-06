package com.ucsal.trabalhodispmoveis.models;

public class Book {

    String title;
    String author;
    String genre;
    String description;
    Long isbn;
    String image;
    String published;


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", isbn=" + isbn +
                ", image='" + image + '\'' +
                ", published=" + published +
                '}';
    }
}
