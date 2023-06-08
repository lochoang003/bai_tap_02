package quanLySinhVien.point;

import quanLySinhVien.ClassStudent;
import quanLySinhVien.Student;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Point implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
    private static List<Double> test15p = new ArrayList<>();
    private static List<Double> test45p = new ArrayList<>();
    private static List<Double> semesterTest = new ArrayList<>();


   static File file = new File("School.txt");
  static   File fileSt = new File("Student.txt");
    protected static List<ClassStudent> classStudents;
    public static List<Student> students;

   static  {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (!fileSt.exists()) {
            try {
                fileSt.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

   static  {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            classStudents = (List<ClassStudent>) objectInputStream.readObject();

        } catch (Exception e) {
            classStudents = new ArrayList<>();
            e.printStackTrace();
        }


        try (FileInputStream fileInputStream = new FileInputStream(fileSt);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            students = (List<Student>) objectInputStream.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
            e.printStackTrace();
        }
    }


    /*   public  void write(){
         try(  FileWriter fileWriter = new FileWriter("School.txt");
               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
             for (ClassStudent c : classStudents ) {
                   bufferedWriter.write(c.toString()+"\n");
             }
         }catch (Exception e){
               e.printStackTrace();
         }
       }*/
    public static void writeObject() {
        try (FileOutputStream fis = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(classStudents);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileOutputStream fis = new FileOutputStream(fileSt);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Point() {
    }


    private boolean checkSemester() {
        return this.semesterTest.size() > 2;
    }

    private boolean check45p() {
        return this.test45p.size() > 3;
    }

    private boolean check15p() {
        return this.test15p.size() > 5;
    }

    private double test45pMedium() {
        boolean check = check45p();
        if (!check) {
            double count = 0.0;
            for (Double d : test45p) {
                count += d;
            }
            return count / test45p.size();
        }
        System.err.println("score 45 minutes exceeding regulations //   số lượng điểm 45 phút vượt quy định");
        return -1;
    }

    private double test15pMedium() {
        boolean check = check15p();
        if (!check) {
            double count = 0.0;
            for (Double d : test15p) {
                count += d;
            }
            return count / test15p.size();
        }
        System.err.println("score 15 minutes exceeding regulations //   số lượng điểm 15 phút vượt quy định");
        return -1;
    }

    private double semesterTestMedium() {
        boolean check = checkSemester();
        if (!check) {
            double count = 0.0;
            for (Double d : semesterTest) {
                count += d;
            }
            return count / semesterTest.size();
        }
        System.err.println("score semester test exceeding regulations //   số lượng điểm học kỳ vượt quy định");
        return -1;
    }

    public double mediumScore() {
        double test15p = test15pMedium();
        double test45p = test45pMedium();
        double semesterTest = semesterTestMedium();
        if (test15p != -1 && test45p != -1 && semesterTest != -1) {
            return (test15p + test45p + semesterTest) / 3;
        }
        return -1;
    }

    private int checkIndex15p(int index) {
        for (int i = 0; i < test15p.size(); i++) {
            if (i == index) {
                return i;
            }
        }
        return -1;
    }

    private int checkIndex45p(int index) {
        for (int i = 0; i < test45p.size(); i++) {
            if (i == index) {
                return i;
            }
        }
        return -1;
    }

    private int checkIndexsemesterTest(int index) {
        for (int i = 0; i < semesterTest.size(); i++) {
            if (i == index) {
                return i;
            }
        }
        return -1;
    }

    private void editTest15p() {
        System.out.println("Input index edit");
        int index = Integer.parseInt(scanner.nextLine());
        int temp = checkIndex15p(index);
        if (temp != -1) {
            System.out.println(" 15 minutes edit");
            double edit15p = Double.parseDouble(scanner.nextLine());
            test15p.set(temp, edit15p);
        } else
            System.out.println("not found index");
    }

    private void editTest45p() {
        System.out.println("Input index edit");
        int index = Integer.parseInt(scanner.nextLine());
        int temp = checkIndex45p(index);
        if (temp != -1) {
            System.out.println(" 45 minutes edit");
            double edit45p = Double.parseDouble(scanner.nextLine());
            test45p.set(temp, edit45p);
        } else
            System.out.println("not found index");
    }

    private void editSemesterTest() {
        System.out.println("Input index edit");
        int index = Integer.parseInt(scanner.nextLine());
        int temp = checkIndexsemesterTest(index);
        if (temp != -1) {
            System.out.println(" 15 minutes edit");
            double semester = Double.parseDouble(scanner.nextLine());
            semesterTest.set(temp, semester);
        } else
            System.out.println("not found index");
    }

    private void add15p() {
        System.out.println("extra points 15 minutes");
        double add15p = Double.parseDouble(scanner.nextLine());
        test15p.add(add15p);
    }

    private void add45p() {
        System.out.println("extra points 45 minutes");
        double add45p = Double.parseDouble(scanner.nextLine());
        test45p.add(add45p);
    }

    private void addSemesterTest() {
        System.out.println("extra points Semester Test");
        double addSemesterTest = Double.parseDouble(scanner.nextLine());
        semesterTest.add(addSemesterTest);
    }

    private void delete15p() {
        System.out.println("remove points 15 minutes by index");
        int temp = checkIndex15p(Integer.parseInt(scanner.nextLine()));
        if (temp != -1) {
            test15p.remove(temp);
        } else
            System.out.println("not found index");
    }

    private void delete45p() {
        System.out.println("remove points 45 minutes by index");
        int temp = checkIndex45p(Integer.parseInt(scanner.nextLine()));
        if (temp != -1) {
            test45p.remove(temp);
        } else
            System.out.println("not found index");
    }

    private void deleteSemesterTest() {
        System.out.println("remove points Semester Test by index");
        int temp = checkIndexsemesterTest(Integer.parseInt(scanner.nextLine()));
        if (temp != -1) {
            semesterTest.remove(temp);
        } else
            System.out.println("not found index");
    }

    public void crudPoint() {
        while (true) {
            System.out.println("1. add point");
            System.out.println("2. edit point");
            System.out.println("3. delete point");
            System.out.println("4. exit");
            String choine = scanner.nextLine();
            switch (choine) {
                case "1" -> add();
                case "2" -> edit();
                case "3" -> delete();
                case "4" -> {
                    return;
                }
            }

        }
    }

    private void add() {
        System.out.println("1. add points 15 minutes");
        System.out.println("2. add points 45 minutes");
        System.out.println("3. add points Semester Test");
        System.out.println("4. exit");
        String choine = scanner.nextLine();
        switch (choine) {
            case "1" -> add15p();
            case "2" -> add45p();
            case "3" -> addSemesterTest();
            case "4" -> {
                return;
            }
            default -> System.err.println(" not found choine");
        }
        writeObject();

    }

    private void edit() {
        System.out.println("1. edit points 15 minutes");
        System.out.println("2. edit points 45 minutes");
        System.out.println("3. edit points Semester Test");
        System.out.println("4. exit");
        String choine = scanner.nextLine();
        switch (choine) {
            case "1" -> editTest15p();
            case "2" -> editTest45p();
            case "3" -> editSemesterTest();
            case "4" -> {
                return;
            }
            default -> System.err.println(" not found choine");
        }
        writeObject();
    }

    private void delete() {
        System.out.println("1. delete points 15 minutes");
        System.out.println("2. delete points 45 minutes");
        System.out.println("3. delete points Semester Test");
        System.out.println("4. exit");
        String choine = scanner.nextLine();
        switch (choine) {
            case "1" -> delete15p();
            case "2" -> delete45p();
            case "3" -> deleteSemesterTest();
            case "4" -> {
                return;
            }
            default -> System.err.println(" not found choine");
        }
        writeObject();
    }

    private double mediumScore15p() {
        double count15p = 0;
        for (Double d : test15p) {
            count15p += d;
        }
        return count15p / test15p.size();
    }

    private double mediumScore45p() {
        double count45p = 0;
        for (Double d : test45p) {
            count45p += d;
        }
        return count45p / test45p.size();
    }

    private double mediumSemesterTest() {
        double countSemesterTest = 0;
        for (Double d : semesterTest) {
            countSemesterTest += d;
        }
        return countSemesterTest / semesterTest.size();
    }

    public double mediumScore0() {
        return (mediumScore15p() + mediumScore45p() + mediumScore45p() + mediumSemesterTest() * 3) / 6;


    }

    public String learningAbility() {
        double check = mediumScore0();
        if (check >= 7.5) {
            return "học lực giỏi " + check;
        } else if (check >= 6.5) {
            return "học lực khá " + check;
        } else if (check >= 5.5) {
            return "học lực trung bình " + check;
        } else if (check >= 4.5) {
            return "học lực trung bình  khá " + check;
        }
        return "học lực yếu " + check;

    }


    public List<Double> getTest15p() {
        return test15p;
    }

    public void setTest15p(List<Double> test15p) {
        this.test15p = test15p;
    }

    public List<Double> getTest45p() {
        return test45p;
    }

    public void setTest45p(List<Double> test45p) {
        this.test45p = test45p;
    }

    public List<Double> getSemesterTest() {
        return semesterTest;
    }

    public void setSemesterTest(List<Double> semesterTest) {
        this.semesterTest = semesterTest;
    }


    @Override
    public String toString() {
        return
                test15p +
                        ", " + test45p +
                        ", " + semesterTest;
    }
}
