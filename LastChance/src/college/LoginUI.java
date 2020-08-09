package college;

//import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//=import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
//import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class LoginUI extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private String username;
	private String password;
	private String database;
	/**
	 * Create the panel.
	 */
	public LoginUI() {
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		topPanel.setBackground(Color.DARK_GRAY);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("PHARMACY   MANAGEMENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setForeground(Color.WHITE);
		lblSystem.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		GroupLayout gl_topPanel = new GroupLayout(topPanel);
		gl_topPanel.setHorizontalGroup(
			gl_topPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addGap(56)
					.addComponent(lblSystem, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
				.addGroup(gl_topPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		gl_topPanel.setVerticalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSystem, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		topPanel.setLayout(gl_topPanel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.DARK_GRAY);
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 0));
		rightPanel.setBackground(Color.DARK_GRAY);
		add(rightPanel, BorderLayout.CENTER);
		
		usernameTextField = new JTextField();
		usernameTextField.setAlignmentX(0.0f);
		usernameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 18));
		
		JLabel lblLoginWindow = new JLabel("LOGIN WINDOW");
		lblLoginWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginWindow.setForeground(Color.WHITE);
		lblLoginWindow.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 26));
		GroupLayout gl_rightPanel = new GroupLayout(rightPanel);
		gl_rightPanel.setHorizontalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLoginWindow, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_rightPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(88)
									.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
								.addGroup(gl_rightPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addGap(86)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))))
					.addGap(80))
		);
		gl_rightPanel.setVerticalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup()
					.addGap(41)
					.addComponent(lblLoginWindow, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		rightPanel.setLayout(gl_rightPanel);
		
		JPanel bottomPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) bottomPanel.getLayout();
		flowLayout.setVgap(50);
		bottomPanel.setBackground(Color.DARK_GRAY);
		add(bottomPanel, BorderLayout.SOUTH);
		
		JButton loginButton = new JButton("LOGIN");
		//loginButton.setBackground(Color.WHITE);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int flag = 0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/users?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM users_data");
				
					while(rs.next()) {
						username = rs.getString("username");
						password = rs.getString("password");
						database = rs.getString("data_base");
						if((usernameTextField.getText()).equals(username) && (passwordField.getText().equals(password))) {
							
							JFrame frame = new JFrame("Account Page");
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
							frame.getContentPane().add(new MainUI(username, database));
							
							frame.setBounds(450, 75, 600, 400);
							frame.setVisible(true);
							Main.theFrame.dispose();
							flag++;
						}
						
						}
					if(flag ==  0) {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
					
					rs.close();
					con.close();
					
					}catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
				}
				
					
			}
		});
		loginButton.setHorizontalAlignment(SwingConstants.LEADING);
		bottomPanel.add(loginButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_1);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
			}
		});
		bottomPanel.add(resetButton);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_4);
		
		JButton registerButton = new JButton("REGISTER");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Register");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new RegisterUI());
				frame.setSize(500, 400);
				frame.setVisible(true);
			}
		});
		bottomPanel.add(registerButton);

	}
}
