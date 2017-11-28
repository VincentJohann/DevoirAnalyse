package Models;

import java.util.ArrayList;
import java.util.List;

public class Arbre {
	public  List<MaClasse> Classes;
	
	public Arbre() {
		Classes = new ArrayList<MaClasse>();// TODO Auto-generated constructor stub
	}

	public void Add(MaClasse laClasse){
		Classes.add(laClasse);
	}
	
	public MaClasse GetClassByName(String classeName){
		MaClasse myItem=null;
		for(MaClasse item : Classes){
			if(classeName.equals(item.getName())){
				myItem=item;
			};
			if(myItem == null) {
				myItem=GetClassListIterate(item,classeName);
			}
		}
		return myItem;
	}
	
	
	public MaClasse GetClassListIterate(MaClasse itemClass, String className){
		String classList="Liste des classe :\r\n";
		for(MaClasse item : itemClass.getInnerClasses()){
			if(className.equals(item.getName())){
				return item;
			};
		}

		return null;
	}
	
	
	public String GetClassList(){
		String classList="Liste des classe :\r\n";
		for(MaClasse item : Classes){
			classList+="Class name: - "+item.getName()+"\r\n";
		}

		return classList;
	}
	
	
	public String GetCompleteClassList(){
		String classList="Liste des classe :\r\n";
		for(MaClasse item : Classes){
			classList+="Class name: - "+item.getName()+"\r\n";
			if(item.getInnerClasses().size()>0) {
			classList+=IterateClassList(item," --- ");
			}
		}

		return classList;
	}
	
	public String IterateClassList(MaClasse myitem,String spacer){
		String classList="Liste des classe  interne:\r\n";
		for(MaClasse item : myitem.getInnerClasses()){
			classList+= spacer +"Inner class name: - "+item.getName()+"\r\n";
			if(item.getInnerClasses().size()>0) {
				classList+=IterateClassList(item,spacer+" --- ");
			}
		}
		return classList;
		}
}
