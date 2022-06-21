import java.io.*;
import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.EncryptedDocumentException;

public class DataAkun extends Fitur{
    private static int pilih;

    public static void createAcc() throws Exception{
        FileInput();
        String email, password, username, alamat;

        System.out.println("-------BUAT AKUN-------");
        System.out.println("Masukkan Nama Anda! ");
        System.out.println("Maksimal 15 karakter termasuk spasi");
        System.out.print("Nama: ");
        username = inp.next();
        System.out.println("Buat E-Mail Anda! ");
        System.out.println("Maksimal 20 karakter, tidak boleh spasi spasi");
        System.out.print("E-Mail: ");
        email = inp.next();
        System.out.println("Buat Password Anda! ");
        System.out.println("Maksimal 14 karakter, tidak boleh spasi");
        System.out.print("Password: ");
        password = DigestUtils.md5Hex(inp.next());
        inp.nextLine();
        System.out.println("Masukkan Alamat Anda! ");
        System.out.println("Maksimal 22 karakter termasuk spasi");
        System.out.print("Alamat: ");
        alamat = inp.nextLine();
        userAcc user = new userAcc(email, password, username, alamat);

        sh = wb.getSheet("pasien");
        int noOfRow = sh.getLastRowNum();
        row = sh.createRow(noOfRow + 1);
        cell = row.createCell(0);
        cell.setCellValue((noOfRow+1) + "_PASIEN");
        cell = row.createCell(1);
        cell.setCellValue(userAcc.getUsername());
        cell = row.createCell(2);
        cell.setCellValue(userAcc.getEmail());
        cell = row.createCell(3);
        cell.setCellValue(userAcc.getPassword());
        cell = row.createCell(4);
        cell.setCellValue(userAcc.getAdd());

        fo = new FileOutputStream("src/data.xlsx");
        wb.write(fo);
        fo.flush();
        fo.close();
        System.out.println("Akun sukses dibuat!");
        backMain();
    }

    /**
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public static void viewData() throws EncryptedDocumentException, IOException {
        FileInput();
        sh = wb.getSheet("pasien");
        int noOfRow = sh.getLastRowNum();
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("|                               DATA PASIEN                               |");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("|  Id User  |   Username   |        E-Mail        |          Alamat       |");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 1; i <= noOfRow; i++) {
            System.out.printf("|%10s | %12s | %20s | %21s |", sh.getRow(i).getCell(0).toString(), sh.getRow(i).getCell(1).toString(), sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(4).toString() );
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------");
        FileOutput();
        backMain();
    }
}