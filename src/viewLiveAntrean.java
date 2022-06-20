import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hwpf.usermodel.DateAndTime;

public class viewLiveAntrean {
    public static Scanner inp = new Scanner(System.in);

  
        
            public static void Live(){
               String[] dataAntrean = refresh();
               System.out.println("|    No   | No Selanjutnya | Total Antrian  |");
               System.out.printf("| %7s | %14s | %7s |", dataAntrean[0], dataAntrean[1],dataAntrean[2] );
               System.out.println("\n Selanjutnya ?(y/n)");
               String refresh = inp.next();
               if( refresh.equalsIgnoreCase("y")){
                System.out.println("\n");
                    Live();
               }
            }
            public static String[] refresh(){
                String[] temp = ModelLiveAntrean.getCurrentQueue();
                return temp;
            }
}
