package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class FileIsOnReadOnlyModeException extends RuntimeException{
    public FileIsOnReadOnlyModeException() {
    }

    public FileIsOnReadOnlyModeException(String message) {
        super(message);
    }
}
