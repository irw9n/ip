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

    public static int event(String input, Task[] tasks, int listSize) {
        String[] inputParts = input.split("/from|/to");
        String symbol = "[E]";
        printSeparator();
        tasks[listSize] = new Event(inputParts[0], inputParts[1], inputParts[2], symbol);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[listSize].toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int deadline(String input, Task[] tasks, int listSize) {
        String[] inputParts = input.split("/by");
        String symbol = "[D]";
        printSeparator();
        tasks[listSize] = new Deadline(inputParts[0], inputParts[1], symbol);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[listSize].toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int toDo(String input, Task[] tasks, int listSize) {
        String symbol = "[T]";
        printSeparator();
        tasks[listSize] = new Todo(input, symbol);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[listSize].toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static void list(Task[] tasks, int listSize) {
        for (int i = 0; i < listSize; i++) {
            if (tasks[i] != null) {
                if (i == 0) {
                    printSeparator();
                    System.out.println("Here are the tasks in your list:");
                }
                System.out.println((i + 1)+ ". " + tasks[i].toString());
            }
        }
        if (listSize > 0) {
            printSeparator();
        }
    }

    public static void main(String[] args) {

        printSeparator();
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
        printSeparator();

        int listSize = 0;

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
                list(tasks, listSize);
            } else if (userInput.contains("mark")) {
                mark_or_unmark(!userInput.contains("unmark"), userInput, tasks);
            } else if (userInput.contains("deadline")) {
                listSize = deadline(userInput, tasks, listSize);
            } else if  (userInput.contains("todo")) {
                listSize = toDo(userInput, tasks, listSize);
            } else if (userInput.contains("event")) {
                listSize = event(userInput, tasks, listSize);
            }
        } while (true);

        scanner.close();

    }
}
