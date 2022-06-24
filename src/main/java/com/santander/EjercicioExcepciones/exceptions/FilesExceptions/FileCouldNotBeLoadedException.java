package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class FileCouldNotBeLoadedException extends RuntimeException{
    public FileCouldNotBeLoadedException() {
    }

    public FileCouldNotBeLoadedException(String message) {
        super(message);
    }
}
