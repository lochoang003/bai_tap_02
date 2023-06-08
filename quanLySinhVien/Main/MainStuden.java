package quanLySinhVien.Main;

import quanLySinhVien.Class.CrudClass;
import quanLySinhVien.Crud.Student.CdruStudent;

import java.util.Scanner;

public class MainStuden {

    public static void main(String[] args) {
        CrudClass crudClass = new CrudClass();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. check learning Ability");
            System.out.println("2. search students");
            System.out.println("3. list of students");
            System.out.println("4. list of class");
            System.out.println("5. exit");
            String choine = scanner.nextLine();
            switch (choine){
                case "1"-> crudClass.learningAbility();
                case "2"-> crudClass.showOne();
                case "3"-> crudClass.showAll();
                case "4"-> crudClass.showAllClass();
                case "5"-> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
        }
    }
}
