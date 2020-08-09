package college;
import javax.swing.*;
import java.awt.event.*;
//import java.sql.SQLException;

@SuppressWarnings("serial")
public class UpdateUI extends SearchUI {

	/**
	 * Create the panel.
	 */
	public UpdateUI() {
		
		JButton updateButton = new JButton("UPDATE");
		panel.add(updateButton);
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = -1;
				row = table.getSelectedRow();
				
				if(row != -1) {
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					JFrame frame = new JFrame("Pharmacy Management System");
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.getContentPane().add(new MainUpdateUI(id));
					frame.setBounds(450, 75, 650, 440);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Select a Medicine");
				}
			}
		});
	}

}
