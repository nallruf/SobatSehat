import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DaftarAntrean extends Fitur{

    public static void Daftar() throws Exception{
        FileInput();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nPage Daftar Antrean");

        System.out.println("Pilih waktu konsultasi: " +
                "\n\t1. Pagi " +
                "\n\t2. Sore" +
                "\n\t3. Kembali ke halaman utama");
        System.out.print("Pilhan Menu(1/2/3): ");
        menu = inp.nextInt();
        inp.nextLine();
        String username = Login.UserSession.getId();
        System.out.println("\n--------------------------");
        switch(menu){
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
        FileOutput();

        System.out.println("--------------------------");
        backMain();
    }
}