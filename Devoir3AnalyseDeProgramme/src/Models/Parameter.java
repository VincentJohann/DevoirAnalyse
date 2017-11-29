package Models;

public class Parameter {
private String Name;
private String Type;
public Parameter(String name, String type) {
	Name = name;
	Type = type;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}

}
