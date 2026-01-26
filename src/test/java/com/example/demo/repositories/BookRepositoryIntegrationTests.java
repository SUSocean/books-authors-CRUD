package com.example.demo.repositories;

import com.example.demo.TestDataUtil;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        Book savedBook = underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA(author);
        Book savedBooksA = underTest.save(bookA);

        Book bookB = TestDataUtil.createTestBookB(author);
        Book savedBooksB = underTest.save(bookB);

        Book bookC = TestDataUtil.createTestBookC(author);
        Book savedBooksC = underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();

        assertThat(result)
                .hasSize(3)
                .contains(savedBooksA, savedBooksB, savedBooksC);
    }

    @Test
    public void testThatBookCanBeUpdated(){
        Author author = TestDataUtil.createTestAuthorA();

        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);

        book.setTitle("UPDATED");
        Book updatedBook = underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(updatedBook);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        Author author = TestDataUtil.createTestAuthorA();

        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);

        underTest.deleteById(book.getIsbn());

        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isEmpty();
    }
}
