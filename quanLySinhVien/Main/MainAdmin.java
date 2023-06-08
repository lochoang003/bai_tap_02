package quanLySinhVien.Main;

import quanLySinhVien.Class.CrudClass;

import java.util.Scanner;

public class MainAdmin  {




    public static   void admin() {
        CrudClass crudClass = new CrudClass();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Crud point");
            System.out.println("2.  check learning Ability");
            System.out.println("3. search students");
            System.out.println("4. list of students");
            System.out.println("5. search class");
            System.out.println("6. list of class");
            System.out.println("7. Crud class");
            System.out.println("8. Crud student by class");
            System.out.println("9. Crud student");
            System.out.println("0. exit");
            String choine = scanner.nextLine();
            switch (choine){
                case "1"-> crudClass.crudPointByStudenByClass();
                case "2"-> crudClass.learningAbility();
                case "3"-> crudClass.showOne();
                case "4"-> crudClass.showAll();
                case "5"-> crudClass.showOneClass();
                case "6"-> crudClass.showAllClass();
                case "7"-> crudClass.crudClass();
                case "8"-> crudClass.crudSt_Class();
                case "9"-> crudClass.crud_Student();
                case "0"-> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
        }
    }
    }

