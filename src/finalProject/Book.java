package finalProject;

// Builder pattern (Паттерн проектирования Строитель)
public class Book {

    // Обязательные параметры
    private String author;
    private String title;
    private int year;

    // Дополнительные параметры
    private String genre;

    // Приватный конструктор запрещает напрямую создавать объект класса Book
    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.year = builder.year;
        this.genre = builder.genre;
    }

    // Статический вложенный класс Строитель
    public static class Builder {
        private String author;
        private String title;
        private int year;

        private String genre = "не задан";      // значение по умолчанию

        // Конструктор класса Builder
        public Builder(String author, String title, int year) {
            this.author = author;
            this.title = title;
            this.year = year;
        }

        // Сеттер genre
        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        // Создание объекта класса Book
        public Book build() {
            return new Book(this);
        }
    }

}
