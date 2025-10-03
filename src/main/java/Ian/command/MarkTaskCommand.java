package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class MarkTaskCommand extends Command {
    private int index;

    public MarkTaskCommand(int index)
    {
        super("mark");
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        tasks.markTask(index);
        ui.showMessage("Nice! I've marked this task as done:");
        ui.showMessage(tasks.listSpecificTask(index));
        Storage.saveTasks(tasks.fetchTasks());
    }
}