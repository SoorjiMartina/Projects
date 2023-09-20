import java.util.ArrayList;
import java.util.Scanner;
class HelloWorld {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== To-Do List App =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Task added!");
                    break;
                case 2:
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks in the to-do list.");
                    } else {
                        System.out.println("Tasks in the to-do list:");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                    }
                    break;
                case 3:
                   
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks to mark as done.");
                    } else {
                        System.out.print("Enter the task number to mark as done: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (taskNumber >= 1 && taskNumber <= todoList.size()) {
                            String doneTask = todoList.remove(taskNumber - 1);
                            System.out.println("Task marked as done: " + doneTask);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 4:
                
                    System.out.println("Exiting the To-Do List App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
