package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewWindowController {

	@FXML
	private TextField tf1;

	@FXML
	private TextField tf2;

	@FXML
	private TextField tf3;

	@FXML
	private TextField tf4;

	@FXML
	private TextField tf5;
	@FXML
	private void initialize() {
		tf1.setText(SampleController.uid);
		tf2.setText(SampleController.uname);
		tf3.setText(SampleController.uemail);
		tf4.setText(SampleController.uphone);
	}
    @FXML
    void onClickBack(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }
}
