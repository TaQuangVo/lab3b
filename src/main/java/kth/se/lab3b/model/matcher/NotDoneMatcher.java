package kth.se.lab3b.model.matcher;

import kth.se.lab3b.model.Task;
import kth.se.lab3b.model.TaskState;

public class NotDoneMatcher  implements ITaskMatcher{
    public NotDoneMatcher(){}

    @Override
    public boolean match(Task _task) {
        return _task.getState() != TaskState.DONE;
    }
}