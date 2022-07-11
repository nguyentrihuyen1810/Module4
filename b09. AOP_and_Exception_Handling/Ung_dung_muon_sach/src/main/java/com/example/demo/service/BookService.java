package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean rentBook( Book book);

    void giveBookBack(Book book);
}