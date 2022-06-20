
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hslf.usermodel.HSLFSheet;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ModelLiveAntrean {
    private static Workbook wb, wbb;
    private static org.apache.poi.ss.usermodel.Sheet sh, shh;
    private static FileInputStream fis, fiss;
    private static FileOutputStream fos, foss;
    private static Row row;
    private static Cell cell;
    private static Queue<String> queue;

    public static void initQueue(String jadwal) throws EncryptedDocumentException, IOException{
        queue= new LinkedList<>();

        fis = new FileInputStream("./src/data.xlsx");
        fiss = new FileInputStream("./src/data.xlsx");

        wb = WorkbookFactory.create(fis);
        wbb = WorkbookFactory.create(fiss);

        sh = wb.getSheet(jadwal);
        int lastRow = sh.getLastRowNum();
        
       
        
        for(int i = 1; i <= lastRow ;i++){
            String temp =sh.getRow(i).getCell(2).toString();
            queue.add(temp);
        }
        for (String x : queue) {
            shh = wbb.getSheet("queue");
            int lastRowQueue = shh.getLastRowNum();
            row = shh.createRow(lastRowQueue + 1);
            cell = row.createCell(0);
            // System.out.println(x);

            cell.setCellValue(x);
            fos = new FileOutputStream("./src/data.xlsx");
            wbb.write(fos);
            fos.flush();
            fos.close();
        }
        
        System.out.println(queue);
    }

	public static void addQueue(String value){
        queue.add(value);
    }

    public static String[] getCurrentQueue(){
        sh = wb.getSheet("queue");
        String current = queue.remove();
        // row = sh.getRow(1);
        // shh.removeRow(shh.getRow(1));
        // int rowIndex = sh.getRow
        int lastRowNum = sh.getLastRowNum();
        // sh.shiftRows(2,lastRowNum, -1);
        // HSSFRow sh = wb.getSheetAt(5);
        // HSSFRow row = sh.getRow(1);
        // sh.removeRow(row);
        sh.shiftRows(1, lastRowNum, -1);
        String next = queue.peek();
        String total = getTotalQueue();

        String[] data = {current, next, total};
        return data;
    }

    public static String getTotalQueue(){
        String total = Integer.toString(queue.size());
        return total;
    }
}
