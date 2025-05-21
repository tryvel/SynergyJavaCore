package finalProject;

public enum Genre {
    FANTASY("Фантастика"),
    DYSTOPIAN("Антиутопия"),
    ADVENTURE("Приключения"),
    DETECTIVE("Детектив"),
    THRILLER("Триллер"),
    ROMANCE("Романтика"),
    HORROR("Ужасы"),
    CHILDREN("Детская"),
    AUTOBIOGRAPHY("Автобиография"),
    HISTORICAL("Историческая"),
    COMEDY("Комедия");

    private final String title;

    Genre(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
