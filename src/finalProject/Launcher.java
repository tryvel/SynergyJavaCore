package finalProject;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Демонстрация создания книги посредством builder
        Book book = new Book.Builder()              // создание объекта класса Builder
                .author("Марк Твен")                // задание параметров
                .title("Принц и нищий")
                .year(2011)
                .genre("Приключения, Детективы")
                .build();       // создание объекта класса Book из объекта Builder после валидации

        while (true) {
            System.out.println("Введите команду (--exit - выход, --add - добавить книгу, --list - вывести список книг)");
            String command = scanner.nextLine();
            if (command.equals("--exit")) {
                library.writeBooksToFile();
                break;
            } else if (command.equals("--add")) {
                if (library.addBookFromTerminal()) {
                    System.out.println("Книга успешно добавлена в библиотеку");
                } else {
                    System.out.println("Процесс добавления книги прерван");
                }
            } else if (command.equals("--list")) {
                library.showListBooks();
            }

        }

        System.out.println("Работа программы завершена");
    }
}
