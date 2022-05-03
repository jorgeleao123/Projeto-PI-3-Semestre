package connect.go.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FavoriteAddressAlreadyExistsException extends RuntimeException{

    @ExceptionHandler(value = FavoriteAddressAlreadyExistsException.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<>("Endereço Favorito já existe", HttpStatus.BAD_REQUEST);
    }
}
