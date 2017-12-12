package analysedevoir3ast.handlers;



import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
   public IProject CurrentProject;
   public String ProjectDataText;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProjectDataText="";				
        // Get the root of the workspace
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        // Get all projects in the workspace 
        IProject[] projects = root.getProjects();  
        // project selector window
        
        if(projects.length==0) {
        	IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    		MessageDialog.openInformation(
    				window.getShell(),
    				"ASTAnalyseProgrammeDevoir3",
    				"Aucun projet disponible");
        }else {
        	ShowChoiceWindow(projects);
        	CreateProjectString(event);
        }

        return null;
    }

	public void ShowChoiceWindow(IProject[] projects) {
		//Creation de la liste de choix
		 String[] choices = new String[projects.length];
	        for(int i=0;i<projects.length;i++) {
	        	choices[i]=projects[i].getName();
	        }
	        
	        // Fenetre des choix possibles
	        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choisir le projet a vérifier", JOptionPane.QUESTION_MESSAGE, null,
	            choices, // Array of choices
	            choices[0]); // Initial choice	
	        
	      	//set Selected Project
	        for(int i=0;i<projects.length;i++) {
	        	//Dans notre cas on recupere seuelement le projet selectionné.
	        	if(contains(projects[i].getName(),input)) {
	        		CurrentProject=projects[i];
	        	}
	        }	
	}
	
	public boolean contains( String contenant, String contenu ) {
		contenant = contenant == null ? "" : contenant;
		  contenu = contenu == null ? "" : contenu;
		  return contenant.toLowerCase().contains( contenu.toLowerCase() );
		}
	// La méthode principale
	public void CreateProjectString(ExecutionEvent event) {
		ProjectDataText+="Project Name: "+CurrentProject.getName()+"\n\r";
		
		
		try {
			IJavaProject javaProject = JavaCore.create(CurrentProject);
			printPackageInfos(javaProject);

		} catch (JavaModelException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AfficheResultat();
		
		
	}
	
	public void AfficheResultat() {
		JTextArea textArea = new JTextArea(ProjectDataText);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "Resultat des analyses",  
                                       JOptionPane.DEFAULT_OPTION);
	}
	

	private void printPackageInfos(IJavaProject javaProject) throws JavaModelException {
		IPackageFragment[] packages = javaProject.getPackageFragments();
		for (IPackageFragment mypackage : packages) {
			// Package fragments include all packages in the
			// classpath
			// We will only look at the package from the source
			// folder
			// K_BINARY would include also included JARS, e.g.
			// rt.jar
			if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
				ProjectDataText+="Dans Package " + mypackage.getElementName()+"\n\r";
				printICompilationUnitInfo(mypackage);
			}

		}
	}

	private void printICompilationUnitInfo(IPackageFragment mypackage) throws JavaModelException {
		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
			printCompilationUnitDetails(unit);

		}
	}

	private void printIMethods(ICompilationUnit unit) throws JavaModelException {
		IType[] allTypes = unit.getAllTypes();
		for (IType type : allTypes) {
			printIMethodDetails(type);
		}
	}

	private void printCompilationUnitDetails(ICompilationUnit unit) throws JavaModelException {
		ProjectDataText+="Pour la Classe: ----" + unit.getElementName()+"-----\n\r";
		// Document doc = new Document(unit.getSource());
		// System.out.println("Has number of lines: " + doc.getNumberOfLines());
		printIMethods(unit);
	}

	private void printIMethodDetails(IType type) throws JavaModelException {
		IMethod[] methods = type.getMethods();
		for (IMethod method : methods) {
			ProjectDataText+="Method name " + method.getElementName()+"\n\r";
			ProjectDataText+="Signature " + method.getSignature()+"\n\r";
			ProjectDataText+="Return Type " + method.getReturnType()+"\n\r";
		}
	}

}
