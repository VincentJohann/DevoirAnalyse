package Models;

import java.util.ArrayList;
import java.util.List;

public class MaClasse {
	private String Name;

	public List<MaClasse> InnerClasses;
	public List<Attribut> Attributs;
	public List<Method> Methodes;
	private int CompteurPrivate;
	private int CompteurPublic;
	private int CompteurProtected;
	private int CompteurSimple;
	private int CompteurReference;

	

	public MaClasse(String name) {
		Name = name;
		CompteurPrivate = 0;
		CompteurPublic = 0;
		CompteurProtected = 0;
		InnerClasses= new ArrayList<MaClasse>();
		Attributs= new ArrayList<Attribut>();
		Methodes= new ArrayList<Method>();
	}

	public List<MaClasse> getInnerClasses() {
		return InnerClasses;
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
