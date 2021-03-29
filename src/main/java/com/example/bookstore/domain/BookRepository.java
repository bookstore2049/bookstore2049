package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

  // Returns all Book instances:
  Iterable<Book> findAll();

  // Find all the Books by an Author:
  List<Book> findByAuthor(@Param("author") String author);

  // Find all the Books by a Year:
  List<Book> findByYear(@Param("year") int year);

  // Find a Book
  Book findBookByTitle(@Param("title") String title);
}
