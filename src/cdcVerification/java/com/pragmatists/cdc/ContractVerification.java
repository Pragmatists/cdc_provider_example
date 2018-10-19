package com.pragmatists.cdc;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.pragmatists.cdc.domain.Book;
import com.pragmatists.cdc.domain.BooksRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.batch.JobExecutionExitCodeGenerator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.SocketUtils;

@RunWith(PactRunner.class)
@Provider("books_provider")
@PactFolder("../pacts")
public class ContractVerification {

    @TestTarget
    public final Target target = new HttpTarget("http", "localhost", port);
    private static ConfigurableApplicationContext applicationContext;
    private static int port;


    @BeforeClass
    public static void setupBooksProviderApplication() {
        SpringApplication application = new SpringApplication(BooksEndpointConfigurationCdc.class);
        application.setAdditionalProfiles("cdc");
        port = SocketUtils.findAvailableTcpPort();
        applicationContext = application.run(String.format("--server.port=%d", port));
    }

    @AfterClass
    public static void stopApplication() {
        SpringApplication.exit(applicationContext, new JobExecutionExitCodeGenerator());
    }


    @State("there are books to read")
    public void setupBooks() {
        BooksRepository booksRepository = applicationContext.getBean(BooksRepository.class);
        booksRepository.add(new Book("0765377063", "Liu Cixin", "The Three-Body Problem", 2007));
        booksRepository.add(new Book("076537708X", "Liu Cixin", "The Dark Forest", 2009));
        booksRepository.add(new Book("076537708X", "Liu Cixin", "The Dark Forest", 2009));
    }
}
