public class Etudiant extends Humain{
    private String Cours;
    private String Session;

    public Etudiant(String cours, String session){
        super(nom, age);        
        this.Cours = cours;
        this.Session = session;
    }

    public String ParleEncore(String paroles){
        return this.nom +  " dit : " + paroles + "Pendant son cours de :" + this.Cours;
    }
}