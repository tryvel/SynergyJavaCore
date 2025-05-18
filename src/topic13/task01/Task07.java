package topic13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task07 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Alice", 25));
        personList.add(new Person(2, "Bob", 30));
        personList.add(new Person(3, "Charlie", 25));
        personList.add(new Person(4, "David", 30));

        Map<Integer, List<Person>> personMap = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(personMap);
    }
}
