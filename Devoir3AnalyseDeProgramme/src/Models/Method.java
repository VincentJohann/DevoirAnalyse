package Models;

import java.util.ArrayList;
import java.util.List;

public class Method {
	private String Name;
	private String Block;
	private boolean IsPublic;
	private boolean IsPrivate;
	private boolean IsProtected;
	private List<Parameter> Parameter;
	private List<Method> InnerMethods;
	private String Invoker;
	
	public String getInvoker() {
		return Invoker;
	}

	public void setInvoker(String invoker) {
		Invoker = invoker;
	}

	public Method(String name, String accessModifier ) {
		Name = name;
		Parameter= new ArrayList<Parameter>();
		InnerMethods= new ArrayList<Method>();
		SetAccessModifier(accessModifier);
		
	}
	
	public List<Method> getInnerMethods() {
		return InnerMethods;
	}

	public void setInnerMethods(List<Method> innerMethods) {
		InnerMethods = innerMethods;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBlock() {
		return Block;
	}

	
	public void addToBlock(String block) {
		Block += block;
	}
	
	public void setBlock(String block) {
		Block = block;
	}

	public boolean isIsPublic() {
		return IsPublic;
	}

	public void setIsPublic(boolean isPublic) {
		IsPublic = isPublic;
	}

	public boolean isIsPrivate() {
		return IsPrivate;
	}

	public void setIsPrivate(boolean isPrivate) {
		IsPrivate = isPrivate;
	}

	public boolean isIsProtected() {
		return IsProtected;
	}

	public void setIsProtected(boolean isProtected) {
		IsProtected = isProtected;
	}

	public List<Parameter> getParameter() {
		return Parameter;
	}
	
	public String getParameterString() {
		String paramStr="";
		for( Parameter param:Parameter) {
			paramStr+=param.getType()+" "+param.getName()+" , ";
		}
		return paramStr;
	}
	
	
	public List<String> CreateInnerParameterString() {
		List<String> params=new ArrayList<String>();
		for( Method param1:InnerMethods) {
				if (!params.contains(param1.getName())) {
					params.add(param1.getName());
				
			}
		}
		return params;
	}
	
	
	public String getInnerParameterString() {
		String paramStr="";
		List<String> uniqueList=CreateInnerParameterString();
		for( String param:uniqueList) {
			paramStr+="- Appel interne: "+param;
		}
		return paramStr;
	}
	
	public int getInnerParameterOccurency(String occurency) {
		int paramCount=0;
		for( Method param:InnerMethods) {
			if(param.getName().equals(occurency)) {
				paramCount++;
			};
		}
		return paramCount;
	}
	
	
	

	public void setParameter(List<Parameter> parameter) {
		Parameter = parameter;
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
