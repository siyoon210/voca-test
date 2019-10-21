package kr.co.blossomedu.vocatest.users.controller.api;


import kr.co.blossomedu.vocatest.users.service.UserService;
import kr.co.blossomedu.vocatest.users.service.dto.UserCreate;
import kr.co.blossomedu.vocatest.users.service.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate userCreate) {
        UserResponse userResponse = userService.save(userCreate);
        final URI uri = linkTo(UserApiController.class).slash(userResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }
}
