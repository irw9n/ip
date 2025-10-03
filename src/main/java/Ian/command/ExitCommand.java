package Ian.command;

import Ian.Storage;
import Ian.Ui;
import Ian.data.TaskList;
import Ian.exception.IanException;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("bye");
    }

    @Override
    public void execute(TaskList tasks,
                        Storage storage,
                        Ui ui) throws IanException {
        ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }

}