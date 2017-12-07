package Models;

import java.util.ArrayList;
import java.util.List;

public class MaClasse {
	private String Name;

	private List<MaClasse> InnerClasses;
	private List<Parameter> Attributs;
	public List<Method> Methodes;
	private int CompteurPrivate;
	private int CompteurPublic;
	private int CompteurProtected;
	private int CompteurSimple;
	private int CompteurReference;
	private List<String> Parents;
	private List<String> Interfaces;
	private List<String> VisibilityClasses;
	

	public MaClasse(String name) {
		Parents=new ArrayList<String>();
		Interfaces=new ArrayList<String>();
		Name = name;
		CompteurPrivate = 0;
		CompteurPublic = 0;
		CompteurProtected = 0;
		InnerClasses= new ArrayList<MaClasse>();
		Attributs= new ArrayList<Parameter>();
		Methodes= new ArrayList<Method>();
		VisibilityClasses= new ArrayList<String>();
	}
	
	public List<String> getParent() {
		return Parents;
	}
	
	public String getParentToString() {
		String parents="Class parents : \r\n";
		for(String parentName:Parents) {
			parents+=" - "+parentName+ "\r\n";
		}
		return parents;
	}

	public List<String> getParents() {
		return Parents;
	}

	public void setParents(List<String> parents) {
		Parents = parents;
	}

	
	public String getInterfacesToString() {
		String interfaces="Class interfaces : \r\n";
		for(String interfaceName:Interfaces) {
			interfaces+=" - "+interfaceName+ "\r\n";
		}
		return interfaces;
	}
	public List<String> getInterfaces() {
		return Interfaces;
	}

	public void setInterfaces(List<String> interfaces) {
		Interfaces = interfaces;
	}
	
	public void addInterface(String interfaceName) {
		Interfaces.add(interfaceName);
	}
	public void addParent(String parent) {
		Parents.add(parent);
	}

	public void addVisibility(String newVisibility) {
		if(!IsInVisibility(newVisibility)) {
			VisibilityClasses.add(newVisibility);
		}
		
	}
	
    public boolean IsInVisibility(String newVisibility) {
    	boolean IsInList=false;
    	for(String item : VisibilityClasses) {
    		if(item.equals(newVisibility)) {
    			IsInList=true;
    		}
    	}
    	return IsInList;
	}
    
    public String GetVisibilitys() {
    	String strList="Voici les classes associée(Visibilitée):\r\n";
    	for(String item : VisibilityClasses) {
    		strList+=" - "+item+"\r\n ";    		
    	}
    	strList+="\r\n ";
    	return strList;
	}

	public List<MaClasse> getInnerClasses() {
		return InnerClasses;
	}


	public List<String> getVisibilityClasses() {
		return VisibilityClasses;
	}

	public void setVisibilityClasses(List<String> visibilityClasses) {
		VisibilityClasses = visibilityClasses;
	}
	
	public int getCompteurSimple() {
		return CompteurSimple;
	}

	public void setCompteurSimple(int compteurSimple) {
		CompteurSimple = compteurSimple;
	}

	public int getCompteurReference() {
		return CompteurReference;
	}

	public void setCompteurReference(int compteurReference) {
		CompteurReference = compteurReference;
	}
	public void setInnerClasses(List<MaClasse> innerClasses) {
		InnerClasses = innerClasses;
	}

	public List<Parameter> getAttributs() {
		return Attributs;
	}

	public void setAttributs(List<Parameter> attributs) {
		Attributs = attributs;
	}

	public List<Method> getMethodes() {
		return Methodes;
	}

	public void setMethodes(List<Method> methodes) {
		Methodes = methodes;
	}
	
	public String getMethodesString() {
		String allMethods="";
		for(Method myMethod : Methodes) {
			allMethods += "   "+myMethod.getName() +"("+myMethod.getParameterString()+") \r\n";
			for(Method inmyMethod : myMethod.getInnerMethods()) {
				allMethods += myMethod.getInnerParameterString() +"() \r\n";
			}
		}
		return allMethods;
	}
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCompteurPrivate() {
		return CompteurPrivate;
	}

	public void setCompteurPrivate(int compteurPrivate) {
		CompteurPrivate = compteurPrivate;
	}

	public int getCompteurPublic() {
		return CompteurPublic;
	}

	public void setCompteurPublic(int compteurPublic) {
		CompteurPublic = compteurPublic;
	}

	public int getCompteurProtected() {
		return CompteurProtected;
	}

	public void setCompteurProtected(int compteurProtected) {
		CompteurProtected = compteurProtected;
	}
}
