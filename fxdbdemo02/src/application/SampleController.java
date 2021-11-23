package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		lookup();
	}
	public void lookup() {
		try {

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
			srs = stmt.executeQuery("select * from student");

			if(srs.next()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}

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
	void onClickNext(ActionEvent event) {
		try {
			if(srs.next()) {
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
	void onClickBack(ActionEvent event) {
		try {
			if(srs.previous()) {
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
	void onClickFirst(ActionEvent event) {
		try {
			if(srs.first()) {
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
	void onClickLast(ActionEvent event) {
		try {
			if(srs.last()) {
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

}
