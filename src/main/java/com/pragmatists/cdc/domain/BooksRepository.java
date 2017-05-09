package com.pragmatists.cdc.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksRepository {
    public List<Book> all() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("0060855924", "Terry Pratchett", "The Color of Magic", 1983));
        books.add(new Book("0061020702", "Terry Pratchett", "The Light Fantastic", 1986));
        books.add(new Book("0060855908", "Terry Pratchett", "Equal Rites", 1987));
        return books;
    }
}
