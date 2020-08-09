package college;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
//import java.util.List;
//import java.awt.FlowLayout;
//import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
//import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class SearchUI extends JPanel{
	/**
	 * 
	 */
	private JTextField nameTextField;
	JTable table;
	private ResultSet rs;
	public static Connection con;
	
	DefaultTableModel tableModel;
	JPanel panel;
	/**
	 * Create the panel.
	 */
	public SearchUI() {
		setLayout(new BorderLayout(5, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setSize(new Dimension(10, 10));
		topPanel.setForeground(Color.WHITE);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("MEDICINE  DATA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER NAME");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.PLAIN, 16));
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSearchEnvironment();
			}
		});
		
		
		GroupLayout gl_topPanel = new GroupLayout(topPanel);
		gl_topPanel.setHorizontalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_topPanel.createSequentialGroup()
							.addGap(152)
							.addComponent(lblNewLabel_1)
							.addGap(73)
							.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
							.addGap(70)
							.addComponent(searchButton))
						.addGroup(gl_topPanel.createSequentialGroup()
							.addGap(336)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(226)))
					.addGap(178))
		);
		gl_topPanel.setVerticalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		topPanel.setLayout(gl_topPanel);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		add(panel, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		
		ArrayList<Medicines> medicineList = new ArrayList<Medicines>();
		
		table = new JTable();
		table.setCellSelectionEnabled(true);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/medicines?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM "+MainUI.database+"_data");
			
			while(rs.next()) {
				medicineList.add(new Medicines(rs.getInt("id"), rs.getString("name"), rs.getString("salt"), rs.getInt("quantity"), rs.getString("type"), rs.getFloat("buyingPrice"), rs.getFloat("sellingPrice"), rs.getString("buyingDate"), rs.getString("sellingDate"), rs.getString("color"), rs.getString("manufacturer"),  rs.getString("mfcLicence") ));
			}
		
			
						/*
			while(rs.next()) {
				object[i][0] = rs.getInt("id");
				object[i][1] = rs.getString("name");
				object[i][2] = rs.getString("salt");
				object[i][3] = rs.getString("quantity");
				object[i][4] = rs.getString("type");
				object[i][5] = rs.getFloat("buyingPrice");
				object[i][6] = rs.getFloat("sellingPrice");
				object[i][7] = rs.getString("buyingDate");
				object[i][8] = rs.getString("sellingDate");
				object[i][9] = rs.getString("color");
				object[i][10] = rs.getString("manufacturer");
				object[i][11] = rs.getString("mfcLicence");
				i++;
			}
			*/
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		tableModel = new DefaultTableModel();
		
		tableModel.setColumnIdentifiers(new String[] {
				"ID", "NAME", "SALT", "QUANTITY", "TYPE", "BUYING PRICE", "SELLING PRICE", "BUYING DATE", "EXPIRY DATE", "COLOR", "MANUFACTURER", "MFC LIC NO."
			});
		
		Object[] object = new Object[12];
		
		for(Medicines data:medicineList) {
			object[0] = data.getID();
			object[1] = data.getName();
			object[2] = data.getSalt();
			object[3] = data.getQuantity();
			object[4] = data.getType();
			object[5] = data.getBuyingPrice();
			object[6] = data.getSellingPrice();
			object[7] = data.getBuyingDate();
			object[8] = data.getExpiryDate();
			object[9] = data.getColor();
			object[10] = data.getManufacturer();
			object[11] = data.getMFCLicence();
			
			tableModel.addRow(object);
		}
		
		table.setModel(tableModel);
		
		/*table.setModel(new DefaultTableModel(
			object,
			new String[] {
				"ID", "NAME", "SALT", "QUANTITY", "TYPE", "BUYING PRICE", "SELLING PRICE", "BUYING DATE", "EXPIRY DATE", "COLOR", "MANUFACTURER", "MFC LIC NO."
			}
		));*/
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(81);
		table.getColumnModel().getColumn(6).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(46);
		table.getColumnModel().getColumn(10).setPreferredWidth(93);
		table.setColumnSelectionAllowed(true);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.EAST);

	}
	
	public void setSearchEnvironment() {
		
		ArrayList<Medicines> searchedList = new ArrayList<Medicines>();
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+MainUI.database+"_data WHERE name=?");
			ps.setString(1, nameTextField.getText());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				rs = ps.executeQuery();
				while(rs.next()) {
					searchedList.add(new Medicines(rs.getInt("id"), rs.getString("name"), rs.getString("salt"), rs.getInt("quantity"), rs.getString("type"), rs.getFloat("buyingPrice"), rs.getFloat("sellingPrice"), rs.getString("buyingDate"), rs.getString("sellingDate"), rs.getString("color"), rs.getString("manufacturer"),  rs.getString("mfcLicence")));
				}
					
				tableModel.getDataVector().removeAllElements();
				
				Object[] object = new Object[12];
				
				for(Medicines data:searchedList) {
					
					object[0] = data.getID();
					object[1] = data.getName();
					object[2] = data.getSalt();
					object[3] = data.getQuantity();
					object[4] = data.getType();
					object[5] = data.getBuyingPrice();
					object[6] = data.getSellingPrice();
					object[7] = data.getBuyingDate();
					object[8] = data.getExpiryDate();
					object[9] = data.getColor();
					object[10] = data.getManufacturer();
					object[11] = data.getMFCLicence();
					
					tableModel.addRow(object);
					}
				
				}else {
					JOptionPane.showMessageDialog(null,  "Enter name of the medicine");
				}
				
			}catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,  "Some Error Occured: Please try again");
			}
	}

	class Medicines {
		
		int id, quantity;
		
		float buyingPrice, sellingPrice;
		
		String name, salt, type, buyingDate, expiryDate, color, manufacturer, mfcLicence;
		
		public Medicines(int id, String name, String salt, int quantity, String type, float buyingPrice, float sellingPrice, String buyingDate, String expiryDate, String color, String manufacturer, String mfcLicence) {
			this.id = id;
			this.quantity = quantity;
			this.buyingPrice = buyingPrice;
			this.sellingPrice = sellingPrice;
			this.name = name;
			this.salt = salt;
			this.type = type;
			this.color = color;
			this.buyingDate = buyingDate;
			this.expiryDate = expiryDate;
			this.manufacturer = manufacturer;
			this.mfcLicence = mfcLicence;
		}
		
		public int getID() {
			return id;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public String getName() {
			return name;
		}

		public String getSalt() {
			return salt;
		}
		public String getBuyingDate() {
			return buyingDate;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public String getManufacturer() {
			return manufacturer;
		}
		public String getMFCLicence() {
			return mfcLicence;
		}
		public String getColor() {
			return color;
		}
		public String getType() {
			return type;
		}
		public float getSellingPrice() {
			return sellingPrice;
		}
		public float getBuyingPrice() {
			return buyingPrice;
		}
	}
}

