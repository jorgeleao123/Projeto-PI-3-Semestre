package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyExistsException extends RuntimeException{

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<>("Usuário já existe", HttpStatus.BAD_REQUEST);
    }
}
