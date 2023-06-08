package quanLySinhVien.Acc;


import quanLySinhVien.Main.MainAdmin;
import quanLySinhVien.Main.MainClass;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAdmin implements Serializable {


    static Scanner scanner = new Scanner(System.in);
    final String ADMIN_ACC = "admin";
    final String ADMIN_PASS = "123";
    static File file = new File("Acc_Pass.txt");
    static List<Admin> admins ;
    static {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            List<Admin> admins1;
            admins = (List<Admin>) objectInputStream.readObject();

        } catch (Exception e) {
            admins = new ArrayList<>();
            e.printStackTrace();
        }

    }

    public static void write() {
        try (FileOutputStream fis = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(admins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void add() {
        System.out.println("Input new account");
        String acc = scanner.nextLine();
        System.out.println("Input new pass");
        String pass = scanner.nextLine();
        admins.add(new Admin(acc, pass));
        System.out.println("Sign Up Success");
        write();
    }

    public void menu() {
        while (true) {
            System.out.println("1. log in");
            System.out.println("2. register");
            System.out.println("3. exit");
            String choine = scanner.nextLine();
            switch (choine) {
                case "1" -> login();
                case "2" -> add();
                case "3" -> {
                    return;
                }
                default -> System.err.println("not found choine");
            }
        }
    }

    public void login() {
        System.out.println("Input the account");
        String acc = scanner.nextLine();
        int checkA = checkAcc(acc);
        if (acc.equals(ADMIN_ACC)) {
            System.out.println("Input pass");
            String pass = scanner.nextLine();
            if (!pass.equals(ADMIN_PASS)) {
                System.err.println("wrong password");
            } else {
                MainAdmin.admin();
            }
        } else if (checkA != -1) {
            System.out.println("Input pass");
            String pass = scanner.nextLine();
            if (!checkPass(checkA, pass)) {
                System.err.println("wrong password");
            } else {
                MainClass.mainCLASS();
            }
        } else
            System.err.println("wrong account");

    }

    public int checkAcc(String acc) {
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getAcc().equals(acc)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkPass(int idex, String pass) {
        return admins.get(idex).getPass().equals(pass);
    }


}
