package kr.co.blossomedu.vocatest.vocabularies.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class VocabularyRepositoryTest {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Test
    void 파생어_제외_테스트1() {
        // when
        final List<Vocabulary> vocabularies = vocabularyRepository.findAllByChapterIdBetweenAndIsDerivative(1L, 3L, false);

        // then
        assertThat(vocabularies).hasSize(12);
    }

    @Test
    void 파생어_제외_테스트2() {
        // when
        final List<Vocabulary> vocabularies = vocabularyRepository.findAllByChapterIdBetweenAndIsDerivative(2L, 2L, false);

        // then
        assertThat(vocabularies).hasSize(4);
    }
}