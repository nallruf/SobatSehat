import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AkunSaya {
    private static Workbook wb;
    private static org.apache.poi.ss.usermodel.Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;

    public static void Akun() throws EncryptedDocumentException, IOException {
        fis = new FileInputStream("src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("pasien");
        String idUser = Login.UserSession.getId();
        int lastRow = sh.getLastRowNum();
        System.out.println("Akun Saya");
        System.out.println("------------------------------");
        for(int i = 1; i <= lastRow ;i++){
            String tempId = sh.getRow(i).getCell(0).toString();
            // int target = Integer.getInteger(tempId);
            // String value = new String(sh.getRow(i).getCell(1));
            
            if( tempId.equals(idUser)){
                System.out.print("ID Akun : ");
                System.out.print(sh.getRow(i).getCell(0)+"\n");
                System.out.print("Nama  : ");
                System.out.print(sh.getRow(i).getCell(1)+"\n");
                System.out.print("Email : ");
                System.out.print(sh.getRow(i).getCell(2)+"\n");
                System.out.print("Alamat : ");
                System.out.print(sh.getRow(i).getCell(4)+"\n");
                System.out.println("------------------------------");
            }
        }        

    }
}
