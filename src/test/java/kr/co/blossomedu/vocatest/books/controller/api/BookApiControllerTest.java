package kr.co.blossomedu.vocatest.books.controller.api;

import kr.co.blossomedu.vocatest.books.service.dto.BookCreateRequest;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
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
class BookApiControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    private String uri = linkTo(BookApiController.class).toUri().toString();

    @Test
    void 책_목록_조회_성공() {
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
        assertThat(bookResponses).isNotEmpty(); //sample data.sql이 있다는 가정하에 true
    }

    @Test
    void 책_생성() {
        // given
        final BookCreateRequest bookCreateRequest = new BookCreateRequest("smaple name");

        // when
        final BookResponse bookResponse = webTestClient.post().uri(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(bookCreateRequest), BookCreateRequest.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(BookResponse.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(bookCreateRequest.getName()).isEqualTo(bookResponse.getName());
    }
}