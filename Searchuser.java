/**
	
	* Search user class Find the the user in database by 
	* getting user member id and displaying the 
	* users information from the database

*/

package bankingsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Searchuser extends JFrame {

	private JPanel contentPane;
	private JTextField txt_search;
	Connectsql connection = new Connectsql();
	Insertinfo insertin;
	Getinfo getin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchuser frame = new Searchuser();
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
	public Searchuser() {
		setTitle("Banking System - Search user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(186, 27, 273, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter memeber id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(38, 100, 368, 40);
		contentPane.add(lblNewLabel_1);
		
		txt_search = new JTextField();
		txt_search.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txt_search.setBounds(38, 153, 448, 55);
		contentPane.add(txt_search);
		txt_search.setColumns(10);
		
		JButton searchbtn = new JButton("Search");
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		searchbtn.setBackground(Color.BLACK);
		// Action listener set a the action to be performed
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize InsertInfo class
				insertin = new Insertinfo();
				//Initialize Get info class
				getin = new Getinfo();
                //Assign Search member id text box to setmemberid
				getin.setmemberid(txt_search.getText());
				//Assign getin class to search Sql parameter
				insertin.search(getin);
			}
		});
		searchbtn.setBounds(146, 238, 260, 69);
		contentPane.add(searchbtn);
		

	}

}
