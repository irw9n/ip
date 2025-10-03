package Ian.data;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String symbol;

    public Task(String description,  String symbol) {
        this.description = description;
        this.isDone = false;
        this.symbol = symbol;
    }

    public void mark() {
        this.isDone = true;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    @Override
    public String toString() {
        return this.symbol + "[" + getStatusIcon() + "] " + this.description;
    }

    public abstract String toFileFormat();
}