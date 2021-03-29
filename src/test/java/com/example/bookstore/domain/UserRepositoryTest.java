package com.example.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

  @Autowired UserRepository userdb;

  @Test public void testFindByUserNameAdmin()
  {
    User a = userdb.findByUsername("admin");
    assertThat(a.getUsername()).isEqualTo("admin");
  }

  @Test public void testFindByUserNameUser()
  {
    User u = userdb.findByUsername("user");
    assertThat(u.getUsername()).isEqualTo("user");
  }

  @Test public void testAddUserAsko()
  {
    User u = new User("asko", "$2a$10$.sdMzEBSmQZWgLgPoKRY/e08TOcb7s4.e5VHH/zaBbi2QT2e44fLW", "this@there", "USER");
    userdb.save(u);
    User a = userdb.findByUsername("asko");
    assertThat(a.getUsername()).isEqualTo("asko");
  }

  @Test public void testDelete()
  {
    User u = new User("asko", "$2a$10$.sdMzEBSmQZWgLgPoKRY/e08TOcb7s4.e5VHH/zaBbi2QT2e44fLW", "this@there", "USER");
    userdb.save(u);

    User a = userdb.findByUsername("asko");
    assertThat(a.getUsername()).isEqualTo("asko");

    userdb.delete(a);
    assertThat(userdb.findByUsername("asko")).isEqualTo(null);

  }
}
