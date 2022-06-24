package com.santander.EjercicioExcepciones.Utils;

import com.santander.EjercicioExcepciones.exceptions.FilesExceptions.*;

import java.io.File;

public class FileUtil {

    public static boolean writeFile(String file, String message) {

        // file is not open
        if (!checkFileIsOpen(file)) {
            throw new FileNotOpenException("The file is not open");
        }

        // file is read mode only
        if (checkFileIsReadOnly(file)) {
            throw new FileIsOnReadOnlyModeException("The file is on read-only mode. It cannot be written");
        }

        // write permissions not granted
        if (!checkFilePermissions(file)) {
            throw new WritingPermissionsDeniedException("You don't have write permissions for this file");
        }

        // here the file should be written with the message
            // *~magic~* //

        return true;
    }

    public static String openFile(String path) {

        if (!checkFileExists(path)) {
            throw new FileNotFoundException("File not found, try with a different path");
        }

        if (checkFileIsOpen(path)) {
            throw new FileAlreadyOpenException("The File has already been opened");
        }

        if (!checkFileLoadedCorrectly(path)) {
            throw new FileCouldNotBeLoadedException("File could not be loaded correctly");
        }

        // here the opened file should be returned
        return "this should be a file";
    }

    public static boolean checkFileIsOpen(String path) {
        return false;
    }

    public static boolean checkFileLoadedCorrectly(String path) {
        return true;
    }

    public static boolean checkFileExists(String path) {
        return true;
    }

    public static boolean checkFileIsReadOnly(String file) {
        return false;
    }

    public static boolean checkFilePermissions(String file) {
        return true;
    }
}
