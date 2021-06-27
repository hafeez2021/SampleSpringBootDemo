package com.dp.demo.utils;

import java.io.File;
import java.util.StringJoiner;

public class TestResources {
    public final static String getFilePath(final String dirName) {
        return new StringJoiner(File.separator)
                .add(System.getProperty("user.dir"))
                .add("src")
                .add("test")
                .add("resources")
                .add(dirName)
                .toString();
    }
}
