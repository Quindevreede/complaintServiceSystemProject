package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.exceptions.BadRequestException;
import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = nl.quin.complaintservicesystem.exceptions.RecordNotFoundException.class)
    public ResponseEntity<Object> exception(nl.quin.complaintservicesystem.exceptions.RecordNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception(BadRequestException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = nl.quin.complaintservicesystem.exceptions.ForbiddenException.class)
    public ResponseEntity<Object> exception(nl.quin.complaintservicesystem.exceptions.ForbiddenException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler(value = nl.quin.complaintservicesystem.exceptions.FileStorageException.class)
    public ResponseEntity<Object> exception(nl.quin.complaintservicesystem.exceptions.FileStorageException exception) {
        return ResponseEntity.badRequest().build();
    }

}