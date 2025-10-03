package Ian.data;

/**
 * Represents a task inputted by the user. Subclasses consist of Todo, Deadline, Event.
 */
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

    /**
     * Returns a string of the Task
     * @return returns a string that fully lists a task.
     */
    @Override
    public String toString() {
        return this.symbol + "[" + getStatusIcon() + "] " + this.description;
    }

    /**
     * Formats task before saving into data file.
     * @return A formatted string of the task that gets saved into the data file.
     */
    public abstract String toFileFormat();
}