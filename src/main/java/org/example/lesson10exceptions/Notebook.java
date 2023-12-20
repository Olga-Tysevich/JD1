package org.example.lesson10exceptions;


public class Notebook {
    private String note;

    public void addNote(String note) {
        this.note = note;
    }

    public void printNoteInLowerCase() {
        try {
            System.out.println("Note: " + note.toLowerCase());
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Cause: " + e.getMessage());
            System.out.println("You must add a note!");
        }
    }
}
