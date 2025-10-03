package Ian.data;

public class Deadline extends Task {

    protected String by;

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
