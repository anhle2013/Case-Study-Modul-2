package call.action;

public class PromotionAccount {
    static int promotionMinute;
    static int promotionSMS;
    static int promotionData;

    public static void run() {
        System.out.println("Promotion Account:" +
                "\n Promotion Minute: " + promotionMinute +
                "\n Promotion SMS: " + promotionSMS +
                "\n Promotion Data: " + promotionData );
        menu.CallCenterMenu.selectCallCenter();
    }
}
