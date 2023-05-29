package baiTapSlack.bai1.bai3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageEmployee {
    private static File file = new File("Employee.txt");
    private static List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    static {
        boolean checkFile = file.exists();
        if (!checkFile) {
            try {
                file.createNewFile();
                employees.add(new AdministrativeEmployee(12, "AdministrativeEmployee", 12, 13, 25, 11));
                employees.add(new TechnicalEmployee(14, "TechnicalEmployee", 12, 13, 25, 11));
                employees.add(new SalesEmployee(13, "SalesEmployee", 12, 13, 25, 11));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter("Employee.txt");
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ) {
                for (Employee employee : employees) {
                    bufferedWriter.write(employee + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //////////READ/////////////////
        try (FileReader fileReader = new FileReader("C:\\Users\\locho\\OneDrive\\Máy tính\\Employee.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            int id;
            String name;
            int age;
            double salary;
            int day;
            int dayOff;
            int projects;
            int sales;

            String[] arr;
            String str;


            while ((str = bufferedReader.readLine()) != null) {
                arr = str.split(", ");
                id = Integer.parseInt(arr[1]);
                name = arr[2];
                age = Integer.parseInt(arr[3]);
                salary = Double.parseDouble(arr[4]);
                day = Integer.parseInt(arr[5]);

                switch (arr[0]) {
                    case "AdministrativeEmployee" -> {
                        dayOff = Integer.parseInt(arr[6]);
                        AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee(id, name, age, salary, day, dayOff);
                        employees.add(administrativeEmployee);
                    }
                    case "TechnicalEmployee" -> {
                        projects = Integer.parseInt(arr[6]);
                        employees.add(new TechnicalEmployee(id, name, age, salary, day, projects));
                    }
                    case "SalesEmployee" -> {
                        sales = Integer.parseInt(arr[6]);
                        employees.add(new SalesEmployee(id, name, age, salary, day, sales));
                    }
                }
            }
            if (!checkFile){
                for (int i = 0; i < employees.size()-1; i++) {
                    for (int j = i+1; j < employees.size(); j++) {
                        if (employees.get(i).getId() == employees.get(j).getId()){
                            employees.remove(j);
                        }
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////
    private String addname() {
        System.out.println("name");
        return scanner.nextLine();
    }

    private int addAge() {
        System.out.println("age");
        return Integer.parseInt(scanner.nextLine());
    }

    private double addSalary() {
        System.out.println("salary");
        return Double.parseDouble(scanner.nextLine());
    }

    private int addDay() {
        System.out.println("day");
        return Integer.parseInt(scanner.nextLine());
    }

    private int checkId() {
        System.out.println("Id");
        int id = Integer.parseInt(scanner.nextLine());
        for (Employee e : employees) {
            if (e.getId() == id) {
                return -1;
            }
            }
        return id;
        }
        private int addId () {
        int id;
        do {
            id = checkId();
            if (id!=-1){
                return id;
            }
            System.err.println("duplicated ID , retype");
        }while (true);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        private void addAdministrativeEmployee () {
            int id = addId();
            String name = addname();
            int age = addAge();
            double salary = addSalary();
            int day = addDay();
            System.out.println("dayOff");
            int dayOdff = Integer.parseInt(scanner.nextLine());
            AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee(id, name, age, salary, day, dayOdff);
            employees.add(administrativeEmployee);
            write(administrativeEmployee);

        }

        private void addTechnicalEmployee () {
            int id = addId();
            String name = addname();
            int age = addAge();
            double salary = addSalary();
            int day = addDay();
            System.out.println("projects");
            int projects = Integer.parseInt(scanner.nextLine());
            TechnicalEmployee technicalEmployee = new TechnicalEmployee(id, name, age, salary, day, projects);
            employees.add(technicalEmployee);
            write(technicalEmployee);
        }

        private void addSalesEmployee () {
            int id = addId();
            String name = addname();
            int age = addAge();
            double salary = addSalary();
            int day = addDay();
            System.out.println("sales");
            int sales = Integer.parseInt(scanner.nextLine());
            SalesEmployee salesEmployee = new SalesEmployee(id, name, age, salary, day, sales);
            employees.add(salesEmployee);
            write(salesEmployee);
        }

        public void addEmployee () {
            String choine;
            while (true) {
                System.out.println("1. add AdministrativeEmployee ");
                System.out.println("2. add TechnicalEmployee ");
                System.out.println("3. add SalesEmployee ");
                System.out.println("4. exit ");
                choine = scanner.nextLine();
                switch (choine) {
                    case "1" -> addAdministrativeEmployee();
                    case "2" -> addTechnicalEmployee();
                    case "3" -> addSalesEmployee();
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("not found choine");
                }
            }
        }

        //////////////////////////////////////////////////////////////////////////////
        private void showAdministrativeEmployee () {
            System.out.println("Employee AdministrativeEmployee : ");
            System.out.printf("%-5s %-30s %-10s %-10s %-10s %-10s \n","Id","Name","Age","Salary","Day","Day off");
            for (Employee employee : employees) {
                if (employee instanceof AdministrativeEmployee) {
                    employee.print();
                }
            }
            System.out.println();
        }

        private void showTechnicalEmployee () {
            System.out.println("Employee TechnicalEmployee : ");
            System.out.printf("%-5s %-30s %-10s %-10s %-10s %-10s \n","Id","Name","Age","Salary","Day","Projects");
            for (Employee employee : employees) {
                if (employee instanceof TechnicalEmployee) {
                    employee.print();
                }
            }
            System.out.println();
        }

        private void showSalesEmployee () {
            System.out.println("Employee SalesEmployee : ");
            System.out.printf("%-5s %-30s %-10s %-10s %-10s %-10s \n","Id","Name","Age","Salary","Day","Sales");
            for (Employee employee : employees) {
                if (employee instanceof SalesEmployee) {
                    employee.print();
                }
            }
            System.out.println();
        }

        private void showAll () {
            showAdministrativeEmployee();
            showTechnicalEmployee();
            showSalesEmployee();
        }

        public void show () {
            while (true) {
                System.out.println("1. display Administrative Employee");
                System.out.println("2. display Technical Employee");
                System.out.println("3. display Sales Employee");
                System.out.println("4. display All");
                System.out.println("5.  exit");
                String choine = scanner.nextLine();
                switch (choine) {
                    case "1" -> showAdministrativeEmployee();
                    case "2" -> showTechnicalEmployee();
                    case "3" -> showSalesEmployee();
                    case "4" -> showAll();
                    case "5" -> {
                        return;
                    }
                    default -> System.err.println(" not found choine ");

                }
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////
        private double totalSalaryAdministrativeEmployee () {
            double totalSalary = 0;
            for (Employee employee : employees) {
                if (employee instanceof AdministrativeEmployee) {
                    totalSalary += ((AdministrativeEmployee) employee).calculateMonthlySalary();
                }
            }
            return totalSalary;
        }

        private double totalSalaryTechnicalEmployee () {
            double totalSalary = 0;
            for (Employee employee : employees) {
                if (employee instanceof TechnicalEmployee) {
                    totalSalary += ((TechnicalEmployee) employee).calculateMonthlySalary();
                }
            }
            return totalSalary;
        }

        private double totalSalarySalesEmployee () {
            double totalSalary = 0;
            for (Employee employee : employees) {
                if (employee instanceof SalesEmployee) {
                    totalSalary += ((SalesEmployee) employee).calculateMonthlySalary();
                }
            }
            return totalSalary;
        }

        private double totalSalaryAll () {
            return totalSalaryAdministrativeEmployee() + totalSalarySalesEmployee() + totalSalaryTechnicalEmployee();
        }

        public void totalSalary () {
            String choine;
            while (true) {
                System.out.println("1. Total Salary Administrative Employee");
                System.out.println("2. Total Salary Technical Employee");
                System.out.println("3. Total Salary Sales Employee");
                System.out.println("4. Total Salary All");
                System.out.println("5. exit ");
                choine = scanner.nextLine();
                switch (choine) {
                    case "1" ->
                            System.out.println("Total Salary Administrative Employee : " + totalSalaryAdministrativeEmployee() + "\n");
                    case "2" ->
                            System.out.println("Total Salary Technical Employee : " + totalSalaryTechnicalEmployee() + "\n");
                    case "3" ->
                            System.out.println("Total Salary Sales Employee : " + totalSalarySalesEmployee() + "\n");
                    case "4" -> System.out.println("Total Salary All : " + totalSalaryAll() + "\n");
                    case "5" -> {
                        return;
                    }
                    default -> System.err.println(" not found choine  \n");

                }
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        private void write (Employee employee  ){
            try (FileWriter fileWriter = new FileWriter("Employee.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ) {
                bufferedWriter.write(String.valueOf(employee) + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        private boolean checkRollCall(){
            System.out.println("Id Employee Roll Call");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id){
                    int day = employees.get(i).getDay();
                    employees.get(i).setDay(++day);
                    return true;
                }
            }
            return false;
        }
       public void rollCall(){
        showAll();
          if (checkRollCall()){
              System.out.println("Successful Roll Call");
              try (FileWriter fileWriter = new FileWriter("Employee.txt");
                   BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
              ) {
                  for (Employee employee : employees) {
                      bufferedWriter.write(employee + "\n");
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }else
              System.out.println("Roll Call Failed");
       }











    }
