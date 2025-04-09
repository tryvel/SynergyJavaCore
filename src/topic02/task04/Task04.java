package topic02.task04;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scanner.nextInt();
        System.out.println("Число, увеличенное на 15%:\n" + a * 115 / 100);
    }
}
