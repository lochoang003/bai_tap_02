package quanLySinhVien;

import quanLySinhVien.point.Point;

import java.io.Serializable;

public class Student extends Point  implements Serializable {
    private static int count;
    private String name;
    private String studentCode;
    private String dateOfBirth;
    private String address;//địa chỉ
    private String phone;
    private String email;
    private Point points = new Point();

    public  Student(String name, String dateOfBirth, String address, String phone, String email) {
        this.name = name;
        this.studentCode = "ST"+ ++count;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.points = new Point();
    }

    public Student(){}





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Point getPoints() {
        return points;
    }

    public void setPoints(Point points) {
        this.points = points;
    }



    @Override
    public String toString() {
        return "\n Student, " + studentCode +
                ", " +  name+
                ", " + dateOfBirth +
                ", " + address +
                ", " + phone +
                "," + email + ", " + points ;
    }
}
