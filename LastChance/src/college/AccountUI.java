package college;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


@SuppressWarnings("serial")
public class AccountUI extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	Connection con;
	/**
	 * Create the panel.
	 */
	public AccountUI() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setVgap(20);
		topPanel.setBackground(Color.DARK_GRAY);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT WINDOW");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		topPanel.add(lblNewLabel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		leftPanel.setBackground(Color.DARK_GRAY);
		add(leftPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		lblNewLabel_3.setForeground(Color.WHITE);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(15);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(15);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occured: Please Try Again");
		}
		

		
		JButton doneButton = new JButton("DONE");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((confirmPasswordField.getText()).equals(passwordField.getText())) {
					
					try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3308/users?characterEncoding=latin1&useConfig=maxPerfomance", "root", "");
						PreparedStatement st = con.prepareStatement("UPDATE users_data "
								+ " SET password = ? "
								+ " WHERE username = ?");
						st.setString(1, passwordField.getText());
						st.setString(2,  usernameTextField.getText());
						
						int check = st.executeUpdate();
						if(check == 0) {
							JOptionPane.showMessageDialog(null, "Invalid Username");	
							st.close();
							con.close();
						}else {

							Main.writeLog("Password Changed for " + usernameTextField.getText());
							JOptionPane.showMessageDialog(null, "Updated");
							
							st.close();
							con.close();
						}		
					} catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null,  "Some Error Occurred: please try again");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Passwords don't match");
				}
				
			}
		});
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
				confirmPasswordField.setText("");
			}
		});
		
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(117)
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_leftPanel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_leftPanel.createSequentialGroup()
									.addComponent(doneButton)
									.addGap(62)))
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(resetButton)
								.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(39))
		);
		gl_leftPanel.setVerticalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(doneButton))
					.addGap(43))
		);
		leftPanel.setLayout(gl_leftPanel);
	}
}
