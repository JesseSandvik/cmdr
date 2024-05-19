package com.sp3;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command
public class Email implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("HELLO WORLD");
        return 0;
    }
}
