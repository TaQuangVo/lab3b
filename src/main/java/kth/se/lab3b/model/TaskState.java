package kth.se.lab3b.model;

public enum TaskState {
    TO_DO("To do"), IN_PROGRESS("In progress"), DONE("Done");

    private final String str;

    TaskState(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
