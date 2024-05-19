package com.sp3.filesystem.file;

import java.io.*;
import java.util.List;

public class FileExecutor {
    private static final System.Logger LOGGER = System.getLogger(FileExecutor.class.getName());
    private PrintStream printStream = System.out;

    public PrintStream getPrintStream() {
        return printStream;
    }

    public void setPrintStream(PrintStream printStream) {
        LOGGER.log(System.Logger.Level.TRACE, "original file system executor print stream: " + getPrintStream());
        this.printStream = printStream;
        LOGGER.log(System.Logger.Level.TRACE, "updated file system executor print stream: " + printStream);
    }

    public Integer executeCommand(List<String> command) {
        try {
            LOGGER.log(System.Logger.Level.TRACE, "executing command: " + command);

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(command);

            LOGGER.log(System.Logger.Level.TRACE, "initializing command execution process");
            Process process = processBuilder.start();

            LOGGER.log(System.Logger.Level.TRACE, "extracting input stream from command execution process");
            InputStream inputStream = process.getInputStream();

            LOGGER.log(System.Logger.Level.TRACE, "reading input stream from command execution process");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            LOGGER.log(System.Logger.Level.TRACE, "preparing to print input stream from command execution to print stream");
            while ((line = bufferedReader.readLine()) != null) {
                LOGGER.log(System.Logger.Level.TRACE, "printing input stream line from command execution to print stream");
                printStream.println(line);
            }

            LOGGER.log(System.Logger.Level.TRACE, "waiting for command execution process to terminate");
            process.waitFor();
            LOGGER.log(System.Logger.Level.TRACE, "command execution process terminated, returning exit code");
            LOGGER.log(System.Logger.Level.TRACE, "executed command: "  + command + " resulted in exit code: " + process.exitValue());
            return process.exitValue();

        } catch (RuntimeException | InterruptedException | IOException e) {
            LOGGER.log(System.Logger.Level.ERROR, "an exception occurred while executing command: " + command);
            LOGGER.log(System.Logger.Level.ERROR, e);
            throw new RuntimeException(e);
        }
    }
}
