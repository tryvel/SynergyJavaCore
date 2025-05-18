package topic13.task01;

public class Student {
    private String name;
    private int course;
    private int grade;

    public Student(String name, int course, int grade) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}
