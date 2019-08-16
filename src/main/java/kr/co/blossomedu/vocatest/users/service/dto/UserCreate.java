package kr.co.blossomedu.vocatest.users.service.dto;

import kr.co.blossomedu.vocatest.users.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserCreate {

    private String email;
    private String name;
    private String password;

    public UserCreate(final String email, final String name, final String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
