package applicationUI;
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


public class MainController {

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
	    
	    
	    private void ParseValidation2() {
	    	String filePath=BrowseTextField.getText();;
	    	String[] filesPath =new String[20];
	    	filesPath[0]=filePath;
	    	JavaParser parser=new JavaParser(filePath,this);
	    	String result=parser.ExecuteParse(2);


	    }
	    private void ParseValidation1() {
	    	String filePath=BrowseTextField.getText();;
	    	String[] filesPath =new String[20];
	    	//arrayString[0]=textToValidate;
	    	filesPath[0]=filePath;
	    	JavaParser parser=new JavaParser(filePath,this);
	    	String result=parser.ExecuteParse(1);
	    	//ResultMsg=Arbre.GetClassList();

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
