package com.example.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private String author;
  private int year;
  private String isbn;
  private double price;

  @ManyToOne
  @JoinColumn(name = "cId")
  @JsonManagedReference
  private Category category;

  public Book(String title, String author, int year, String isbn, double price, Category category) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.isbn = isbn;
    this.price = price;
    this.category = category;
  }

  public Book() {}

  public long     getId()       { return id;     }
  public String   getAuthor()   { return author; }
  public String   getTitle()    { return title;  }
  public int      getYear()     { return year;   }
  public String   getIsbn()     { return isbn;   }
  public double   getPrice()    { return price;  }
  public Category getCategory() { return category; }

  public void setId       (long   id     )    { this.id     = id;     }
  public void setTitle    (String title  )    { this.title  = title;  }
  public void setAuthor   (String author )    { this.author = author; }
  public void setYear     (int    year   )    { this.year   = year;   }
  public void setIsbn     (String isbn   )    { this.isbn   = isbn;   }
  public void setPrice    (double price  )    { this.price  = price;  }
  public void setCategory (Category category) { this.category = category; }

  @Override
  public String toString() {
    return "Book ["
            + "id="        + id     + ", "
            + "title='"    + title  + '\''
            + ", author='" + author + '\''
            + ", year="    + year
            + ", isbn='"   + isbn   + '\''
            + ", price="   + price  + ']';
  }
}
