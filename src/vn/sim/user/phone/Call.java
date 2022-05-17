//package vn.moblie.views.phone;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Call {
//    public static final int PRICE_CALL_PER_SEC = 500;
//
//    public static void run() throws IOException {
//        String phoneNumber;
//        int sec;
//        long start, end;
//        int secAvailable = MainAccount.mainAccount / PRICE_CALL_PER_SEC;
//
//        Scanner scanner = new Scanner(System.in);
//        if (secAvailable <= 0) {
//            System.out.println("Not enough money to dial call, please deposit more!");
//            vn.moblie.views.menu.MainMenu.selectMainMenu();
//        }
//
//        do {
//            System.out.println("Enter phone number to call: ");
//            //phoneNumber = Interrupt.nextLineBlocking();
//            phoneNumber = scanner.nextLine();
//            if (action.PhoneNumber.isNotPhoneNumber(phoneNumber))
//                System.out.println("Invalid phone number, please re-type");
//        } while (action.PhoneNumber.isNotPhoneNumber(phoneNumber));
//
//        start = System.currentTimeMillis();
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println("*                                     *");
//        System.out.printf("*      CALLING to %s          * \n", phoneNumber);
//        System.out.println("*                                     *");
//        System.out.println("*   Press 'Enter key' to end call     *");
//        System.out.println("*                                     *");
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println();
//
//        Thread thread = new Thread(() -> {
//            do {
//                long now = System.currentTimeMillis();
//                float secFromNow = (now - start) / 1000F;
//                if (secAvailable <= secFromNow) {
//                    //Interrupt.cancel();
//                    System.out.println("Out of money! Ended call!");
//                    break;
//                }
//            } while (true);
//        });
//
//        thread.start();
//
//        while ((System.currentTimeMillis() - start)/1000F < secAvailable) {
//            if (System.in.available() > 0) {
//                try {
//                    System.in.read();
//                }
//                catch (Exception e) {
//
//                }
//                break;
//            }
//        }
//
//        end = System.currentTimeMillis();
//        sec = Math.round((end - start) / 1000F);
//        System.out.println("Called: " + sec + " seconds");
//        MainAccount.mainAccount -= sec * PRICE_CALL_PER_SEC;
//        vn.moblie.views.menu.MainMenu.selectMainMenu();
//    }
//}
