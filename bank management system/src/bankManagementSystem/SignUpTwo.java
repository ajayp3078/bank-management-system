package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField pan, adhaar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion, category, income, education, occupation;
	String formno;
	
	SignUpTwo(String formno){
		
		this.formno = formno;
		
		// if not set null by default it takes border layout
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		String valCategory[] = {"General","OBC","SC","ST","NT","Other"};
		category = new JComboBox(valCategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.white);
		add(category);
		
		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,0000"};
		income = new JComboBox(incomeCategory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.white);
		add(income);
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,315,200,30);
		add(email);
		
		String educationValues[] = {"Non-Graduate","Graduation","Post-Graduation","Doctrate","Other"};
		education = new JComboBox(educationValues);
		education.setBounds(300,300,400,30);
		education.setBackground(Color.white);
		add(education);
		
		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		String occupationValues[] = {"Salaried","Self Employed","Business","Student","Retired","Other"};
		occupation = new JComboBox(occupationValues);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		JLabel address = new JLabel("Pan Number:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300,440,400,30);
		add(pan);
		
		JLabel city = new JLabel("Adhaar Number:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		adhaar = new JTextField();
		adhaar.setFont(new Font("Raleway",Font.BOLD,14));
		adhaar.setBounds(300,490,400,30);
		add(adhaar);
		
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.white);
		syes.setBounds(300,540,60,30);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBackground(Color.white);
		sno.setBounds(420,540,60,30);
		add(sno);
		
		ButtonGroup button = new ButtonGroup();
		button.add(syes);
		button.add(sno);
		
		JLabel pincode = new JLabel("Existing Account:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setBackground(Color.white);
		eyes.setBounds(300,590,60,30);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBackground(Color.white);
		eno.setBounds(420,590,60,30);
		add(eno);
		
		ButtonGroup button2 = new ButtonGroup();
		button2.add(eyes);
		button2.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignUpTwo("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String span = pan.getText();
		String sadhaar = adhaar.getText();
		
		String scitizen = null;
		if(syes.isSelected()) {
			scitizen = "Yes";
		}
		else if(sno.isSelected()) {
			scitizen = "No";
		}
		
		String eaccount = null;
		if(eyes.isSelected()) {
			eaccount = "Yes";
		}
		else if(eno.isSelected()) {
			eaccount = "No";
		}
		
		// validations
		try {
			if(pan.equals("")) {
				JOptionPane.showMessageDialog(null,"Pan Number is required");
			}
			// can apply validations for other fields as well
			else {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"', '"+soccupation+"','"+span+"','"+sadhaar+"','"+scitizen+"','"+eaccount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details saved successfully");
				
				// Signup 3 object
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
//		
	}

}
