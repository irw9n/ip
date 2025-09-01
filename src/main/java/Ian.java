import java.util.Scanner;

public class Ian {
    private static void printSeparator() {
        System.out.println("____________________________________________________________");
    }

    public static void add(String input, String[] list) {
        printSeparator();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = input;
                break;
            }
        }
        System.out.println("added: " + input);
        printSeparator();
    }

    public static void list(String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println((i + 1) + ". " + list[i]);
            }
        }
    }

    public static void main(String[] args) {

        printSeparator();
        System.out.println("Hello! I'm Ian");
        System.out.println("What can I do for you?");
        printSeparator();

        String[] List = new String[100];

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
                list(List);

            } else {
                add(userInput, List);
            }
        } while (true);


        scanner.close();

    }
}
