package com.example.demo.services;

import com.example.demo.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);

}
