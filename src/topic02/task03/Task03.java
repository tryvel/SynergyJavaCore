package topic02.task03;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату x точки A");
        int x1 = scanner.nextInt();
        System.out.println("Введите координату y точки A");
        int y1 = scanner.nextInt();
        System.out.println("Введите координату x точки B");
        int x2 = scanner.nextInt();
        System.out.println("Введите координату y точки B");
        int y2 = scanner.nextInt();
        System.out.println("Координаты вектора AB:\nx = " + (x2 - x1) + "; y = " + (y2 - y1));
    }
}
