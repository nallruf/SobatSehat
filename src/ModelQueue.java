import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;


public class ModelQueue {
    private static Workbook wb;
    private static org.apache.poi.ss.usermodel.Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;
    private static Queue<String> queue;

    public static void initQueue(String jadwal) throws EncryptedDocumentException, IOException{
        queue= new LinkedList<>();

        fis = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fis);

        sh = wb.getSheet("queue");
        int lastRow = sh.getLastRowNum();
        row = sh.createRow(lastRow + 1);
        cell = row.createCell(0);
        cell.setCellValue("true");
        cell = row.createCell(1);
        cell.setCellValue("next");
        fos = new FileOutputStream("./src/data.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();

        sh = wb.getSheet(jadwal);
         lastRow = sh.getLastRowNum();     
        
        for(int i = 1; i <= lastRow ;i++){
            String temp =sh.getRow(i).getCell(2).toString();
            queue.add(temp);
        }

        for (String x : queue) {
            sh = wb.getSheet("queue");
            int lastRowQueue = sh.getLastRowNum();
            row = sh.createRow(lastRowQueue + 1);
            cell = row.createCell(0);
            cell.setCellValue("false");
            cell = row.createCell(1);
            cell.setCellValue(x);
            fos = new FileOutputStream("./src/data.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
        }
    }

    public static String[] getCurrentQueue(int target) throws Exception{
        fis = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("queue");
        int lastRow = sh.getLastRowNum();
        row = sh.getRow(target);
        cell = row.getCell(0);
        cell.setCellValue("true");
        fos = new FileOutputStream("./src/data.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();

        Fillo fillo = new Fillo();
        Connection conn = fillo.getConnection("./src/data.xlsx");
        String query = "Delete from queue where status='true'";  
        conn.executeUpdate(query);
        conn.close();

        fis = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("queue");
        lastRow = sh.getLastRowNum();
        row = sh.getRow(lastRow);
            String isUpdate = row.getCell(0).toString();
            if(isUpdate.equalsIgnoreCase("baru")){
                String dataBaru = row.getCell(1).toString();
                System.out.println("posisi update"+ dataBaru);
                sh = wb.getSheet("queue");
                lastRow = sh.getLastRowNum();
                row = sh.getRow(lastRow);
                cell = row.getCell(0);
                cell.setCellValue("false");
                fos = new FileOutputStream("./src/data.xlsx");
                wb.write(fos);
                fos.flush();
                fos.close();
                queue.add(dataBaru);
                isUpdate = "";
            }
        
        if(queue.size() > 0){
            String current = queue.remove();
            String next = queue.peek();
            String total = getTotalQueue();
            String[] data = {current, next, total};
            System.out.println("Test");
            return data;
        }
        System.out.println("Test2");
        String temp = "Antrean Habis";
        String[] data = {temp, temp, temp};
        return data;
    }

    public static String getTotalQueue(){
        String total = Integer.toString(queue.size());
        return total;
    }
}
