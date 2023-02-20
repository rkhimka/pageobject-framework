package com.app.utils;

import com.app.data.enums.PhoneFormat;
import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

    public static String randomEmail() {
        return String.format("test_%s@maildrop.cc", randomAlphanumericStr(10));
    }

    public static String generatePhoneNumber(PhoneFormat format) {
        String number = null;
        switch (format) {
            case SIMPLE:
                number = String.format("+38067%s", randomNumericStr(7));
                break;
            case WITH_DASHES:
                number = String.format("38067-%s-%s-%s", randomNumericStr(3),
                        randomNumericStr(2), randomNumericStr(2));
                break;
            case WITH_BRACKETS:
                number = String.format("380(67) %s %s %s", randomNumericStr(3),
                        randomNumericStr(2), randomNumericStr(2));
                break;
        }
        return number;
    }

    public static String randomAlphanumericStr(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String randomNumericStr(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
