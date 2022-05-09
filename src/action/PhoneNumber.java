package action;

public class PhoneNumber {
    public static final int COMPARE_CHAR_WITH_0 = 48;
    public static final int SIZE_OF_PHONE_NUMBER = 10;

    public static boolean isNotPhoneNumber(String string) {
        if (string.length() != SIZE_OF_PHONE_NUMBER)
            return true;
        else if (string.charAt(0) != COMPARE_CHAR_WITH_0)
            return true;
        else return !checkAllNumber(string);
    }

    public static boolean checkAllNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            boolean flag = Character.isDigit(string.charAt(i));
            if (!flag)
                return false;
        }
        return true;
    }
}
