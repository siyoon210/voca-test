package kr.co.blossomedu.vocatest.users.controller.api;

import kr.co.blossomedu.vocatest.users.service.dto.UserCreate;
import kr.co.blossomedu.vocatest.users.service.dto.UserResponse;
import kr.co.blossomedu.vocatest.users.service.exception.SignUpException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

import static kr.co.blossomedu.vocatest.users.domain.UserValidator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTests {

    public static final String VALID_USER_NAME = "name";
    public static final String VALID_USER_EMAIL = "email@gmail.com";
    public static final String VALID_USER_PASSWORD = "P@ssw0rd";

    private String uri = linkTo(UserApiController.class).toUri().toString();

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void 회원가입() {
        // given
        final UserCreate userCreate = new UserCreate(VALID_USER_EMAIL, VALID_USER_NAME, VALID_USER_PASSWORD);

        // when
        final UserResponse userResponse = webTestClient.post().uri(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(userCreate), UserCreate.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserResponse.class)
                .returnResult()
                .getResponseBody();

        // then
        assertThat(userCreate.getEmail()).isEqualTo(userResponse.getEmail());
        assertThat(userCreate.getName()).isEqualTo(userResponse.getName());
    }

    @ParameterizedTest(name = "{index}: {4}")
    @MethodSource("invalidParameters")
    @DisplayName("회원가입 한가지 유효값 입력한 경우 예외처리")
    void 회원가입_유효성_에러_테스트(String name, String email, String password, String message, String me) {
        final UserCreate userCreate = new UserCreate(email, name, password);

        webTestClient.post().uri(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(userCreate), UserCreate.class)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody()
                .consumeWith(response -> {
                    String body = new String(response.getResponseBody());
                    final String defaultMessage = SignUpException.DEFAULT_MESSAGE;
                    assertThat(body.contains(defaultMessage)).isTrue();
                    assertThat(body.contains(message)).isTrue();
                });
    }

    static Stream<Arguments> invalidParameters() throws Throwable {
        return Stream.of(
                Arguments.of("name", "asfas", "P@assw0rd", EMAIL_CONSTRAINT_MESSAGE, "email 양식"),
                Arguments.of("a", "valid@gmail.com", "P@assw0rd", NAME_CONSTRAINT_MESSAGE, "name 2자 미만"),
                Arguments.of("qwertasdfzp", "valid@gmail.com", "P@assw0rd", NAME_CONSTRAINT_MESSAGE, "name 10자 초과"),
                Arguments.of("12ad", "valid@gmail.com", "P@assw0rd", NAME_CONSTRAINT_MESSAGE, "name 숫자 포함"),
                Arguments.of("name", "valid@gmail.com", "Passw0rd", PASSWORD_CONSTRAINT_MESSAGE, "password 특수문자 제외"),
                Arguments.of("name", "valid@gmail.com", "P@ssword", PASSWORD_CONSTRAINT_MESSAGE, "password 숫자 제외"),
                Arguments.of("name", "valid@gmail.com", "p@ssw0rd", PASSWORD_CONSTRAINT_MESSAGE, "password 대문자 제외"),
                Arguments.of("name", "valid@gmail.com", "P@SSW0RD", PASSWORD_CONSTRAINT_MESSAGE, "password 소문자 제외")
        );
    }
}