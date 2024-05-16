package com.epam.training.student_oleksandra_kyrylchuk.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle
            .getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}