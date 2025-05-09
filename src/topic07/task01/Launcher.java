package topic07.task01;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные производственного работника");
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Фамилия: ");
        String lastname = scanner.nextLine();
        System.out.print("Номер сотрудника: ");
        int number = scanner.nextInt();
        System.out.print("Номер смены: ");
        int shiftNumber = scanner.nextInt();
        System.out.print("Почасовая ставка: ");
        double payment = scanner.nextDouble();

        ProductionWorker productionWorker = new ProductionWorker(name, lastname, number, shiftNumber, payment);
        System.out.println("Новый сотрудник:");
        System.out.println(productionWorker);
    }
}
