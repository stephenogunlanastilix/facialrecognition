/*
 * Update user account with some money
 */
package bankingsystem;
//Doing all the imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
// Class Updateacct extending JFrame
public class Updateacct extends JFrame {

	private JPanel contentPane;
	private JTextField id_area;
	Connectsql connection = new Connectsql();
	Insertinfo insertin;
	Getinfo getin;
	private JTextField amount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {//TRy and catch bloc to throw an exception and printing the stackTrace
					Updateacct frame = new Updateacct();
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
	public Updateacct() {
		setTitle("Banking System - Update user Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add money to users account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(90, 23, 465, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter memeber id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(38, 100, 312, 22);
		contentPane.add(lblNewLabel_1);
		
		id_area = new JTextField();
		id_area.setBounds(38, 135, 420, 36);
		contentPane.add(id_area);
		id_area.setColumns(10);
		
		JButton searchbtn = new JButton("Add");
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setBackground(Color.BLACK);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize the insertinfo class
				insertin = new Insertinfo();
				//Initialize the Getinfo class
				getin = new Getinfo();
		       	//Sets delete id textbox to setmember id setter
				getin.setmemberid(id_area.getText());
		       	//Set Account balance textbox to setacctbalance setter
				getin.setacctbalance(amount.getText());
				//inset the getin setter to the inserttoacct method in insert info that inserts money to accoutbalance in database
				insertin.inserttoacct(getin);
			}
		});
		searchbtn.setBounds(174, 309, 222, 63);
		contentPane.add(searchbtn);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount$:");
		lblEnterAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterAmount.setBounds(38, 184, 230, 22);
		contentPane.add(lblEnterAmount);
		
		amount = new JFormattedTextField();
		amount.setColumns(10);
		amount.setBounds(38, 219, 420, 36);
		contentPane.add(amount);
		

	}
}
//Ends Update Account