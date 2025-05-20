package topic14.task01.classes;

import topic14.task01.AutoInstantiate;

@AutoInstantiate
public class SecondClass {
    public SecondClass() {
        System.out.println("Создан объект второго класса");
    }

    @Override
    public String toString() {
        return "SecondClass{метод toString}";
    }
}
