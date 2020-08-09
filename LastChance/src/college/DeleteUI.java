package college;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


@SuppressWarnings("serial")
public class DeleteUI extends SearchUI{

	/**
	 * Create the panel.
	 */
	public DeleteUI() {
		JButton deleteButton = new JButton("DELETE");
		panel.add(deleteButton);
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = -1;
				selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());	
					PreparedStatement ps;
					try {
						
						ps = con.prepareStatement("DELETE FROM "+MainUI.database+"_data WHERE id="+id);
						ps.execute();
						Main.writeLog("Medicine Deleted with ID " + id);
						JOptionPane.showMessageDialog(null, "Medicine Deleted");
						tableModel.removeRow(table.getSelectedRow());	
						
					}catch(java.lang.ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Please select a medicine to delete");
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Some Error Occured. Please Try Again");
					}
				}else {
						JOptionPane.showMessageDialog(null, "Select a Medicine");
				}
			}
		});
		
 
	}
	
	
}
