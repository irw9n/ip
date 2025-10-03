package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        super("event");
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the addition of a Deadline task.
     * @param tasks ArrayList of tasks to add to.
     * @param storage Filesystem to save the new list of tasks into.
     * @param ui UI for execution.
     * @throws IanException in case of errors.
     * @throws IOException in case of errors.
     */
    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        ui.showLine();
        tasks.addDeadline(description, by);
        ui.addTaskAcknowledgement();
        ui.showMessage(tasks.listAddedTask());
        System.out.println("Now you have " + tasks.getTaskListLength() + " " + (tasks.getTaskListLength() == 1 ? "task" : "tasks") + " in the list.");
        Storage.saveTasks(tasks.fetchTasks());
    }
}