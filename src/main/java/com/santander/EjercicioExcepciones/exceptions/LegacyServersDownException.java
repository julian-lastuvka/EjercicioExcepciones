package com.santander.EjercicioExcepciones.exceptions;

public class LegacyServersDownException extends RuntimeException{

    public LegacyServersDownException() {
    }

    public LegacyServersDownException(String message) {
        super(message);
    }
}
