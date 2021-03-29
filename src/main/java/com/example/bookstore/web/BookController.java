package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

import com.example.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
  @Autowired private BookRepository bookdb;
  @Autowired private CategoryRepository catdb;

  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }

  @GetMapping("/index")
  public String index() {
    return "index";
  }

  @GetMapping("/booklist")
  public String list(Model model) {
    model.addAttribute("books", bookdb.findAll());
    return "booklist";
  }

  @GetMapping("/addbook")
  public String add(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", catdb.findAll());
    return "addbook";
  }

  @PostMapping("/save")
  public String save(Book book) {
    bookdb.save(book);
    return "redirect:booklist";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    bookdb.deleteById(id);
    return "redirect:../booklist";
  }

  @GetMapping(value = "/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
    model.addAttribute("book", bookdb.findById(id));
    model.addAttribute("categories", catdb.findAll());
    return "editbook";
  }

  // REST services:

  @GetMapping("/book/{id}")
  public @ResponseBody
  Optional<Book> findBookRest(@PathVariable("id") Long id) {
    return bookdb.findById(id);
  }

  @GetMapping("/books")
  public @ResponseBody
  List<Book> bookListRest() {
    return (List<Book>) bookdb.findAll();
  }
}
