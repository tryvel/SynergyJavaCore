package topic07.task01;

public class ProductionWorker extends Employee {
    int shiftNumber;
    double payment;

    public ProductionWorker(String name, String lastname, int number, int shiftNumber, double payment) {
        super(name, lastname, number);
        this.shiftNumber = shiftNumber;
        this.payment = payment;
    }

    public int getShiftNumber() {
        return shiftNumber;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Имя: " + this.getName() + ", Фамилия: " + this.getLastname() + ", Номер сотрудника: " + this.getNumber() +
                ", Номер смены: " + this.getShiftNumber() + ", Почасовая ставка: " + this.getPayment();
    }
}
