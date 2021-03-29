package com.example.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @JsonBackReference
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private List<Book> books;

  public Category(String name) {
    this.name = name;
  }

  public Category() {}

  public Long       getId()    { return id; }
  public String     getName()  { return name; }
  public List<Book> getBooks() { return books; }

  public void setId    (Long id          ) { this.id    = id;    }
  public void setName  (String name      ) { this.name  = name;  }
  public void setBooks (List<Book> books ) { this.books = books; }

  @Override
  public String toString() {
    return name;
  }
}
