package Ian.data;

public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Adds a new Event to the list of tasks.
     * @param description Event description
     * @param from Event start time
     * @param to Event end time
     * @param symbol Event symbol to be displayed when listed "[E]"
     */
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