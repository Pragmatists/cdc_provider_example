package com.pragmatists.cdc;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.pragmatists.cdc.domain.Book;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BooksEndpointConfiguration.class, webEnvironment = RANDOM_PORT)
public class BooksEndpointTest {
    @LocalServerPort
    private int port;

    @Autowired
    private JsonMapper jsonMapper;

    @Test
    public void shouldGetAllBooks() throws Exception {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(format("http://localhost:%d/books", port)).get().build();

        Response response = httpClient.newCall(request).execute();

        List<Book> books = jsonMapper.transform(response, TypeFactory.defaultInstance().constructCollectionType(List.class, Book.class));
        assertThat(books).hasSize(3).extracting("year").containsExactly(1983, 1986, 1987);

    }
}