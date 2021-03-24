package myapp.exercise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Control
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		//Scene
		Scene scene = new Scene(root);
		
		//Stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}

	

}
