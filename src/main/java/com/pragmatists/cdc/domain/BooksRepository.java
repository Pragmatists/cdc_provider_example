package com.pragmatists.cdc.domain;

import java.util.List;

public interface BooksRepository {
    List<Book> all();

    void add(Book book);
}
