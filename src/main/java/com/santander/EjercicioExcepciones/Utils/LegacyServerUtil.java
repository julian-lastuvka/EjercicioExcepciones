package com.santander.EjercicioExcepciones.Utils;

import com.santander.EjercicioExcepciones.exceptions.LegacyServersDownException;

import java.util.List;

public class LegacyServerUtil {

    public static boolean sentQueueToLegacyServer(List queue) {

        if (checkIfLegacyServersAreDown()) {
            throw new LegacyServersDownException("Legacy Servers are down");
        }

        // here the queue should be sent to the legacy server
        // sentQueueToLegacy(queue);

        return true;
    }

    public static boolean checkIfLegacyServersAreDown() {
        return false;
    }
}
