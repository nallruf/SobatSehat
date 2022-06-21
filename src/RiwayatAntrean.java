import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

public class RiwayatAntrean extends Fitur {
    public static void data() throws EncryptedDocumentException, IOException {
        FileInput();
        sh = wb.getSheet("rekap");
        String idUser = Login.UserSession.getId();
        int lastRow = sh.getLastRowNum();
        System.out.println("\n---------------------------------------------------");
        System.out.println("|               Riwayat Antrean Saya              |");
        System.out.println("---------------------------------------------------");
        System.out.println("|    ID Antrean     | No Antrean | Jadwal Antrean |");
        for(int i = 1; i <= lastRow ;i++){
            String tempId = sh.getRow(i).getCell(1).toString();
            if( tempId.equals(idUser)){
                System.out.printf("|%18s | %10s | %14s |", sh.getRow(i).getCell(0),sh.getRow(i).getCell(2),sh.getRow(i).getCell(3));
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        backMain();
    }
}