package finalProject;

import java.util.*;

public class Library {
    private List<Book> books;

    public Library() {
        try {
            books = XmlDom.readBooks();
        } catch (Exception e) {
            books = new ArrayList<>();
            System.out.println("Ошибка чтения списка книг из файла!");
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    // Добавление книги согласно информации, введенной пользователем
    public void addBook() {
        Book.Builder builder = new Book.Builder();

        if (requestBuilderParameters(builder)) {
            Book book = builder.build();        // создание книги методом build() объекта builder
            books.add(book);
            System.out.println("Книга '" + book + "' успешно добавлена в библиотеку");
        } else {
            System.out.println("Процесс добавления книги прерван");
        }
    }

    // Запрос параметров builder с верификацией
    private boolean requestBuilderParameters (Book.Builder builder) {
        System.out.println("Введите информацию о книге (для прерывания процесса на любом этапе введите '--break')");
        // верификация и вывод сообщений об ошибке выполняется методами класса Builder
        String input;
        input = TerminalReader.inputWithValidation(
                "Автор: ",
                s -> {
                    try {
                        builder.author(s);
                        return true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    return false;
                    },
                null);
        if (input.equals("--break"))
            return false;

        input = TerminalReader.inputWithValidation(
                "Название: ",
                s -> {
                    try {
                        builder.title(s);
                        return true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    return false;
                    },
                null);
        if (input.equals("--break"))
            return false;

        input = TerminalReader.inputWithValidation(
                "Год издания: ",
                s -> {
                    try {
                        builder.year(Integer.parseInt(s));
                        return true;
                    } catch (NumberFormatException e) {
                        System.out.println("Необходимо ввести целое число");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    return false;
                },
                null);
        if (input.equals("--break"))
            return false;

        input = TerminalReader.inputWithValidation(
                "Жанр (для пропуска оставьте поле пустым): ",s -> true,null);
        if (input.equals("--break"))
            return false;
        builder.genre(input);

        return true;
    }

    // Удаление книги по id
    public void removeBook() {
        long id;

        String input = TerminalReader.inputWithValidation(
                "Введите номер книги для удаления (для прерывания процесса введите '--break'): ",
                s -> s.matches("\\d+") || s.equals("--break"),
                "Необходимо ввести целое число больше 0"
        );
        if (input.equals("--break")) {
            System.out.println("Процесс удаления книги прерван");
            return;
        } else {
            id = Long.parseLong(input);
        }

        Iterator<Book> iterator = books.iterator();     // итератор для прохода по списку
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                input = TerminalReader.inputWithValidation(
                        "Удалить книгу '" + book + "'? ('y' - подтвердить, 'n' - отменить): ",
                        s -> s.matches("[YyNn]"),
                        "Допустимые значения 'y' или 'n'"
                );

                if (input.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("Книга успешно удалена");
                } else {
                    System.out.println("Операция удаления отменена");
                }
                return;
            }
        }
        System.out.println("Книга с указанным номером не найдена");
    }

    public void findBooks() {
        int item = Integer.parseInt(TerminalReader.inputWithValidation(
                "Укажите по какому параметру выполнить поиск (1 - автор, 2 - название, 0 - отменить): ",
                s -> s.matches("[012]"),
                "Необходимо ввести значение от 0 до 2"
        ));

        Scanner scanner = new Scanner(System.in);
        List<Book> findBooks = null;
        String text;
        switch (item) {
            case 0:
                System.out.println("Поиск отменен");
                return;
            case 1:
                System.out.println("Введите текст, который должен содержаться в поле 'автор'");
                text = scanner.nextLine();
                findBooks = books.stream()
                        .filter(book -> book.getAuthor().toLowerCase().contains(text.toLowerCase()))
                        .toList();
                break;
            case 2:
                System.out.println("Введите текст, который должен содержаться в названии");
                text = scanner.nextLine();
                findBooks = books.stream()
                        .filter(book -> book.getTitle().toLowerCase().contains(text.toLowerCase()))
                        .toList();
                break;
        }
        showListBooks(findBooks);
    }

    public void writeBooksToFile () {
        XmlDom.writeBooks(books);
    }

    // Вывод списка книг
    public void showListBooks (List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Нет элементов для отображения");
        } else {
            books.forEach(System.out::println);
        }
    }
}
