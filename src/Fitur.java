import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;

// import org.apache.commons.codec.digest.DigestUtils;
// import org.apache.poi.EncryptedDocumentException;

public class Fitur {
    public static Workbook wb;
    public static Sheet sh;
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static Row row;
    public static Cell cell;
    public static Scanner inp = new Scanner(System.in);
    public static int menu;

    public static void FileInput() throws IOException{
        fi = new FileInputStream("src/data.xlsx");
        wb = WorkbookFactory.create(fi);
    }

    public static void FileOutput() throws IOException{
        fo = new FileOutputStream("src/data.xlsx");
        wb.write(fo);
        fo.flush();
        fo.close();
    }

    public static void backMain(){
        System.out.println("Tekan enter untuk kembali ke halaman utama");
        inp.nextLine();
    }

}