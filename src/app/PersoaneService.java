package app;

import java.util.ArrayList;
import java.util.List;


public class PersoaneService {
    List<Persoane> persoane= new ArrayList<Persoane>();
    public void load(){
        Persoane persoane1=new Persoane();
        persoane1.id=1;
        persoane1.name="Alex";
        persoane1.age=18;
        persoane1.gender="male";
        persoane1.address="A1";

        Persoane persoane2=new Persoane();
        persoane2.id=2;
        persoane2.name="Andreea";
        persoane2.age=25;
        persoane2.gender="female";
        persoane2.address="B2";

        Persoane persoane3=new Persoane();
        persoane3.id=3;
        persoane3.name="Andrei";
        persoane3.age=23;
        persoane3.gender="male";
        persoane3.address="C3";

        this.persoane.add(persoane1);
        this.persoane.add(persoane2);
        this.persoane.add(persoane3);
    }


    public void afisarePersoane(){
        for(int i=0;i<persoane.size();i++){
            System.out.println(this.persoane.get(i).Descriere());
        }
    }
    public void tanarBatranSort(){

        for(int i=0;i<persoane.size()-1;i++){
            for(int j=0;j<persoane.size()-i-1;j++){
                if(persoane.get(j).age>persoane.get(j+1).age){
                    Persoane temp =persoane.get(j);
                    persoane.set(j,persoane.get(j+1));
                    persoane.set(j+1,temp);
                }

            }
        }
        for(int i=0;i<persoane.size();i++){
            System.out.println(this.persoane.get(i).Descriere());
        }
    }


}
