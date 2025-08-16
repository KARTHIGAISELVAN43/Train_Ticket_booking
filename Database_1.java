/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
import com.mycompany.edittraininfo.*;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Database_1 
{
	 ResultSet result;
     Connection con;
     Statement statement;
	 int t=0;
	Database_1()
	{
            
            
		try
		{
		           Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
            JOptionPane.showMessageDialog(null,"Connected");    
	
		}
		catch(Exception e)
		{
			          JOptionPane.showMessageDialog(null,"Not Connected");
		}
	
	}

	public int execute(String query)
	{
		try
		{
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
			statement=con.createStatement();
			t=statement.executeUpdate(query);
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Exception in processing");
		}
		return t;
		
	}
	
	public  ResultSet select(String query)
	{
		try
		{
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
			statement=con.createStatement();
			result=statement.executeQuery(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Exception in processing");
		}
		return result;
	}
        public static void main(String args[])
        {
            new Database_1();
        }

//    private void initComponents() {
  //      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
}