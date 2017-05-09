package com.pragmatists.cdc.domain;

public class Book {
    public String id;
    public String author;
    public String title;
    public int year;

    Book() {
        //for deserialization
    }

    public Book(String id, String author, String title, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }
}
