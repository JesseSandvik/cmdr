package com.sp3.filesystem.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DefaultFileHandler implements IFileHandler {

    @Override
    public Object getFileContent(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
