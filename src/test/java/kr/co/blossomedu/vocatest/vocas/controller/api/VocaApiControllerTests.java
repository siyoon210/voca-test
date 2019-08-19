package kr.co.blossomedu.vocatest.vocas.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VocaApiControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    private String uri = linkTo(VocaApiController.class).toString();

    @Test
    void 단어_목록_조회() {
        // given
        final long bookId = 1L;
        final int size = 8;
        final int startChapterSeq = 1;
        final int endChapterSeq = 3;
        final boolean derivative = false;

        // when
        final Set vocaResponses = webTestClient.get().uri(uri + "?bookId={bookId}&size={size}&startChapter={startChapterSeq}&endChapter={endChapterSeq}&includeDerivative={derivative}"
                , bookId, size, startChapterSeq, endChapterSeq, derivative)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(vocaResponses).hasSize(8);
    }

    @Test
    void 파생어_포함_단어_목록_조회() {
        // given
        final long bookId = 1L;
        final int size = 10;
        final int startChapter = 1;
        final int endChapter = 2;
        final boolean derivative = true;

        // when
        final Set vocaResponses = webTestClient.get().uri(uri + "?bookId={bookId}&size={size}&startChapter={startChapter}&endChapter={endChapter}&includeDerivative={derivative}"
                , bookId, size, startChapter, endChapter, derivative)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(vocaResponses).hasSize(10);
    }
}