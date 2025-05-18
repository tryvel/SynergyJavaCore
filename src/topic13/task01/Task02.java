package topic13.task01;

import java.util.ArrayList;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "1984", "Детектив"));
        bookList.add(new Book(2, "Властелин колец", "Фэнтези"));
        bookList.add(new Book(3, "Марсианин", "Фантастика"));
        bookList.add(new Book(4, "Гарри Поттер", "Фэнтези"));

        bookList.stream()
                .filter((book -> book.getGenre().equals("Фантастика")))
                .forEach(System.out::println);
    }
}
