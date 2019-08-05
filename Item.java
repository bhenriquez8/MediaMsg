public class Item {
    private int time;
    private String from;
    private String to;
    private double charge;

    public Item() {
        this.time = 0;
        this.from = "";
        this.to = "";
        this.charge = 0.0;
    }

    public Item(int time, String from, String to, double charge) {
        this.time = time;
        this.from = from;
        this.to = to;
        this.charge = charge;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getCharge() {
        return charge;
    }

    public String toString() {
        return "\tTime: " + this.time + ", From: "+ this.from +
        ", To: " + this.to;
    }
}