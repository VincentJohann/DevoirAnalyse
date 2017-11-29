package Models;

import java.util.ArrayList;
import java.util.List;

public class MaClasse {
	private String Name;

	private List<MaClasse> InnerClasses;
	private List<Attribut> Attributs;
	public List<Method> Methodes;
	private int CompteurPrivate;
	private int CompteurPublic;
	private int CompteurProtected;
	private int CompteurSimple;
	private int CompteurReference;
	private String Parent;
	private List<String> VisibilityClasses;
	

	public MaClasse(String name) {
		Parent="";
		Name = name;
		CompteurPrivate = 0;
		CompteurPublic = 0;
		CompteurProtected = 0;
		InnerClasses= new ArrayList<MaClasse>();
		Attributs= new ArrayList<Attribut>();
		Methodes= new ArrayList<Method>();
		VisibilityClasses= new ArrayList<String>();
	}
	
	public String getParent() {
		return Parent;
	}

	public void setParent(String parent) {
		Parent = parent;
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
    	String strList="class "+Name+" visibility :[";
    	for(String item : VisibilityClasses) {
    		strList+=" "+item+", ";    		
    	}
    	strList+="]\r\n ";
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

	public List<Attribut> getAttributs() {
		return Attributs;
	}

	public void setAttributs(List<Attribut> attributs) {
		Attributs = attributs;
	}

	public List<Method> getMethodes() {
		return Methodes;
	}

	public void setMethodes(List<Method> methodes) {
		Methodes = methodes;
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
