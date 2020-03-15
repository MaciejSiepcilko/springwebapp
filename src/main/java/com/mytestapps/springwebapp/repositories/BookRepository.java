package com.mytestapps.springwebapp.repositories;

import com.mytestapps.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
