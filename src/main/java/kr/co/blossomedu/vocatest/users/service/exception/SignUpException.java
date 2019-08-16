package kr.co.blossomedu.vocatest.users.service.exception;

import kr.co.blossomedu.vocatest.commons.exception.CustomException;

public class SignUpException extends CustomException {
    public static final String DEFAULT_MESSAGE = "회원가입 실패";

    public SignUpException(final String message) {
        super(DEFAULT_MESSAGE + "\n" + message);
    }
}
