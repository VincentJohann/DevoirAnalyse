public class Animal{
    private String Nom;
    private String Age;
    protected String Race;
	protected Chien Arrold;


    public Animal(String nom, String age, String race, String action){
        this.Nom = nom;
        this.Age = age;
        this.Race = race;
		System.out.println("test");

}
}



public class Chien extends Animal{
    private String Nom;
    private String Age;
    protected String Race;
    public String Action;
	public boolean test;
	public Oiseau test;

    public Chien(String nom, String age, String race, String action){
        this.Nom = nom;
        this.Age = age;
        this.Race = race;
        this.Action = action;
    }

    public String JappeSur(Chat chat){
		chat2.Miaule();
        return this.Nom = " jappe sur " + chat.prenom;
    }

    public void Assis() {
        System.out.println(this.prenom = " est assis");
		System.out.println(this.prenom = " est assis");
    }

    private void Saute(){
        System.out.println(this.prenom = " saute");
    }

    protected void Dort(){
        System.out.println(this.prenom = " dort");        
    }
}

public class Chat{
    private String Nom;
    private String Age;
    protected String Race;
    public String Action;

    public Chat(String nom, String age, String race, String action){
        this.Nom = nom;
        this.Age = age;
        this.Race = race;
        this.Action = action;
    }

    public String Attaque(Chien chien){
        return this.Nom = " attaque " + chien.prenom;
    }
}

public class Tigre{
    private String Nom;
    private String Age;
    protected String Race;
    public String Action;

    public Tigre(String nom, String age, String race, String action){
        this.Nom = nom;
        this.Age = age;
        this.Race = race;
        this.Action = action;
    }

    public String Attaque(Grizly grizly){
        return this.Nom = " attaque " + grizly.prenom;
    }
}

public class Grizly{
    private String Nom;
    private String Age;
    protected String Race;
    public String Action;

    public Grizly(String nom, String age, String race, String action){
        this.Nom = nom;
        this.Age = age;
        this.Race = race;
        this.Action = action;
    }

    public String Attaque(Tigre tigre){
        return this.Nom = " attaque " + tigre.prenom;
    }
	
	private class TigreEtGrizzlyInterne{
    public Tigre tigre;
    public Grizly grizly;
	public Grizly grizlyBlanc;
	public int Nbtigre;
    public double coutgrizly;
	public boolean tigreEstLa;
    public float grizlyEsperance;

    public TigreEtGrizzlyInterne(){
        this.tigre = new Tigre("Tigrou","2","Bengal","Dort");
        this.grizly = new Tigre("Grizlou","5","Ours","Se Promène");
        System.out.println(this.grizly.Attaque(this.tigre));
    }
}
}

private class TigreEtGrizzly{
    public Tigre tigre;
    public Grizly grizly;

    public TigreEtGrizzly(){
        this.tigre = new Tigre("Tigrou","2","Bengal","Dort");
        this.grizly = new Tigre("Grizlou","5","Ours","Se Promène");
        System.out.println(this.grizly.Attaque(this.tigre));
    }
}