package quanLySinhVien.Crud.Student;

import quanLySinhVien.ClassStudent;
import quanLySinhVien.Student;
import quanLySinhVien.point.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CdruStudent  extends Point implements Serializable {




    public Student addStudent() {
        String name = inputName();

        String birthDay = inputbirthDay();

        String ress = inputAddress();

        String phone = addPhone();

        String email = addEmail();

        Student student = new Student(name, birthDay, ress, phone, email);
        students.add(student);

        return student;
    }

    public void crud_Student(){
        while (true) {
            System.out.println("1. add student");
            System.out.println("2. edit student");
            System.out.println("3. delete student");
            System.out.println("4. exit");
            String choine = scanner.nextLine();
            switch (choine) {
                case "1" -> addStudent();
                case "2" -> {
                    System.out.println("Input class code edit");
                    String edit = scanner.nextLine();
                    editStudent(edit);
                }
                case "3" -> {
                    System.out.println("Input class code delete");
                    String delete = scanner.nextLine();
                    deleteStudent(delete);
                }
                case "4" -> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
           // write();
           writeObject( );
        }

    }



    public Student editStudent(String str) {

        int check = checkIdStudent(str);
        if (check != -1) {
            students.get(check).setName(inputName());
            students.get(check).setDateOfBirth(inputbirthDay());
            students.get(check).setAddress(inputAddress());
            students.get(check).setPhone(inputPhone());
            students.get(check).setEmail(inputEmail());
           return students.get(check);
        }else
            System.err.println("Not found student code edit");
        return null;
    }

    public void deleteStudent(String str) {

        int check = checkIdStudent(str);
        if (check != -1) {
            students.remove(check);
        } else
            System.err.println("Not found student code delete");
    }
    public void arrangeName(){
        Collections.sort(students,new StudentNameComparator());
    }
    public void showAll(){
        for (Student s :students    ) {
            System.out.println(s.toString());
        }
    }
    public void showOne(){
        System.out.println("Input id student");
        String id = scanner.nextLine();
        for (Student s :students    ) {
            if (s.getStudentCode().equals(id)){
                System.out.println(s);
                return;
            }
        }
        System.err.println("Not found student code ");
    }




    protected int checkIdStudent(String str) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentCode().equals(str)) {
                return i;
            }
        }
        return -1;
    }
    private String addEmail() {
        while (true) {
            String check = inputEmail();
            for (Student s : students) {
                if (s.getEmail().equals(check)) {
                    System.err.println("Same student email");
                }
            }

            return check;
        }

    }

    private String inputEmail() {
        boolean check;
        String email;
        while (true) {
            System.out.println("Student email");
            email = scanner.nextLine();
            check = checkEmailRegex(email);
            if (check)
                return email;
            System.err.println("Wrong format");
        }
    }

    private boolean checkEmailRegex(String str) {
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private String addPhone() {
        while (true) {
            String check = inputPhone();
            for (Student s : students) {
                if (s.getPhone().equals(check)) {
                    System.err.println("Same student phone");
                }
            }
            return check;
        }
    }

    private String inputPhone() {
        boolean check;
        String phone;
        while (true) {
            System.out.println("Student phone");
            phone = scanner.nextLine();
            check = checkPhoneRegex(phone);
            if (check)
                return phone;
            System.err.println("Wrong format");
        }
    }

    private boolean checkPhoneRegex(String str) {
        Pattern pattern = Pattern.compile("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private String inputAddress() {
        boolean check;
        String address;
        while (true) {
            System.out.println("Student address");
            address = scanner.nextLine();
            check = checkAddressRegex(address);
            if (check)
                return address;
            System.err.println("Wrong format");
            System.out.println("123A đường Lê Lai, phường Bến Thành, quận 1, thành phố Hồ Chí Minh");
        }
    }

    private boolean checkAddressRegex(String str) {
        Pattern pattern = Pattern.compile("^\\d{1,3}[A-Za-z]?\\s+(đường|phố|ấp|thôn|tổ|khu|ngách|ngõ|hẻm|lô|đặc khu)\\s+[\\p{L}\\d\\s,/\\-.()]+(,\\s+[\\p{L}\\d\\s,/\\-.()]+)*,\\s+(phường|xã|thị trấn|thành phố|quận|huyện|tỉnh)\\s+[\\p{L}\\s/-]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    private String inputbirthDay() {
        boolean check;
        String birth;
        do {
            System.out.println("Student birth day 'dd MM yyyy'");
            birth = scanner.nextLine();
            check = checkBirthDayRegex(birth);
            if (!check) {
                System.err.println("Wrong format");
            }
        } while (!check);
        return birth;
    }


    private boolean checkBirthDayRegex(String birthDay) {
        Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[- /. ](0?[1-9]|1[012])[- /. ](19|20)?[0-9]{2}$");
        Matcher matcher = pattern.matcher(birthDay);
        return matcher.matches();
    }

    private String inputName() {
        boolean check;
        String name;
        while (true){
            System.out.println("Student name");
            name = scanner.nextLine();
            check = checkNameRegex(name);
            if (check){
                return capitalizeName(name);
            }
            System.err.println("Wrong format");
        }


    }
    private boolean checkNameRegex(String str){
        Pattern pattern = Pattern.compile("^([\\p{L}\\s]{2,})+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
// check tên
    private String capitalizeName(String name) {
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
}
