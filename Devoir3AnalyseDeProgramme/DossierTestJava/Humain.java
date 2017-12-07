public class Humain{
    private String Nom;
    private String Age;

    public Humain(String nom, String age){
        this.Nom = nom;
        this.Age = age;
    }

    public String Parle(String paroles){
        return this.Nom +  " dit : " + paroles;
    }
}