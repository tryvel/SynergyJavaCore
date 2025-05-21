package finalProject;

import java.time.Year;

public class Book {
    private static long id = 0L;
    private long number;
    private String author;
    private String title;
    private Year year;
    private Genre genre;


    public void setTitle(String title) {
        if(title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Поле 'Название' не должно быть пустым");
        }
    }
}
