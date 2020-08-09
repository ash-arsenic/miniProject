package college;
import javax.swing.*;
import java.io.*;

public class Main {
	
	// KEEP TRACK OF THE TODAYS EARNING     //
	public static float totalAmount=0.00f;
	public static JFrame theFrame;
	public static void main(String[] args) {
		
		//        START THE PHARMACY MANAGEMENT SYSTEM FROM LOGIN WINDOW     //
		
		theFrame = new JFrame("Pharmacy Management System");
		theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		theFrame.add(new LoginUI());
		
		theFrame.setBounds(500, 75, 500, 600);
		theFrame.setVisible(true);
		
	}
	
	public static void updateEarning(float n) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_a.txt"));
			totalAmount = Float.parseFloat(reader.readLine());
			reader.close();
			totalAmount += n;
			
			FileWriter fw = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_a.txt");
			fw.write(String.valueOf(totalAmount));
			fw.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
	}
	
	public static void writeLog(String entry) {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_log.txt", true);
			writer.write(entry+"/");
			writer.close();
		}catch(Exception ex ) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
		updateLog();
		
	}
	
	public static void updateLog() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\LastChance\\Users\\"+MainUI.database+"\\"+MainUI.database+"_log.txt"));
			String logData;
			while((logData = reader.readLine()) != null) {
				
				String[] logs = logData.split("/");
				int len = logs.length;
				
				MainUI.logLabel4.setText(logs[len-1]);
				MainUI.logLabel3.setText(logs[len-2]);
				MainUI.logLabel2.setText(logs[len-3]);
				MainUI.logLabel1.setText(logs[len-4]);
				
			}
			reader.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Some Error Occurred: please Try again");
		}
		
	}
	
}
