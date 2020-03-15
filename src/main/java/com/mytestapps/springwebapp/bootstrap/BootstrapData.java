package com.mytestapps.springwebapp.bootstrap;

import com.mytestapps.springwebapp.domain.Author;
import com.mytestapps.springwebapp.domain.Book;
import com.mytestapps.springwebapp.domain.Publisher;
import com.mytestapps.springwebapp.repositories.AuthorRepository;
import com.mytestapps.springwebapp.repositories.BookRepository;
import com.mytestapps.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher();
        publisher1.setName("ABC Publishing");
        publisher1.setCity("Warsaw");
        publisher1.setState("Mazowieckie");

        publisherRepository.save(publisher1);
        System.out.println("Publisher Count: " + publisherRepository.count());


        Author tolkien = new Author("JRR", " Tolkien");
        Book lordOfTheRingsSaga = new Book("Lord of The Rings", " 123456");

        tolkien.getBooks().add(lordOfTheRingsSaga);
        lordOfTheRingsSaga.getAuthors().add(tolkien);
        lordOfTheRingsSaga.setPublisher(publisher1);
        publisher1.getBooks().add(lordOfTheRingsSaga);

        authorRepository.save(tolkien);
        bookRepository.save(lordOfTheRingsSaga);
        publisherRepository.save(publisher1);


        Author sapkowski = new Author("Andrzej", "Sapkowski");
        Book witcherSaga = new Book("Witcher", "654321");

        sapkowski.getBooks().add(witcherSaga);
        witcherSaga.getAuthors().add(sapkowski);
        witcherSaga.setPublisher(publisher1);
        publisher1.getBooks().add(witcherSaga);


        authorRepository.save(sapkowski);
        bookRepository.save(witcherSaga);
        publisherRepository.save(publisher1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher1.getBooks().size());




    }


}
