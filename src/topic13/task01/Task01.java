package topic13.task01;

import java.util.ArrayList;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Alice", 25));
        personList.add(new Person(2, "Bob", 35));
        personList.add(new Person(3, "Charlie", 40));
        personList.add(new Person(4, "David", 28));

        personList.stream()
                .filter((person -> person.getAge() > 30))
                .forEach(System.out::println);
    }
}
