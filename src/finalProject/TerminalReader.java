package finalProject;

import java.util.Scanner;
import java.util.function.Predicate;

public class TerminalReader {
    private static final Scanner scanner = new Scanner(System.in);

/*
* Универсальный метод ввода из терминала с валидацией
* @param prompt Сообщение для пользователя
* @param validator Предикат для проверки ввода
* @param errorMessage Сообщение об ошибке
* Пример валидации:
* s -> s.matches("\\d+") && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 10 - целое число от 0 до 10
* */
    public static String inputWithValidation(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (validator.test(input)) {
                return input;
            }
            if (errorMessage != null) {
                System.out.println(errorMessage);
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}
