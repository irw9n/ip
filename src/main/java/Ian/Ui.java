package Ian;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() { scanner =  new Scanner(System.in); }

    /**
     * Prints a welcome message at the beginning of every execution.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
    }

    /**
     * Prints a breaking line to demarcate different sections of output.
     */
    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints an exit message once program has been terminated by the user.
     */
    public void showExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints error message to the user.
     * @param message The error message generated.
     */
    public void showError(String message) {
        System.out.println(":( OOPS!!! " + message);
    }

    /**
     * Prints a general acknowledgement to the user once it has successfully parsed a task.
     */
    public void addTaskAcknowledgement() { System.out.println("Got it. I've added this task: "); }

    /**
     * Prints a general message to the user.
     * @param message The message that will be shown to the user.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}