package Ian.command;
import Ian.data.TaskList;
import Ian.Ui;
import Ian.Storage;
import Ian.exception.IanException;

import java.io.IOException;

public class FindCommand extends Command {
    private String query;

    public FindCommand(String query) {
        super("find");
        this.query = query;
    }

    /**
     * Executes the search of tasks that contain the query
     * @param tasks List of tasks to search from
     * @param storage Storage
     * @param ui UI
     * @throws IanException Error handling.
     * @throws IOException Error handling.
     */
    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException, IOException {
        if (tasks.findTasks(query).isEmpty()) {
            ui.showMessage("Sorry, there were no matching tasks found.");
        } else {
            ui.showMessage("Here are the matching tasks in your list:");
            tasks.listFoundTasks(tasks.findTasks(query));
        }
    }
}