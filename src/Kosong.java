import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

class Kosong{
    // public static void main(String[] args) {
           public static void main(String[] args) throws FilloException  {

            
            Fillo fillo = new Fillo();
            Connection conn = fillo.getConnection("./src/data.xlsx"); 
            // int hours = dt.getHours(); 
               
                String query = "Delete from antrean_sore";
                conn.executeUpdate(query);
                
                String query2 = "Delete from antrean_pagi";
                conn.executeUpdate(query2);
    
    
                String query3 = "Delete from queue";
            conn.executeUpdate(query3);
            conn.close();
    
                // conn.close();
    
            }
    }
