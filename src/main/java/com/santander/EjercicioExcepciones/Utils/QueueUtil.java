package com.santander.EjercicioExcepciones.Utils;

import com.santander.EjercicioExcepciones.exceptions.QueueIsFullException;

import java.util.List;

public class QueueUtil {

    public static List<String> addMessageToQueue(String message, List queue) {

        if (checkQueueIsFull()){
            throw new QueueIsFullException("Queue is full. The message cannot be added");
        }

        queue.add(message);

        return queue;
    }

    public static boolean checkQueueIsFull() {
        return false;
    }
}
