package applicationUMLWindow;
import java.awt.Component;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import JavaCodeParsing.JavaParser;
import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UMLController {

		public Arbre Arbre;
		public String  ResultMsg;
	
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
	    	ParseValidation1();
	    }
	    
	    @FXML
	    public void Analyse2Visibility_Click(ActionEvent event) {
	    	ParseValidation2();
	    }
	    

	    @FXML
	    public void BrowseButton_Click(ActionEvent event) {
	    	SelectFile();
	    }

	    @FXML
	    void CloseButton_Click(ActionEvent event) {
	    	final Node source = (Node) event.getSource();
	        final Stage stage = (Stage) source.getScene().getWindow();
	        stage.close();
	    }
	    
	   
	    private void SelectFile() {
	    	

	    }
	    
	    
	    private void ParseValidation2() {
	    	
	    }
	    private void ParseValidation1() {
	     }
	    
	    public void CreateAnalysisMessageBox (String message) {
	    	

	    
	        
	    }
	    
	    
	    private void InitValue() {
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
	    	ResultMsg=msg;
	    	
	    	} 
	    
	    public void ShowAnalyseResult(){
	    	CreateAnalysisMessageBox(ResultMsg);
	    	
	    	} 

	    
	   
	
	
}
