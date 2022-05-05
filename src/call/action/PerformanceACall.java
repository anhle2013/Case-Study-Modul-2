package call.action;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class PerformanceACall {
    public static void main(String[] args) {
        String phoneNumber;

        do {
            System.out.println("Enter phone number to call: ");
            Scanner scanner = new Scanner(System.in);
            phoneNumber = scanner.nextLine();
            if (!checkPhoneNumber(phoneNumber))
                System.out.println("Invalid phone number, please re-type");
        } while (checkPhoneNumber(phoneNumber));
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i <5; i++) {
//            Thread.sleep(60);
//        }
//        // finding the time after the operation is executed
//        long end = System.currentTimeMillis();
//        //finding the time difference and converting it into seconds
//        float sec = (end - start) / 1000F; System.out.println(sec + " seconds");

        System.out.println("Calling");
        menu.CallCenterMenu.selectCallCenter();
    }
    public static boolean checkPhoneNumber(String string) {
        if (string.length() != 10)
            return false;
        else if (string.charAt(0) != 0)
            return false;
        else if (checkAllNumber(string))
            return true;
        else
            return false;
    }
    public static boolean checkAllNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            Boolean flag = Character.isDigit(string.charAt(i));
            if (!flag)
                return false;
        }
        return true;
    }
    public static void run(){}
}
