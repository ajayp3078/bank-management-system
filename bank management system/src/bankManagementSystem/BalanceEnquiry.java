package bankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinNumber;
	
	BalanceEnquiry(String pinNumber){
		
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' ");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else if(rs.getString("type").equals("Withdraw")) {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		JLabel text = new JLabel("Available Balance : " + balance);
		text.setFont(new Font("Raleway", Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(250,350,300,30);
		image.add(text);
		
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		setSize(900,900);
		setUndecorated(true);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
		
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
