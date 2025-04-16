package topic03.task03;

/*Используя цикл for вывести на экран прямоугольный треугольник
из восьмерок со сторонами 10 и 10*/

public class Task03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
