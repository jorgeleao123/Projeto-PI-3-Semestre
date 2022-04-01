package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestException extends RuntimeException{

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception() {
        return new ResponseEntity<>("Dados enviados incorretamente", HttpStatus.BAD_REQUEST);
    }
}
