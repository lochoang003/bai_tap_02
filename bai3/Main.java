package baiTapSlack.bai1.bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageEmployee manageEmployee = new ManageEmployee();
        String choine ;
        while (true){
            System.out.println("1. Add Employee ");
            System.out.println("2. Show Employee ");
            System.out.println("3. Total Salary Employee ");
            System.out.println("4. Employee Roll Call ");
            System.out.println("5. exit ");
            choine = new Scanner(System.in).nextLine();
            switch (choine){
                case "1" -> manageEmployee.addEmployee();
                case "2" -> manageEmployee.show();
                case "3" -> manageEmployee.totalSalary();
                case "4"-> manageEmployee.rollCall();
                case "5"-> System.exit(0);
                default -> System.err.println("Not found choine");

            }
        }
    }
}
