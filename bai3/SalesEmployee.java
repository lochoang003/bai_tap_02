package baiTapSlack.bai1.bai3;

public class SalesEmployee extends Employee{
    private int sales;

    public SalesEmployee(int id ,String name, int age, double salary, int day, int sales) {
        super(id,name, age, salary, day);
        this.sales = sales;
    }
    public double calculateMonthlySalary(){
        return 300*super.getDay() + 50*sales;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "SalesEmployee, " + super.toString() + sales ;
    }
    public void print(){
        super.print();
        System.out.printf(sales+ "\n");
    }
}
