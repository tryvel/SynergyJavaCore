package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    // Добавление книги согласно информации, введенной пользователем
    public boolean addBookFromTerminal() {
        Scanner scanner = new Scanner(System.in);
        String command;
        Book.Builder builder = new Book.Builder();      // builder для определения корректных параметров книги

        System.out.println("Введите информацию о книге (для прерывания процесса введите '--break')");
        while (true) {
            System.out.print("Автор: ");
            if ((command = scanner.nextLine()).equals("--break")) {
                return false;
            }
            try {
                builder.author(command);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.print("Название: ");
            if ((command = scanner.nextLine()).equals("--break")) {
                return false;
            }
            try {
                builder.title(command);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.print("Год издания: ");
            if ((command = scanner.nextLine()).equals("--break")) {
                return false;
            }
            try {
                builder.year(Integer.parseInt(command));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Жанр (для пропуска оставьте поле пустым): ");
        if ((command = scanner.nextLine()).equals("--break")) {
            return false;
        }
        builder.genre(command);

        Book book = builder.build();        // создание книги методом build объекта builder
        addBook(book);
        System.out.println(book);

        return true;
    }
}
