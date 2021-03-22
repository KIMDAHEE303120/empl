package event;

import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 컨테이너 만들기
		HBox root = new HBox();
		root.setPrefHeight(50);
		root.setPrefWidth(200);
		root.setSpacing(20);

		// 버튼 만들기
		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("버튼1이 클릭되었습니다.");

			}
		});
		Button btn2 = new Button("버튼2");
		btn2.setOnAction(event -> System.out.println("버튼2가 클릭되었습니다.")); //람다식
		
		

		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		
		//scene (컨테이너를 Scene의 매개값으로 넣음)
		Scene scene = new Scene(root);
		
		//stage의 매개값으로 Scene을 달아줌
		primaryStage.setScene(scene);
		primaryStage.show();
	} //end of start
	
		
	public static void main(String[] args) {
		Application.launch(args);
	}

}
