package applicationUI;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			// Ouverture de l'interface graphique
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/applicationUI/Main.fxml"));
			fxmlLoader.setController(new MainController());
			Parent root1 = (Parent) fxmlLoader.load();
			Scene newScene=new Scene(root1);
			newScene.getStylesheets().add(getClass().getResource("/applicationUI/application.css").toExternalForm());
			Stage anotherStage = new Stage();
			anotherStage.setScene(newScene);
			anotherStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
