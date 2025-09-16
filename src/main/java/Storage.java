import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Storage {
    private static final String DIRECTORY_PATH = "./data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/tasks.txt";

    public static void createDirectory() throws IOException {
        File dir = new File(DIRECTORY_PATH);
        if (!dir.exists()) {
            boolean wasSuccessful = dir.mkdir();
            if (!wasSuccessful) {
                System.err.println("Failed to create directory: " + DIRECTORY_PATH);
            }
        }
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void saveTasks(ArrayList<Task> tasks) throws IOException {
        createDirectory();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat() + "\n");
            }
        }
    }

    public static ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    Task task = parseLine(line);
                    tasks.add(task);
                } catch (IanException e) {
                    System.out.println("Warning: Corrupted line in file. Skipping: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Starting with an empty list.");
        }
        return tasks;
    }


    private static Task parseLine(String line) throws IanException {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new IanException("Corrupted data line format.");
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                Todo todo = new Todo(description, "T");
                if (isDone) todo.isDone = true;
                return todo;
            case "D":
                if (parts.length < 4) {
                    throw new IanException("Missing deadline date in file.");
                }
                String by = parts[3];
                Deadline deadline = new Deadline(description, by, "D");
                if (isDone) deadline.isDone = true;
                return deadline;
            case "E":
                if (parts.length < 5) {
                    throw new IanException("Missing event dates in file.");
                }
                String from = parts[3];
                String to = parts[4];
                Event event = new Event(description, from, to, "E");
                if (isDone) event.isDone = true;
                return event;
            default:
                throw new IanException("Unknown task type in file.");
        }
    }


}
