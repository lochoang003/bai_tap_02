package quanLySinhVien.Crud.Student;

import quanLySinhVien.Student;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int nameCompare = s1.getName().compareTo(s2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            int compare = s1.getStudentCode().compareTo(s2.getStudentCode());
            return compare;
        }
    }
}