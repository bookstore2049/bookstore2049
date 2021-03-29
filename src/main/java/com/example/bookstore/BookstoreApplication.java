package com.example.bookstore;

import com.example.bookstore.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

      userdb.deleteAll();

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