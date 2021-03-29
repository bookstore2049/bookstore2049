package com.example.bookstore;

import com.example.bookstore.web.BookController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

  @Autowired private BookController bookController;

  @Test void testContextLoads() {
    assertThat(bookController).isNotNull();
  }
}
