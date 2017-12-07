public class Professeur extends Humain{
    private String Cours;
    private String Session;
    private Etudiant EtudiantFavoris;

    public Professeur(String cours, String session,Etudiant etudiantFavoris){
        super(nom, age);        
        this.Cours = cours;
        this.Session = session;
        this.EtudiantFavoris = etudiantFavoris;
        this.DesigneSonEtudiantFavoris(this.EtudiantFavoris);
    }

    public String ParleEncore(String paroles){
        return this.nom +  " dit : " + paroles + "Pendant son cours de :" + this.Cours;
    }

    private void DesigneSonEtudiantFavoris(Etudiant etudiant){
        System.out.print("Mon étudiant favoris est pépé OU "+etudiant.nom);
    }
}