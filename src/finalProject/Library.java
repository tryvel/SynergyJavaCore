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
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Введите информацию о книге (для прерывания процесса на любом этапе введите '--break')");
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

        return true;
    }

    // Удаление книги по id
    public void removeBook() {
        Scanner scanner = new Scanner(System.in);
        String command;
        long id;

        System.out.println("Введите номер книги для удаления (для прерывания процесса введите '--break')");
        while (true) {
            System.out.print("Номер: ");
            if ((command = scanner.nextLine()).equals("--break")) {
                System.out.println("Процесс удаления книги прерван");
                return;
            }
            try {
                id = Long.parseLong(command);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            }
        }
        Iterator<Book> iterator = books.iterator();     // итератор для прохода по списку
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                System.out.print("Удалить книгу '" + book + "'? ('y' - подтвердить, другое значение - отменить): ");
                if (scanner.nextLine().equals("y")) {
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
        Scanner scanner = new Scanner(System.in);

        int item = -1;
        while (item < 0 || item > 2) {
            System.out.println("Укажите по какому параметру выполнить поиск (1 - автор, 2 - название, 0 - отменить)");
            try {
                item = scanner.nextInt();
                if (item < 0 || item > 2) {
                    System.out.println("Необходимо ввести значение от 0 до 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести целое число");
                scanner.nextLine();     // очистка буфера сканера
            }
        }
        scanner.nextLine();             // очистка буфера сканера

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
