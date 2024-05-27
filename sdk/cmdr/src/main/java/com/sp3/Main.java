package com.sp3;

import com.sp3.cmdr.Command;
import com.sp3.cmdr.ExecutorCommand;
import com.sp3.cmdr.models.PositionalParameter;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setValue("ABC 123456789");

        Command command = new ExecutorCommand();
        command.addPositionalParameter(positionalParameter);

        Properties properties = new Properties();
        properties.setProperty("executableFilePath", "sdk/cmdr/src/test/resources/echo");
        command.setProperties(properties);

        int exitCode = command.call();
        System.exit(exitCode);
    }
}