package call.action;

import java.util.ArrayList;
import java.util.Scanner;

public class DepositMainAccount {
    static ArrayList<String> card1 = new ArrayList<>();
    static ArrayList<String> card2 = new ArrayList<>();
    static ArrayList<String> card5 = new ArrayList<>();
    static ArrayList<String> card10 = new ArrayList<>();
    static {
        card1.add("010X2022X123456");
        card1.add("010X2022X123455");
        card1.add("010X2022X123454");
        card1.add("010X2022X123453");
        card1.add("010X2022X123452");
        card1.add("010X2022X123451");

        card2.add("020X2022X123456");
        card2.add("020X2022X123455");
        card2.add("020X2022X123454");
        card2.add("020X2022X123453");
        card2.add("020X2022X123452");
        card2.add("020X2022X123451");

        card5.add("050X2022X123456");
        card5.add("050X2022X123455");
        card5.add("050X2022X123454");
        card5.add("050X2022X123453");
        card5.add("050X2022X123452");
        card5.add("050X2022X123451");

        card10.add("100X2022X123456");
        card10.add("100X2022X123455");
        card10.add("100X2022X123454");
        card10.add("100X2022X123453");
        card10.add("100X2022X123452");
        card10.add("100X2022X123451");
    }

    public static String checkCard(String str) {
        for (int i = 0; i < card1.size(); i++) {
            if (card1.get(i).equals(str)) {
                card1.remove(i);
                MainAccount.mainAccount += 1;
                System.out.println("Main accout: " + MainAccount.mainAccount);
                return "Congratulation, you just added $1 into your main account";
            }
        }
        for (int i = 0; i < card2.size(); i++) {
            if (card2.get(i).equals(str)) {
                card2.remove(i);
                MainAccount.mainAccount += 2;
                System.out.println("Main accout: " + MainAccount.mainAccount);
                return "Congratulation, you just added $2 into your main account";
            }
        }
        for (int i = 0; i < card5.size(); i++) {
            if (card5.get(i).equals(str)) {
                card5.remove(i);
                MainAccount.mainAccount += 5;
                System.out.println("Main accout: " + MainAccount.mainAccount);
                return "Congratulation, you just added $5 into your main account";
            }
        }
        for (int i = 0; i < card10.size(); i++) {
            if (card10.get(i).equals(str)) {
                card10.remove(i);
                MainAccount.mainAccount += 10;
                System.out.println("Main accout: " + MainAccount.mainAccount);
                return "Congratulation, you just added $10 into your main account";
            }
        }
        return "Code does not exist or used!";
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code: ");
        String str = sc.nextLine();

        System.out.println(checkCard(str));
        menu.CallCenterMenu.selectCallCenter();
    }
}
