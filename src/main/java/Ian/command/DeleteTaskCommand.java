package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class  DeleteTaskCommand extends Command
{
    private int index;

    public DeleteTaskCommand(int index) {
        super("delete");
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        ui.showMessage("  " + tasks.deleteTask(index).toString());
        ui.showMessage("Noted. I've removed this task:");
        ui.showMessage("Now you have " + tasks.getTaskListLength() + " " + (tasks.getTaskListLength() == 1 ? "task" : "tasks") + " in the list.");
        Storage.saveTasks(tasks.fetchTasks());
    }
}