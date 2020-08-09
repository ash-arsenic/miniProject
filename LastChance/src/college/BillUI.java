package college;

import javax.swing.JPanel;
//import java.text.*;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
//import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

@SuppressWarnings("serial")
public class BillUI extends JPanel {
	private JTextField customerNameTextField;
	private JTextField ageTextField;
	private JTextField mobileTextField;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField quantityTextField;
	private JTextField priceTextField;
	private FileWriter fw;
	private JTextField discountTextField;
	public float totalAmount=0.00f;
	private Connection con;
	private PreparedStatement ps;
	private PreparedStatement ps1;
	private int quantity;
	private int quantityCheck;
	private int nameFlag=0;
	private int medicineFlag=0;
	/**
	 * Create the panel.
	 */
	public BillUI(File file) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) topPanel.getLayout();
		flowLayout_3.setVgap(15);
		topPanel.setBackground(Color.DARK_GRAY);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("GENERATE BILL");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		topPanel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1, BorderLayout.SOUTH);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/medicines?characterEncoding=latin1&useConfig=maxPerfomance", "root", "");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		JButton doneButton = new JButton("DONE");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(medicineFlag == 2) {
					
					try {
						
						
						fw.write("\r\n\r\n\r\n\r\n Total Amount\t\t\t\t\t"+String.valueOf(totalAmount)+"\r\n");
						fw.write(" Discount\t\t\t\t\t"+discountTextField.getText()+"\r\n\r\n");
						fw.write(" Payable Amount\t\t\t\t\t"+String.valueOf(totalAmount - Float.parseFloat(discountTextField.getText())+"\r\n\r\n\r\n"));
						
						fw.write("------------------------------------------------------------------------------------\r\n\r\n");
						
						fw.write("\r\n Ashish Chauhan\r\n");
						fw.write(" Chemist\r\n");
						fw.write(" 9874631231\r\n");
						fw.write("\r\n************************************************************************************");
						fw.close();
						
						college.Main.writeLog("Bill Generated for "+customerNameTextField.getText()+" of "+String.valueOf(totalAmount - Float.parseFloat(discountTextField.getText())));
						
						FileWriter dateFw = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_date.txt");
						/*SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
						Date date = new Date();
						*/
						dateFw.write(String.valueOf(java.time.LocalDate.now()));
						dateFw.close();
						college.Main.updateEarning(totalAmount - Float.parseFloat(discountTextField.getText()));
						
						con.close();
						JOptionPane.showMessageDialog(null, "Bill Generated");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
					}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Submit Medicine Info First");
				}
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("DISCOUNT");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Century", Font.BOLD, 14));
		panel_1.add(lblNewLabel_7);
		
		discountTextField = new JTextField();
		panel_1.add(discountTextField);
		discountTextField.setColumns(10);
		discountTextField.setText("0.00");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_8);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4);
		panel_1.add(doneButton);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centreTopPanel = new JPanel();
		centreTopPanel.setBackground(Color.DARK_GRAY);
		centreTopPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) centreTopPanel.getLayout();
		flowLayout.setVgap(25);
		flowLayout.setHgap(15);
		centerPanel.add(centreTopPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 14));
		centreTopPanel.add(lblNewLabel_1);
		
		customerNameTextField = new JTextField();
		centreTopPanel.add(customerNameTextField);
		customerNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 14));
		centreTopPanel.add(lblNewLabel_2);
		
		ageTextField = new JTextField();
		centreTopPanel.add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE NO.");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century", Font.PLAIN, 14));
		centreTopPanel.add(lblNewLabel_3);
		
		mobileTextField = new JTextField();
		centreTopPanel.add(mobileTextField);
		mobileTextField.setColumns(10);
		
		
		JLabel nameLabel = new JLabel("Bansal Medicos");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		try {
			
			fw = new FileWriter(file);

			fw.write("\r\n************************************************************************************\r\n\r\n\r\n");
			fw.write("\t\t\t\t\tBANSAL MEDICOS\r\n");
			fw.write("\t\t\t\t433-A, Nyay Khand 3, Indirapuram\r\n");
			fw.write("\t\t\t\t\tGhaziabad, UP-201014\r\n");
			fw.write("\t\t\t\t\tGST:46389878AAA\r\n\r\n");
			fw.write("------------------------------------------------------------------------------------\r\n");
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		JButton customerAddButton = new JButton("Done");
		customerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((customerNameTextField.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Name");
				}
				else {
					try {
						fw.write(" Name: "+customerNameTextField.getText());
						fw.write("\t\tAge:"+ageTextField.getText());
						fw.write("\t\tMobile No.:"+mobileTextField.getText());
						fw.write("\r\n------------------------------------------------------------------------------------\r\n");
						fw.write(" ID\t\tName\t\tQuantity\t\tPrice\t\r\n");
						nameFlag = 1;
						
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
					}
				}
			}
		});
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		centreTopPanel.add(horizontalStrut_9);
		centreTopPanel.add(customerAddButton);
		
		JPanel centerBottomPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) centerBottomPanel.getLayout();
		flowLayout_2.setVgap(15);
		centerBottomPanel.setBackground(Color.DARK_GRAY);
		centerPanel.add(centerBottomPanel, BorderLayout.SOUTH);
		

		
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if((nameTextField.getText().equals("")) || (quantityTextField.getText().equals("")) || (priceTextField.getText().equals("")) || (idTextField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Fill all the Field");
				}
				
				else {

					if(nameFlag == 1) {
						try {
							ps = con.prepareStatement("UPDATE "+MainUI.database+"_data"
									+ " SET quantity=?"
									+ " WHERE id=?");
							
							ps1 = con.prepareStatement("SELECT quantity FROM "+MainUI.database+"_data WHERE id=?");
							ps1.setInt(1, Integer.parseInt(idTextField.getText()));
							
							ResultSet rs = ps1.executeQuery();
							
							while(rs.next()) {
								quantity = rs.getInt(1);
							}
							
							quantityCheck = quantity - Integer.parseInt(quantityTextField.getText());
							
							if(quantityCheck<0) {
								JOptionPane.showMessageDialog(null, "Not enough Medicine");
								ps1.close();
								rs.close();
							}
							
							else {
								ps1.close();
								rs.close();
								
								ps.setInt(1, quantity - Integer.parseInt(quantityTextField.getText()));
								ps.setInt(2, Integer.parseInt(idTextField.getText()));
							
								ps.executeUpdate();
							
								totalAmount = totalAmount + Float.parseFloat(priceTextField.getText()) * Integer.parseInt(quantityTextField.getText());
								
								fw.write(" "+idTextField.getText()+"\t\t"+nameTextField.getText()+"\t"+quantityTextField.getText()+"\t\t\t"+priceTextField.getText()+"\r\n");
								medicineFlag = 2;
								ps.close();
								
							}
							
						}catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
						}
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Submit Customer Information First.");
					}
			
				}	
			}
		});
		centerBottomPanel.add(addButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut_2);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut_10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut_3);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTextField.setText("");
				nameTextField.setText("");
				quantityTextField.setText("");
				priceTextField.setText("");
			}
		});
		centerBottomPanel.add(resetButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut_1);
		
		JButton fillButton = new JButton("FILL");
		fillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int check=0;
				
				try {
					ps=con.prepareStatement("SELECT EXISTS(SELECT * FROM "+MainUI.database+"_data WHERE id=?)");
					ps.setInt(1, Integer.parseInt(idTextField.getText()));
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						check = rs.getInt(1);
					}
					
					if(check == 1) {
						
						ps = con.prepareStatement("SELECT name, quantity, sellingPrice FROM "+MainUI.database+"_data WHERE id=?");
						ps.setInt(1, Integer.parseInt(idTextField.getText()));
						rs = ps.executeQuery();
						
						while(rs.next()) {
							nameTextField.setText(rs.getString("name"));
							quantityTextField.setText(String.valueOf(rs.getInt("quantity")));
							priceTextField.setText(String.valueOf(rs.getFloat("sellingPrice")));
						}
						
						rs.close();
						ps.close();
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Medicine ID Does Not Exist");
						rs.close();
						ps.close();
					}
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Enter ID");
					
				}
			}
		});
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		centerBottomPanel.add(horizontalStrut_11);
		centerBottomPanel.add(fillButton);
		
		JPanel centerCenterPanel = new JPanel();
		centerCenterPanel.setBackground(Color.DARK_GRAY);
		centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		centerCenterPanel.setLayout(new BorderLayout(0, 2));
		
		JPanel centerLeftPanel = new JPanel();
		centerLeftPanel.setBackground(Color.DARK_GRAY);
		centerCenterPanel.add(centerLeftPanel, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Century", Font.PLAIN, 16));
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("NAME");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Century", Font.PLAIN, 16));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		GroupLayout gl_centerLeftPanel = new GroupLayout(centerLeftPanel);
		gl_centerLeftPanel.setHorizontalGroup(
			gl_centerLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_centerLeftPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addGroup(gl_centerLeftPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerLeftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerLeftPanel.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_centerLeftPanel.setVerticalGroup(
			gl_centerLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerLeftPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_centerLeftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(41)
					.addGroup(gl_centerLeftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		centerLeftPanel.setLayout(gl_centerLeftPanel);
		
		JPanel centerRightPanel = new JPanel();
		centerRightPanel.setBackground(Color.DARK_GRAY);
		centerCenterPanel.add(centerRightPanel, BorderLayout.EAST);
		
		JLabel lblNewLabel_5 = new JLabel("PRICE");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Century", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4_2 = new JLabel("QUANTITY");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Century", Font.PLAIN, 16));
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		GroupLayout gl_centerRightPanel = new GroupLayout(centerRightPanel);
		gl_centerRightPanel.setHorizontalGroup(
			gl_centerRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerRightPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_centerRightPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_2)
						.addComponent(lblNewLabel_5))
					.addGap(55)
					.addGroup(gl_centerRightPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_centerRightPanel.setVerticalGroup(
			gl_centerRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerRightPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_centerRightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2)
						.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_centerRightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		centerRightPanel.setLayout(gl_centerRightPanel);
		
		JLabel lblNewLabel_6 = new JLabel("Medicine Information");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Century", Font.BOLD, 24));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		centerCenterPanel.add(lblNewLabel_6, BorderLayout.NORTH);

	}

}
