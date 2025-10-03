package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class UnmarkTaskCommand extends Command {
    private int index;

    public UnmarkTaskCommand(int index)
    {
        super("mark");
        this.index = index;
    }

    /**
     * Executes the unmarking of a task
     * @param tasks Current ArrayList of tasks.
     * @param storage Storage
     * @param ui UI
     * @throws IanException Error Handling
     * @throws IOException Error Handling
     */
    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        tasks.unmarkTask(index);
        ui.showMessage("Nice! I've marked this task as undone:");
        ui.showMessage(tasks.listSpecificTask(index));
        Storage.saveTasks(tasks.fetchTasks());
    }
}