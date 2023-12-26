package org.example.lesson10exceptions;

public class Main {
    public static void main(String[] args) {
        /*Написать код, который выбрасывает NullPointerException.
         * Написать обработчик этого исключения и вывести на экран сообщение,
         * которое будет содержать описание данного исключения*/
        Notebook notebook = new Notebook();
        notebook.createNote("1", null);
        try {
            String text = notebook.getNote(0).getText();
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Cause: " + e.getMessage());
        }

        /*Написать собственное исключение. Сгенерировать код, который будет его выбрасывать и обрабатывать.
         * Результат работы вывести на экран*/
        notebook.createNote("", "text");

        /*Написать метод, который будет возбуждать исключение и обработать это исключение на уровне выше.
         * Результат вывести на экран*/

        try {
            notebook.findNotes("test");
        } catch (NotebookException e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Cause: " + e.getMessage());
        }
    }
}
