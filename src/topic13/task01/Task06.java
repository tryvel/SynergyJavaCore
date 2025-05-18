package topic13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task06 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Alice", 25));
        personList.add(new Person(2, "Bob", 30));
        personList.add(new Person(3, "Alice", 35));

        Map<String, List<Person>> personMap = personList.stream()
                .collect(Collectors.groupingBy(Person::getName));

        System.out.println(personMap);
    }
}
