/*
 * Insert Info class Runs all the database code that is need to delete from database , insert , update and search
 */
package bankingsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Insertinfo {
   //Initialize the Connectsql class
	Connectsql connection = new Connectsql();
	 public void insert(Getinfo getin) {
		try {
			connection.connect();
			//Then runs an insert sql query inorder to insert need vairables into the userinfo table
			PreparedStatement pst = connection.conn.prepareStatement("INSERT INTO userinfo (id,first_name,"
					+ "last_name,username,password,memberid,acctbalance) values (?,?,?,?,?,?,0)");
			//inputs the id into the database using the getter getid
			pst.setInt(1, getin.getid());
			//Inputs firstname into the database using the getter getFirstname
			pst.setString(2, getin.getFirstname());
			//Inputs lastname into the database using the getter getLastname
			pst.setString(3, getin.getLastname());
			//Inputs Username into the database using the getter getUSername
			pst.setString(4, getin.getUsername());
			//Inputs password into the database using the getter getPassword
			pst.setString(5, getin.getPassword());
			//Inputs Member id  into the database using the getter getmemberid
			pst.setString(6, getin.getmemberid());
			//Execute inputs
			pst.executeUpdate();
			//Dialog message showing user has been added to database and displaying member id 
			JOptionPane.showMessageDialog(null, getin.getFirstname() + " has been added to database membership id is " + getin.getmemberid());
			//Disconnect Sql Connection
			connection.disconnect();
		}catch (SQLException ex) {
			//Print out error if any
			System.out.println("Error" + ex);
		}
	}
	 public void delete(Getinfo getin) {
			try {
				connection.connect();
				//Sql query deletes data from userinfo table where memberid matches the inputted String
				PreparedStatement pst = connection.conn.prepareStatement("DELETE FROM userinfo  WHERE memberid=?");
				//Inputs Member id  into the database using the getter getmemberid
				pst.setString(1, getin.getmemberid());
				//Execute inputs
				pst.executeUpdate();
				//Dialog message to know if input are made succesfully
				JOptionPane.showMessageDialog(null,  "Member " + getin.getmemberid() + " has been deleted from database ");
				//Disconnect Sql Connection
				connection.disconnect();
			}catch (SQLException ex) {
				//Print out error if any
				System.out.println("Error" + ex);
			}
		}
	 public void search(Getinfo getin) {
			try {
				//Sql query selects data from userinfo where memberid matches inputted String
				String sql = "SELECT * FROM userinfo  WHERE memberid='"+getin.getmemberid()+"'";
				//Initialize Statemet
			    Statement stm;
				connection.connect();
				//Passses Sql variable to Prepared Statement
				PreparedStatement pst = connection.conn.prepareStatement(sql);
				//Creates sql  Statements
		        stm = connection.conn.createStatement();
		        //Execute Sql query and assigns it to Result set rs
		        ResultSet rs = stm.executeQuery(sql);
		        /*
		         * Loops through result set and Assings them to unique variables
		         */
		        while(rs.next()){
		            String memberid  = rs.getString("memberid");
		            String username = rs.getString("username");
		            String firstname = rs.getString("first_name");
		            String lastname = rs.getString("last_name");
		            String acctbalance = rs.getString("acctbalance");
		            Viewuser viewuser = new Viewuser(username , firstname , lastname , memberid , acctbalance);
		            //Displays View user class
					viewuser.setVisible(true);
		
		         }
		        //Close Loop
		         rs.close();
					//Disconnect Sql Connection
				connection.disconnect();
			}catch (SQLException ex) {
				//Print out error if any
				System.out.println("Error" + ex);
			}
		}
	 public void inserttoacct(Getinfo getin) {
		try {
			connection.connect();
			//Sql query Updates userinfo account balance area where member id matches users member id 
			PreparedStatement pst = connection.conn.prepareStatement("UPDATE userinfo SET acctbalance=? WHERE memberid=?");

			//Inputs Account balance into the database using the getter getacctbalance
			pst.setString(1, getin.getacctbalance());
			//Inputs Member id  into the database using the getter getmemberid
			pst.setString(2, getin.getmemberid());
			//Execute pst inputs
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, " Account has been balanced");
			//Disconnect Sql Connection
			connection.disconnect();
		}catch (SQLException ex) {
			//Print out error if any
			System.out.println("Error" + ex);
		}
	}
}
