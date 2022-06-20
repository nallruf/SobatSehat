/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package SohibulSehat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Login {
    private static Workbook wb;
    private static Sheet sh;
    private static FileInputStream fi;
    private static FileOutputStream fo;
    private static Row row;
    private static Cell cell;
    private static Scanner input = new Scanner(System.in);
    public static Session UserSession;
    
    public static void main(String[] args) throws Exception {

        
        System.out.println("----------------------------------------");
        System.out.println("|                LOG IN                |");
        System.out.println("|            SOHIBUL  SEHAT            |");
        System.out.println("----------------------------------------");

        System.out.println("\nSiapa anda? \n1. Pasien \n2. Admin");
        System.out.print("Pilihan : ");
        int pilih = input.nextInt();
        System.out.println();

        switch(pilih){
            case 1 :
                System.out.println("----------------------------------------");
                System.out.println("|            LOG IN  PASIEN            |");
                System.out.println("----------------------------------------");
                while (login("Pasien")==false){
                    System.out.println("\nMohon maaf, email atau password anda salah! \nSilakan coba lagi :) \n");
                    System.out.println("----------------------------------------");
                    System.out.println("|            LOG IN  PASIEN            |");
                    System.out.println("----------------------------------------");
                }
                break;

            case 2 :
                System.out.println("----------------------------------------");
                System.out.println("|             LOG IN ADMIN             |");
                System.out.println("----------------------------------------");
                while (login("Admin")==false){
                    System.out.println("\nMohon maaf, email atau password anda salah! \nSilakan coba lagi :) \n");
                    System.out.println("----------------------------------------");
                    System.out.println("|             LOG IN ADMIN             |");
                    System.out.println("----------------------------------------");
                }
                break;
        }
        MenuUtama.Menu();

    }

    private static Boolean login(String role) throws EncryptedDocumentException, IOException {
    
        fi = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fi);
        sh = wb.getSheet(role.toLowerCase());
        System.out.print("Email : ");
        String email = input.next();
        input.nextLine();
        System.out.print("Password : ");
        String pass = DigestUtils.md5Hex(input.nextLine());
        
        int sumRow = sh.getLastRowNum();
                
        for (int i = 1; i <= sumRow; i++) {
            if ((String.valueOf(sh.getRow(i).getCell(2)).equals(email)) && (String.valueOf(sh.getRow(i).getCell(3)).equals(pass))){
                    System.out.println("\nSELAMAT DATANG "+ String.valueOf(sh.getRow(i).getCell(1)).toUpperCase()+ "!^^ \n");
                    String idUser = String.valueOf(sh.getRow(i).getCell(0));
                    String namaUser = String.valueOf(sh.getRow(i).getCell(1));
                    String emailUser = String.valueOf(sh.getRow(i).getCell(2));
                    String passUser = String.valueOf(sh.getRow(i).getCell(3));
                    String alamatUser = String.valueOf(sh.getRow(i).getCell(4));
                    UserSession = new Session( idUser,  namaUser,  emailUser,  passUser,  alamatUser, role);
                    return true;
                } 
        }
        return false;
    }

}