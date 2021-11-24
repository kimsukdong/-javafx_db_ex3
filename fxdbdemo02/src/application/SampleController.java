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
	boolean sw;
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
			srs = stmt.executeQuery("select * from student");
			sw = srs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lookup();
	}
	public void lookup() {
		try {
			if(sw) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			} 			
			else {
				JOptionPane.showMessageDialog(null, "No Data!");    		
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
			sw = srs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			lookup();
	}

	@FXML
	void onClickBack(ActionEvent event) {
		try {
			sw= srs.previous();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lookup();
	}

	@FXML
	void onClickFirst(ActionEvent event) {
		try {
			sw= srs.first();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lookup();
	}
	@FXML
	void onClickLast(ActionEvent event) {
		try {
			sw= srs.last();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lookup();
	}
}
