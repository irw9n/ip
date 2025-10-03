package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

public class ListTasksCommand extends Command {
    public ListTasksCommand() {super("list");}

    /**
     * Executes the listing of all current tasks.
     * @param tasks Current list of tasks.
     * @param storage Storage
     * @param ui UI
     * @throws IanException Error Handling.
     */
    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException {
        tasks.listTasks();
    }
}