package Ian.data;
import Ian.exception.IanException;

import java.util.ArrayList;

/**
 * Represents a list of Task objects that have a suite of methods to modify them.
 */
public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {}

    public ArrayList<Task> fetchTasks() { return this.tasks; }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Lists all the current tasks saved.
     */
    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null) {
                if (i == 0) {
                    System.out.println("Here are the tasks in your list:");
                }
                System.out.println((i + 1)+ ". " + tasks.get(i).toString());
            }
        }
    }

    /**
     * Lists the most recently added task by the user, right after addition.
     * @return The string of the task.
     */
    public String listAddedTask() {
        return tasks.get(tasks.size() - 1).toString();
    }

    /**
     * Lists a specific task when queried by the program based on index.
     * @param index the identifier of the specific task.
     * @return The string of the task.
     */
    public String listSpecificTask(int index) {
        return tasks.get(index).toString();
    }

    /**
     * Finds a list of Tasks based on a String query by the user.
     * @param query String query which is used to search through the current list of tasks.
     * @return The list of tasks containing the String query in them.
     */
    public ArrayList<Task> findTasks(String query) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(query.toLowerCase())) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    /**
     * Lists the found tasks from findTasks(query) above.
     * @param foundTasks Found tasks
     */
    public void listFoundTasks(ArrayList<Task> foundTasks) {
        for (int i = 0; i < foundTasks.size(); i++) {
            System.out.println((i + 1) + ". " + foundTasks.get(i).toString());
        }
    }

    public int getTaskListLength() {
        return tasks.size();
    }

    /**
     * Adds a new Todo Task to the list of tasks.
     * @param description Todo description.
     */
    public void addToDo(String description) {
        String symbol = "[T]";
        tasks.add(new Todo(description, symbol));
    }

    /**
     * Adds a new Deadline Task to the list of tasks.
     * @param description Deadline description.
     * @param by Deadline
     */
    public void addDeadline(String description, String by) {
        String symbol = "[D]";
        tasks.add(new Deadline(description, by, symbol));
    }

    /**
     * Adds a new Event Task to the list of tasks.
     * @param description Event description
     * @param from Start
     * @param to End
     */
    public void addEvent(String description, String from, String to) {
        String symbol = "[E]";
        tasks.add(new Event(description, from, to, symbol));
    }

    /**
     * Marks selected task based on index as completed.
     * @param index Index of selected task.
     * @throws IanException Exception handling for invalid indexes.
     */
    public void markTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks.get(index).isDone = true;
    }

    /**
     * Unmarks selected task based on index as completed.
     * @param index Index of selected task.
     * @throws IanException Exception handling for invalid indexes.
     */
    public void unmarkTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks.get(index).isDone = false;
    }

    /**
     * Deletes a selected task based on index.
     * @param index Index of task to be deleted within tasks ArrayList.
     * @return Task that was just deleted to be shown to user.
     * @throws IanException in case of invalid index cases.
     */
    public Task deleteTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        Task task_to_delete = tasks.get(index);
        tasks.remove(index);
        return task_to_delete;
    }
}