package facialrecognition;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class personcontrol {


		connectbank connection = new connectbank();
		 public void insert(personmodel mod) {
			try {
				connection.connect();
				PreparedStatement pst = connection.conn.prepareStatement("INSERT INTO person (id,first_name,last_name,dob,office) values (?,?,?,?,?)");
				pst.setInt(1, mod.getId());
				pst.setString(2, mod.getFirst_name());
				pst.setString(3, mod.getLast_name());
				pst.setString(4, mod.getDob());
				pst.setString(5, mod.getOffice());
				pst.executeUpdate();
				System.out.println("Hello" + mod.getFirst_name() +" yea");
				connection.disconnect();
			}catch (SQLException ex) {
				System.out.println("Error" + ex);
			}
		}


}
