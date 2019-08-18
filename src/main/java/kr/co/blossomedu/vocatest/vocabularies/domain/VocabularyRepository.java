package kr.co.blossomedu.vocatest.vocabularies.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @Query("SELECT v FROM Vocabulary v JOIN FETCH v.chapter vc WHERE vc.id BETWEEN :startChapterId AND :endChapterId AND v.isDerivative = false")
    List<Vocabulary> findAllByChapterIdBetweenAndDerivativeIsFalse(@Param("startChapterId") Long startChapterId, @Param("endChapterId") Long endChapterId);

    @Query("SELECT v FROM Vocabulary v JOIN FETCH v.chapter vc WHERE vc.id BETWEEN :startChapterId AND :endChapterId")
    List<Vocabulary> findAllByChapterIdBetween(@Param("startChapterId") Long startChapterId, @Param("endChapterId") Long endChapterId);
}
