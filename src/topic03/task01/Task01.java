package topic03.task01;

// Найти минимальный нечетный элемент для массива:
// int[] nums = {3400,25,345,234,36,234,5,32,42,342};

public class Task01 {
    public static void main(String[] args) {
        int[] nums = {3400,25,345,234,36,234,5,32,42,342};
        double min = Double.POSITIVE_INFINITY;
        for (int num : nums) {
            if (num < min && num % 2 != 0) {
                min = num;
            }
        }
        System.out.println((int)min);
    }
}
