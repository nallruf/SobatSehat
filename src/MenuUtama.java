import java.util.Scanner;
public class MenuUtama {
    public static Scanner inp = new Scanner(System.in);
    public static char backMain = 'y';
    public static int menu;

    public static void Menu() throws Exception {
        Fitur fitur = new Fitur();
        Antrean antrean = new Antrean();
        RekapDataAntrean rekap = new RekapDataAntrean();

        Init.init();

        String role= Login.UserSession.getRole();
        
        while (backMain == 'y') {
            System.out.println("\nMENU APLIKASI SOHIBUL SEHAT :");
            if(role.equalsIgnoreCase("admin")){
                System.out.println("1. Buat Akun" +
                "\n\t2. Data AKun " +
                "\n\t3. Data Antrean " +
                "\n\t4. Rekap Data Antrean " +
                "\n\t5. Live Antrean " +
                "\n\t6. Keluar dari Aplikasi");
                System.out.print("Pilihan Menu(1/2/3/4/5/6) : ");
            menu = inp.nextInt();

            switch (menu){
                case 1 :
                    DataAkun.createAcc();
                    break;
                case 2 :
                    DataAkun.viewData();
                    break;
                case 3 :
                    Antrean.DataAntrean();    
                    break;
                case 4 :
                    RekapDataAntrean.RekapAntrian();
                    break;
                case 5 :
                    viewLiveAntrean.printQueue(1);
                    break;
                case 6 :
                    Clear.clearQueue();
                    System.out.println("Terima kasih, semoga sehat selalu (:");
                    System.exit(0);
            }

            }else{
                System.out.println("1. Ambil Antrean" +
                "\n\t2. Riwayat Antrean " +
                "\n\t3. Akun Saya " +
                "\n\t4. Keluar dari Aplikasi");
                System.out.print("Pilihan Menu(1/2/3/4) : ");
                menu = inp.nextInt();
    
                switch (menu){
                    case 1 :
                        DaftarAntrean.Daftar();
                        break;
                    case 2 :
                        RiwayatAntrean.data();
                        break;
                    case 3 :
                        AkunSaya.Akun(); 
                        break;
                    case 4 :
                        System.out.println("Terima kasih, semoga sehat selalu (:");
                        System.exit(0);
                }
            }
            if (backMain != 'y'){
                break;
            }
        }
    }
}
