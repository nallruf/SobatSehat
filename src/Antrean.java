import java.io.IOException;

public class Antrean extends Fitur {
    public static void DataAntrean() throws IOException {
        FileInput();
        while (true) {
            System.out.println("\nMenu data antrean berdasarkan waktu : " +
                    "\n\t1. Lihat Antrean Pagi " +
                    "\n\t2. Lihat Antrean Sore " +
                    "\n\t3. Kembali ke halaman utama");
            System.out.print("Pilihan menu(1/2/3) : ");
            menu = inp.nextInt();

            while (true) {
                if (menu == 1) {
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("|                  DATA ANTREAN KONSULTASI PAGI                  |");
                    sh = wb.getSheet("antrean_pagi");
                    break;
                }
                if (menu == 2) {
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("|                  DATA ANTREAN KONSULTASI SORE                  |");
                    sh = wb.getSheet("antrean_sore");
                    break;
                }
                if (menu == 3) {
                    break;
                }
                else {
                    System.out.print("Ulangi Pilihan Menu Data Antrean(1/2) : ");
                    menu = inp.nextInt();
                }
            }
            if (menu == 3) {
                break;
            }

            int sumRow = sh.getLastRowNum();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|     Id Antrean    |    Id User    |  Nomor Antrean  |  jadwal  |");
            for (int i = 1; i <= sumRow; i++) {
                    System.out.printf("|%18s | %13s | %15s | %8s", sh.getRow(i).getCell(0).toString(), sh.getRow(i).getCell(1).toString(), sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString());
                        System.out.print(" | ");
                System.out.println();
            }
            System.out.println("----------------------- Total Antrean : " + sumRow + " -----------------------");
            System.out.print("Apakah Anda ingin kembali ke halaman menu data antrean? (y/n) : ");
            int prev = inp.next().charAt(0);
            if (prev != 'y') {
                break;
            }
        }
    }
}