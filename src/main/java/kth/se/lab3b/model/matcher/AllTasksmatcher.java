package kth.se.lab3b.model.matcher;

import kth.se.lab3b.model.Task;

public class AllTasksmatcher implements ITaskMatcher{
    public AllTasksmatcher(){}
    @Override
    public boolean match(Task task) {
        return true;
    }
}
