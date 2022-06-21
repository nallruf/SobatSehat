import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.poi.EncryptedDocumentException;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;


public class ModelQueue extends Fitur {
    private static Queue<String> queue;

    public static void initQueue(String jadwal) throws EncryptedDocumentException, IOException{
        queue= new LinkedList<>();
        FileInput();
        sh = wb.getSheet("queue");
        int lastRow = sh.getLastRowNum();
        row = sh.createRow(lastRow + 1);
        cell = row.createCell(0);
        cell.setCellValue("true");
        cell = row.createCell(1);
        cell.setCellValue("next");

        FileOutput();
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
            FileOutput();
        }
    }

    public static String[] getCurrentQueue(int target) throws Exception{
        FileInput();
        sh = wb.getSheet("queue");
        int lastRow = sh.getLastRowNum();
        row = sh.getRow(target);
        cell = row.getCell(0);
        cell.setCellValue("true");
        FileOutput();

        Fillo fillo = new Fillo();
        Connection conn = fillo.getConnection("./src/data.xlsx");
        String query = "Delete from queue where status='true'";
        conn.executeUpdate(query);
        conn.close();

        FileInput();
        sh = wb.getSheet("queue");
        lastRow = sh.getLastRowNum();
        row = sh.getRow(lastRow);
        String isUpdate = row.getCell(0).toString();
        if(isUpdate.equalsIgnoreCase("baru")){
            String dataBaru = row.getCell(1).toString();
            sh = wb.getSheet("queue");
            lastRow = sh.getLastRowNum();
            row = sh.getRow(lastRow);
            cell = row.getCell(0);
            cell.setCellValue("false");
            FileOutput();
            queue.add(dataBaru);
            isUpdate = "";
        }

        if(queue.size() > 0){
            String current = queue.remove();
            String next = queue.peek();
            String total = getTotalQueue();
            String[] data = {current, next, total};
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