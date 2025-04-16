package topic03.task04;

import java.text.DecimalFormat;
import java.util.Scanner;

/*Пользователь вводит сумму вклада и процент, который будет
начисляться ежегодно. Отобразить размер вклада поочередно на
ближайшие 5 лет.*/

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада:");
        double deposit = scanner.nextInt();
        System.out.println("Введите ежегодный процент:");
        double interest = scanner.nextInt();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = 0; i < 5; i++) {
            deposit *= (1 + interest / 100);
            System.out.println(decimalFormat.format(deposit));
        }
    }
}
