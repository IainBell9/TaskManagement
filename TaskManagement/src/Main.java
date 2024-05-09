import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Task Management Application");
            System.out.println("1. Add a task");
            System.out.println("2. Edit a task");
            System.out.println("3. View all tasks");
            System.out.println("4. Delete a task");
            System.out.println("5. Mark as completed");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            // get input 
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the new line char

            switch (choice){
                case 0:
                    System.out.println("Existing...");
                    return;
                case 1:
                    // Add a task
                    System.out.println("Enter new task name: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter the task description: ");
                    String description = scanner.nextLine();

                    LocalDate dueDate = null;
                    while (dueDate == null){
                        System.out.println("Enter the task due date (YYYY-MM-DD): ");
                        String dueDateString = scanner.nextLine();

                        try{
                            dueDate = LocalDate.parse(dueDateString);
                        }catch (DateTimeParseException e) {
                            System.out.println(" Invalid date format. Please try again. ");
                        }
                }
                taskManager.addTask(title, description, dueDate);
                System.out.println("Task added successfully");
                break;
                case 2:
                    //Edit a task
                    System.out.println("Enter the task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // consume the newline char

                    if (editIndex <=0 || editIndex > taskManager.getTasks().size()){
                        System.out.println("Invalid task number, please try again. ");
                        break;
                    }
                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter new taxk description: ");
                    String newDescription = scanner.nextLine();
                    LocalDate newDueDate = null;
                    while (newDueDate == null) {
                        System.out.print("Enter the new due date for the task (YYYY-MM-DD): ");
                        String newDueDateString = scanner.nextLine();
                        try {
                            newDueDate = LocalDate.parse(newDueDateString);
                        } catch (DateTimeParseException e ){
                            System.out.println("Invalid date format. Please try again. ");
                        }
                    }
                taskManager.editTask(editIndex -1, newTitle, newDescription, newDueDate);
                System.err.println("Task Updated Successfully");
                break;
            case 3:
                    // view all tasks
                    taskManager.viewTasks();
                    break;
            case 4:
                    //Delete a task
                    System.out.print("Enter the task number you want to delete");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); //consume the newline char

                    if (deleteIndex <=0 || deleteIndex > taskManager.getTasks().size()){
                        System.out.println("invalid task number. Please try again. ");
                        break;
                    }

                    taskManager.deleteTasks(deleteIndex -1);
                    System.out.println("task deleted successfully.");
                    break;
                case 5: 
                //mark task as completed
                System.out.print(" enter the task number to mark as completed: ");
                int completeIndex = scanner.nextInt();
                scanner.nextLine();

                if (completeIndex <=0 || completeIndex > taskManager.getTasks().size()){
                    System.out.println("invalid task number please try again.");
                    break;
                }
                taskManager.markTasksAsCompleted(completeIndex -1);
                System.out.println("Task marked as completed successfully.");
                break;

            default: 
                System.out.println("invalid choice please try again");
                break;

            }

            System.out.println();
        }
    }
    
}
