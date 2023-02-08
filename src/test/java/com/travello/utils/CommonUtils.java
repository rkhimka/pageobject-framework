package com.travello.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

    public static String generateEmail() {
        return String.format("test_%s@maildrop.cc", generateRandomAlphanumericStr(10));
    }

    public static String generatePhoneNumber() {
        return String.format("+38067%s", generateRandomNumericStr(7));
    }

    public static String generateGroupName() {
        return String.format("Group_%s", generateRandomAlphanumericStr(10));
    }

    public static String generateRandomAlphanumericStr(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateRandomNumericStr(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
