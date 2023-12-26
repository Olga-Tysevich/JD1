package org.example.lesson10exceptions;

import java.util.LinkedList;
import java.util.List;

public class Notebook {
    private List<Note> notes = new LinkedList<>();

    public boolean createNote(String title, String text) {
        try {
            if (title == null || title.isBlank()) {
                throw new NotebookException("Title cannot be empty!");
            }
            if (title.length() > 30) {
                throw new NotebookException("The title is too long! Maximum 30 characters!");
            }
            return notes.add(new Note(title, text));
        } catch (NotebookException e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Cause: " + e.getMessage());
            return false;
        }
    }

    public List<Note> findNotes(String title) throws NotebookException {
        List<Note> result = notes.stream().filter(n -> n.getTitle().contains(title)).toList();
        if (result.size() == 0) {
            throw new NotebookException("Nothing found");
        } else {
            return result;
        }
    }

    public Note getNote(int index) {
        return notes.get(index);
    }
}
