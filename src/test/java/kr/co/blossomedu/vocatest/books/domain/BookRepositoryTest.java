package kr.co.blossomedu.vocatest.books.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        // when
        final List<Book> books = bookRepository.findAll();

        // then
        assertThat(books).hasSize(3); //sample data.sql 기준
    }

    @Test
    void findById() {
        // when
        final Optional<Book> book = bookRepository.findById(1L);

        // then
        assertThat(book.orElseThrow(RuntimeException::new).getChapters()).hasSize(5); //sample data.sql 기준
    }
}