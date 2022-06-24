package com.santander.EjercicioExcepciones.services;


import com.santander.EjercicioExcepciones.exceptions.BadRequestException;
import com.santander.EjercicioExcepciones.exceptions.UserAlreadyExistsException;
import com.santander.EjercicioExcepciones.services.models.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static com.santander.EjercicioExcepciones.Utils.EmailUtil.sendEmail;
import static com.santander.EjercicioExcepciones.Utils.FileUtil.openFile;
import static com.santander.EjercicioExcepciones.Utils.FileUtil.writeFile;
import static com.santander.EjercicioExcepciones.Utils.LegacyServerUtil.sentQueueToLegacyServer;
import static com.santander.EjercicioExcepciones.Utils.QueueUtil.addMessageToQueue;
import static com.santander.EjercicioExcepciones.Utils.SlackUtil.notifyUserCreationToSlackSupportChannel;

import static com.santander.EjercicioExcepciones.Utils.UserUtil.saveUser;

@Service
public class UserService {


    public String createUser(String email, String password) {

        User newUser = new User(email, password);

        // open file -- Uso un string como file para simplificar
        String file = openFile("path/example");

        // queue
        List<String> queue = new ArrayList<>();

        try {
            //1. debe persistirlo en una base de datos no relacional (supongamos un mongodb)
            saveUser(newUser);

            try {
                // write file with process
                writeFile(file, "The user has been saved to the database successfully");
            } catch (Exception e) {
                System.out.println(e);
            }

            //2. debe enviar una notifiación por Slack informando la creación de un nuevo usuario a un canal de soporte
            notifyUserCreationToSlackSupportChannel(newUser.getEmail());

            //3. debe publicar un mensaje en una cola para ser tratado por un sistema externo Legacy
            addMessageToQueue(String.format("User %s created", newUser.getEmail()), queue);
            sentQueueToLegacyServer(queue);

          // if the user already exists, the exception is caught
        } catch (UserAlreadyExistsException e) {

            // debe enviar un correo a no-response@exceptionexample.com informando que el usuario ya existe
            sendEmail("no-response@exceptionexample.com", String.format("el usuario %s ya existe", newUser.getEmail() ));

            // write file with process
            writeFile(file, "The user already exists");

            throw new UserAlreadyExistsException("El usuario ya existe");
        }


        return String.format("User %s created successfully", newUser.getEmail());
    }
}
