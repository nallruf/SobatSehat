import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class Init {
    public static void init() throws EncryptedDocumentException, IOException, FilloException{
        Date dt = new Date(); 

        Fillo fillo = new Fillo();
        Connection conn = fillo.getConnection("./src/data.xlsx");      
        
        int hours = dt.getHours();   
        // int hours = 13;
        if(hours< 12){
           
            String query = "Delete from antrean_sore";
            conn.executeUpdate(query);
            conn.close();
            if(Login.UserSession.getRole().equals("Admin")){
                ModelQueue.initQueue("antrean_pagi");
            }
            
        }else if(hours > 12){
            String query = "Delete from antrean_pagi";
            conn.executeUpdate(query);
            conn.close();
            if(Login.UserSession.getRole().equals("Admin")){
                ModelQueue.initQueue("antrean_sore");
            };
        }
    }

}
