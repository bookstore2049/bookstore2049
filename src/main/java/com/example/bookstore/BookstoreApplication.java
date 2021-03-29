package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.*;


// TASK SP6.1 a): Test all controller(s)
// Test: context creates BookController.

// TASK SP6.1 b): Add JPA repository tests.
// Tests: create, search & delete functionality for each repository.

// TASK SP6.2: Not deployed (yet) to Heroku. There's probably some quota and
// I don't care to run it out before the assignment is checked.

@SpringBootApplication
public class BookstoreApplication {

  @Autowired private UserRepository     userdb;
  @Autowired private BookRepository     bookdb;
  @Autowired private CategoryRepository catdb;

  private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }

  @Bean
  public CommandLineRunner runner() {
    return (args) -> {

      System.out.println ("WELCOME TO THE BOOKSTORE");
      log.info           ("ADDING TEST DATA");

      catdb.save(new Category("Western"));
      catdb.save(new Category("Science Fiction"));
      catdb.save(new Category("Epic"));

      bookdb.save(new Book("Blood Meridian", "Cormac McCarthy", 1985, "0-394-54482-X", 1.0, catdb.findByName("Western").get(0)));
      bookdb.save(new Book("Death's End", "Liu Cixin", 2010, "0765377101", 1.0, catdb.findByName("Science Fiction").get(0)));
      bookdb.save(new Book("Moby-Dick", "Herman Melville", 1851, "9780553213119", 1.0, catdb.findByName("Epic").get(0)));

      User USER = userdb.save(new User("user", "$2a$10$OB3JERL.Pv5fupiia3d0/On7CBi3Z.REKtA7vYPPUJRNM9PBOlG.6", "me@here","USER"));
      User ADMIN = userdb.save(new User("admin", "$2a$10$gwLE8ozTX0a329gngl2a3ey7ZdT7N3rmgLZ/uzeyDmw3BFfZ/SSq.", "me@there", "ADMIN"));
      userdb.save(USER);
      userdb.save(ADMIN);

      log.info("Fetch test data");
      for (Book book : bookdb.findAll()) {
        log.info(book.toString());
      }
    };
  }
}

/*
   Delete a Book:
       curl -X DELETE http://localhost:8080/api/books/[ID]
   Find a Book by Author (first name + last name)
       curl http://localhost:8080/api/books/search/findByAuthor?author=[FIRST NAME]+[LAST NAME]
   Find a Book by a Category
       curl http://localhost:8080/api/categories/search/findByName?name=[CATEGORY]
*/
