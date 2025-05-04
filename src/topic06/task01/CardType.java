package topic06.task01;

public enum CardType {
    CREDIT("кредитная"),
    DEBIT("дебетовая");

    private String title;

    CardType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
