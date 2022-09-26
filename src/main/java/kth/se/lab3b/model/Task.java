package kth.se.lab3b.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
    private String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

    Task(String _description, Prio _prio, int _id){
        this.description = _description;
        this.prio = _prio;
        this.id = _id;
        lastUpdate = LocalDate.now();
    }

    public void setTakenBy(String _takenBy){
        this.takenBy = _takenBy;
        lastUpdate = LocalDate.now();
    }

    public LocalDate getLastUpdate(){
        return lastUpdate;
    }

    public String getTakenBy(){
        return this.takenBy;
    }

    public void setState(TaskState _state){
        this.state = _state;
        lastUpdate = LocalDate.now();
    }

    public TaskState getState(){
        return this.state;
    }

    public void setPrio(Prio _prio){
        this.prio = _prio;
        lastUpdate = LocalDate.now();
    }

    public  Prio getPrio(){
        return this.prio;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", descr: " + description + ", prio: " + prio + ", state: " + state
                + ", takenBy: " + takenBy  + ", lastUpdate: " + lastUpdate;
    }

    @Override
    public int compareTo(Task other) {
        if(this.prio.compareTo(other.prio) != 0)
            return this.prio.compareTo(other.prio);
        return this.description.compareTo(other.description);
    }
}
