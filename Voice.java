public class Voice {
    private int duration;
    private String format;

    public Voice() {
        this.duration = 0;
        this.format = "";
    }

    public Voice(int duration, String format) {
        this.duration = duration;
        this.format = format;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public String toString() {
        return new String("\tVOICE: Duration: " + this.duration
            + " (sec), Format: " + this.format);
    }
}