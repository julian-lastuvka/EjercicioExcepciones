package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException() {
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
