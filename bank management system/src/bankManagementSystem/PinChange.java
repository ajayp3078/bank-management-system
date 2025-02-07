package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin , repin;
	JButton change, back;
	String pinNumber;
	
	PinChange(String pinNumber){
		
		setLayout(null);
		
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		text.setBounds(250,280,500,30);
		image.add(text);
		
		JLabel pinText = new JLabel("New PIN:");
		pinText.setFont(new Font("System", Font.BOLD, 16));
		pinText.setForeground(Color.white);
		pinText.setBounds(165,320,180,25);
		image.add(pinText);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,16));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		JLabel repinText = new JLabel("Re-Enter PIN");
		repinText.setFont(new Font("System", Font.BOLD, 16));
		repinText.setForeground(Color.white);
		repinText.setBounds(165,360,180,25);
		image.add(repinText);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,16));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
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
		
		if(change==e.getSource()) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
					return;
				}
				else {
					if(npin.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter new PIN");
						return;
					}
					if(rpin.equals("")) {
						JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
					}
					// pin - login,bank,signupthree
					Conn c = new Conn();
					String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
					String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
					String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
					
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					c.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null,"Pin changed successfully");
					
					setVisible(false);
					new Transactions(rpin).setVisible(true);
				}
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new PinChange("");
	}
}
