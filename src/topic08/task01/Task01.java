package topic08.task01;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Введите значение " + (i + 1) + " элемента массива: ");
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Введите делимое: ");
        int dividend = scanner.nextInt();

        int i = 0;
        while (true) {
            try {
                System.out.println(dividend + " / " + numbers[i] + " = " + (dividend / numbers[i]));
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль запрещено");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Программа успешно завершена");
                break;
            } finally {
                i++;
            }
        }
    }
}
