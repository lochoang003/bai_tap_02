package quanLySinhVien;

import quanLySinhVien.Crud.Student.CdruStudent;
import quanLySinhVien.point.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassStudent extends Student implements Serializable {
    private static int count;
    private String nameClass;
    private String classCode;
    private String teacher;
    private String nameRoom;
    private int studyTime;//số ngày
    private List<Student> studentsClass= new ArrayList<>();





    public ClassStudent() {
    }

    public ClassStudent(String nameClass, String teacher, String nameRoom, int studyTime) {
        this.nameClass = nameClass;
        this.classCode = "CLASS" + ++count;
        this.teacher = teacher;
        this.nameRoom = nameRoom;
        this.studyTime = studyTime;
        this.studentsClass = new ArrayList<>();
    }

    public String getNameClass() {
        return nameClass;
    }


    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getStudyTime() {
        return studyTime;
    }

    public List<Student> getStudents() {
        return studentsClass;
    }

    public void setStudents(List<Student> students) {
        this.studentsClass = students;
    }

    public void setStudyTime(int studyTime) {
        this.studyTime = studyTime;
    }

    public void addSt(Student student) {
        this.studentsClass.add(student);
    }

    public void editSt(int index, Student student) {
        studentsClass.set(index, student);
    }

    public void deleteSt(int index) {
        studentsClass.remove(index);
    }


    @Override
    public String toString() {
        return "ClassStudent" +
                ", " + classCode +
                ", " + nameClass +
                ", " + teacher +
                ", " + nameRoom +
                ", " + studyTime + "," + studentsClass;
    }


}
