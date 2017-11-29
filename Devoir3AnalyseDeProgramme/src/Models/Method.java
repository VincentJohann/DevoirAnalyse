package Models;

import java.util.List;

public class Method {
	String Name;
	boolean IsPublic;
	boolean IsPrivate;
	boolean IsProtected;
	public List<Parameter> InnerClasses;
	public Method(String name, String accessModifier ) {
		Name = name;
		SetAccessModifier(accessModifier);
		
	}
	
	public void SetAccessModifier(String modifier) {
		IsPublic = false;
		IsPrivate = false;
		IsProtected = false; 		
		switch(modifier) {
		case "public": 
			IsPublic = true;
			break;
		case "private": 
			IsPrivate = true;
			break;
		case "protected": 
			IsProtected = true;
			break;
		}
	}
}
