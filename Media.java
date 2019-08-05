public class Media {
    private double size;
    private String format;

    public Media() {
        this.size = 0;
        this.format = "";
    }

    public Media(double size, String format) {
        this.size = size;
        this.format = format;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public String toString() {
        return new String("\tMEDIA: Size: " + this.size
            + " MB, Format: " + this.format);
    }
}