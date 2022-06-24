package com.santander.EjercicioExcepciones.exceptions;

public class QueueIsFullException extends RuntimeException{
    public QueueIsFullException() {
    }

    public QueueIsFullException(String message) {
        super(message);
    }
}
