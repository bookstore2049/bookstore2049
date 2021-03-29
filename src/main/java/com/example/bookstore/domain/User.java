package com.example.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String role;

  public User(String username, String password, String email, String role) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
  }

  public User() {}

  public Long   getId()       { return id;       }
  public String getUsername() { return username; }
  public String getPassword() { return password; }
  public String getEmail()    { return email;    }
  public String getRole()     { return role;     }

  public void setId       (Long   id      ) { this.id       = id;       }
  public void setUsername (String username) { this.username = username; }
  public void setPassword (String password) { this.password = password; }
  public void setEmail    (String email   ) { this.email    = email;    }
  public void setRole     (String role    ) { this.role     = role;     }

}
