package quanLySinhVien.Class;

import quanLySinhVien.ClassStudent;
import quanLySinhVien.Crud.Student.CdruStudent;
import quanLySinhVien.Student;
import quanLySinhVien.point.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrudClass extends CdruStudent implements Serializable {


    public void crudPointByStudenByClass() {
        int checkClass = checkInputClass();
        if (checkClass != -1) {
            System.out.println("Input student code");
            String inputCode = scanner.nextLine();
            for (int i = 0; i < classStudents.get(checkClass).getStudents().size(); i++) {
                if (classStudents.get(checkClass).getStudents().get(i).getStudentCode().equals(inputCode)) {
                    classStudents.get(checkClass).getStudents().get(i).crudPoint();
                }

            }
            writeObject();
        }

    }


    public void crudSt_Class() {
        while (true) {
            System.out.println("1. add new students by class");
            System.out.println("2. add student by class");
            System.out.println("3. edit student");
            System.out.println("4. delete student by class");
            System.out.println("5. exit");
            String choine = scanner.nextLine();
            switch (choine) {
                case "1" -> addStudentByClass();
                case "2" -> addStudent_inListStudent();
                case "3" -> editStudentByClass();
                case "4" -> deleteStudentClass();
                case "5" -> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
//            write();
            writeObject();
        }

    }


    private int checkInputClass() {

        System.out.println("Input class code add student");
        String code = scanner.nextLine();
        for (int i = 0; i < classStudents.size(); i++) {
            if (classStudents.get(i).getClassCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    private void addStudentByClass() {
        int check = checkInputClass();
        if (check != -1) {
            ClassStudent classStudent = classStudents.get(check);
            classStudent.addSt(super.addStudent());
            System.out.println("more success");
        } else
            System.err.println("add failed");

    }

    private void addStudent_inListStudent() {
        int check = checkInputClass();
        if (check != -1) {
            System.out.println("Input student code add");
            String addStudentCode = scanner.nextLine();
            for (Student student : super.students) {
                if (student.getStudentCode().equals(addStudentCode)) {
                    classStudents.get(check).addSt(student);
                    return;
                }
            }
        }
        System.err.println("add failed");

    }

    private void editStudentByClass() {
        int check = checkInputClass();
        if (check != -1) {
            System.out.println("Input student code edit");
            String edit = scanner.nextLine();
            for (int i = 0; i < classStudents.get(check).getStudents().size(); i++) {
                if (classStudents.get(check).getStudents().get(i).getStudentCode().equals(edit)) {
                    classStudents.get(check).editSt(i, super.editStudent(edit));
                    System.out.println("successful edit");
                    return;
                }
            }
            System.err.println("edit failed");
        }
    }

    private void deleteStudentClass() {
        int check = checkIdClass();
        boolean checkDelete = false;
        if (check != -1) {
            System.out.println("Input student code delete");
            String delete = scanner.nextLine();
            for (int i = 0; i < classStudents.get(check).getStudents().size(); i++) {
                if (classStudents.get(check).getStudents().get(i).getStudentCode().equals(delete)) {
                    classStudents.get(check).deleteSt(i);
                    //  super.deleteStudent(delete);
                    System.out.println("successful delete");
                    checkDelete = true;
                    break;
                }
            }
            if (!checkDelete)
                System.err.println("delete failed");
        }

    }

    public void crudClass() {
        while (true) {
            System.out.println("1. add class");
            System.out.println("2. edit class");
            System.out.println("3. delete class");
            System.out.println("4. exit");
            String choine = scanner.nextLine();
            switch (choine) {
                case "1" -> addClass();
                case "2" -> editClass();
                case "3" -> deleteClass();
                case "4" -> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
            // write();
//            Point.writeObject();
        }
    }


    private void addClass() {
        String nameClass = inputclassRoom();
        String teacher = inputNameTeacher();
        String nameRoom = inputnameRoonm();
        int studyTime = inputTime();
        ClassStudent studentClass = new ClassStudent(nameClass, teacher, nameRoom, studyTime);
        classStudents.add(studentClass);
        //writeTrue(studentClass);
        writeObject();
    }

    private void editClass() {
        System.out.println("Input class code edit");
        int check = checkIdClass();
        if (check != -1) {
            classStudents.get(check).setNameClass(inputclassRoom());
            classStudents.get(check).setTeacher(inputNameTeacher());
            classStudents.get(check).setNameRoom(inputnameRoonm());
            classStudents.get(check).setStudyTime(inputTime());

        } else {
            System.err.println("Not found class code edit");

        }
        writeObject();
    }

    private void deleteClass() {
        System.out.println("Input class code delete");
        int check = checkIdClass();
        if (check != -1) {
            classStudents.remove(check);
        } else {
            System.err.println("Not found class code delete");
        }
        writeObject();
    }

    public void showOneClass() {
        System.out.println("Input id class");
        String id = scanner.nextLine();
        for (ClassStudent c : classStudents) {
            if (c.getClassCode().equals(id)) {
                System.out.println(c);
            }
        }
    }

    public void showAllClass() {
        for (ClassStudent c : classStudents) {
            System.out.println(c);
        }
    }


    private int checkIdClass() {

        String delete = scanner.nextLine();
        for (int i = 0; i < classStudents.size(); i++) {
            if (classStudents.get(i).getClassCode().equals(delete)) {
                return i;
            }
        }
        return -1;
    }


    private int inputTime() {

        boolean check;
        String time;
        while (true) {
            System.out.println("Input studytime");
            time = scanner.nextLine();
            check = checkTime(time);
            if (check) {
                return Integer.parseInt(time);
            }
            System.err.println("Wrong format");
        }

    }


    private boolean checkTime(String str) {
        Pattern pattern = Pattern.compile("^([0-9]{5})+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private String inputnameRoonm() {
        boolean check;
        String nameRoom;
        while (true) {
            System.out.println("Input room name");
            nameRoom = scanner.nextLine();
            check = checkNameRoomRegex(nameRoom);
            if (check) {
                return nameRoom;
            }
            System.err.println("Wrong format");
        }

    }

    private boolean checkNameRoomRegex(String str) {
        Pattern pattern = Pattern.compile("^(.{2,9})+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    private String inputNameTeacher() {
        boolean check;
        String name;
        while (true) {
            System.out.println("Teacher name");
            name = scanner.nextLine();
            check = checkNameTeacherRegex(name);
            if (check) {
                return capitalizeNameTeacher(name);
            }
            System.err.println("Wrong format");
        }

    }

    private boolean checkNameTeacherRegex(String str) {
        Pattern pattern = Pattern.compile("^([\\p{L}\\s]{2,})+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    // check tên
    private String capitalizeNameTeacher(String name) {
        String[] words = name.toLowerCase().split("\\s");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                capitalized.append(word.substring(1));
                capitalized.append(" ");
            }
        }
        return capitalized.toString().trim();
    }


    private String inputclassRoom() {
        boolean check;
        String classRoom;
        while (true) {
            System.out.println("Classroom name");
            classRoom = scanner.nextLine();
            check = checkClassRegex(classRoom);
            if (check) {
                return classRoom;
            }
            System.err.println("Wrong format");
        }
    }

    private boolean checkClassRegex(String str) {
        Pattern pattern = Pattern.compile("^(lớp|class|Lớp|Class)[ _]?[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}






