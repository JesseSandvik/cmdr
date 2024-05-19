package com.sp3.filesystem.file;

import java.io.File;

public class FileValidator {
    private static final System.Logger LOGGER = System.getLogger(FileValidator.class.getName());

    public Boolean fileCanExecute(String file) {
        if (file == null) {
            LOGGER.log(System.Logger.Level.TRACE, "provided file path is null for executable file validation");
            return false;
        }

        File potentialExecutableFile = new File(file);
        LOGGER.log(System.Logger.Level.TRACE, "validating file can execute: " + file);
        return potentialExecutableFile.canExecute() && potentialExecutableFile.isFile();
    }

    public Boolean fileExists(String file) {
        if (file == null) {
            LOGGER.log(System.Logger.Level.TRACE, "provided file path is null for file exists validation");
            return false;
        }

        LOGGER.log(System.Logger.Level.TRACE, "validating file exists: " + file);
        return new File(file).isFile();
    }
}
