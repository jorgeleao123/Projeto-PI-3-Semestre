package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ComplaintSavedAlreadyExistsException extends RuntimeException{

    @ExceptionHandler(value = ComplaintSavedAlreadyExistsException.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<>("Denúncia já está salva", HttpStatus.BAD_REQUEST);
    }
}
