/*
 * The Add user class inputs the user information into the database 
 */

package bankingsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bankingsystem.Connectsql;
import bankingsystem.Getinfo;
import bankingsystem.Insertinfo;
import bankingsystem.RandomString;
import javax.swing.JPasswordField;

public class Adduser extends JFrame {
//Variable to get random string from
public static final String SOURCES ="1234567890";
private JPanel contentPane;
private JButton btnNewButton;
//Initialize connection to ConnectSql
Connectsql connection = new Connectsql();
//Initialize insertin to Insertinfo
Insertinfo insertin;
//Initialize getin to Getinfo
Getinfo getin;
private JPasswordField txt_password;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Adduser frame = new Adduser();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public Adduser() {
	setTitle("Banking System - Add user");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 644, 506);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JPanel panel_1 = new JPanel();
	panel_1.setBounds(0, 0, 626, 446);
	contentPane.add(panel_1);
	panel_1.setLayout(null);

	JLabel txt_id_label = new JLabel("Enter a new user");
	txt_id_label.setHorizontalAlignment(SwingConstants.CENTER);
	txt_id_label.setFont(new Font("Tahoma", Font.BOLD, 31));
	txt_id_label.setBounds(0, 13, 602, 40);
	panel_1.add(txt_id_label);

	JPanel panel = new JPanel();
	panel.setBounds(12, 81, 602, 265);
	panel_1.add(panel);
	panel.setLayout(null);

	JLabel lblNewLabel_1 = new JLabel("First Name");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_1.setBounds(12, 44, 173, 16);
	panel.add(lblNewLabel_1);

	/**
	JLabel lblNewLabel_2 = new JLabel("First Name");
	lblNewLabel_2.setBounds(12, 44, 56, 16);
	panel.add(lblNewLabel_2);
    **/
	
	JLabel lblNewLabel_3 = new JLabel("Last Name");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_3.setBounds(327, 44, 189, 16);
	panel.add(lblNewLabel_3);

	JLabel lblNewLabel_4 = new JLabel("Username");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_4.setBounds(12, 143, 122, 16);
	panel.add(lblNewLabel_4);

	JLabel lblNewLabel_5 = new JLabel("Password");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_5.setBounds(327, 143, 147, 16);
	panel.add(lblNewLabel_5);
	JFormattedTextField txt_username = new JFormattedTextField();
	txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txt_username.setBounds(12, 172, 263, 31);
	panel.add(txt_username);
	
	txt_password = new JPasswordField();
	txt_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txt_password.setBounds(327, 172, 251, 31);
	panel.add(txt_password);
	
	JFormattedTextField txt_firstname = new JFormattedTextField();
	txt_firstname.setBounds(12, 73, 253, 31);
	panel.add(txt_firstname);
	
	JFormattedTextField txt_lastname = new JFormattedTextField();
	txt_lastname.setBounds(327, 73, 251, 31);
	panel.add(txt_lastname);

	btnNewButton = new JButton("SAVE");
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		
		insertin = new Insertinfo();
		getin = new Getinfo();
		//initialize Random to Random String class
		RandomString random = new RandomString();
	   //Check if the class is empty then prints outs the error text fields cannot be empty
	    if(txt_firstname.getText().isEmpty()|| txt_lastname.getText().isEmpty() || txt_username.getText().isEmpty() || 
	    		txt_password.getText().isEmpty()) {
	    	 JOptionPane.showMessageDialog(null, "Text fields cannot be empty");
	    }else {
	    	//Set the setter firstname to txt_firstname
			getin.setFirstname(txt_firstname.getText());
			//Set the setter Lastname to txt_lastname
			getin.setLastname(txt_lastname.getText());
			//Set the setter username to txt_username
			getin.setUsername(txt_username.getText());
			//Set the setter Password to txt_password
			getin.setPassword(txt_password.getText());
			//Set the setter memberid to Random String
			getin.setmemberid(RandomString.generateString(new Random(), SOURCES, 4));
			//insert the getin into the method inser
			insertin.insert(getin);
			dispose();
	    }

		

	}
	});
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setBackground(Color.BLACK);
	btnNewButton.setBounds(172, 359, 279, 63);
	panel_1.add(btnNewButton);


}
}