package FacialRecog;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class registerperson extends JFrame {

private JPanel contentPane;
private JButton btnNewButton;
Connectbank connection = new Connectbank();
personcontrol cod;
personmodel mod;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
registerperson frame = new registerperson();
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
public registerperson() {
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

	JLabel txt_id_label = new JLabel("1");
	txt_id_label.setHorizontalAlignment(SwingConstants.CENTER);
	txt_id_label.setFont(new Font("Tahoma", Font.BOLD, 18));
	txt_id_label.setBounds(12, 28, 602, 40);
	panel_1.add(txt_id_label);

	JPanel panel = new JPanel();
	panel.setBounds(12, 81, 602, 215);
	panel_1.add(panel);
	panel.setLayout(null);

	JTextPane txt_firstname = new JTextPane();
	txt_firstname.setBounds(12, 73, 227, 22);
	panel.add(txt_firstname);

	JTextPane txt_lastname = new JTextPane();
	txt_lastname.setBounds(327, 73, 263, 22);
	panel.add(txt_lastname);

	JTextPane txt_office = new JTextPane();
	txt_office.setBounds(327, 172, 263, 22);
	panel.add(txt_office);

	JLabel lblNewLabel_1 = new JLabel("First Name");
	lblNewLabel_1.setBounds(12, 44, 97, 16);
	panel.add(lblNewLabel_1);

	JLabel lblNewLabel_2 = new JLabel("First Name");
	lblNewLabel_2.setBounds(12, 44, 56, 16);
	panel.add(lblNewLabel_2);

	JLabel lblNewLabel_3 = new JLabel("Last Name");
	lblNewLabel_3.setBounds(327, 44, 60, 16);
	panel.add(lblNewLabel_3);

	JLabel lblNewLabel_4 = new JLabel("DOB: (mm-dd-yy)");
	lblNewLabel_4.setBounds(12, 143, 122, 16);
	panel.add(lblNewLabel_4);

	JLabel lblNewLabel_5 = new JLabel("Office");
	lblNewLabel_5.setBounds(327, 143, 51, 16);
	panel.add(lblNewLabel_5);
	JFormattedTextField txt_dob = new JFormattedTextField();
	txt_dob.setBounds(12, 172, 227, 22);
	panel.add(txt_dob);

	btnNewButton = new JButton("SAVE");
	btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		cod = new personcontrol();
		mod = new personmodel();
		
		mod.setFirst_name(txt_firstname.getText());
		mod.setLast_name(txt_lastname.getText());
		mod.setDob(txt_dob.getText());
		mod.setOffice(txt_office.getText());
		cod.insert(mod); 
		
		//test
		
	}
	});
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setBackground(new Color(0, 128, 0));
	btnNewButton.setBounds(249, 335, 97, 25);
	panel_1.add(btnNewButton);


}
private void showIdUser() {
	connection.connect();
	try {
		connection.executesql("SELECT * FROM person ORDER BY id DESC LIMIT 1");
		connection.rs.first();
		JLabel txt_id_label = new JLabel("Each User gets an ID");
		txt_id_label.setText(String.valueOf(connection.rs.getInt("id")));
		int id = Integer.parseInt(txt_id_label.getText());
		id++;
		txt_id_label.setText(String.valueOf(id));	
	}
	catch(Exception e) {
		
	}
}
}
