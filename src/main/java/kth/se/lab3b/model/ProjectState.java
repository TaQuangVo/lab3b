package kth.se.lab3b.model;

public enum ProjectState {
    EMPTY("Empty"), ONGOING("Ongoing"), COMPLETED("Completed");

    private final String str;

    ProjectState(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}

