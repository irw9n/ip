package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

public class ListTasksCommand extends Command {
    public ListTasksCommand() {super("list");}

    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException {
        tasks.listTasks();
    }
}