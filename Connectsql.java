/**
 * Connectsql class create a connection to database , disconnects , 
 * and also execute sql commands  in the database
 */
package bankingsystem;

//IMports neccesary Sql libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Connectsql {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;
    //Assign driver String to driver location
    private  final String driver = "org.mysql.Driver"; 
    //Assign roots to location and name of database name
    private  final String root = "jdbc:mysql://127.0.0.1/bankingsystem";	
    //Assings the user String to database username
    private  final String user = "root";
    //Assign password String to databse base password
    private  final String pass = "";
   
    
    /*
     * Creates connection to database , username and password then throws and error if it fails to connect
     */
    public void connect(){
    	try {
	    	System.setProperty("jdbc.Driver", driver);
	    	conn = DriverManager.getConnection(root,user,pass);
	    	System.out.println("Successfull");
       	}
    	 catch (SQLException e) {
    		System.out.println("Error" + e);
    	 }
    }
    /*
     * Disconnect database by closing connection and throws and error if it fails to disconnect
     */
    public void disconnect(){
    	try {
    		conn.close();
    	}
    	catch(Exception e) {
    		System.out.println("Error" + e);
    	}
    }
    /*
     * Exceute the sql come by declaring the statement and Assign in to the result set to execute
     */
    public void executesql(String SQL) {
    	try {
    		stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    		rs = stm.executeQuery(SQL);
    	}
    	catch(Exception e) {
    		System.out.println("Error" + e);
    	}
    }
    /*
     * Tries out the connection
     */
	public static void main(String[] args) {
		Connectsql connection = new Connectsql();
		connection.connect();
	}
}
