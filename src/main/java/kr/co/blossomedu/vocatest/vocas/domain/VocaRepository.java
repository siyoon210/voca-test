package kr.co.blossomedu.vocatest.vocas.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocaRepository extends JpaRepository<Voca, Long> {
    @Query("SELECT v FROM Voca v JOIN FETCH v.chapter vc JOIN FETCH vc.book vcb WHERE vcb.id =:bookId AND vc.sequence BETWEEN :startChapter AND :endChapter AND v.isDerivative = false")
    List<Voca> findAllByChapterBetweenAndExcludeDerivative(@Param("bookId") Long bookId, @Param("startChapter") Integer startChapter, @Param("endChapter") Integer endChapter);

    @Query("SELECT v FROM Voca v JOIN FETCH v.chapter vc JOIN FETCH vc.book vcb WHERE vcb.id =:bookId AND vc.sequence BETWEEN :startChapter AND :endChapter")
    List<Voca> findAllByChapterBetweenAndIncludeDerivative(@Param("bookId") Long bookId, @Param("startChapter") Integer startChapter, @Param("endChapter") Integer endChapter);
}
