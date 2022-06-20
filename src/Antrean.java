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
                    System.out.println("\n-- DATA ANTREAN KONSULTASI PAGI --");
                    sh = wb.getSheet("antrean_pagi");
                    break;
                }
                if (menu == 2) {
                    System.out.println("\n-- DATA ANTREAN KONSULTASI SORE --");
                    sh = wb.getSheet("antrean_sore");
                    break;
                }
                if (menu == 3) {
                    backMain = 'y';
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
            System.out.println("Total antrean : " + sumRow);
            for (int i = 0; i <= sumRow; i++) {
                for (int j = 0; j <= 3; j++) {
                    System.out.print(sh.getRow(i).getCell(j));
                    if (j == 3) {
                        break;
                    }
                    System.out.print(" | ");
                }
                System.out.println();
            }

            prev();
            if (prev != 'y') {
                break;
            }
        }
    }
}

