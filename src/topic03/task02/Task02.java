package topic03.task02;

import java.util.Scanner;

/*Напишите код, который принимает с клавиатуры целое
положительное трехзначное число и выводит его на экран в
«полном виде»: например, для числа 364 это будет выглядеть как
300 60 4.*/

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое положительное трехзначное число:");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 99 && num < 1000) {
                int digit = 100;
                while (digit > 0) {
                    System.out.print(num / digit * digit + " ");
                    num -= num / digit * digit;
                    digit /= 10;
                }
            } else {
                System.out.println("Введено не положительное трехзначное число!");
            }
        } else {
            System.out.println("Введено не целое число!");
        }
    }
}
