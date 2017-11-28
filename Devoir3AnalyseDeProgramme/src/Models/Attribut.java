package Models;

public class Attribut {
	String Name;
	boolean IsPublic;
	boolean IsPrivate;
	boolean IsProtected;
	public Attribut(String name, boolean isPublic, boolean isPrivate,
			boolean isProtected) {
		Name = name;
		IsPublic = isPublic;
		IsPrivate = isPrivate;
		IsProtected = isProtected;
	}


}
