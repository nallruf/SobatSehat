import java.util.Scanner;

public class viewLiveAntrean {
    public static Scanner inp = new Scanner(System.in);
    public static void printQueue(int target) throws Exception{
        String[] dataAntrean = ModelQueue.getCurrentQueue(target);
        System.out.println("\n---------------------------------------------");
        System.out.println("|    No   | No Selanjutnya | Total Antrian  |");
        System.out.printf("| %7s | %14s | %16s |", dataAntrean[0], dataAntrean[1],dataAntrean[2] );
        System.out.println("\n---------------------------------------------");
        System.out.println("\n Selanjutnya ?(y/n)");
        String refresh = inp.next();
        if(refresh.equalsIgnoreCase("y")){
            System.out.println("\n");
            printQueue(target + 1);
        }
    }
}