package topic02.task05;

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        scanner.nextLine();     // считывает символы оставшиеся после nextInt()
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        scanner.nextLine();     // считывает символы оставшиеся после nextInt()
        System.out.println("Введите математический оператор");
        String operator = scanner.nextLine();
        if (operator.equals("+")) {
            System.out.println("Результат вычислений:\n" + (a + b));
        } else if(operator.equals("-")) {
            System.out.println("Результат вычислений:\n" + (a - b));
        } else if(operator.equals("*")) {
            System.out.println("Результат вычислений:\n" + (a * b));
        } else if(operator.equals("/")) {
            System.out.println("Результат вычислений:\n" + (a / b));
        } else {
            System.out.println("Введен неизвестный математический оператор");
        }
    }
}
