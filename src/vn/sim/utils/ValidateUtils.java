package vn.sim.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String SERIAL_REGEX = "(\\d{3}.){3}\\d{3}";
    public static final String PHONE_NUMBER_REGEX = "0\\d{9}";
    public static final String PASSWORD_REGEX = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}";
    public static final String PERSON_ID_REGEX = "\\d{9}(\\d{3}){0,1}";
    public static final String NAME_REGEX = "([A-Z][a-z]{0,7} ){0,}[A-Z][a-z]{0,7}";
    public static final String EMAIL_REGEX = "([0-9a-z]{1,20}.){0,1}[0-9a-z]{1,20}@(\\w{1,5}\\.){1,2}\\w{1,3}";

    public static boolean isSerialValid(String serial) {
        return Pattern.compile(SERIAL_REGEX).matcher(serial).matches();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return Pattern.compile(PHONE_NUMBER_REGEX).matcher(phoneNumber).matches();
    }


    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isPersonIdValid(String personId) {
        return Pattern.compile(PERSON_ID_REGEX).matcher(personId).matches();
    }

    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

}
