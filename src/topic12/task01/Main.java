package topic12.task01;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double d1 = 1210.44;
        double d2 = 86.46;

        try {
            System.out.println(calculator.add(d1, d2));
            System.out.println(calculator.subtract(d1, d2));
            System.out.println(calculator.multiply(d1, d2));
            System.out.println(calculator.divide(d1, d2));
            System.out.println(calculator.divide(d1, 0));       // exception
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
