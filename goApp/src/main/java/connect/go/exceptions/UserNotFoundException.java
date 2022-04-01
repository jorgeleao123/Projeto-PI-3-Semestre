package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundException extends RuntimeException{

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception() {
        return new ResponseEntity<>("Usuario não encontrdo", HttpStatus.NOT_FOUND);
    }
}
