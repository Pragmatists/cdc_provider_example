package com.pragmatists.cdc.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("live")
public class BooksRepositoryLive implements BooksRepository {

    private List<Book> books = new ArrayList<>();

    public BooksRepositoryLive() {
        add(new Book("0060855924", "Terry Pratchett", "The Color of Magic", 1983));
        add(new Book("0061020702", "Terry Pratchett", "The Light Fantastic", 1986));
        add(new Book("0060855908", "Terry Pratchett", "Equal Rites", 1987));
    }

    @Override
    public List<Book> all() {
        return books;
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }
}
