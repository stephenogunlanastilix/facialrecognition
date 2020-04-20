package facialrecognition;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu(String user) {
		setTitle("Security System - Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What do you want to do ");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(255, 93, 284, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Capture");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new registerperson().setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 266, 196, 160);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Recognse");
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(310, 266, 196, 160);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Data");
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.setBounds(568, 266, 196, 153);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("Choose an option");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(310, 132, 284, 42);
		contentPane.add(label);
		
		JLabel txt_username = new JLabel("Welcome User!");
		txt_username.setBackground(new Color(0, 0, 255));
		txt_username.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txt_username.setBounds(268, 75, 357, 16);
		txt_username.setText("Welcome " + user);
		contentPane.add(txt_username);
		
	}


	public Menu() {
		// TODO Auto-generated constructor stub
	}

}
