package Ian.data;

public class Deadline extends Task {

    protected String by;

    /**
     * Adds a new Deadline to the list of tasks.
     * @param description Deadline description
     * @param by Deadline day/date AND/OR time
     * @param symbol Deadline symbol to be displayed when listed "[D]"
     */
    public Deadline(String description, String by, String symbol) {
        super(description, symbol);
        this.by = by;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
