import java.util.Scanner;

public class Ian {
    private static void printSeparator() {
        System.out.println("____________________________________________________________");
    }

    public static void mark_or_unmark(Boolean toMark, String input, Task[] tasks) {
        char lastChar = input.charAt(input.length() - 1);
        int  index = (Integer.parseInt(String.valueOf(lastChar))) - 1;
        tasks[index].isDone = toMark;

        String output = toMark ? "done" : "not done yet";
        printSeparator();
        System.out.println("Nice! I've marked this task as " + output + ":");
        System.out.println("  [" + tasks[index].getStatusIcon() + "] " + tasks[index].description);
        printSeparator();
    }

    public static void add(String input, Task[] tasks) {
        printSeparator();
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = new Task(input);
                break;
            }
        }
        System.out.println("added: " + input);
        printSeparator();
    }

    public static void list(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                if (i == 0) {
                    printSeparator();
                    System.out.println("Here are the tasks in your list:");
                }
                System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
            } else {
                if (i != 0) {
                    printSeparator();
                }
                break;
            }
        }
    }

    public static void main(String[] args) {

        printSeparator();
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
        printSeparator();

        Task[] tasks = new Task[100];

        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            userInput = scanner.nextLine();

            if (userInput.equals("bye")) {
                printSeparator();
                System.out.println("Bye. Hope to see you again soon!");
                printSeparator();
                break;
            } else if (userInput.equals("list")) {
                list(tasks);

            } else if (userInput.contains("mark")) {
                 mark_or_unmark(!userInput.contains("unmark"), userInput, tasks);
            } else {
                add(userInput, tasks);
            }
        } while (true);

        scanner.close();

    }
}
