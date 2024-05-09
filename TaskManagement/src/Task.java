
import java.time.LocalDate;


public class Task{ // task object

    private String title;//title of the task

    private String description;// description of the task and what needs to be done

    private LocalDate dueDate; // when the task is due 

    private boolean completed; // if the task is completed

    //constructor

    public Task(String title, String description, LocalDate dueDate){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false; // by default Tasks are not completed
    }

    // getters and setters
    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title= title; }
    public String getDescription() { return description; }
    public void setDescription(String desctription) { this.description = description; }
    public LocalDate getDuDate() { return dueDate; }
    public void setDueDate(LocalDate duDate){ this.dueDate = dueDate; }
    public boolean isCompleted() {return completed; }
    public void setCompleted(boolean completed) { this.completed = completed;}

    //toString method to display task information

    @Override
    public String toString() {
        return title + "(" + (completed ? "completed" : "not completed")+ ")"+
        "\nDescription: " + description + 
        "\nDue date: "+ dueDate;
    }


    
}