package Ian;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() { scanner =  new Scanner(System.in); }

    public void showWelcome() {
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showError(String message) {
        System.out.println(":( OOPS!!! " + message);
    }

    public void addTaskAcknowledgement() { System.out.println("Got it. I've added this task: "); }

    public void showMessage(String message) {
        System.out.println(message);
    }
}