package com.santander.EjercicioExcepciones.Utils;

import com.santander.EjercicioExcepciones.exceptions.BadRequestException;
import com.santander.EjercicioExcepciones.exceptions.NotFoundException;
import com.santander.EjercicioExcepciones.exceptions.UserAlreadyExistsException;
import com.santander.EjercicioExcepciones.services.models.User;

public class UserUtil {

    public static boolean saveUser(User user) {


        if (checkUserExistence(user)) {
            throw new UserAlreadyExistsException("El usuario ya existe");
        }

        // here the user should be saved to the mongo database.
        // * ~ magic ~ *

        return true;
    }


    // this method should check if the user exists in the relational database
    public static boolean checkUserExistence(User user) {
        return false;
    }
}
