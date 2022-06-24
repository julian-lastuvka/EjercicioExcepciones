package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class FileNotOpenException extends RuntimeException{
    public FileNotOpenException() {
    }

    public FileNotOpenException(String message) {
        super(message);
    }
}
