import java.io.*;
import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class DataAkun {
    private static Workbook wb;
    private static Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;
    private static int pilih;
    private static Scanner input = new Scanner(System.in); 
    
    public static void createAcc() throws Exception{
        fis = new FileInputStream("src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        String email, password, username, alamat;

        System.out.println("-------BUAT AKUN-------");
        System.out.print("Masukkan nama anda: ");
        username = input.next();
        System.out.print("Buat E-mail: ");
        email = input.next();
        System.out.print("Buat Password: ");
        password = DigestUtils.md5Hex(input.next());
        input.nextLine();
        System.out.print("Masukan alamat: ");
        alamat = input.nextLine();
        userAcc user = new userAcc(email, password, username, alamat);

        sh = wb.getSheet("pasien");
        int noOfRow = sh.getLastRowNum();
        row = sh.createRow(noOfRow + 1);
        cell = row.createCell(0);
        cell.setCellValue(noOfRow + 1);
        cell = row.createCell(1);
        cell.setCellValue(userAcc.getUsername());
        cell = row.createCell(2);
        cell.setCellValue(userAcc.getEmail());
        cell = row.createCell(3);
        cell.setCellValue(userAcc.getPassword());
        cell = row.createCell(4);
        cell.setCellValue(userAcc.getAdd());
            
        fos = new FileOutputStream("src/data.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();
        System.out.print("Akun sukses dibuat!");

    }

    public static void viewData() throws EncryptedDocumentException, IOException {
        fis = new FileInputStream("src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("pasien");
        int noOfRow = sh.getLastRowNum();
        System.out.println("Data Pasien");
        System.out.println("-------------------");
        
        for(int i = 1; i <= noOfRow; i++){
            System.out.print("Id user: ");
            System.out.print(sh.getRow(i).getCell(0)+"\n");
            System.out.print("Username: ");
            System.out.print(sh.getRow(i).getCell(1)+"\n");
            System.out.print("E-mail: ");
            System.out.print(sh.getRow(i).getCell(2)+"\n");
            System.out.print("Alamat: ");
            System.out.print(sh.getRow(i).getCell(4)+"\n");
            System.out.println("\n");
        }
        
        fos = new FileOutputStream("src/data.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();
        } 
    
}
