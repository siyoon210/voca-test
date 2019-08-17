package kr.co.blossomedu.vocatest.vocabularies.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    List<Vocabulary> findAllByChapterIdBetweenAndIsDerivative(Long startChapterId, Long endChapterId, boolean isDerivative);

    List<Vocabulary> findAllByChapterIdBetween(Long startChapterId, Long endChapterId);
}
