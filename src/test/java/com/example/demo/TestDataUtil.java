package com.example.demo;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }
}