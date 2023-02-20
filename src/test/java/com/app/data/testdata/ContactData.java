package com.app.data.testdata;

import com.app.data.enums.PhoneFormat;
import com.app.models.Contact;

import java.util.List;
import java.util.stream.Collectors;

import static com.app.utils.CommonUtils.*;

public class ContactData {
    static String mobile = generatePhoneNumber(PhoneFormat.SIMPLE);
    static String home = generatePhoneNumber(PhoneFormat.WITH_DASHES);
    static String work = generatePhoneNumber(PhoneFormat.WITH_BRACKETS);

    public static Contact getContactData() {
        return new Contact().firstName(String.format("User_%s", randomAlphanumericStr(5)))
                .lastName("Test")
                .nickName(String.format("r_test_%s", randomAlphanumericStr(5)))
                .company(String.format("Test Company %s", randomAlphanumericStr(5)))
                .homePhone(home).mobilePhone(mobile).workPhone(work)
                .email(randomEmail())
                .allPhones(mergePhones(List.of(home, mobile, work)));
    }

    private static String mergePhones(List<String> phones) {
        return phones.stream().filter(s -> !s.equals(""))
                .map(ContactData::customize)
                .collect(Collectors.joining("\n"));
    }

    private static String customize(String phoneNumber) {
        return phoneNumber.replaceAll("\\s|[-()]", "");

    }
}
