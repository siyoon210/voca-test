package kr.co.blossomedu.vocatest.books.controller.api;

import kr.co.blossomedu.vocatest.books.service.dto.BookCreate;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import reactor.core.publisher.Mono;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookApiControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    private String uri = linkTo(BookApiController.class).toUri().toString();

    @Test
    void 조회_성공() {
        // given

        // when
        final Set bookResponses = webTestClient.get().uri(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Set.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(bookResponses).isEmpty();
    }

    @Test
    void 책_생성() {
        // given
        final BookCreate bookCreate = new BookCreate("smaple name");

        // when
        final BookResponse bookResponse = webTestClient.post().uri(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(bookCreate), BookCreate.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(BookResponse.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(bookCreate.getName()).isEqualTo(bookResponse.getName());
    }
}