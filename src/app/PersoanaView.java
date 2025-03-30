package app;
import java.sql.SQLOutput;
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
        System.out.println("5->Adaugare persoana noua");
        System.out.println("6->Stergere persoana ");
        System.out.println("7->Editare persoana");
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
                case 5:
                    adaugaPersoana();
                    break;
                case 6:
                    stergePersoana();
                    break;
                case 7:
                    editarePersoana();
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

    public void adaugaPersoana(){

        System.out.println("Introduceti Id:");
        persoane.id=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti nume");
        persoane.name=scanner.nextLine();

        System.out.println("Introduceti varsta:");
        persoane.age=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti gen(male/female):");
        persoane.gender=scanner.nextLine();

        System.out.println("Introduceti adresa:");
        persoane.address=scanner.nextLine();

        persoanaService.adaugarePersoana(persoane);
    }

    public void stergePersoana(){
        System.out.println("Introduceti Id pentru sters:");
        int id = Integer.parseInt(scanner.nextLine());

        boolean rezultat= persoanaService.stergePersoana(id);

        if(rezultat){
            System.out.println("Persoana a fost stearsa");
        }
        else {
            System.out.println("Nu s a gasit pers");
        }
    }

    public void editarePersoana(){
        System.out.println("ID persoana pe care vreti sa o editati:");
        int id=Integer.parseInt(scanner.nextLine());

        Persoane persGasita = persoanaService.cautareDupaID(id);
        if(persGasita==null){
            System.out.println("Persoana nu exista");
        }

        System.out.println("Persoana gasita:" + persGasita.descriere());
        
    }
}
