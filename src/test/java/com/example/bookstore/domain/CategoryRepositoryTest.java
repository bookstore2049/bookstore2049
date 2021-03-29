package com.example.bookstore.domain;

import org.junit.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

  @Autowired private CategoryRepository catdb;

  @Test public void testCreateCategoryProgrammingLanguageTheory()
  {
    Category c = new Category("Programming Language Theory");
    catdb.save(c);
    List<Category> d = catdb.findByName("Programming Language Theory");
    assertThat(d.get(0).getName()).isEqualTo("Programming Language Theory");
  }

  @Test public void testFindByNameEpic()
  {
    List<Category> c = catdb.findByName("Epic");
    assertThat(c.get(0).getName()).isEqualTo("Epic");
  }

  @Test public void testDeleteCategoryProgrammingLanguageTheory()
  {
    Category c = new Category("Programming Language Theory");
    catdb.save(c);

    List<Category> d = catdb.findByName("Programming Language Theory");
    assertThat(d.get(0).getName()).isEqualTo("Programming Language Theory");

    catdb.delete(c);
    assertThat(catdb.findByName("Programming Language Theory")).isEmpty();
  }
}
