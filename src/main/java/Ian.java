import java.util.Scanner;
import java.util.ArrayList;

public class Ian {
    private static void printSeparator() {
        System.out.println("_________________________________________________________________________________________________");
    }

    public static int delete(String input, ArrayList<Task> tasks, int listSize) throws IanException {
        char lastChar = input.charAt(input.length() - 1);
        int  index = (Integer.parseInt(String.valueOf(lastChar))) - 1;
        if (tasks.get(index) == null) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        Task task_to_delete = tasks.get(index);
        tasks.remove(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task_to_delete.toString());
        System.out.println("Now you have " + (listSize - 1) + " " + (listSize > 1 ? "tasks" : "task") + " in the list.");
        return listSize - 1;
    }

    public static void mark_or_unmark(Boolean toMark, String input, ArrayList<Task> tasks) throws IanException {
        char lastChar = input.charAt(input.length() - 1);
        int  index = (Integer.parseInt(String.valueOf(lastChar))) - 1;
        if (tasks.get(index) == null) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks.get(index).isDone = toMark;
        String output = toMark ? "done" : "not done yet";
        printSeparator();
        System.out.println("Nice! I've marked this task as " + output + ":");
        System.out.println("  [" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).description);
    }

    public static int event(String input, ArrayList<Task> tasks, int listSize) throws IanException {
        input = input.replace("event", "").trim();
        String[] inputParts = input.split("/from |/to");
        if (inputParts.length != 3) {
            throw new IanException("You did not enter a valid event.\nFollow the format: \"event <event description> /from <start date and/or time> /to <emd date and/or time>");
        }
        String symbol = "[E]";
        printSeparator();
        tasks.add(listSize, new Event(inputParts[0], inputParts[1], inputParts[2], symbol));
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(listSize).toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int deadline(String input, ArrayList<Task> tasks, int listSize) throws IanException{
        input = input.replace("deadline", "").trim();
        String[] inputParts = input.split("/by");
        if (inputParts.length != 2) {
            throw new IanException("You did not enter a valid deadline.\nFollow the format \"deadline <task description> /by <deadline date and/or time>\"");
        }
        String symbol = "[D]";
        printSeparator();
        tasks.add(listSize, new Deadline(inputParts[0], inputParts[1], symbol));
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(listSize).toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static int toDo(String input, ArrayList<Task> tasks, int listSize) throws IanException {
        input = input.replace("todo", "").trim();
        if (input.isEmpty()) {
            throw new IanException("You did not enter any tasks.\nFollow the format: \"todo <task description>\"");
        }
        String symbol = "[T]";
        printSeparator();
        tasks.add(listSize, new Todo(input, symbol));
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(listSize).toString());
        System.out.println("Now you have " + (listSize + 1) + " " + (listSize == 0 ? "task" : "tasks") + " in the list.");
        return listSize + 1;
    }

    public static void list(ArrayList<Task> tasks, int listSize) {
        for (int i = 0; i < listSize; i++) {
            if (tasks.get(i) != null) {
                if (i == 0) {
                    printSeparator();
                    System.out.println("Here are the tasks in your list:");
                }
                System.out.println((i + 1)+ ". " + tasks.get(i).toString());
            }
        }
    }

    public static void main(String[] args) {

        printSeparator();
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
        printSeparator();

        int listSize = 0;

        ArrayList<Task> tasks = new ArrayList<>();

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
                }
                String[] words = userInput.split(" ", 2);
                String command = words[0].toLowerCase();

                switch (command) {
                    case "list":
                        list(tasks, listSize);
                        break;
                    case "mark":
                        mark_or_unmark(true, userInput, tasks);
                        break;
                    case "unmark":
                        mark_or_unmark(false, userInput, tasks);
                        break;
                    case "todo":
                        listSize = toDo(userInput, tasks, listSize);
                        break;
                    case "deadline":
                        listSize = deadline(userInput, tasks, listSize);
                        break;
                    case "event":
                        listSize = event(userInput, tasks, listSize);
                        break;
                    case "delete":
                        listSize = delete(userInput, tasks, listSize);
                        break;
                    default:
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
