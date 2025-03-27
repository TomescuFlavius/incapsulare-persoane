package app;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersoanaView {
    public PersoaneService PersoanaService= new PersoaneService();
    public Scanner scanner = new Scanner(System.in);
    public void meniu(){
        System.out.println("1->Afisare Persoane");
        System.out.println("2->Sortare functie de varsta");
    }



    public void play(){
        boolean running = true;
        this.PersoanaService.load();
        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    this.PersoanaService.afisarePersoane();
                    break;
                case 2:
                    this.PersoanaService.tanarBatranSort();
                    break;

                default:
                    System.out.println("Alegere invalida");
            }
        }
    }




}
