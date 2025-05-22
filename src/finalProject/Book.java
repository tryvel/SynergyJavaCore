package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Builder pattern (Паттерн проектирования Строитель)
public class Book {
    private static final AtomicLong idGenerator = new AtomicLong(1L);
    private final long id;

    // Обязательные параметры
    private final String author;
    private final String title;
    private final Integer year;

    // Дополнительные параметры
    private final String genre;

    // Приватный конструктор запрещает напрямую создавать объект класса Book
    private Book(Builder builder) {
        this.id = idGenerator.getAndIncrement();
        this.author = builder.author;
        this.title = builder.title;
        this.year = builder.year;
        this.genre = builder.genre;
    }

    @Override
    public String toString() {
        return "Номер: " + id +
                ", автор: " + author +
                ", название: " + title +
                ", год издания: " + year +
                ", жанр: " + genre;
    }

    // Статический вложенный класс Строитель
    public static class Builder {
        private String author;
        private String title;
        private Integer year;

        private String genre = "Не задан";      // значение по умолчанию

        // Сеттер author для объекта Builder с валидацией значения
        public Builder author(String author) {
            if (author == null || author.trim().isEmpty()) {
                throw new IllegalArgumentException("Поле 'Автор' не может быть пустым");
            }
            this.author = author;
            return this;
        }

        // Сеттер title для объекта Builder с валидацией значения
        public Builder title(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Поле 'Название' не может быть пустым");
            }
            this.title = title;
            return this;
        }

        // Сеттер year для объекта Builder с валидацией значения
        public Builder year(Integer year) {
            if (year < 1000 || year > 9999) {
                throw new IllegalArgumentException("Значение поля 'Год' должно быть в диапазоне от 1000 до 9999");
            }
            this.year = year;
            return this;
        }

        // Сеттер genre для объекта Builder
        public Builder genre(String genre) {
            if (genre != null && !genre.trim().isEmpty()) {
                this.genre = genre;
            }
            return this;
        }

        // Создание объекта класса Book с проверкой, что значения параметров были предварительно заданы сеттерами
        public Book build() {
            // Список для накопления сообщений об ошибках
            List<String> errors = new ArrayList<>();
            if (author == null) {
                errors.add("Необходимо задать автора");
            }
            if (title == null) {
                errors.add("Необходимо задать название");
            }
            if (year == null) {
                errors.add("Необходимо задать год");
            }
            if (!errors.isEmpty()) {
                throw new IllegalStateException("Ошибка создания книги: " + String.join(", ", errors));
            }
            return new Book(this);
        }
    }

}
