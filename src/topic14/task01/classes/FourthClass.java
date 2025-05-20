package topic14.task01.classes;

import topic14.task01.AutoInstantiate;

@AutoInstantiate
public class FourthClass {
    public FourthClass() {
        System.out.println("Создан объект четвертого класса");
    }

    @Override
    public String toString() {
        return "FourthClass{метод toString}";
    }
}
