import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaftarAntrean {
    private static Workbook wb;
    private static Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;

    public static void Daftar() throws Exception{
        Scanner input = new Scanner(System.in);
        fis = new FileInputStream("./src/data.xlsx");
        wb = WorkbookFactory.create(fis);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nPage Daftar Antrean");

        System.out.println("\npilih waktu konsultasi: \n1. pagi \n2. sore");
        System.out.print("\npilhan: ");
        int waktu = input.nextInt();
        input.nextLine();
        String username = Login.UserSession.getId();

        switch(waktu){
            case 1:
                sh = wb.getSheet("antrean_pagi");
                int noOfRow = sh.getLastRowNum();
                int temp = noOfRow + 1;
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue(dtf.format(now) + "_PAGI_" + (noOfRow + 1));
                cell = row.createCell(1);
                cell.setCellValue(username);
                cell = row.createCell(2);
                cell.setCellValue(noOfRow + 1);
                cell = row.createCell(3);
                cell.setCellValue("PAGI");
                String no_antrean = Integer.toString(noOfRow + 1);
                System.out.println("\nnomor antrean anda: " + no_antrean);
                // ModelQueue.addQueue(no_antrean);
                sh = wb.getSheet("rekap");
                noOfRow = sh.getLastRowNum();
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue(dtf.format(now) + "_PAGI_" + temp);
                cell = row.createCell(1);
                cell.setCellValue(username);
                cell = row.createCell(2);
                cell.setCellValue(temp);
                cell = row.createCell(3);
                cell.setCellValue("PAGI");
                
                sh = wb.getSheet("queue");
                noOfRow = sh.getLastRowNum();
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue("baru");
                cell = row.createCell(1);
                cell.setCellValue(no_antrean);

                break;
            case 2:
                sh = wb.getSheet("antrean_sore");
                noOfRow = sh.getLastRowNum();
                temp = noOfRow + 1;
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue(dtf.format(now) + "_SORE_" + (temp));
                cell = row.createCell(1);
                cell.setCellValue(username);
                cell = row.createCell(2);
                cell.setCellValue(noOfRow + 1);
                cell = row.createCell(3);
                cell.setCellValue("SORE");
                System.out.println("\nnomor antrean anda: " + (temp));
                sh = wb.getSheet("rekap");
                noOfRow = sh.getLastRowNum();
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue(dtf.format(now) + "_SORE_" + temp);
                cell = row.createCell(1);
                cell.setCellValue(username);
                cell = row.createCell(2);
                cell.setCellValue(temp);
                cell = row.createCell(3);
                cell.setCellValue("SORE");

                sh = wb.getSheet("queue");
                noOfRow = sh.getLastRowNum();
                row = sh.createRow(noOfRow + 1);
                cell = row.createCell(0);
                cell.setCellValue("baru");
                cell = row.createCell(1);
                cell.setCellValue(temp);
        }

        fos = new FileOutputStream("./src/data.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();
    }
}