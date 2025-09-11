import java.util.Scanner;

public class Ian {
    private static void printSeparator() {
        System.out.println("_________________________________________________________________________________________________");
    }

    public static void mark_or_unmark(Boolean toMark, String input, Task[] tasks) throws IanException {
        char lastChar = input.charAt(input.length() - 1);
        int  index = (Integer.parseInt(String.valueOf(lastChar))) - 1;
        if (tasks[index] == null) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks[index].isDone = toMark;
        String output = toMark ? "done" : "not done yet";
        printSeparator();
        System.out.println("Nice! I've marked this task as " + output + ":");
        System.out.println("  [" + tasks[index].getStatusIcon() + "] " + tasks[index].description);
    }

    public static int event(String input, Task[] tasks, int listSize) throws IanException {
        input = input.replace("event", "").trim();
        String[] inputParts = input.split("/from |/to");
        if (inputParts.length != 3) {
            throw new IanException("You did not enter a valid event.\nFollow the format: \"event <event description> /from <start date and/or time> /to <emd date and/or time>");
        }
        String symbol = "[E]";
        printSeparator();
        tasks[listSize] = new Event(inputParts[0], inputParts[1], inputParts[2], symbol);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[listSize].toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int deadline(String input, Task[] tasks, int listSize) throws IanException{
        input = input.replace("deadline", "").trim();
        String[] inputParts = input.split("/by");
        if (inputParts.length != 2) {
            throw new IanException("You did not enter a valid deadline.\nFollow the format \"deadline <task description> /by <deadline date and/or time>\"");
        }
        String symbol = "[D]";
        printSeparator();
        tasks[listSize] = new Deadline(inputParts[0], inputParts[1], symbol);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[listSize].toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int toDo(String input, Task[] tasks, int listSize) throws IanException {
        input = input.replace("todo", "").trim();
        if (input.isEmpty()) {
            throw new IanException("You did not enter any tasks.\nFollow the format: \"todo <task description>\"");
        }
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
            try {
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
                } else if (userInput.contains("todo")) {
                    listSize = toDo(userInput, tasks, listSize);
                } else if (userInput.contains("event")) {
                    listSize = event(userInput, tasks, listSize);
                } else {
                    throw new IanException("I'm sorry, but I don't know what you are typing. Please try again!");
                }
            } catch (IanException e) {
                System.out.println(":( OOPS!!! " + e.getMessage());
            } finally {
                printSeparator();
            }
        } while (true);

        scanner.close();

    }
}
