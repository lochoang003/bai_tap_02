package baiTapSlack.bai1.bai3;

public class AdministrativeEmployee extends Employee {
   private int dayOff;


    public AdministrativeEmployee(int id, String name, int age, double salary, int day, int dayOff) {
        super(id, name, age, salary, day);
        this.dayOff = dayOff;
    }

    public double calculateMonthlySalary(){
        return 500*(super.getDay() - dayOff);
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    @Override
    public String toString() {
        return "AdministrativeEmployee, " + super.toString() + dayOff ;
    }
    public void print(){
        super.print();
        System.out.printf(dayOff+ "\n");
    }
}
