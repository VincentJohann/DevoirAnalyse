package applicationUI;
import java.awt.Component;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import JavaCodeParsing.JavaParser;
import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainController {

		public Arbre Arbre;
		public String  ResultMsg;
		public ToggleGroup FileOrFolderSelection;
	
		@FXML
	    private RadioButton SelectFileRadioBt;
		
		@FXML
	    private RadioButton SelectFolderRadioBt;
		
	    @FXML
	    public void initialize() {
	    	InitValue();
	    }
	 	@FXML
	    private TextField BrowseTextField;

	    @FXML
	    private Button CloseButton;

	    @FXML
	    private Button BrowseButton;

	    @FXML
	    public void Analyse1PublicPrivateStat_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(!BrowseTextField.getText().equals(""))
	    		ParseValidationMethod(1);
	    }
	    
	    @FXML
	    public void Analyse2Visibility_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(!BrowseTextField.getText().equals(""))
	    		ParseValidationMethod(2);
	    }
	    @FXML
	    public void Analyse3UMLDiagram_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(!BrowseTextField.getText().equals(""))
	    	ParseValidationMethod(3);
	    }
	    @FXML
	    public void Analyse4MethodAnalyse_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(!BrowseTextField.getText().equals(""))
	    	ParseValidationMethod(4);
	    }
	    @FXML
	    public void Analyse5MethodAnalyse_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(!BrowseTextField.getText().equals(""))
	    	ParseValidationMethod(5);
	    }
	    @FXML
	    public void BrowseButton_Click(ActionEvent event) {
	    	ResultMsg="";
	    	if(SelectFileRadioBt.isSelected()){
	    		SelectFile();
		    	return;
	    	}
	    	SelectFolder();
	    	
	    }
	    
	   

	    @FXML
	    void CloseButton_Click(ActionEvent event) {
	    	final Node source = (Node) event.getSource();
	        final Stage stage = (Stage) source.getScene().getWindow();
	        stage.close();
	    }
	    
	    
	    
	    private void SelectFile() {
	    	JFileChooser fc = new JFileChooser();
	    	File workingDirectory = new File(System.getProperty("user.dir"));
	    	fc.setCurrentDirectory(workingDirectory); // start at application current directory
	    	JFrame parentFrame = new JFrame();
	    	int returnVal = fc.showOpenDialog(parentFrame);
	    	if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	    //File yourFolder = fc.getSelectedFile();
	    	    BrowseTextField.setText(fc.getSelectedFile().getAbsolutePath());
	    	}

	    }
	    
	    private void SelectFolder() {
	    	JFileChooser fc = new JFileChooser();
	    	File workingDirectory = new File(System.getProperty("user.dir"));
	    	fc.setCurrentDirectory(workingDirectory); // start at application current directory
	    	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    	JFrame parentFrame = new JFrame();
	    	int returnVal = fc.showOpenDialog(parentFrame);
	    	if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	    //File yourFolder = fc.getSelectedFile();
	    	    BrowseTextField.setText(fc.getSelectedFile().getAbsolutePath());
	    	}

	    }
	    
	    private List<String> GetSelectedFiles(){
	    	List<String> allPaths= new ArrayList<String>();
	    	if(SelectFileRadioBt.isSelected()){
		    	String filePath=BrowseTextField.getText();
		    	allPaths.add(filePath);
		    	
	    	}else{
	    		allPaths=GetAllFilesFromPath();
	    	}
	    	
	    	return allPaths;
	    	
	    }
	    
	    private List<String> GetAllFilesFromPath() {
	    	List<String> results = new ArrayList<String>();


	    	File[] files = new File(BrowseTextField.getText()).listFiles();
	    	//If this pathname does not denote a directory, then listFiles() returns null. 

	    	for (File file : files) {
	    	    if (file.isFile() && getFileExtension(file).equals("java") ) {
	    	        results.add(file.getAbsolutePath());
	    	    }
	    	}
	    	return results;

	    }
	    
	    private String getFileExtension(File file) {
	        String name = file.getName();
	        try {
	            return name.substring(name.lastIndexOf(".") + 1).toLowerCase();
	        } catch (Exception e) {
	            return "";
	        }
	    }

	    /*private void ParseValidation1() {
	    	List<String> allPaths= GetSelectedFiles();
	    	JavaParser parser=new JavaParser(allPaths,this);
	    	parser.ExecuteParse(1);

	    }
	    private void ParseValidation2() {
	    	List<String> allPaths= GetSelectedFiles();
	    	JavaParser parser=new JavaParser(allPaths,this);
	    	parser.ExecuteParse(1);
	    }
	    private void ParseValidation3UML() {
	    	List<String> allPaths= GetSelectedFiles();
	    	JavaParser parser=new JavaParser(allPaths,this);
	    	parser.ExecuteParse(1);
	    }
	    private void ParseValidation4Method() {
	    	List<String> allPaths= GetSelectedFiles();
	    	JavaParser parser=new JavaParser(allPaths,this);
	    	parser.ExecuteParse(1);
	    }*/
	    
	    private void ParseValidationMethod(int choice) {
	    	List<String> allPaths= GetSelectedFiles();
	    	JavaParser parser=new JavaParser(allPaths,this);
	    	parser.ExecuteParse(choice);
	    }

	    
	   
	    
	    public void CreateAnalysisMessageBox (String message) {
	    	
	    	  //Create error logs window
	        JTextArea textArea = new JTextArea(message);
	        JScrollPane scrollPane = new JScrollPane(textArea);  
	        textArea.setLineWrap(true);  
	        textArea.setWrapStyleWord(true); 
	        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	        JOptionPane.showMessageDialog(null, scrollPane, "Resultat des analyses",  
	                                       JOptionPane.DEFAULT_OPTION);
	        InitValue();
	        
	    }
	    
	    
	    private void InitValue() {
	    	Arbre=new Arbre();
	    	
	    	FileOrFolderSelection = new ToggleGroup();
	    	SelectFileRadioBt.setToggleGroup(FileOrFolderSelection);
	    	SelectFileRadioBt.setSelected(true);
	    	SelectFolderRadioBt.setToggleGroup(FileOrFolderSelection);
	    	
	    }
	    
	    public void AddClass(MaClasse maClasse){
	    	Arbre.Add(maClasse);
	    } 
	    public Arbre GetArbre(){
	    	return Arbre;
	    }
	    public Arbre SetArbre(){
	    	return Arbre;
	    }
	    
	    public void AddInnerClass(MaClasse maClasse,String parentClass){
	    	Arbre.GetClassByName(parentClass).getInnerClasses().add(maClasse);
	    } 
	    
	    public void SetResultMsg(String msg){
	    	ResultMsg+=msg;
	    	
	    	} 
	    
	    public void ShowAnalyseResult(){
	    	CreateAnalysisMessageBox(ResultMsg);
	    	
	    	} 

	    
	   
	
	
}
