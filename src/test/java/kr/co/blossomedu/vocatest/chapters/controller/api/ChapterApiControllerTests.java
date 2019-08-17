package kr.co.blossomedu.vocatest.chapters.controller.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
    }
}