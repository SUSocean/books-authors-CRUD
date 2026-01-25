package com.example.demo.dao;

import com.example.demo.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(String isbn, Book bookA);

    void delete(String isbn);
}

