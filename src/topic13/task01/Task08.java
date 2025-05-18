package topic13.task01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task08 {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("Alice", 1, 90),
                new Student("Bob", 2, 85),
                new Student("Charlie", 1, 95),
                new Student("David", 2, 80)
        );
        // Группировка студентов по курсу и их оценкам
        Map<Integer, Map<Integer, List<Student>>> studentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.groupingBy(Student::getGrade)));

        System.out.println(studentMap);
    }
}
