package com.mytestapps.springwebapp.bootstrap;

import com.mytestapps.springwebapp.domain.Author;
import com.mytestapps.springwebapp.domain.Book;
import com.mytestapps.springwebapp.repositories.AuthorRepository;
import com.mytestapps.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author tolkien = new Author("JRR", " Tolkien");
        Book lordOfTheRingsSaga = new Book("Lord of The Rings", " 123456");
        tolkien.getBooks().add(lordOfTheRingsSaga);
        lordOfTheRingsSaga.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lordOfTheRingsSaga);


        Author sapkowski = new Author("Andrzej", "Sapkowski");
        Book witcherSaga = new Book("Witcher", "654321");
        sapkowski.getBooks().add(witcherSaga);
        witcherSaga.getAuthors().add(sapkowski);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
