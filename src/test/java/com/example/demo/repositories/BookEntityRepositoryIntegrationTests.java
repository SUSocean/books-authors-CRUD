//package com.example.demo.repositories;
//
//import com.example.demo.TestDataUtil;
//import com.example.demo.domain.entities.AuthorEntity;
//import com.example.demo.domain.entities.BookEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookEntityRepositoryIntegrationTests {
//
//    private BookRepository underTest;
//
//    @Autowired
//    public BookEntityRepositoryIntegrationTests(BookRepository underTest){
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatBookCanBeCreatedAndRecalled(){
//        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
//        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
//        BookEntity savedBookEntity = underTest.save(bookEntity);
//        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(savedBookEntity);
//    }
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
//        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
//
//        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntity);
//        BookEntity savedBooksA = underTest.save(bookEntityA);
//
//        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntity);
//        BookEntity savedBooksB = underTest.save(bookEntityB);
//
//        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntity);
//        BookEntity savedBooksC = underTest.save(bookEntityC);
//
//        Iterable<BookEntity> result = underTest.findAll();
//
//        assertThat(result)
//                .hasSize(3)
//                .contains(savedBooksA, savedBooksB, savedBooksC);
//    }
//
//    @Test
//    public void testThatBookCanBeUpdated(){
//        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
//
//        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
//        underTest.save(bookEntity);
//
//        bookEntity.setTitle("UPDATED");
//        BookEntity updatedBookEntity = underTest.save(bookEntity);
//
//        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(updatedBookEntity);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted(){
//        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
//
//        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
//        underTest.save(bookEntity);
//
//        underTest.deleteById(bookEntity.getIsbn());
//
//        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
//        assertThat(result).isEmpty();
//    }
//}
