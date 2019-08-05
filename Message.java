public class Message<T> extends Item {
    private T obj;  // can be Text, Voice, or Media object

    public Message() {
        super();
        this.obj = null;
    }

    public Message(int time, String from, String to, double charge, T obj) {
        super(time, from, to, charge);
        this.obj = obj;
    }

    public void setMessage(T obj) {
        this.obj = obj;
    }

    public T getMessage() {
        return this.obj;
    }

    public String toString() {
        return this.obj.toString() + super.toString();
    }
}