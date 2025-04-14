package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersoanaView {
    private PersoaneService persoanaService = new PersoaneService();
    private Scanner scanner = new Scanner(System.in);
    Filtrare filtrare = new Filtrare();

    public PersoanaView() {
        this.persoanaService = new PersoaneService();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    private void meniu() {
        System.out.println("1->Afisare Persoane");
        System.out.println("3->Filtrare dupa varsta");
        System.out.println("4->Filtrare dupa gen(male/female)");
        System.out.println("5->Adaugare persoana noua");
        System.out.println("6->Stergere persoana ");
        System.out.println("8->Persoane cu acelasi nume");
        System.out.println("9->Varsta medie a persoanelor");

    }


    public void play() {
        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    this.persoanaService.afisarePersoane();
                    break;

                case 3:
                    persoanaService.filtrareDupaVarsta(filtrare);
                    break;
                case 4:
                    persoanaService.filtrareDupaGen(filtrare);
                    break;
                case 5:
                    persoanaService.addPersoana(new Persoane(1, "A", 20, "female", "b3"));
                    break;
                case 6:
                    persoanaService.stergePersoana(1);
                    break;

                case 8:
                    persoanaService.cautareDupaNume("alex");
                    break;
                case 9:
                    persoanaService.calculMedieVarsta();
                    break;


                default:
                    System.out.println("Alegere invalida");
            }
        }
    }


}