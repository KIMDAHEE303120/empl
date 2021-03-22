package myapp.bindingControl;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {

//	@FXML
//	private AnchorPane root;
//	@FXML
//	private Circle circle;
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
//		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
//	}

	@FXML
	private Slider slider;
	@FXML
	private Label label;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newValue) {
				label.setFont(new Font(newValue.doubleValue()));
				//System.out.println(oldvalue + ", " + newValue);
			}
		});
	}
}