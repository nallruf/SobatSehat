import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

public class AkunSaya extends Fitur{
    public static void Akun() throws EncryptedDocumentException, IOException {
        FileInput();
        sh = wb.getSheet("pasien");
        String idUser = Login.UserSession.getId();
        int lastRow = sh.getLastRowNum();
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("|                                 AKUN SAYA                                 |");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|    ID Akun    |    Nama    |        E-Mail        |          Alamat       |");
        for(int i = 1; i <= lastRow ;i++){
            String tempId = sh.getRow(i).getCell(0).toString();
            // int target = Integer.getInteger(tempId);
            // String value = new String(sh.getRow(i).getCell(1));

            if( tempId.equals(idUser)){
                System.out.printf("| %13s | %10s | %20s | %21s |",sh.getRow(i).getCell(0),sh.getRow(i).getCell(1),sh.getRow(i).getCell(2),sh.getRow(i).getCell(4) );
                System.out.println("\n-----------------------------------------------------------------------------");
            }
        }
        backMain();
    }
}