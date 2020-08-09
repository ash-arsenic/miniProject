package college;

//import java.lang.*;
import javax.swing.*;
import java.sql.*;
//import java.util.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Component;
//import java.awt.SystemColor;
import java.awt.Color;

@SuppressWarnings("serial")
public class AddUI extends JPanel {
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField manufacturerTextField;
	private JTextField saltTextField;
	private JTextField mfcLicenseTextField;
	private JTextField typeTextField;
	private JTextField quantityTextField;
	private JTextField colorTextField;
	private JTextField buyingPriceTextField;
	private JTextField sellingPriceTextField;
	private JTextField buyingDateTextField;
	private JTextField expiryDateTextField;

	/**
	 * Create the panel.
	 */
	public AddUI() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setVgap(15);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ADD MEDICINE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		topPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MANUFACTURER");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.PLAIN, 12));
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SALT");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		saltTextField = new JTextField();
		saltTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("MFC LIC NO");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		mfcLicenseTextField = new JTextField();
		mfcLicenseTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("TYPE");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		typeTextField = new JTextField();
		typeTextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(manufacturerTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(saltTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mfcLicenseTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(idTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(typeTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(manufacturerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(saltTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(mfcLicenseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) bottomPanel.getLayout();
		flowLayout_1.setHgap(50);
		flowLayout_1.setVgap(15);
		add(bottomPanel, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("ADD");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((nameTextField.getText().equals("")) || (saltTextField.getText().equals("")) || (manufacturerTextField.getText().equals("")) || (mfcLicenseTextField.getText().equals("")) || (typeTextField.getText().equals("")) || (colorTextField.getText().equals("")) || (buyingDateTextField.getText().equals("")) || (expiryDateTextField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Fill all the Field");
				}
				
				else {
					
					if(Float.parseFloat(buyingPriceTextField.getText()) < Float.parseFloat(sellingPriceTextField.getText())) {
						

						SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
						
						java.util.Date buying;
						java.util.Date expiry;
						
						try {
							
							buying = formatter.parse(buyingDateTextField.getText());
							expiry = formatter.parse(expiryDateTextField.getText());
							if(expiry.compareTo(buying) > 0) {
								try {
									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/medicines?characterEncoding=latin1&useConfig=maxPerfomance", "root", "");
									PreparedStatement st = con.prepareStatement("INSERT INTO "+MainUI.database+"_data "
											+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
									
									
									st.setInt(1,  Integer.parseInt(idTextField.getText()));
									st.setString(2,  nameTextField.getText());
									st.setString(3,  manufacturerTextField.getText());
									st.setString(4,  saltTextField.getText());
									st.setString(5,  mfcLicenseTextField.getText());
									st.setString(6,  typeTextField.getText());
									st.setInt(7,  Integer.parseInt(quantityTextField.getText()));
									st.setString(8,  colorTextField.getText());
									st.setFloat(9,  Float.parseFloat(buyingPriceTextField.getText()));
									st.setFloat(10, Float.parseFloat(sellingPriceTextField.getText()));
									st.setString(11, buyingDateTextField.getText());
									st.setString(12, expiryDateTextField.getText());
									st.executeUpdate();
									st.close();
									con.close();
									
									Main.writeLog(quantityTextField.getText() +" "+ nameTextField.getText()+" Medicine Added");
									JOptionPane.showMessageDialog(null,"Medicine Added");
								
								} catch(NullPointerException ex) {
									JOptionPane.showMessageDialog(null,"Fill all the Field");
									
								}catch(NumberFormatException ex) {
									JOptionPane.showMessageDialog(null,"Enter Valid Entry");
								
								}catch(MySQLIntegrityConstraintViolationException ex) {
									JOptionPane.showMessageDialog(null,"Medicine ID already Exists");
								
								}catch(com.mysql.jdbc.MysqlDataTruncation ex) {
									JOptionPane.showMessageDialog(null,  "Data Too long");
								}catch(Exception ex) {
									JOptionPane.showMessageDialog(null,  "Error Occured, Try Again");
									ex.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null, "Enter Valid Expiry date");	
							}
							
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, "Enter Date in dd-mm-yyyy format");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Enter Valid Selling Price");
					}
				}
			}
		});
		addButton.setHorizontalAlignment(SwingConstants.LEFT);
		bottomPanel.add(addButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTextField.setText("");
				nameTextField.setText("");
				manufacturerTextField.setText("");
				mfcLicenseTextField.setText("");
				quantityTextField.setText("");
				saltTextField.setText("");
				buyingPriceTextField.setText("");
				sellingPriceTextField.setText("");
				buyingDateTextField.setText("");
				expiryDateTextField.setText("");
				typeTextField.setText("");
				colorTextField.setText("");
				
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut);
		resetButton.setHorizontalAlignment(SwingConstants.LEFT);
		bottomPanel.add(resetButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("QUANTITY");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Century", Font.PLAIN, 14));
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("COLOR");
		lblNewLabel_1_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		colorTextField = new JTextField();
		colorTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("BUYING PRICE");
		lblNewLabel_1_1_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		buyingPriceTextField = new JTextField();
		buyingPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1_1 = new JLabel("SELLING PRICE");
		lblNewLabel_1_1_1_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		sellingPriceTextField = new JTextField();
		sellingPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1_2 = new JLabel("BUYING DATE");
		lblNewLabel_1_1_1_1_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1_1_2.setFont(new Font("Century", Font.PLAIN, 14));
		
		buyingDateTextField = new JTextField();
		buyingDateTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1_1_1 = new JLabel("EXPIRY DATE");
		lblNewLabel_1_1_1_1_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1_1_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		expiryDateTextField = new JTextField();
		expiryDateTextField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buyingPriceTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sellingPriceTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_2_1_1_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buyingDateTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(expiryDateTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(quantityTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(colorTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(buyingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(sellingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_2_1_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(buyingDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(expiryDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

	}
}
