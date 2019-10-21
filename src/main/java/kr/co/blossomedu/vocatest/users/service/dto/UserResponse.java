package kr.co.blossomedu.vocatest.users.service.dto;

import kr.co.blossomedu.vocatest.users.domain.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    private String name;

    @Builder
    public UserResponse(final Long id, final String email, final String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static UserResponse from(final User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
