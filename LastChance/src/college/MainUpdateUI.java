package college;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import college.SearchUI;
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

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.swing.JButton;
//import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainUpdateUI extends JPanel {
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField manufacturerTextField;
	private JTextField saltTextField;
	private JTextField mfcLicenceTextField;
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
	public MainUpdateUI(int id) {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setVgap(15);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("UPDATE MEDICINE DATA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		topPanel.add(lblNewLabel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.DARK_GRAY);
		add(leftPanel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("MANUFACTURER");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Century", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_3 = new JLabel("SALT");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_4 = new JLabel("MFC LIC NO.");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_5 = new JLabel("TYPE");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Century", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setColumns(10);
		
		saltTextField = new JTextField();
		saltTextField.setColumns(10);
		
		mfcLicenceTextField = new JTextField();
		mfcLicenceTextField.setColumns(10);
		
		typeTextField = new JTextField();
		typeTextField.setColumns(10);
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(
			gl_leftPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(manufacturerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(mfcLicenceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_leftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(saltTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_leftPanel.createSequentialGroup()
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_leftPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(idTextField)
								.addComponent(nameTextField))))
					.addContainerGap())
		);
		gl_leftPanel.setVerticalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(manufacturerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(saltTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(mfcLicenceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		leftPanel.setLayout(gl_leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.DARK_GRAY);
		add(rightPanel, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("QUANTITY");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 14));
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("COLOR");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2 = new JLabel("BUYING PRICE");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_3 = new JLabel("SELLING PRICE");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_4 = new JLabel("BUYING DATE");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Century", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_5 = new JLabel("EXPIRY DATE");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Century", Font.PLAIN, 14));
		
		colorTextField = new JTextField();
		colorTextField.setColumns(10);
		
		buyingPriceTextField = new JTextField();
		buyingPriceTextField.setColumns(10);
		
		sellingPriceTextField = new JTextField();
		sellingPriceTextField.setColumns(10);
		
		buyingDateTextField = new JTextField();
		buyingDateTextField.setColumns(10);
		
		expiryDateTextField = new JTextField();
		expiryDateTextField.setColumns(10);
		GroupLayout gl_rightPanel = new GroupLayout(rightPanel);
		gl_rightPanel.setHorizontalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(buyingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2_5, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(expiryDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_rightPanel.createSequentialGroup()
							.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(sellingPriceTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buyingDateTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_rightPanel.setVerticalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(buyingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(sellingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(buyingDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(expiryDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		rightPanel.setLayout(gl_rightPanel);
		
		JPanel bottomPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) bottomPanel.getLayout();
		flowLayout_1.setVgap(20);
		bottomPanel.setBackground(Color.DARK_GRAY);
		add(bottomPanel, BorderLayout.SOUTH);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//SearchUI.con = DriverManager.getConnection("jdbc:mysql://localhost:3308/medicines?characterEncoding=latin1&useConfigs=maxPerfomance", "root", "");					
			Statement st = SearchUI.con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM "+MainUI.database+"_data WHERE id="+id);
			
			
			while(rs.next()) {
			
				idTextField.setText(String.valueOf(rs.getInt("id")));
				
				nameTextField.setText(String.valueOf(rs.getString("name")));
				
				manufacturerTextField.setText(String.valueOf(rs.getString("manufacturer")));
				
				mfcLicenceTextField.setText(String.valueOf(rs.getString("mfcLicence")));
				
				typeTextField.setText(String.valueOf(rs.getString("type")));
				
				colorTextField.setText(String.valueOf(rs.getString("color")));
				
				buyingDateTextField.setText(String.valueOf(rs.getString("buyingDate")));
				
				expiryDateTextField.setText(String.valueOf(rs.getString("sellingDate")));
				
				saltTextField.setText(String.valueOf(rs.getString("salt")));
				//nameTextField.setText(String.valueOf(rs.getString("name")));
				
				quantityTextField.setText(String.valueOf(rs.getInt("quantity")));
				
				buyingPriceTextField.setText(String.valueOf(rs.getFloat("buyingPrice")));
				
				sellingPriceTextField.setText(String.valueOf(rs.getFloat("sellingPrice")));
			
			}
			
			rs.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((nameTextField.getText().equals("")) || (saltTextField.getText().equals("")) || (manufacturerTextField.getText().equals("")) || (mfcLicenceTextField.getText().equals("")) || (typeTextField.getText().equals("")) || (colorTextField.getText().equals("")) || (buyingDateTextField.getText().equals("")) || (expiryDateTextField.getText().equals(""))) {
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
									
									/*PreparedStatement ps = SearchUI.con.prepareStatement("UPDATE medicine_date"
											+ " SET name="+ nameTextField.getText() + ", manufacturer=" + manufacturerTextField.getText() + ", mfcLicence=" + mfcLicenceTextField.getText() + ", type=" + typeTextField.getText() + ", color=" + colorTextField.getText() + ", buyingDate=" + buyingDateTextField.getText() + ", sellingDate=" + expiryDateTextField.getText() + ", salt=" + saltTextField.getText() + ", quantity=" + Integer.parseInt(quantityTextField.getText()) + ", buyingPrice=" + Float.parseFloat(buyingPriceTextField.getText()) + ", sellingPrice=" + Float.parseFloat(sellingPriceTextField.getText())
											+ "WHERE id="+id );
									*/
									PreparedStatement ps = SearchUI.con.prepareStatement("UPDATE "+MainUI.database+"_data"
											+ " SET name=?, manufacturer=?, mfcLicence=?, type=?, color=?, buyingDate=?, sellingDate=?, salt=?, quantity=?, buyingPrice=?, sellingPrice=?"
											+ "WHERE id="+id );
									
									ps.setString(1, nameTextField.getText());
									ps.setString(2, manufacturerTextField.getText());
									ps.setString(3, mfcLicenceTextField.getText());
									ps.setString(4, typeTextField.getText());
									ps.setString(5, colorTextField.getText());
									ps.setString(6, buyingDateTextField.getText());
									ps.setString(7, expiryDateTextField.getText());
									ps.setString(8, saltTextField.getText());
									ps.setInt(9, Integer.parseInt(quantityTextField.getText()));
									ps.setFloat(10, Float.parseFloat(buyingPriceTextField.getText()));
									ps.setFloat(11, Float.parseFloat(sellingPriceTextField.getText()));
									
									ps.executeUpdate();
									
									college.Main.writeLog("Medicine Updated with ID " + id);
									
									ps.close();

									JOptionPane.showMessageDialog(null, "Medicine Updated");
									
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
		bottomPanel.add(updateButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut_2);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				manufacturerTextField.setText("");
				mfcLicenceTextField.setText("");
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
		bottomPanel.add(resetButton);

	}
}
