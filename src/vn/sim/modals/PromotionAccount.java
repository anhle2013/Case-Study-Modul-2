package vn.sim.modals;

public class PromotionAccount {
    int promotionMinute = 0;
    int promotionSMS = 0;
    int promotionData = 0;
    public PromotionAccount() {}

    public int getPromotionData() {
        return promotionData;
    }

    public int getPromotionMinute() {
        return promotionMinute;
    }

    public int getPromotionSMS() {
        return promotionSMS;
    }

    public void setPromotionData(int promotionData) {
        this.promotionData = promotionData;
    }

    public void setPromotionMinute(int promotionMinute) {
        this.promotionMinute = promotionMinute;
    }

    public void setPromotionSMS(int promotionSMS) {
        this.promotionSMS = promotionSMS;
    }

    @Override
    public String toString() {
        return "Promotion Account:" +
                "\n Promotion Minute: " + getPromotionMinute() +
                "\n Promotion SMS: " + getPromotionSMS() +
                "\n Promotion Data: " + getPromotionData();
    }
}
