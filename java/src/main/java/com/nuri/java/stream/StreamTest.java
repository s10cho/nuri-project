package com.nuri.java.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getNameStream()
            .forEach(StreamTest::process);
        System.out.println(String.format("elapsed time %s(ms)", System.currentTimeMillis() - start));
    }

    public static void process(String name) {
        try {
            Thread.sleep(1000);
            System.out.println(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<String> getNameStream() {
        List<String> nameList = getNameList();
        return nameList.size() > 5
            ? nameList.parallelStream()
            : nameList.stream();
    }

    private static List<String> getNameList() {
        return List.of(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F"
        );
    }
}
