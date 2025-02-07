package bankManagementSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
	
	String pinNumber;
	
	MiniStatement(String pinNumber){
		
		setLayout(null);
		
		this.pinNumber = pinNumber;
		
		setTitle("Mini Statement");
		
		JLabel text = new JLabel();
		add(text);
		
		JLabel bank = new JLabel("Citi Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,90,300,20);
		add(card);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,220);
		add(mini);
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"' ");
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("cardNumber").substring(0,4)+ "XXXXXXXX" + rs.getString("cardNumber").substring(12));
				
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText() +"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +"<br><br>" +"<html>");		
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// balance
		int bal=0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else if(rs.getString("type").equals("Withdraw")) {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		JLabel balance = new JLabel("Available balance : "+ bal);
		balance.setBounds(20,400,300,20);
		add(balance);
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
