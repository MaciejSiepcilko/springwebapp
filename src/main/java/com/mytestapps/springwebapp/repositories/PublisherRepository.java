package com.mytestapps.springwebapp.repositories;

import com.mytestapps.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
