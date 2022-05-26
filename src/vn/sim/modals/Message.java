package vn.sim.modals;

import java.time.Instant;

public class Message {
    private String fromPhone;
    private String toPhone;
    private Instant time;
    private String text;

    public Message(Instant time, String text) {
        this.time = time;
        this.text = text;
    }

    public Message(String fromPhone, String toPhone, Instant time, String text) {
        this.fromPhone = fromPhone;
        this.toPhone = toPhone;
        this.time = time;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Instant getTime() {
        return time;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public void setTime(Instant time) {
        this.time = time;
    }


}
