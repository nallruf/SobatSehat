import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fitur {
    public static Workbook wb;
    public static Sheet sh;
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static Row row;
    public static Cell cell;
    public static Scanner inp = new Scanner(System.in);
    public static char backMain;
    public static int menu, prev;

    public static void FileInput() throws IOException{
        fi = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fi);
    }

    public static void prev(){
        System.out.print("Apakah Anda ingin kembali ke halaman menu data antrean? (y/n) : ");
        prev = inp.next().charAt(0);
    }

}

