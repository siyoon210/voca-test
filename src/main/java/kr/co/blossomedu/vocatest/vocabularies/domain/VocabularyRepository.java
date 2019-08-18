package kr.co.blossomedu.vocatest.vocabularies.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @Query("SELECT v FROM Vocabulary v JOIN FETCH v.chapter vc WHERE vc.bookId =:bookId AND vc.sequence BETWEEN :startChapter AND :endChapter AND v.isDerivative = false")
    List<Vocabulary> findAllByChapterBetweenAndDerivativeIsFalse(@Param("bookId") long bookId, @Param("startChapter") int startChapter, @Param("endChapter") int endChapter);

    @Query("SELECT v FROM Vocabulary v JOIN FETCH v.chapter vc WHERE vc.bookId =:bookId AND vc.sequence BETWEEN :startChapter AND :endChapter")
    List<Vocabulary> findAllByChapterBetween(@Param("bookId") long bookId, @Param("startChapter") int startChapter, @Param("endChapter") int endChapter);
}
