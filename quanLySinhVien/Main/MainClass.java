package quanLySinhVien.Main;

import quanLySinhVien.Class.CrudClass;

import java.util.Scanner;

public class MainClass {
    static CrudClass crudClass = new CrudClass();
    static Scanner scanner = new Scanner(System.in);

    public static void mainCLASS() {
        while (true){
            System.out.println("1. Crud point");
            System.out.println("2.  check learning Ability");
            System.out.println("3. search students");
            System.out.println("4. list of students");
            System.out.println("5. search class");
            System.out.println("6. list of class");
            System.out.println("7. exit");
            String choine = scanner.nextLine();
            switch (choine){
                case "1"-> crudClass.crudPoint();
                case "2"-> crudClass.learningAbility();
                case "3"-> crudClass.showOne();
                case "4"-> crudClass.showAll();
                case "5"-> crudClass.showOneClass();
                case "6"-> crudClass.showAllClass();
                case "7"-> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
        }
    }
}
