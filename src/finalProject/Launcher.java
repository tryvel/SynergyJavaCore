package finalProject;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);


        Book book = new Book.Builder("Марк Твен", "Принц и нищий", 2011)    // создание объекта класса Builder
                .genre("Приключения, Детективы")        // задание дополнительного параметра
                .build();       // создание объекта класса Book из объекта Builder после валидации
    }
}
