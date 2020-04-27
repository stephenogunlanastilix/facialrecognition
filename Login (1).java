/**

* Login class Authuenticates user 
* information and makes sure user can have access to the software 
* 

*/
package bankingsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//Imports banking system class 
import bankingsystem.Menu;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JPasswordField txt_pass;
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Banking system -Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 593, 539);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txt_user = new JTextField();
		txt_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_user.setBounds(32, 137, 500, 50);
		panel_1.add(txt_user);
		txt_user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(32, 98, 282, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(lblNewLabel);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(32, 200, 282, 16);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("Login to your account");
		lblNewLabel_1.setBounds(153, 27, 294, 50);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		panel_1.add(lblNewLabel_1);
		
		txt_pass = new JPasswordField();
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_pass.setBounds(32, 229, 500, 50);
		panel_1.add(txt_pass);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(174, 305, 237, 72);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		// Action listener set a the action to be performed
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Set the String user to the username textbox variable
				 String user = txt_user.getText();
				//Set the String password to the password textbox variable
				 String password = txt_pass.getText();
				//Check if the password and user is empty then throws an error
			     if(password.isEmpty()|| user.isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Username or password  cannot be empty");
				 }
			     //Checks if the password is equals to admin
				 else if (password.equals("admin")){
					 //Initialize Menu class and passes the Variable user as a parameter
					 Menu menu = new Menu(user);
					 //Redirect users to menu class by set visbility to true
					 menu.setVisible(true);		
					 //Dispose closes the login page
					 dispose();
				 }
				 else {
					 //Display password not correct  error if password does not equal to admin
					 JOptionPane.showMessageDialog(null, "Password not correct");
				 }
			     

			}
		});
		panel_1.add(btnNewButton);
	}
}

