package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {
  List<Category> findByName(@Param("name") String name);
}
