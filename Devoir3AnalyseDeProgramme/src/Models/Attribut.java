package Models;

public class Attribut 
{
	String Name;
	boolean IsPublic;
	boolean IsPrivate;
	boolean IsProtected;
	
	public Attribut(String name,String modifier) 
	{
		Name = name;
		SetAccessModifier(modifier);
	}
	
	public void SetAccessModifier(String modifier) 
	{
		IsPublic = false;
		IsPrivate = false;
		IsProtected = false;
		
		switch(modifier) 
		{
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
