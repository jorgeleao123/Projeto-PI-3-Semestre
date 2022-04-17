package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressAlreadyExistsException extends RuntimeException{

    @ExceptionHandler(value = AddressAlreadyExistsException.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<>("Endereço já existe", HttpStatus.BAD_REQUEST);
    }
}
