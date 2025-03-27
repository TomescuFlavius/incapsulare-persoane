package app;



public class Persoane {

        //atribute
        public int id;
        public String name;
        public int age;
        public String gender;
        public String address;


        public String Descriere() {
            String text="";
            text+="Id : "+this.id+"\n";
            text+="Name : "+this.name+"\n";
            text+="Age : "+this.age+"\n";
            text+="Gender : "+this.gender+"\n";
            text+="Address : "+this.address+"\n";
            return text;

        }

    }


