package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
 JTextField tfname,tfage,tfsalary,tfphone,tfmail,tfaadhar;
 JRadioButton rbmale,rbfemale,rbother;
 JButton submit; 
 JComboBox jcjob;
 
 
	AddEmployee(){
		setLayout(null);

		getContentPane().setBackground(Color.WHITE);
		setBounds(350,200,850,540);
	
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lblname);

		 tfname = new JTextField();
		tfname.setBounds(200,30, 150,30);
		add(tfname);

		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lblage);

		 tfage = new JTextField();
		tfage.setBounds(200,80, 150,30);
		add(tfage);
		
		JLabel lblgender = new JLabel("AGE");
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lblgender);
		
		 rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,130,60,30);
		rbmale.setFont(new Font("Tahona", Font.PLAIN, 14));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		 rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(270,130,90,30);
		rbfemale.setFont(new Font("Tahona", Font.PLAIN, 14));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		 rbother = new JRadioButton("Others");
		rbother.setBounds(360,130,70,30);
		rbother.setFont(new Font("Tahona", Font.PLAIN, 14));
		rbother.setBackground(Color.WHITE);
		add(rbother);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		bg.add(rbother);
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180,120,30);
		lbljob.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lbljob);
		
		String str[] = {"Front desk clerk", "Porters", "HouseKeeping","Kitchen Staff","Room Service","Chefs","Manager","Waiter/Waiteress"}; 
		 jcjob = new JComboBox(str);
		jcjob.setBounds(200,180,150,30);
		jcjob.setBackground(Color.WHITE);
		add(jcjob); 
		
		JLabel jlsalary = new JLabel("SALARY");
		jlsalary.setBounds(60,230,120,30);
		jlsalary.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(jlsalary);
		

		 tfsalary = new JTextField();
		tfsalary.setBounds(200,230, 150,30);
		add(tfsalary);

		
		JLabel jlbphone = new JLabel("PHONE");
		jlbphone.setBounds(60,280,120,30);
		jlbphone.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(jlbphone);
		
		 tfphone = new JTextField();
		tfphone.setBounds(200,280, 150,30);
		add(tfphone);
		
		JLabel lblmail = new JLabel("EMAIL");
		lblmail.setBounds(60,330,120,30);
		lblmail.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lblmail);
		
		 tfmail = new JTextField();
		tfmail.setBounds(200,330, 150,30);
		add(tfmail);
		
		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setFont(new Font("Tahona", Font.ITALIC, 17));
		add(lblaadhar);
		
		 tfaadhar = new JTextField();
		 tfaadhar.setBounds(200,380, 150,30);
		add(tfaadhar);
		
		 submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(200,430,110,30);
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon a1= new ImageIcon(ClassLoader.getSystemResource("Icons/tenth.jpg"));
		Image a2 = a1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
		ImageIcon a3= new ImageIcon(a2);
		JLabel image = new JLabel(a3);
		image.setBounds(400,60,450,380);
		add(image);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfmail.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name should not be empty");
			
		}else if(salary.equals("")) {
			JOptionPane.showMessageDialog(null, "Salary should contain an amount");
			return;
		}else if(email.equals("") && email.contains("@") && email.contains(".com")) {
			JOptionPane.showMessageDialog(null, "Email should not be empty");
			return;
		}else if(age.equals("")) {
			JOptionPane.showMessageDialog(null, "Age should not be empty");
			return;
		}else if(aadhar.equals("")) {
			JOptionPane.showMessageDialog(null, "Aadhar should not be empty");
			return;
		}
		
		if(rbmale.isSelected()) {
			gender = "MALE";
		}else if(rbfemale.isSelected()) {
			gender = "FEMALE";
		}else if(rbother.isSelected()) {
			gender = "OTHERS";
		}
		
		String job = (String) jcjob.getSelectedItem();
		
		try {
			Conn c = new Conn();
			String query = "insert into employee values( '" + name + "', '" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
			
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Employee added successsfully");
			
			setVisible(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddEmployee();
	}

}
