package Models;

public class Parameter 
{
	private String Modifier;
	private String Name;
	private String Type;
	public Parameter(String modifier, String type,String name) 
	{
		Modifier=modifier;
		Name = name;
		Type = type;
	}

	public String getModifier() 
	{
		return Modifier;
	}

	public void setModifier(String modifier) 
	{
		Modifier = modifier;
	}

	public Parameter( String type,String name) 
	{
		Name = name;
		Type = type;
	}
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public String getType() 
	{
		return Type;
	}
	
	public void setType(String type) 
	{
		Type = type;
	}
}
