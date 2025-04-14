package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersoaneService {
    private List<Persoane> persoane;
    private File file;
    public PersoaneService() {
        persoane = new ArrayList<>();
        this.file = new File("C:\\mycode\\oop\\incapsulare\\incapsulare-persoane\\src\\app\\persoane.txt");
        this.loadPersoane();
    }

    private void loadPersoane(){
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Persoane persoane = new Persoane(line);
                this.persoane.add(persoane);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String toSavePersoane() {
        String text = "";
        int i;
        for (i = 0; i < this.persoane.size()-1; i++) {
            text += persoane.get(i).descriere() + "\n";
        }
        return text += persoane.get(i).descriere();
    }

    public void savePersoane() {
        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(toSavePersoane());
            printWriter.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void afisarePersoane() {
        for (int i = 0; i < persoane.size(); i++) {
            System.out.println(this.persoane.get(i).descriere());
        }
    }

    public void addPersoana(Persoane persoana) {
        this.persoane.add(persoana);
    }


    public void minimVarsta() {
        Persoane minimV = new Persoane();

        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getAge() > minimV.getAge()) {
                System.out.println(persoane.get(i).descriere());
            }
        }
    }

    public void maximVarsta() {
        Persoane maximV = new Persoane();
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getAge() > maximV.getAge()) {
                System.out.println(persoane.get(i).descriere());
            }
        }
    }

    public List<Persoane> filtrareDupaVarsta(Filtrare filtrare) {
        List<Persoane> filtrate = new ArrayList<>();
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getAge() >= filtrare.minAge && persoane.get(i).getAge() <= filtrare.maxAge) {
                filtrate.add(persoane.get(i));
            }
        }
        return filtrate;
    }


    public List<Persoane> filtrareDupaGen(Filtrare filtrare) {
        List<Persoane> filtrate = new ArrayList<>();
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getGender().equals(filtrare.gen)) {
                filtrate.add(persoane.get(i));
            }
        }
        return filtrate;
    }

    public void adaugarePersoana(Persoane persoana) {
        for (Persoane p : persoane) {
            if (p.getId() == persoana.getId()) {
                System.out.println("id ul exista deja");
            }
        }
        persoane.add(persoana);
        System.out.println("persoana adaugata");
    }

    public boolean stergePersoana(int id) {
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getId() == id) {
                persoane.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editarePersoane(int id, Persoane persoana) {
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getId() == id) {
                persoana.setId = id;
                persoane.set(i, persoana);
                return true;
            }
        }
        return false;
    }

    public Persoane cautareDupaID(int id) {
        for (int i = 0; i < persoane.size(); i++) {
            if (persoane.get(i).getId() == id) {
                return persoane.get(i);
            }
        }
        return null;
    }
//todo:
    public List<Persoane> cautareDupaNume(String nume) {
        List<Persoane> persoanesCuAcelasiNume = new ArrayList<>();
        for (Persoane p : persoanesCuAcelasiNume) {
            if (p.getName().equalsIgnoreCase(nume)) {
                persoanesCuAcelasiNume.add(p);
            }
        }
        return persoanesCuAcelasiNume;
    }

    public double calculMedieVarsta() {
        int s = 0;
        for (int i = 0; i < persoane.size(); i++) {
            s = s + persoane.get(i).getAge();
        }
        return s / persoane.size();
    }

    public void adaugarePersoanaCuIdNou(Persoane persoana) {
        int maxId = 0;
        if(!persoane.isEmpty()) {
            for (Persoane p : persoane) {
                if (p.getId() > maxId) {
                    maxId = p.getId();
                }
            }
        }

        persoana.setId()=maxId+1;
        persoane.add(persoana);
        System.out.println("persoana adaugata"+persoana.getId());


    }



}



