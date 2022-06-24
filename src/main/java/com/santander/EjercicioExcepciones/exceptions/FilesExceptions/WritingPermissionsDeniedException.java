package com.santander.EjercicioExcepciones.exceptions.FilesExceptions;

public class WritingPermissionsDeniedException extends RuntimeException{
    public WritingPermissionsDeniedException() {
    }

    public WritingPermissionsDeniedException(String message) {
        super(message);
    }
}
