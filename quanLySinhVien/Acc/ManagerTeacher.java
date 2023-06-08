/*
package quanLySinhVien.Acc;

import quanLySinhVien.Main.MainAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerTeacher {
     List<Admin> member = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void  login(){
        System.out.println("Input the account");
        String acc = scanner.nextLine();
        if (checkAcc(acc)){
            System.out.println("Input pass");
            String pass = scanner.nextLine();
            if (!checkPass(pass)){
                System.err.println("wrong password");
            }else {
                MainAdmin.admin();
            }
        }else
            System.err.println("wrong account");
    }
    public boolean checkAcc( String acc){
        for (Admin a:admins) {
            if (a.getAcc().equals(acc)){
                return true;
            }
        }
        return false;
    }
    public boolean checkPass( String pass){
        for (Admin a:admins) {
            if (a.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }


}
*/
