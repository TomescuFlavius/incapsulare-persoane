package app;



public class Persoane {

        //atribute
        private int id;
        private String name;
        private int age;
        private String gender;
        private String address;

        public Persoane(){
            System.out.println("Constructor gol");
        }

        public Persoane(int id, String name, int age, String gender, String address) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
        }

        public Persoane(String text) {
            text.split(" ");
            this.id = Integer.parseInt(text.split(" ")[0]);
            this.name = text.split(" ")[1];
            this.age = Integer.parseInt(text.split(" ")[2]);
            this.gender = text.split(" ")[3];
            this.address = text.split(" ")[4];
        }


        public String descriere() {
            String text="";
            text+="Id : "+this.id+"\n";
            text+="Name : "+this.name+"\n";
            text+="Age : "+this.age+"\n";
            text+="Gender : "+this.gender+"\n";
            text+="Address : "+this.address+"\n";
            return text;
        }

    }


