package kr.co.blossomedu.vocatest.chapters.controller.api;

import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterCreateRequest;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChapterApiControllerTests {
    @Autowired
    private WebTestClient webTestClient;

    private String uri = linkTo(ChapterApiController.class).toString();

    @Test
    void 챕터_목록_조회() {
        //given

        //when
        final Set chapterResponses = webTestClient.get().uri(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        //then
        assertThat(chapterResponses).isEmpty();
    }

    @Test
    void 챕터_생성() {
        //given
        final ChapterCreateRequest chapterCreateRequest = new ChapterCreateRequest(1L, "1과", 1L);

        //when
        final ChapterResponse chapterResponse = webTestClient.post().uri(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(chapterCreateRequest), ChapterCreateRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ChapterResponse.class)
                .returnResult()
                .getResponseBody();

        //then
        assertThat(chapterResponse.getName()).isEqualTo(chapterCreateRequest.getName());
    }
}