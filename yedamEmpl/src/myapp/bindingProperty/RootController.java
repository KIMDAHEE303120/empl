package myapp.bindingProperty;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {

	@FXML
	private TextArea txetArea1;
	@FXML
	private TextArea txetArea2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(txetArea1.textProperty(), txetArea2.textProperty());
	}
}
