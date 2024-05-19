package com.sp3.cmdr;

import com.sp3.cmdr.properties.PropertyKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExecutorCommand extends Command {
    @Override
    public Integer call() {
        List<String> command = new ArrayList<>();
        Properties properties = this.getProperties();

        String executableFilePath = properties.getProperty(PropertyKeys.EXECUTABLE_FILE_PATH.key);
        command.add(executableFilePath);

        if (!this.getPositionalParameters().isEmpty()) {
            this.getPositionalParameters().forEach(positionalParameter -> {
                if (positionalParameter.getValue() != null) {
                    command.add(positionalParameter.getValue().toString());
                }
            });
        }

        if (!this.getOptions().isEmpty()) {
            this.getOptions().forEach(option -> {
                if (option.getValue() != null) {
                    command.add(option.getLongName());
                    command.add(option.getValue().toString());
                }
            });
        }

        System.out.println(command);
        return 0;
    }
}
