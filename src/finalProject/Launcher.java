package finalProject;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Демонстрация создания книги посредством builder
        /*Book book = new Book.Builder()              // создание объекта класса Builder
                .author("Марк Твен")                // задание параметров
                .title("Принц и нищий")
                .year(2011)
                .genre("Приключения, Детективы")
                .build();       // создание объекта класса Book из объекта Builder после валидации*/

        while (true) {
            System.out.println("Введите команду (--list - вывести список книг, --add - добавить книгу, --exit - выход)");
            String command = scanner.nextLine();
            if (command.equals("--list")) {
                library.showListBooks();
            } else if (command.equals("--add")) {
                library.addBookFromTerminal();
            } else if (command.equals("--exit")) {
                library.writeBooksToFile();
                break;
            } else {
                System.out.println("Неизвестная команда");
            }
        }

        System.out.println("Работа программы завершена");
    }
}
