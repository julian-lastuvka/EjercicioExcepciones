package com.santander.EjercicioExcepciones.exceptions;

public class SlackServersDownException extends RuntimeException{

    public SlackServersDownException() {

    }

    public SlackServersDownException(String message) {
        super(message);
    }
}
