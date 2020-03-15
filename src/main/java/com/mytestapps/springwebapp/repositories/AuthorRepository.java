package com.mytestapps.springwebapp.repositories;

import com.mytestapps.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {


}
