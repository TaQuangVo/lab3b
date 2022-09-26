package kth.se.lab3b.model.matcher;

import kth.se.lab3b.model.Task;

public class TakenByMatcher implements ITaskMatcher{
    String takenBy;
    public TakenByMatcher(String _takenBy){
        this.takenBy = _takenBy;
    }
    @Override
    public boolean match(Task task) {
        return task.getTakenBy().equals(takenBy);
    }
}
