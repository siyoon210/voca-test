package kr.co.blossomedu.vocatest.users.controller.api;

import kr.co.blossomedu.vocatest.commons.ErrorMessage;
import kr.co.blossomedu.vocatest.commons.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = UserApiController.class)
public class UserApiControllerAdvice {

    @ExceptionHandler({CustomException.class})
    private ResponseEntity<ErrorMessage> handleException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
