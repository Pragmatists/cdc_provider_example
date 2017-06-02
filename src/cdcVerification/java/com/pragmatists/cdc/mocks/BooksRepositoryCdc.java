package com.pragmatists.cdc.mocks;

import com.pragmatists.cdc.domain.Book;
import com.pragmatists.cdc.domain.BooksRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("cdc")
public class BooksRepositoryCdc implements BooksRepository {
    private final ArrayList<Book> books = new ArrayList<>();

    @Override
    public List<Book> all() {
        return books;
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }
}
