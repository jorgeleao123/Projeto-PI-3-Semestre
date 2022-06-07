package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressNotFoundException extends RuntimeException{

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<>("Endereço não encontrdo", HttpStatus.NOT_FOUND);
    }
}
