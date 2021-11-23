package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SampleController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;
	
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private Label label1;
    
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {			
			stmt = conn.createStatement();
    		srs = stmt.executeQuery("select * from student");
		} catch (SQLException e) {
			System.out.println("SQL Error");
		} 
		
		lookup();
	}
	
	public void lookup(){
    	try {
    		if(srs.next()) {
    			tf1.setText(srs.getString("id"));
    			tf2.setText(srs.getString("name"));
    			tf3.setText(srs.getString("email"));
    			tf4.setText(srs.getString("phone"));
    		}
    		else
    			label1.setText("더이상 자료가 없음 !!!");
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}

    @FXML
    void onClickNext(ActionEvent event) {
    	lookup();
    }

}
