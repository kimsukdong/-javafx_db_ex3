package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

import javax.swing.JOptionPane;

public class SampleController {
	Connection conn;
	PreparedStatement stmt = null;
	ResultSet srs;
	String sql;
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			sql = "select * from student where name=?";
			stmt = conn.prepareStatement(sql);


		} catch (SQLException e) {
			System.out.println("SQL Error");
		} 
	}
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
	void onClickSearch(ActionEvent event) {
		try {		
			stmt.setString(1, tf5.getText());
			srs = stmt.executeQuery();
			if(srs.next()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}
			else {
				JOptionPane.showMessageDialog(null, "No Name!");    		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
