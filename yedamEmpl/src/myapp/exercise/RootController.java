package myapp.exercise;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	@FXML TableView<Student> tableView;
	@FXML private TableColumn<Student, String> name;
	@FXML private TableColumn<Student, String> koScore;
	@FXML private TableColumn<Student, String> mathScore;
	@FXML private TableColumn<Student, String> engScore;
	
	@FXML Button addBtn;
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@Override
	public void initialize(URL locaion, ResourceBundle resources) {
		
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addBtnAction(e);				
			}
		});
		
		//ObservableList<Student> std = Student.boardList();
		TableColumn<Student, String> tcStd = (TableColumn<Student, String>) TableView.getClassCssMetaData();
		
		//TableView.setItems(null);
		
		
		
	} //end of Initialize
	
	
	
	public void addBtnAction(ActionEvent e) {
		//팝업창 열기
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		
		try {
			AnchorPane ap = FXMLLoader.load(getClass().getResource("Form.fxml"));
			Scene scene = new Scene(ap);
			stage.setScene(scene);
			stage.show();
			
			Button addBtn = (Button) ap.lookup("#addBtn");
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					name.setCellValueFactory(new PropertyValueFactory<>("name"));
					koScore.setCellValueFactory(new PropertyValueFactory<>("koScore"));
					mathScore.setCellValueFactory(new PropertyValueFactory<>("mathScore"));
					engScore.setCellValueFactory(new PropertyValueFactory<>("engScore"));
					
//					TextField name = (TextField) ap.lookup("#name");
//					TextField koScore = (TextField) ap.lookup("#koScore");
//					TextField mathScore = (TextField) ap.lookup("#mathScore");
//					TextField engScore = (TextField) ap.lookup("#engScore");
//					
//					Student std = new Student();
//					std.setName(name.getText());
//					std.setKoScore(koScore.getText());
//					std.setMathScore(mathScore.getText());
//					std.setEngScore(engScore.getText());
//					
					tableView.setItems();					
				}
			
			});
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	

}
