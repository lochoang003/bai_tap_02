package baiTapSlack.bai1.bai3;

public class Employee {
    private static int count;
    private int id;
    private String name;
    private int age;
    private double salary;
    private int day;

    public Employee() {
        this.id = count++;
    }

    public Employee(int id,String name, int age, double salary, int day) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.day = day;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return
                 + id +
                ", " + name  +
                ", " + age  +
                ", " + salary +
                ", " + day
                +", ";
    }
   public void print(){
        System.out.printf("%-5d %-30s %-10d %-10d %-10d ",this.id,this.name,this.age,Math.round(this.salary),this.day);
    }
}
