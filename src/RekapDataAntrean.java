import java.io.IOException;

public class RekapDataAntrean extends Fitur {
    public static void RekapAntrian() throws IOException {
        FileInput();

                    sh = wb.getSheet("rekap");
                    int sumRow = sh.getLastRowNum();

                    System.out.println("\n-- REKAP DATA ANTREAN --");
                    System.out.println("Total Antrean : " + sumRow);
                    System.out.println("   Id Antrean    | Id User |NoAntrean|  jadwal |");
                    for (int i = 1; i <= sumRow; i++) {
                            System.out.printf("%15s | %7s | %7s | %7s |", sh.getRow(i).getCell(0).toString(), sh.getRow(i).getCell(1).toString(), sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString() );
                            System.out.println();
                        }
                    

                        System.out.println("Tekan enter untuk kembali ke halaman utama");
                        inp.nextLine();
                    
                   
                
        }
    }
