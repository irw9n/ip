package Ian.data;
import Ian.exception.IanException;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {}

    public ArrayList<Task> fetchTasks() { return this.tasks; }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

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

    public String listAddedTask() {
        return tasks.get(tasks.size() - 1).toString();
    }

    public String listSpecificTask(int index) {
        return tasks.get(index).toString();
    }

    public ArrayList<Task> findTasks(String query) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(query.toLowerCase())) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    public void listFoundTasks(ArrayList<Task> foundTasks) {
        for (int i = 0; i < foundTasks.size(); i++) {
            System.out.println((i + 1) + ". " + foundTasks.get(i).toString());
        }
    }

    public int getTaskListLength() {
        return tasks.size();
    }

    public void addToDo(String description) {
        String symbol = "[T]";
        tasks.add(new Todo(description, symbol));
    }

    public void addDeadline(String description, String by) {
        String symbol = "[D]";
        tasks.add(new Deadline(description, by, symbol));
    }

    public void addEvent(String description, String from, String to) {
        String symbol = "[E]";
        tasks.add(new Event(description, from, to, symbol));
    }

    public void markTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks.get(index).isDone = true;
    }

    public void unmarkTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        tasks.get(index).isDone = false;
    }

    public Task deleteTask(int index) throws IanException {
        if (index < 0 || index >= tasks.size()) {
            throw new IanException("Invalid task number selected. Make sure task number stays within the range of tasks.\nps: run the command \"list\" to view all the current tasks and their corresponding numbers.");
        }
        Task task_to_delete = tasks.get(index);
        tasks.remove(index);
        return task_to_delete;
    }
}