import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RiwayatAntrean {
    private static Workbook wb;
    private static org.apache.poi.ss.usermodel.Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;
    
    public static void data() throws EncryptedDocumentException, IOException {
        fis = new FileInputStream("src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("rekap");
        String idUser = Login.UserSession.getId();
        int lastRow = sh.getLastRowNum();
        System.out.println("Antrean Saya");
        System.out.println("------------------------------");
        for(int i = 1; i <= lastRow ;i++){
            String tempId = sh.getRow(i).getCell(1).toString();
            // int target = Integer.getInteger(tempId);
            // String value = new String(sh.getRow(i).getCell(1));
            
            if( tempId.equals(idUser)){
                System.out.print("ID Antrean : ");
                System.out.print(sh.getRow(i).getCell(0)+"\n");
                System.out.print("No Antrean : ");
                System.out.print(sh.getRow(i).getCell(2)+"\n");
                System.out.print("Jadwal Antrean : ");
                System.out.print(sh.getRow(i).getCell(3)+"\n");
                System.out.println("------------------------------");
            }

            System.out.println("Tekan enter untuk kembali ke halaman utama");
            // inp.nextLine();
        }        

        


        
    
    }
}
