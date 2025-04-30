package topic05.task01;

import java.time.YearMonth;

/*Опишите с помощью Java класса банковскую карту.
Создайте класс Card и запишите поля класса (характеристики банковской карты)
- Название банка
- Название платёжной системы
- Номер карты
- Срок действия
- CVV
- Тип карты (кредитная/дебетовая)
- Поддержка NFC (true/false)
При создании полей самостоятельно выбирайте типы данных, в комментариях
к каждому полю укажите, почему выбрали именно такой тип.
Добавьте поле double balance = 1000.00. Реализуйте метод pay(double summ).*/

public class Card {
    String bank;
    String paymentSystem;
    long number; // целое число 16 цифр
    YearMonth expirationDate; // год и месяц
    int cvv; // целое число 3 цифры
    CardType type; // предопределенные значения
    boolean nfc; // только два значения
    double balance = 1000.00;

    public Card(String bank, String paymentSystem, long number, YearMonth expirationDate, int cvv, CardType type, boolean nfc) {
        this.bank = bank;
        this.paymentSystem = paymentSystem;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.type = type;
        this.nfc = nfc;
    }

    public boolean pay(double summ){
        if (this.balance >= summ) {
            this.balance -= summ;
            return true;
        } else {
            return false;
        }
    }

    public void getCardInfo() {
        System.out.printf("Информация о карте:\n" +
                "Банк: " + bank + ", " +
                "платежная система: " + paymentSystem + ", " +
                "номер карты: " + number + ", " +
                "срок действия: %02d" + "/" + (expirationDate.getYear() % 100) + ", " +
                "CVV: " + cvv + ", " +
                "тип карты: " + type + ", " +
                "NFC: " + (nfc ? "поддерживается" : "не поддерживается") + ", " +
                "баланс: " + balance + "\n", expirationDate.getMonthValue());
    }

    public static void main(String[] args) {
        Card card = new Card("Банк",
                "МИР",
                2334_4556_6778_8990L,
                YearMonth.now().plusYears(3L),
                357,
                CardType.DEBIT,
                true);
//        card.getCardInfo();
        for (int i = 0; i < 3; i++) {
            System.out.println(card.pay(500.0));
//            card.getCardInfo();
        }
    }
}
