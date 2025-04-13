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
        System.out.println("2->Sortare functie de varsta");
        System.out.println("3->Filtrare dupa varsta");
        System.out.println("4->Filtrare dupa gen(male/female)");
        System.out.println("5->Adaugare persoana noua");
        System.out.println("6->Stergere persoana ");
        System.out.println("7->Editare persoana");
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
                case 8:
                    persoaneCuAcelasiNume();
                    break;
                case 9:
                    medieVarste();
                    break;
                case 10:
                    persoanaCuIdNou();
                    break;


                default:
                    System.out.println("Alegere invalida");
            }
        }
    }


    public void filtrareVarsta() {
        System.out.println("Introduceti varsta minima");
        int varstaAleasaMinim = Integer.parseInt(scanner.nextLine());
        System.out.println("introduecti varsta maxima");
        int varstaAleasaMaxim = Integer.parseInt(scanner.nextLine());

        Filtrare filtrare = new Filtrare();

        filtrare.minAge = varstaAleasaMinim;
        filtrare.maxAge = varstaAleasaMaxim;

        List<Persoane> persoanes = this.persoanaService.filtrareDupaVarsta(filtrare);


        for (Persoane persoane : persoanes) {
            System.out.println(persoane.descriere());
        }
    }


    public void filtrareGen() {
        System.out.println("Introduceti genul:");
        String alegeGen = scanner.nextLine();
        Filtrare filtrare = new Filtrare();
        filtrare.gen = alegeGen;

        List<Persoane> persoaneFiltrate = persoanaService.filtrareDupaGen(filtrare);

        for (Persoane persoane : persoaneFiltrate) {
            System.out.println(persoane.descriere());
        }
    }

    public void adaugaPersoana() {

        Persoane  persoane = new Persoane();
        System.out.println("Introduceti Id:");
        persoane.id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti nume");
        persoane.name = scanner.nextLine();

        System.out.println("Introduceti varsta:");
        persoane.age = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti gen(male/female):");
        persoane.gender = scanner.nextLine();

        System.out.println("Introduceti adresa:");
        persoane.address = scanner.nextLine();

        persoanaService.adaugarePersoana(persoane);
    }

    public void stergePersoana() {
        System.out.println("Introduceti Id pentru sters:");
        int id = Integer.parseInt(scanner.nextLine());

        boolean rezultat = persoanaService.stergePersoana(id);

        if (rezultat) {
            System.out.println("Persoana a fost stearsa");
        } else {
            System.out.println("Nu s a gasit pers");
        }
    }

    public void editarePersoana() {
        System.out.println("ID persoana pe care vreti sa o editati:");
        int id = Integer.parseInt(scanner.nextLine());

        Persoane persGasita = persoanaService.cautareDupaID(id);
        if (persGasita == null) {
            System.out.println("Persoana nu exista");
        }

        System.out.println("Persoana gasita:" + persGasita.descriere());
        System.out.println("Alegeti ce sa se modifice: nume:value, varsta:value, gen:value, adresa:Value");
        String alage = scanner.nextLine();
        String[] prop = alage.split(",");
        for (int i = 0; i < prop.length; i++) {
            String proprietate = prop[i].split(":")[0];
            String valoare = prop[i].split(":")[1];
            switch (proprietate) {
                case "nume":
                    persGasita.name = valoare;
                    break;
                case "varsta":
                    persGasita.age = Integer.parseInt(valoare);
                    break;
                case "gen":
                    persGasita.gender = valoare;
                    break;
                case "adresa":
                    persGasita.address = valoare;
                    break;
            }
        }

        System.out.println("Editat cu succes!");
    }

    public void persoaneCuAcelasiNume(){
        System.out.println("Introduceti numele:");
        String name= scanner.nextLine();
        List<Persoane> persoanes=persoanaService.cautareDupaNume(name);
        if(persoanes.isEmpty()) {
            System.out.println("Persoana nu exista");
        }
        else {
            for (Persoane persoane : persoanes) {
                System.out.println(persoane.descriere());
            }
        }
    }
    public void medieVarste(){
        System.out.println(this.persoanaService.calculMedieVarsta());
    }

    public void persoanaCuIdNou(){
        Persoane persoane1=new Persoane();
        System.out.println("Introduceti Nume:");
        String name = scanner.nextLine();
        System.out.println("Introduceti Varsta:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti gen(male/female):");
        String gen = scanner.nextLine();
        System.out.println("Introduceti adresa:");
        String address = scanner.nextLine();

        persoane1.name = name;
        persoane1.age = age;
        persoane1.gender = gen;
        persoane1.address = address;
        persoanaService.adaugarePersoana(persoane1);
    }
}
