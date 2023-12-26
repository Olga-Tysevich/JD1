package org.example.lesson10exceptions;

import java.util.LinkedList;
import java.util.List;

import static org.example.lesson10exceptions.Constants.*;

public class Notebook {
    private List<Note> notes = new LinkedList<>();

    public boolean createNote(String title, String text) {
        try {
            if (title == null || title.isBlank()) {
                throw new NotebookException(EMPTY_TITLE_EXCEPTION);
            }
            if (title.length() > TITLE_LENGTH) {
                throw new NotebookException(LONG_TITLE_EXCEPTION);
            }
            return notes.add(new Note(title, text));
        } catch (NotebookException e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
            return false;
        }
    }

    public List<Note> findNotes(String title) throws NotebookException {
        List<Note> result = notes.stream().filter(n -> n.getTitle().contains(title)).toList();
        if (result.size() == 0) {
            throw new NotebookException(NOTHING_FOUND_EXCEPTION);
        } else {
            return result;
        }
    }

    public Note getNote(int index) {
        return notes.get(index);
    }
}
