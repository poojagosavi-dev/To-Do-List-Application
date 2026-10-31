import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<Boolean> completed = new ArrayList<>();

    // Method to Add Task
    public static void addTask(Scanner sc) {

        System.out.print("Enter Task: ");
        String task = sc.nextLine();

        tasks.add(task);
        completed.add(false);

        System.out.println("Task Added Successfully!");
    }

    // Method to Display Tasks
    public static void displayTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available!");
            return;
        }

        System.out.println("\n------ TO-DO LIST ------");

        for (int i = 0; i < tasks.size(); i++) {

            String status;

            if (completed.get(i)) {
                status = "[Completed]";
            } else {
                status = "[Pending]";
            }

            System.out.println((i + 1) + ". " + tasks.get(i) + " " + status);
        }
    }

    // Method to Delete Task
    public static void deleteTask(Scanner sc) {

        displayTasks();

        if (tasks.isEmpty())
            return;

        System.out.print("Enter Task Number to Delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 1 && index <= tasks.size()) {

            tasks.remove(index - 1);
            completed.remove(index - 1);

            System.out.println("Task Deleted Successfully!");

        } else {

            System.out.println("Invalid Task Number!");
        }
    }
    // Method to Mark Task as Complete
    public static void markTaskComplete(Scanner sc) {

        displayTasks();

        if (tasks.isEmpty())
            return;

        System.out.print("Enter Task Number to Mark as Complete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 1 && index <= tasks.size()) {

            completed.set(index - 1, true);

            System.out.println("Task Marked as Completed!");

        } else {

            System.out.println("Invalid Task Number!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== TO-DO LIST ==========");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTask(sc);
                    break;

                case 2:
                    displayTasks();
                    break;

                case 3:
                    deleteTask(sc);
                    break;

                case 4:
                    markTaskComplete(sc);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}