package topic13.task01;

import java.util.List;
import java.util.Optional;

public class Task03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(((n1, n2) -> n1 + n2));

        sum.ifPresent(System.out::println);
    }
}
