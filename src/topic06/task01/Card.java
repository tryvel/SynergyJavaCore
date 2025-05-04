package topic06.task01;

import java.time.YearMonth;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*bank, paymentSystem, number, expirationDate, cvv, type, nfc - задаются при выпуске карты,
* и не изменяются, для данных полей только геттеры.
* balance, pin - могут меняться, для данных полей геттеры и сеттеры */

public class Card {
    private String bank;
    private String paymentSystem;
    private long number; // целое число 16 цифр
    private YearMonth expirationDate; // год и месяц
    private int cvv; // целое число 3 цифры
    private CardType type; // предопределенные значения
    private boolean nfc; // только два значения
    private double balance = 1000.00;
    private String pin = "0000";

    public Card(String bank, String paymentSystem, long number, YearMonth expirationDate, int cvv, CardType type, boolean nfc) {
        this.bank = bank;
        this.paymentSystem = paymentSystem;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.type = type;
        this.nfc = nfc;
    }

    public String getBank() {
        return bank;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public long getNumber() {
        return number;
    }

    public YearMonth getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public CardType getType() {
        return type;
    }

    public boolean isNfc() {
        return nfc;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public void setBalance(double difference) {
        if (this.balance + difference < 0.0) {
            System.out.println("Недостаточно средств");
        } else {
            this.balance += difference;
            if (difference < 0.0) {
                System.out.println("Успешное списание средств, остаток " + this.balance);
            } else {
                System.out.println("Баланс успешно пополнен, остаток " + this.balance);
            }
        }
    }

    public void setPin(String pin) {
        Matcher matcher = Pattern.compile("\\d{4}").matcher(pin);
        if (matcher.matches()) {
            System.out.println("ПИН-код успешно изменен");
        } else {
            System.out.println("Некорректный ПИН-код");
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
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Введите команду: \n" +
                    "(/balance - изменить баланс, /pin - изменить pin, /exit - выход)");
            command = scanner.nextLine();
            if (command.equals("/balance")) {
                System.out.println("На какую сумму изменить баланс:\n" +
                        "(отрицательное значение - списать, положительное - пополнить)");
                card.setBalance(scanner.nextDouble());
                scanner.nextLine();
            } else if (command.equals("/pin")) {
                System.out.println("Введите новый ПИН-код (4 цифры):");
                card.setPin(scanner.nextLine());
            } else if (command.equals("/exit")) {
                break;
            }
        }
    }
}
