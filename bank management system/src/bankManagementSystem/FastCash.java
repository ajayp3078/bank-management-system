package bankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.awt.event.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, fastcash, miniStatement, pinchange, balanceEnquiry, exit;
	String pinNumber;
	
	FastCash(String pinNumber){
		
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(210,300,700,20);
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Rs 500");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		miniStatement = new JButton("Rs 2000");
		miniStatement.setBounds(355,450,150,30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceEnquiry = new JButton("Rs 10000");
		balanceEnquiry.setBounds(355,485,150,30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("BACK");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}else{
			String amount = ((JButton) e.getSource()).getText().substring(3);		// Rs 500 to 500
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else if(rs.getString("type").equals("Withdraw")) {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(e.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinNumber+"','"+date+"', 'Withdraw', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
				
					
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
	}

	public static void main(String[] args) {
		new FastCash("");
	}

}
