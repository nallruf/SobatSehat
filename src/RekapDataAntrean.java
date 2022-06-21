import java.io.IOException;

public class RekapDataAntrean extends Fitur {
    public static void RekapAntrian() throws IOException {
        FileInput();

        sh = wb.getSheet("rekap");
        int sumRow = sh.getLastRowNum();

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("|                       REKAP DATA ANTREAN                       |");
        System.out.println("------------------------------------------------------------------");
        System.out.println("|     Id Antrean    |    Id User    |  Nomor Antrean  |  jadwal  |");
        for (int i = 1; i <= sumRow; i++) {
            System.out.printf("|%18s | %13s | %15s | %8s |", sh.getRow(i).getCell(0).toString(), sh.getRow(i).getCell(1).toString(), sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString() );
            System.out.println();
        }
        System.out.println("----------------------- Total Antrean : " + sumRow + " -----------------------");
        backMain();
    }
}