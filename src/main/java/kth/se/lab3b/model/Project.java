package kth.se.lab3b.model;

import kth.se.lab3b.model.matcher.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project implements Comparable<Project>, Serializable {
    private String title;
    private int id;
    private String description;
    private LocalDate createdAt;
    private int nextTaskId;
    private List<Task> tasks;

    public Project(String _title, String _description, int _id){
        tasks = new ArrayList<>();
        nextTaskId = 0;
        createdAt = LocalDate.now();
        this.title = _title;
        this.description = _description;
        this.id = _id;
    }

    public ProjectState getState(){
        if(tasks.size() == 0)
            return ProjectState.EMPTY;

        for(Task task: tasks)
            if(task.getState() == TaskState.TO_DO || task.getState() == TaskState.IN_PROGRESS)
                return ProjectState.ONGOING;

        return ProjectState.COMPLETED;
    }

    public LocalDate getLastUpdated(){
        LocalDate latest = null;
        for(Task task: tasks){
            if(latest == null) latest = task.getLastUpdate();

            if(latest.isBefore(task.getLastUpdate())) latest = task.getLastUpdate();
        }
        return latest;
    }

    public  String getTitle(){
        return this.title;
    }

    public int getId(){
        return this.id;
    }

    public Task getTaskById( int id ){
        for(Task task: tasks)
            if(task.getId() == id)
                return task;
        return null;
    }

    public List<Task> findTasks(ITaskMatcher matcher){
        List<Task> matches = new ArrayList<>();
        for(Task task: tasks)
            if(matcher.match(task))
                matches.add(task);
        return matches;
    }

    public void addTask(String description, Prio prio){
        Task newTask = new Task(description, prio, nextTaskId++);
        tasks.add(newTask);
    }

    public Task removeTask(Task taskToRemove){
        for(Task task: tasks)
            if(task == taskToRemove) {
                tasks.remove(task);
                return taskToRemove;
            }
        return null;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", title: " + title + ", descr: " + description + ", createdAt: " + createdAt
                + ", nextTaskID: " + nextTaskId;
    }

    @Override
    public int compareTo(Project o) {
        return this.title.compareTo(o.title);
    }
}
