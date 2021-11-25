package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewWindowController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;
	boolean sw;

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
		 		
		conn = mysqlconnect.ConnectDb();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
			srs = stmt.executeQuery("select * from student");
		} catch (SQLException e) {
			System.out.println("SQL Error");
		} 				
		try {
			sw = srs.next();
			lookup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    @FXML
    void onClickBack(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }
    @FXML
    void onClickClose(ActionEvent event) {
		int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want really to close?");
		if(dialogresult == JOptionPane.YES_NO_OPTION)
		{
			System.exit(0);
		}
    }
    
    void lookup() {
		try {
			if(sw) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}
			else {
				JOptionPane.showMessageDialog(null, "No Data !!");     		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void onClickBack2(ActionEvent event) {
		try {
			sw = srs.previous();
			lookup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickFirst(ActionEvent event) {
		try {
			sw = srs.first();
			lookup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickLast(ActionEvent event) {
		try {
			sw = srs.last();
			lookup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void onClickNext(ActionEvent event) {
		try {
			sw = srs.next();
			lookup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
