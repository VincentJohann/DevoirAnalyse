package Models;

public class Method {
	String Name;
	boolean IsPublic;
	boolean IsPrivate;
	boolean IsProtected;
	public Method(String name, boolean isPublic, boolean isPrivate,
			boolean isProtected) {
		Name = name;
		IsPublic = isPublic;
		IsPrivate = isPrivate;
		IsProtected = isProtected;
	}
}
