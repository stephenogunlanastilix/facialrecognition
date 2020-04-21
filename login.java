package facialrecognition;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JPasswordField txt_pass;
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Security System -Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 424, 460);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txt_user = new JTextField();
		txt_user.setBounds(32, 114, 342, 22);
		panel_1.add(txt_user);
		txt_user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(32, 83, 108, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(32, 149, 108, 16);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(153, 27, 83, 50);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		panel_1.add(lblNewLabel_1);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(32, 178, 342, 22);
		panel_1.add(txt_pass);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(150, 235, 97, 25);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String user = txt_user.getText();
				 String password = txt_pass.getText();
				 if(password.equals("admin")) {
					 Menu menu = new Menu(user);
					 menu.setVisible(true);
					 
					 dispose();
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "try Again");
				 }
			}
		});
		panel_1.add(btnNewButton);
	}
}
