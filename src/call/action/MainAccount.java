package call.action;

public class MainAccount {
    static int mainAccount;
    public static void run() {
        System.out.println("Main Account: " + mainAccount);
        menu.CallCenterMenu.selectCallCenter();
    }
}
