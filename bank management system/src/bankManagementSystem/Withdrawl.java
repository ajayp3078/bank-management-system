package bankManagementSystem;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JButton withdraw, back;
	JTextField amount;
	String pinNumber;
	
	Withdrawl(String pinNumber){
		
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw:");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(195,300,700,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,25));
		amount.setBounds(195,350,300,25);
		amount.addActionListener(this);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter valid amount");
			}else {
				Conn c = new Conn();
				String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdraw','"+number+"')";
				try {
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+ " Withdrawn Successfully");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
					
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
			
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Withdrawl("");
	}

}
