package kr.co.blossomedu.vocatest.books.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT DISTINCT b FROM Book b JOIN FETCH b.chapters bc")
    List<Book> findAll();

    @Query("SELECT b FROM Book b JOIN FETCH b.chapters bc WHERE b.id =:bookId")
    Optional<Book> findById(@Param("bookId") Long bookId);
}
