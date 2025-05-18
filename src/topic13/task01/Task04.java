package topic13.task01;

import java.util.List;

public class Task04 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "elderberry");

        List<String> threeFruits = fruits.stream()
                .limit(3)
                .toList();

        System.out.println(threeFruits);
    }
}
