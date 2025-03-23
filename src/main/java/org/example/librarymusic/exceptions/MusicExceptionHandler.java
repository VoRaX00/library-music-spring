package org.example.librarymusic.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.example.librarymusic.errors.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MusicExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseError handle(NotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseError(HttpStatus.NOT_FOUND, e.getMessage());
    }

    public ResponseError handle(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseError(HttpStatus.CONFLICT, e.getMessage());
    }
}
