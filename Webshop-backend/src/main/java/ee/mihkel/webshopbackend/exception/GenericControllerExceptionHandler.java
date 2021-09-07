package ee.mihkel.webshopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@ControllerAdvice
public class GenericControllerExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<ItemErrorResponse> handleError(ItemNotFoundException e) {
        ItemErrorResponse response = new ItemErrorResponse(new Date(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<ItemErrorResponse> handleError(MethodArgumentTypeMismatchException e) {
        ItemErrorResponse response = new ItemErrorResponse(new Date(), HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ItemErrorResponse> handleError(Exception e) {
//        ItemErrorResponse response = new ItemErrorResponse(new Date(), HttpStatus.BAD_REQUEST, "Tundmatu viga");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}
