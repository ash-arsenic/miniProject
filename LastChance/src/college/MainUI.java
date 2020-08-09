package college;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//import javax.swing.ImageIcon;
//import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
//import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MainUI extends JPanel implements Runnable, WindowListener{
	
	public float showAmount = 0.00f;
	private Thread t;
	private JLabel clockLabel;
	public static JLabel logLabel1;
	public static JLabel logLabel2;
	public static JLabel logLabel3;
	public static JLabel logLabel4;
	public static String database="medicine";
	
	public void windowClosing(WindowEvent windowEvent){
        System.out.println("Closed");
     }    
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) { }  
	public void windowDeactivated(WindowEvent e) {}  
	public void windowDeiconified(WindowEvent e) {}  
	public void windowIconified(WindowEvent e) {}  
	public void windowOpened(WindowEvent arg0) {}  
	
	
	/**
	 * Create the panel.
	 */
	
	public MainUI(String userName, String database) {
		setBackground(Color.DARK_GRAY);
		
		MainUI.database = database;
/*		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_a.txt"));
			Main.totalAmount = Float.parseFloat(reader.readLine());
			reader.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
*/
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_date.txt"));				
			String previousDate = reader.readLine();
			
			if(previousDate.equals(String.valueOf(java.time.LocalDate.now()))) {
				
			}
			else {
				FileWriter fw = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_a.txt");
				fw.write("0.00");
				fw.close();
			}
			
			reader.close();
			
		}catch(Exception ex) {

			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("HELLO ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		
		lblNewLabel.setText("HELLO "+userName.toUpperCase());
		
		clockLabel= new JLabel("HH:MM:SS");
		clockLabel.setForeground(Color.WHITE);
		clockLabel.setBackground(Color.WHITE);
		clockLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		GroupLayout gl_topPanel = new GroupLayout(topPanel);
		gl_topPanel.setHorizontalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_topPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(clockLabel)
					.addContainerGap())
		);
		gl_topPanel.setVerticalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_topPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(clockLabel))
					.addContainerGap())
		);
		topPanel.setLayout(gl_topPanel);
		
		t = new Thread(this);
		t.start();
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		leftPanel.setBackground(Color.DARK_GRAY);
		add(leftPanel, BorderLayout.WEST);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Pharmacy Management System");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				frame.getContentPane().add(new AddUI());
				
				frame.setBounds(450, 75, 600, 400);
				frame.setVisible(true);
				
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Pharmacy Management System");
				
				frame.getContentPane().add(new UpdateUI());
				
				frame.setBounds(75, 20, 1250, 700);
				frame.setVisible(true);
				frame.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							SearchUI.con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Some Error Occured. Please Try Again");
						}
					}
			      });
				
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame("Pharmacy Management System");
				
				frame.getContentPane().add(new DeleteUI());
				
				frame.setBounds(75, 20, 1250, 700);
				frame.setVisible(true);
				frame.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							SearchUI.con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Some Error Occured. Please Try Again");
						}
					}
			      });
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Pharmacy Management System");   
				
				frame.getContentPane().add(new SearchUI());
				
				frame.setBounds(75, 20, 1250, 700);
				frame.setVisible(true);
				frame.addWindowListener((WindowListener) new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							SearchUI.con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Some Error Occured. Please Try Again");
						}
					}
			      });
			}
		});
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton billButton = new JButton("BILL");
		billButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Pharmacy Management System");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JFileChooser fileSave = new JFileChooser();
				fileSave.showSaveDialog(frame);
				
				frame.getContentPane().add(new BillUI(fileSave.getSelectedFile()));
				
				frame.setBounds(450, 75, 800, 500);
				frame.setVisible(true);
			}
		});
		billButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton accountButton = new JButton("ACCOUNT");
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Pharmacy Management System");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				frame.getContentPane().add(new AccountUI());
				
				frame.setBounds(500, 75, 500, 450);
				frame.setVisible(true);
			}
		});
		accountButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(deleteButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(addButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(billButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(57)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(accountButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(updateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_leftPanel.setVerticalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(addButton)
						.addComponent(updateButton))
					.addGap(26)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteButton)
						.addComponent(searchButton))
					.addGap(33)
					.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(billButton)
						.addComponent(accountButton))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		leftPanel.setLayout(gl_leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rightPanel.setBackground(Color.DARK_GRAY);
		add(rightPanel, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("LOGS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		logLabel1 = new JLabel("No Log Here for Now");
		logLabel1.setFont(new Font("Century", Font.PLAIN, 11));
		logLabel1.setForeground(Color.WHITE);
		logLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		logLabel2 = new JLabel("No Log here for now");
		logLabel2.setFont(new Font("Century", Font.PLAIN, 11));
		logLabel2.setForeground(Color.WHITE);
		logLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		logLabel3 = new JLabel("No log here for now");
		logLabel3.setFont(new Font("Century", Font.PLAIN, 11));
		logLabel3.setForeground(Color.WHITE);
		logLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		
		logLabel4 = new JLabel("No log here for now");
		logLabel4.setFont(new Font("Century", Font.PLAIN, 11));
		logLabel4.setForeground(Color.WHITE);
		logLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		
		Main.updateLog();
		
		JPanel bottomRightPanel = new JPanel();
		bottomRightPanel.setBackground(Color.DARK_GRAY);
		bottomRightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_rightPanel = new GroupLayout(rightPanel);
		gl_rightPanel.setHorizontalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
							.addComponent(logLabel1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(84))
						.addGroup(gl_rightPanel.createSequentialGroup()
							.addComponent(bottomRightPanel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
							.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(logLabel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(logLabel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(logLabel2, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_rightPanel.setVerticalGroup(
			gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(25)
					.addComponent(logLabel1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(logLabel2)
					.addGap(11)
					.addComponent(logLabel3)
					.addGap(11)
					.addComponent(logLabel4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bottomRightPanel, GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE)
					.addGap(9))
		);
		
		JLabel lblNewLabel_4 = new JLabel("TODAYS EARNING");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Century", Font.BOLD, 18));
		
		
		
		
		JButton showAmountButton = new JButton("SHOW AMOUNT");
		showAmountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_a.txt"));
					showAmount = Float.parseFloat(reader.readLine());
					reader.close();
					
				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
				}
				
				JOptionPane.showMessageDialog(null,  String.valueOf(showAmount));
			}
		});
		
		
		GroupLayout gl_bottomRightPanel = new GroupLayout(bottomRightPanel);
		gl_bottomRightPanel.setHorizontalGroup(
			gl_bottomRightPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bottomRightPanel.createSequentialGroup()
					.addGroup(gl_bottomRightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bottomRightPanel.createSequentialGroup()
							.addGap(36)
							.addComponent(showAmountButton))
						.addGroup(gl_bottomRightPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_bottomRightPanel.setVerticalGroup(
			gl_bottomRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottomRightPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_4)
					.addGap(18)
					.addComponent(showAmountButton)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		bottomRightPanel.setLayout(gl_bottomRightPanel);
		rightPanel.setLayout(gl_rightPanel);

	}
	

	@SuppressWarnings("static-access")
	public void run() {
		
		try {
			
			while(true) {
			
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				clockLabel.setText(formatter.format(date));
				t.sleep(1000);
			} 
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
	}
}
