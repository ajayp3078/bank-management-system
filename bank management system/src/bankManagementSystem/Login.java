package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		// to disable default layout
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		// to write content on frame
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Raleway",Font.BOLD,28));
		cardNo.setBounds(120,150,150,30);
		add(cardNo);
		
		// to add text box
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		// to pick whole frame
		getContentPane().setBackground(Color.white);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		}else if(e.getSource()==login) {
			
			Conn c = new Conn();
			String cardNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();   // showing cross because it is not string but password, but it should work
			String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"' ";
	
			try {
				 ResultSet rs = c.s.executeQuery(query);	// executeQuery used for DDL queries
				 if(rs.next()) {
					 setVisible(false);
					 new Transactions(pinNumber).setVisible(true);
				 }else {
					 JOptionPane.showMessageDialog(null,"Incorrect Credentials");
				 }
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}else if(e.getSource()==signup) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
		
	}

}
