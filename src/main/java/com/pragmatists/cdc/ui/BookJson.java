package com.pragmatists.cdc.ui;

import com.pragmatists.cdc.domain.Book;

public class BookJson {
    public String id;
    public String author;
    public String title;
    public int year;

    public BookJson() {
    }

    public BookJson(Book book) {
        this.id = book.id;
        this.author = book.author;
        this.title = book.title;
        this.year = book.year;
    }
}
