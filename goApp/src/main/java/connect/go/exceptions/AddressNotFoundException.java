package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressNotFoundException extends RuntimeException{

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<Object> exception() {
        return new ResponseEntity<>("Endereço não encontrado", HttpStatus.NOT_FOUND);
    }
}
