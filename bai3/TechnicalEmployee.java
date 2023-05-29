package baiTapSlack.bai1.bai3;

public class TechnicalEmployee extends Employee{
    private int projects;


    public TechnicalEmployee(int id ,String name, int age, double salary, int day, int projects) {
        super(id,name, age, salary, day);
        this.projects = projects;
    }
    public double calculateMonthlySalary(){
        return 500*getDay() + 200*projects;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "TechnicalEmployee, " + super.toString() + projects ;
    }
    public void print(){
        super.print();
        System.out.printf(projects+ "\n");
    }
}
