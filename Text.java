public class Text {
    private String content;

    public Text() {
        this.content = "";
    }

    public Text(String text) {
        this.content = text;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return "\tTEXT: " + this.content;
    }
}