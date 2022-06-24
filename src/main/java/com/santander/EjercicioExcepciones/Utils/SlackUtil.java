package com.santander.EjercicioExcepciones.Utils;

import com.santander.EjercicioExcepciones.exceptions.SlackServersDownException;

public class SlackUtil {

    public static boolean notifyUserCreationToSlackSupportChannel(String newUserEmail){

        // servers down
        if(checkIfSlackServersAreDown()) {
            throw new SlackServersDownException("Slack servers are down");
        }

        // here a notification should be sent to the slack support channel

        return true;
    }

    public static boolean checkIfSlackServersAreDown() {
        return false;
    }
}

