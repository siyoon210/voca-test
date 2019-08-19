package kr.co.blossomedu.vocatest.vocas.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class VocaRepositoryTest {

    @Autowired
    private VocaRepository vocaRepository;

    @Test
    void 파생어_제외_테스트1() {
        // when
        final List<Voca> vocas = vocaRepository.findAllByChapterBetweenAndExcludeDerivative(1L, 1, 3);

        // then
        assertThat(vocas).hasSize(12);
    }

    @Test
    void 파생어_제외_테스트2() {
        // when
        final List<Voca> vocas = vocaRepository.findAllByChapterBetweenAndExcludeDerivative(1L, 2, 2);

        // then
        assertThat(vocas).hasSize(4);
    }

    @Test
    void 파생어_포함_테스트() {
        // when
        final List<Voca> vocas = vocaRepository.findAllByChapterBetweenAndIncludeDerivative(1L, 1, 3);

        // then
        assertThat(vocas).hasSize(15);
    }
}