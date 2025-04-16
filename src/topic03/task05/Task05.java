package topic03.task05;

import java.util.Arrays;
import java.util.Scanner;

/*Создайте массив: int[] nums = new int[10]; Добавьте в массив 10
чисел с клавиатуры. Найдите длину самой длинной
последовательности повторяющихся чисел в списке.*/

public class Task05 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(nums));
        int counter = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]){
                counter++;
                if(maxLength < counter) {
                    maxLength = counter;
                }
            } else {
                counter = 1;
            }
        }
        System.out.println(maxLength);
    }
}
