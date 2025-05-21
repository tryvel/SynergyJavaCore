package finalProject;

import java.time.Year;

public class Book2 {
    private static long id = 0L;
    private long number;
    private String author;
    private String title;
    private Genre genre;
    private Year year;

    private static String validateAuthor (String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        return author;
    }

    private static String validateTitle(String title) {
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        return title;
    }



    public void setTitle(String title) {
        this.title = validateTitle(title);
    }
}
