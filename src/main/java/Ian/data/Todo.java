package Ian.data;

public class Todo extends Task {

    public Todo(String description, String symbol) {
        super(description, symbol);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}