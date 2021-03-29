package com.example.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
  @Autowired BookRepository     bookdb;
  @Autowired CategoryRepository catdb;

  @Test public void testSaveBookBOTNS() {
    Book b = new Book("Book Of The New Sun", "Gene Wolfe", 1980, "1337", 2, catdb.findByName("Epic").get(0));
    assertThat(b.getTitle()).isEqualTo("Book Of The New Sun");
  }

  @Test public void testDeleteBooks() {
    bookdb.deleteAll();
    assertThat(bookdb.findAll()).isEmpty();
  }

  @Test public void testFindBookByTitleBloodMeridian() {
    Book b = bookdb.findBookByTitle("Blood Meridian");
    assertThat(b.getTitle()).isEqualTo("Blood Meridian");
  }
}
