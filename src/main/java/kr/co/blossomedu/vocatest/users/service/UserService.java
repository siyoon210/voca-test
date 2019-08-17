package kr.co.blossomedu.vocatest.users.service;

import kr.co.blossomedu.vocatest.users.domain.UserRepository;
import kr.co.blossomedu.vocatest.users.service.dto.UserCreate;
import kr.co.blossomedu.vocatest.users.service.dto.UserResponse;
import kr.co.blossomedu.vocatest.users.service.exception.SignUpException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse save(final UserCreate userCreate) {
        try {
            return UserResponse.from(userRepository.save(userCreate.toEntity()));
        } catch (Exception e) {
            throw new SignUpException(e.getMessage());
        }
    }
}
