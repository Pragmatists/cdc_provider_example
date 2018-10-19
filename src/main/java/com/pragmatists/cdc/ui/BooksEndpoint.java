package com.pragmatists.cdc.ui;

import com.pragmatists.cdc.domain.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BooksEndpoint {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksEndpoint(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(
            value = "/books",
            method = GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BooksJson getAll() {
        List<BookJson> books = booksRepository.all().stream().map(BookJson::new).collect(toList());
        return new BooksJson(books);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook() {

    }

}
