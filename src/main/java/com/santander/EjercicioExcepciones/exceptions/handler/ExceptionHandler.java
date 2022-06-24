package com.santander.EjercicioExcepciones.exceptions.handler;


import com.santander.EjercicioExcepciones.dtos.ResponseDTO;
import com.santander.EjercicioExcepciones.exceptions.*;
import com.santander.EjercicioExcepciones.exceptions.FilesExceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundException.class, FileNotFoundException.class})
    public ResponseEntity<ResponseDTO> notFoundException(Exception e) {
        return new ResponseEntity(new ResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class, UserAlreadyExistsException.class})
    public ResponseEntity<ResponseDTO> badRequestException(Exception e) {
        return new ResponseEntity(new ResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({SlackServersDownException.class, LegacyServersDownException.class})
    public ResponseEntity<ResponseDTO> serversDownException(Exception e) {
        return new ResponseEntity(new ResponseDTO(e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({FileAlreadyOpenException.class,
            FileCouldNotBeLoadedException.class,
            FileIsOnReadOnlyModeException.class,
            FileNotOpenException.class,
            WritingPermissionsDeniedException.class,
            QueueIsFullException.class})
    public ResponseEntity<ResponseDTO> blabla(Exception e) {
        return new ResponseEntity(new ResponseDTO(e.getMessage()), HttpStatus.CONFLICT);
    }

}
