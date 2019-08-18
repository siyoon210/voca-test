package kr.co.blossomedu.vocatest.vocabularies.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VocabularyApiControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    private String uri = linkTo(VocabularyApiController.class).toString();

    @Test
    void 단어_목록_조회() {
        // given
        final int size = 8;
        final int startChapterSeq = 1;
        final int endChapterSeq = 3;
        final boolean derivative = false;

        // when
        final Set vocabularyResponses = webTestClient.get().uri(uri + "?size={size}&startChapter={startChapterSeq}&endChapter={endChapterSeq}&includeDerivative={derivative}"
                , size, startChapterSeq, endChapterSeq, derivative)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(vocabularyResponses).hasSize(8);
    }

    @Test
    void 파생어_포함_단어_목록_조회() {
        // given
        final int size = 10;
        final int startChapterId = 1;
        final int endChapterId = 2;
        final boolean derivative = true;

        // when
        final Set vocabularyResponses = webTestClient.get().uri(uri + "?size={size}&startChapterId={startChapterId}&endChapterId={endChapterId}&derivative={derivative}"
                , size, startChapterId, endChapterId, derivative)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(vocabularyResponses).hasSize(10);
    }
}