package Ian.command;
import Ian.data.TaskList;
import Ian.Storage;
import Ian.Ui;
import Ian.exception.IanException;

import java.io.IOException;

public class Command {
    protected String commandWord;

    public Command(String commandWord) {
        this.commandWord = commandWord;
    }

    public void execute(TaskList tasks,
                                 Storage storage,
                                 Ui ui) throws IanException, IOException {}

    public boolean isExit() {return false;}
}