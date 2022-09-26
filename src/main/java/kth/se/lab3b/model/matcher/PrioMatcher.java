package kth.se.lab3b.model.matcher;

import kth.se.lab3b.model.Prio;
import kth.se.lab3b.model.Task;

public class PrioMatcher implements ITaskMatcher{
    Prio prio;
    public PrioMatcher(Prio _prio){
        this.prio = _prio;
    }

    @Override
    public boolean match(Task task) {
        return task.getPrio() == this.prio;
    }
}