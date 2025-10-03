package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String description, String from, String to) {
        super("event");
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        tasks.addEvent(description, from, to);
        ui.addTaskAcknowledgement();
        ui.showMessage(tasks.listAddedTask());
        System.out.println("Now you have " + tasks.getTaskListLength() + " " + (tasks.getTaskListLength() == 1 ? "task" : "tasks") + " in the list.");
        Storage.saveTasks(tasks.fetchTasks());
    }
}