//package vn.moblie.views.phone;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class DepositMainAccount {
//    public static final int VALUE_OF_CARD10 = 10000;
//    public static final int VALUE_OF_CARD20 = 20000;
//    public static final int VALUE_OF_CARD50 = 50000;
//    public static final int VALUE_OF_CARD100 = 100000;
//    static ArrayList<String> card10 = new ArrayList<>();
//    static ArrayList<String> card20 = new ArrayList<>();
//    static ArrayList<String> card50 = new ArrayList<>();
//    static ArrayList<String> card100 = new ArrayList<>();
//    static {
//        card10.add("010X2022X123456");
//        card10.add("010X2022X123455");
//        card10.add("010X2022X123454");
//        card10.add("010X2022X123453");
//        card10.add("010X2022X123452");
//        card10.add("010X2022X123451");
//
//        card20.add("020X2022X123456");
//        card20.add("020X2022X123455");
//        card20.add("020X2022X123454");
//        card20.add("020X2022X123453");
//        card20.add("020X2022X123452");
//        card20.add("020X2022X123451");
//
//        card50.add("050X2022X123456");
//        card50.add("050X2022X123455");
//        card50.add("050X2022X123454");
//        card50.add("050X2022X123453");
//        card50.add("050X2022X123452");
//        card50.add("050X2022X123451");
//
//        card100.add("100X2022X123456");
//        card100.add("100X2022X123455");
//        card100.add("100X2022X123454");
//        card100.add("100X2022X123453");
//        card100.add("100X2022X123452");
//        card100.add("100X2022X123451");
//    }
//
//    public static String checkCard(String str) {
//        for (int i = 0; i < card10.size(); i++) {
//            if (card10.get(i).equals(str)) {
//                card10.remove(i);
//                MainAccount.mainAccount += VALUE_OF_CARD10;
//                return "Congratulation, you just added 10,000 đ into your main account" +
//                        "\nvn.moblie.Main account: " + MainAccount.mainAccount;
//            }
//        }
//        for (int i = 0; i < card20.size(); i++) {
//            if (card20.get(i).equals(str)) {
//                card20.remove(i);
//                MainAccount.mainAccount += VALUE_OF_CARD20;
//                return "Congratulation, you just added 20,000 đ into your main account" +
//                        "\nvn.moblie.Main account: " + MainAccount.mainAccount;
//            }
//        }
//        for (int i = 0; i < card50.size(); i++) {
//            if (card50.get(i).equals(str)) {
//                card50.remove(i);
//                MainAccount.mainAccount += VALUE_OF_CARD50;
//                return "Congratulation, you just added 50,000 đ into your main account" +
//                        "\nvn.moblie.Main account: " + MainAccount.mainAccount;
//            }
//        }
//        for (int i = 0; i < card100.size(); i++) {
//            if (card100.get(i).equals(str)) {
//                card100.remove(i);
//                MainAccount.mainAccount += VALUE_OF_CARD100;
//                return "Congratulation, you just added 100,000 đ into your main account" +
//                        "\nvn.moblie.Main account: " + MainAccount.mainAccount;
//            }
//        }
//        return "Code does not exist or used!";
//    }
//
//    public static void run() throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter code: ");
//        String str = sc.nextLine();
//
//        System.out.println(checkCard(str));
//        vn.moblie.views.menu.CallCenterMenu.selectCallCenter();
//    }
//}
