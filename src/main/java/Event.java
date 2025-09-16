public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to, String symbol) {
        super(description, symbol);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + from + "to: " + to + ")";
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}