package org.example.lesson13thread_interaction.deadlock;

public class Resources {
    private final String first = "First resource";
    private final String second = "Second resource";
    private final String third = "Third resource";


    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }
}
