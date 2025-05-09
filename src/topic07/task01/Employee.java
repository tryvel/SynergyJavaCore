package topic07.task01;

abstract public class Employee {
    String name;
    String lastname;
    int number;

    public Employee(String name, String lastname, int number) {
        this.name = name;
        this.lastname = lastname;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getNumber() {
        return number;
    }
}
