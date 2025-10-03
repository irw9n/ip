package Ian;

import Ian.command.Command;
import Ian.command.MarkTaskCommand;
import Ian.command.UnmarkTaskCommand;
import Ian.command.ToDoCommand;
import Ian.command.DeadlineCommand;
import Ian.command.DeleteTaskCommand;
import Ian.command.ListTasksCommand;
import Ian.command.EventCommand;
import Ian.command.ExitCommand;
import Ian.command.FindCommand;
import Ian.exception.IanException;


public class Parser {
    public static Command parse(String userInput) throws IanException {

        String command = userInput.trim().split(" ")[0];
        String arguments = "";

        if (userInput.split(" ").length > 1) {
            arguments = userInput.trim().split(" ", 2)[1];
        }

        return switch (command) {
            case "list" -> new ListTasksCommand();
            case "mark" -> parseMarkTaskCommand(arguments);
            case "unmark" -> parseUnmarkTaskCommand(arguments);
            case "todo" -> parseToDoCommand(arguments);
            case "deadline" -> parseDeadlineCommand(arguments);
            case "event" -> parseEventCommand(arguments);
            case "find" -> new FindCommand(arguments);
            case "delete" -> parseDeleteCommand(arguments);
            case "bye" -> new ExitCommand();
            default -> throw new IanException("I'm sorry, but I don't know what you are typing. Please try again!");
        };
    }

    private static Command parseMarkTaskCommand(String arguments) throws IanException {
        if (arguments.isEmpty()) {
            throw new IanException("Invalid mark task format. " +
                    "Please try again with the proper format:" +
                    "\n\"mark <task number>\"");
        }
        for (int i = 0; i < arguments.length(); i++) {
            if (!Character.isDigit(arguments.charAt(i))) {
                throw new IanException("Invalid mark task format. " +
                        "Please try again with the proper format:" +
                        "\n\"mark <task number>\"");
            }
        }

        int index = (Integer.parseInt(arguments)) - 1;
        return new MarkTaskCommand(index);

    }

    private static Command parseUnmarkTaskCommand(String arguments) throws IanException {
        if (arguments.isEmpty()) {
            throw new IanException("Invalid unmark task format. " +
                    "Please try again with the proper format:" +
                    "\n\"unmark <task number>\"");
        }
        for (int i = 0; i < arguments.length(); i++) {
            if (!Character.isDigit(arguments.charAt(i))) {
                throw new IanException("Invalid unmark task format. " +
                        "Please try again with the proper format:" +
                        "\n\"unmark <task number>\"");
            }
        }

        int index = (Integer.parseInt(arguments)) - 1;
        return new UnmarkTaskCommand(index);
    }

    private static Command parseToDoCommand(String arguments) throws IanException {
        if (arguments.isEmpty()) {
            throw new IanException("You did not enter any tasks.\nFollow the proper format: \"todo <task description>\"");
        }
        return new ToDoCommand(arguments);
    }

    private static Command parseDeadlineCommand(String arguments) throws IanException {
        String[] argumentsArray = arguments.split("/by");

        if (argumentsArray.length != 2) {
            throw new IanException("You did not enter a valid deadline." +
                    "\nFollow the format \"deadline " +
                    "<task description> /by <deadline date and/or time>\"");
        }
        String description = argumentsArray[0];
        String deadline = argumentsArray[1];
        return new DeadlineCommand(description, deadline);
    }

    private static Command parseEventCommand(String arguments) throws IanException {
        String[] argumentsArray = arguments.split("/from |/to");
        if (argumentsArray.length != 3) {
            throw new IanException("You did not enter a valid event.\nFollow the format: " +
                    "\"event <event description> /from <start date and/or time> " +
                    "/to <emd date and/or time>");
        }

        String description = argumentsArray[0];
        String from = argumentsArray[1];
        String to = argumentsArray[2];

        return new EventCommand(description, from, to);
    }

    private static Command parseDeleteCommand(String arguments) throws IanException {
        if (arguments.isEmpty()) {
            throw new IanException("Invalid delete task format. " +
                    "Please try again with the proper format:" +
                    "\n\"delete <task number>\"");
        }
        for (int i = 0; i < arguments.length(); i++) {
            if (!Character.isDigit(arguments.charAt(i))) {
                throw new IanException("Invalid delete task format. " +
                        "Please try again with the proper format:" +
                        "\n\"delete <task number>\"");
            }
        }
        int index = (Integer.parseInt(arguments)) - 1;
        return new DeleteTaskCommand(index);
    }

}