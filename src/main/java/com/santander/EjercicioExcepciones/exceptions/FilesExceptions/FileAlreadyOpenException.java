package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class FileAlreadyOpenException extends RuntimeException{
    public FileAlreadyOpenException() {
    }

    public FileAlreadyOpenException(String message) {
        super(message);
    }
}
