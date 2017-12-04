package Models;

import java.util.ArrayList;
import java.util.List;

public class Arbre {
	public  List<MaClasse> Classes;
	public  List<MaClasse> CompleteClasses;
	
	public Arbre() {
		Classes = new ArrayList<MaClasse>();// TODO Auto-generated constructor stub
		CompleteClasses= new ArrayList<MaClasse>();
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
	
	public void InitCompleteClassList(){
		String classList="Liste des classe :\r\n";
		for(MaClasse item : Classes){
			CompleteClasses.add(item);
			if(item.getInnerClasses().size()>0) {
				IterateClassList(item);
			}
		}

	}
	
	public String GetAnalyseAttribute1Statistic(){
		InitCompleteClassList();
		String resultMsg="Voici les statistiques de la portée des attibuts :\r\n";
		for(MaClasse item : CompleteClasses){
			resultMsg+="Pour la classe: --- "+item.getName()+" ---\r\n";
			int totalAttribute=item.getCompteurPrivate() +item.getCompteurProtected()+ item.getCompteurPublic();
			resultMsg+="Voici le nombre d'attribut public :"+ item.getCompteurPublic() +"  \r\n";
			resultMsg+="Voici le nombre d'attribut privé :"+ item.getCompteurPrivate() +"  \r\n";
			resultMsg+="Voici le nombre d'attribut protected :"+ item.getCompteurProtected() +"  \r\n";
			if(totalAttribute != 0) {
				double privateAttrib =((double)item.getCompteurPrivate()/(double)totalAttribute)*100 ;
				double publicAttrib =((double)item.getCompteurPublic()/(double)totalAttribute)*100 ;
				double protectedAttrib =((double)item.getCompteurProtected()/(double)totalAttribute)*100 ;
				resultMsg+="Voici le pourcentage d'attribut public :"+ Math.round(publicAttrib*100)/100.f  +" % \r\n";
				resultMsg+="Voici le pourcentage d'attribut privé :"+ Math.round(privateAttrib*100)/100.f  +" % \r\n";
				resultMsg+="Voici le pourcentage d'attribut protected :"+ Math.round(protectedAttrib*100)/100.f +" % \r\n ";			
			}
			resultMsg+="\r\n";
		}

		return resultMsg;
	}
	
	public String GetAnalyseAttribute2Statistic(){
		InitCompleteClassList();
		String resultMsg="Voici les statistiques de la portée des attibuts :\r\n";
		for(MaClasse item : CompleteClasses){
			resultMsg+="Pour la classe: --- "+item.getName()+" ---\r\n";
			int totalAttribute=item.getCompteurPrivate() +item.getCompteurProtected()+ item.getCompteurPublic();
			resultMsg+="Voici le nombre d'attribut de référence(objet) :"+ item.getCompteurReference() +"  \r\n";
			resultMsg+="Voici le nombre d'attribut simple(primitive) :"+ item.getCompteurSimple() +"  \r\n";
			if(totalAttribute != 0) {
				double referenceAttrib =((double)item.getCompteurReference()/(double)totalAttribute)*100 ;
				double simpleAttrib =((double)item.getCompteurSimple()/(double)totalAttribute)*100 ;
				resultMsg+="Voici le pourcentage d'attribut de référence objet :"+ Math.round(referenceAttrib*100)/100.f +" % \r\n";
				resultMsg+="Voici le pourcentage d'attribut simple(primitive) :"+ Math.round(simpleAttrib*100)/100.f +" % \r\n";
				resultMsg+="Voici les visibilité:"+item.GetVisibilitys();
			  }
			resultMsg+="\r\n";
			}
		

		return resultMsg;
	}
	
	public String GetAnalyseUML3Statistic(){
		InitCompleteClassList();
		String resultMsg="Voici les statistiques de la portée des attibuts :\r\n";
		for(MaClasse item : CompleteClasses){
			resultMsg+="Pour la classe: --- "+item.getName()+" ---\r\n";		
			resultMsg+="Voici les classes associée(Association):"+item.GetVisibilitys();
			if(!item.getParent().equals("")) {
				resultMsg+="Cette classe est une classe enfant de :"+item.getParent();
				resultMsg+="\r\n";
			} 
			resultMsg+="\r\n";
			}

		return resultMsg;
	}
	
	public String GetAnalyseMethod5Stats(){
		InitCompleteClassList();
		String resultMsg="Voici les statistiques de la dépendance entre classe :\r\n";
		for(MaClasse item : CompleteClasses){
			resultMsg+="Pour la classe: --- "+item.getName()+" ---\r\n";		
			if(item.getMethodesString().length()>0) {
				resultMsg+="Voici les méthodes de la classes: \r\n"+item.getMethodesString();

			}else {
				resultMsg+="Aucune méthodes externe appelée.\r\n";	
			}
			resultMsg+="\r\n";
			}

		return resultMsg;
	}
	

	
	public String GetAnalyseMethod4Stats(){
		InitCompleteClassList();
		String resultMsg="Voici les statistiques de la dépendance entre classe :\r\n";
		for(MaClasse item : CompleteClasses){
			resultMsg+="Pour la classe: --- "+item.getName()+" ---\r\n";
			if(item.getMethodesString().length()>0) {
				List<String> myMethodsNotUnique=CreateMethodArray();
				List<String> myMethodsUnique=CreateMethdoUniqueArray();
				resultMsg+="Voici les méthodes de classes externes de la classes \r\n";
				for(String methodName:myMethodsUnique) {
					int nbOccurency=getInnerParameterOccurency(methodName,myMethodsNotUnique);
					resultMsg+="Nombre d'occurences: "+nbOccurency+" pour la méthode: "+methodName+"() \r\n";
				}
			}else {
				resultMsg+="Aucune méthodes externe appelée.\r\n";	
			}
			resultMsg+="\r\n";
			}

		return resultMsg;
	}
	
	
	public int getInnerParameterOccurency(String occurency,List<String> array) {
		int paramCount=0;
		for( String param:array) {
			if(param.equals(occurency)) {
				paramCount++;
			};
		}
		return paramCount;
	}
	
	
	public List<String> CreateMethodArray() {
		List<String> myMethods=new ArrayList<String>();
		for(MaClasse item : CompleteClasses){
			if(item.getMethodesString().length()>0) {
				for(Method innerItem : item.getMethodes()){
					for(Method innerItemMethod : innerItem.getInnerMethods()){
							myMethods.add(innerItemMethod.getName());											
				}											
				}				
			}		
			}
		return myMethods;
	}
	
	
	public List<String> CreateMethdoUniqueArray() {
		List<String> myMethods=new ArrayList<String>();
		for(MaClasse item : CompleteClasses){
			if(item.getMethodesString().length()>0) {
				for(Method innerItem : item.getMethodes()){
					for(Method innerItemMethod : innerItem.getInnerMethods()){
						if (!myMethods.contains(innerItemMethod.getName())) {
							myMethods.add(innerItemMethod.getName());	
						}				
				}											
				}				
			}		
			}
		return myMethods;
	}
	
	public void CountMethodArray() {
		
	}
	
	public void IterateClassList(MaClasse myitem){
		for(MaClasse item : myitem.getInnerClasses()){
			CompleteClasses.add(item);
			if(item.getInnerClasses().size()>0) {
				IterateClassList(item);
			}
		}

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
