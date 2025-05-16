package topic12.task01;

public class Calculator {
    public double add(double d1, double d2) {
        MathOperation addOperation = (x, y) -> x + y;
        return calculate(d1, d2, addOperation);
    }

    public double subtract(double d1, double d2) {
        MathOperation subtractOperation = (x, y) -> x - y;
        return calculate(d1, d2, subtractOperation);
    }

    public double multiply(double d1, double d2) {
        MathOperation multiplyOperation = (x, y) -> x * y;
        return calculate(d1, d2, multiplyOperation);
    }

    public double divide(double d1, double d2) {
        if (d2 == 0.0) {
            throw new ArithmeticException("Деление на ноль запрещено");
        }
        MathOperation divideOperation = (x, y) -> x / y;
        return calculate(d1, d2, divideOperation);
    }

    private static double calculate(double d1, double d2, MathOperation mathOperation) {
        return mathOperation.operate(d1, d2);
    }
}