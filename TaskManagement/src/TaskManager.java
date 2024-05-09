import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    //Constructor

    public TaskManager(){ tasks = new ArrayList<>();}

    // Add as Task

    public void addTask(String title, String description, LocalDate dueDate){
        Task task = new Task(title, description, dueDate);
        tasks.add(task);

    }

    //edit a task
    public void editTask(int index, String title, String description, LocalDate dueDate){
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
    }

    //return the tasks list

    public List<Task> getTasks(){ return tasks;}

    //view tasks
    public void viewTasks(){
        if ( tasks.isEmpty()){
            System.out.println("You have no tasks");
        }
        for (int i =0; i < tasks.size(); i++){
            System.out.println("Task #"+ (i+1));
            System.out.println(tasks.get(i));
            System.out.println();

        }
    }
    // delete tasks
    public void deleteTasks(int index){
        tasks.remove(index);
    }

    // mark tasks as completed

    public void markTasksAsCompleted(int index){
        Task task = tasks.get(index);
        task.setCompleted(true);
    }

}