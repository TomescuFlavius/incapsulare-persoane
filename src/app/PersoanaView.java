package app;
import java.util.List;
import java.util.Scanner;


public class PersoanaView {
    public Persoane persoane = new Persoane();
    public PersoaneService persoanaService = new PersoaneService();
    public Scanner scanner = new Scanner(System.in);
    Filtrare filtrare = new Filtrare();
    public void meniu(){
        System.out.println("1->Afisare Persoane");
        System.out.println("2->Sortare functie de varsta");
        System.out.println("3->Filtrare dupa varsta");
        System.out.println("4->Filtrare dupa gen(male/female)");

    }



    public void play(){
        boolean running = true;
        this.persoanaService.load();
        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    this.persoanaService.afisarePersoane();
                    break;
                case 2:
                    this.persoanaService.tanarBatranSort();
                    break;
                case 3:
                   filtrareVarsta();
                    break;
                case 4:
                    filtrareGen();
                    break;

                default:
                    System.out.println("Alegere invalida");
            }
        }
    }



    public  void filtrareVarsta(){
        System.out.println("Introduceti varsta minima");
        int varstaAleasaMinim=Integer.parseInt(scanner.nextLine());
        System.out.println("introduecti varsta maxima");
        int varstaAleasaMaxim=Integer.parseInt(scanner.nextLine());

        Filtrare filtrare= new Filtrare();

        filtrare.minAge=varstaAleasaMinim;
        filtrare.maxAge=varstaAleasaMaxim;

        List<Persoane> persoanes=this.persoanaService.filtrareDupaVarsta(filtrare);


        for(Persoane persoane : persoanes){
            System.out.println(persoane.descriere());
        }
    }


    public void filtrareGen(){
        System.out.println("Introduceti genul:");
        String alegeGen=scanner.nextLine();
        Filtrare filtrare= new Filtrare();
        filtrare.gen=alegeGen;

        List<Persoane> persoaneFiltrate=persoanaService.filtrareDupaGen(filtrare);

        for(Persoane persoane : persoaneFiltrate){
            System.out.println(persoane.descriere());
        }
    }


}
