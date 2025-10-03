package Ian;

import java.io.FileNotFoundException;
import java.io.IOException;
import Ian.command.Command;
import Ian.data.TaskList;
import Ian.exception.IanException;


public class Ian {

    private Storage storage;
    private static TaskList tasks;
    private Ui ui;

    public Ian(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(Storage.loadTasks());
        } catch (FileNotFoundException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showLine();
        ui.showWelcome();
        boolean isExit = false;
        ui.showLine();

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, storage, ui);
                isExit = c.isExit();
            } catch (IanException | IOException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {

        new Ian("data/tasks.txt").run();
    }
}
