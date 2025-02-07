package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;
	
	SignUpThree(String formno){
		
		this.formno = formno;
		
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,130,200,30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,150,20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,250,20);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,150,20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		ButtonGroup button = new ButtonGroup();
		button.add(r1);
		button.add(r2);
		button.add(r3);
		button.add(r4);
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-5006");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetail.setBounds(100,330,300,20);
		add(cardDetail);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		JLabel pinDetail = new JLabel("Your 4 Digit Pin Number");
		pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetail.setBounds(100,400,300,20);
		add(pinDetail);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBackground(Color.white);
		services.setBounds(100,450,250,30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBackground(Color.white);
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBackground(Color.white);
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBackground(Color.white);
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBackground(Color.white);
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBackground(Color.white);
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBackground(Color.white);
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBackground(Color.white);
		c7.setBounds(100,680,600,30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		// to make a frame
		setSize(850,820);
		getContentPane().setBackground(Color.white);
		setLocation(350,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit) {
			
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardNumber = "" + Math.abs((random.nextLong() % 900000000L) + 5040936000000000L);
			String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility += "ATM CARD";
			}if(c2.isSelected()) {
				facility += "Internet Banking";
			}if(c3.isSelected()) {
				facility += "Mobile Banking";
			}if(c4.isSelected()) {
				facility += "Email & SMS Alerts";
			}if(c5.isSelected()) {
				facility += "Cheque Book";
			}if(c6.isSelected()) {
				facility += "E-Statement";
			}
			
			try {
				
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}else {
					Conn c = new Conn();
					String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\n PIN: "+ pinNumber);
					
					setVisible(false);
					new Login().setVisible(true);
				}
				
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}else if(e.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new SignUpThree("");

	}

}
