package college;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.sql.*;

@SuppressWarnings("serial")
public class RegisterUI extends JPanel {
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField dobTextField;

	/**
	 * Create the panel.
	 */
	public RegisterUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(17);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("REGISTERATION WINDOW");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("AR CENA", Font.PLAIN, 18));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("USERNAME");
		lblNewLabel_1_1.setFont(new Font("AR CENA", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("PASSWORD");
		lblNewLabel_1_2.setFont(new Font("AR CENA", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_3 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_1_3.setFont(new Font("AR CENA", Font.PLAIN, 18));
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(10);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("DOB");
		lblNewLabel_1_3_1.setFont(new Font("AR CENA", Font.PLAIN, 18));
		
		dobTextField = new JTextField();
		dobTextField.setColumns(10);
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_leftPanel.createSequentialGroup()
									.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
									.addGap(53)
									.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
										.addComponent(dobTextField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
											.addComponent(passwordField, 160, 160, 160))))
								.addGroup(gl_leftPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1_3)
									.addGap(18)
									.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(43, Short.MAX_VALUE))))
		);
		gl_leftPanel.setVerticalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_leftPanel.createSequentialGroup()
									.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(40))
								.addGroup(gl_leftPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(24)
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(26, Short.MAX_VALUE))
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addComponent(dobTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(66))))
		);
		leftPanel.setLayout(gl_leftPanel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(20);
		add(panel_1, BorderLayout.SOUTH);
		
		JButton doneButton = new JButton("DONE");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tableName = usernameTextField.getText().toLowerCase()+"_data";
				
				if((confirmPasswordField.getText()).equals(passwordField.getText())) {

					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con; 
						PreparedStatement st;
						
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3308/users?characterEncoding=latin1&useConfig=maxPerfomance", "root", "");
						st = con.prepareStatement("SELECT EXISTS(SELECT * FROM users_data WHERE username=?)");
						st.setString(1,  usernameTextField.getText());
						if(st.executeQuery() != null) {
							JOptionPane.showMessageDialog(null, "Username Already Exists");
							st.close();
						}else {
							st.close();

							st = con.prepareStatement("INSERT INTO users_data VALUES(?,?,?)");
							st.setString(1, usernameTextField.getText());
							st.setString(2,  passwordField.getText());
							st.setString(3, usernameTextField.getText().toLowerCase());
							st.execute();
							st.close();
							con.close();
							
							con = DriverManager.getConnection("jdbc:mysql://localhost:3308/medicines?characterEncoding=latin1&useConfig=maxPerfomance", "root", "");
							st = con.prepareStatement("CREATE TABLE "+tableName+"("
									+ " id INT PRIMARY KEY," 
									+ " name VARCHAR(20) NOT NULL," 
									+ " manufacturer VARCHAR(20)," 
									+ " salt VARCHAR(20),"
									+ " mfcLicence VARCHAR(10)," 
									+ " type VARCHAR(20)," 
									+ " quantity INT,"
									+ " color VARCHAR(20),"
									+ " buyingPrice FLOAT(7,2)," 
									+ " sellingPrice FLOAT(7,2),"  
									+ " buyingDate VARCHAR(10),"  
									+ " sellingDate VARCHAR(10)"
									+ ")");
							
							st.execute();
							st.close();					
							con.close();
							
							File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+usernameTextField.getText().toLowerCase());
							dir.mkdirs();
							

							File file = new File(dir, usernameTextField.getText().toLowerCase()+"_a.txt");
							file.createNewFile();
							
							file = new File(dir, usernameTextField.getText().toLowerCase()+"_date.txt");
							file.createNewFile();
							
							file = new File(dir, usernameTextField.getText().toLowerCase()+"_log.txt");
							file.createNewFile();
							
							FileWriter writer = new FileWriter(file);
							for(int i=1; i<=4; i++) {
								writer.write("NO Log Here Now/");
							}
							writer.close();
							
							JOptionPane.showMessageDialog(null,  "Registered");
							
						}
						

					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null,  "Some Error Occured: Please Try Again");
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "Passwords don't match");
				}
				
								
			}
		});
		panel_1.add(doneButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nameTextField.setText("");
				usernameTextField.setText("");
				passwordField.setText("");
				dobTextField.setText("");
				confirmPasswordField.setText("");
			}
		});
		panel_1.add(resetButton);

	}
}
