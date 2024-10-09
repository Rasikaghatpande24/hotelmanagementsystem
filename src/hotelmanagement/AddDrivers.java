package hotelmanagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddDrivers extends JFrame implements ActionListener {

	JButton adddriver, canceldriver;
	JTextField tfname,tflocation,tfage ;
	JComboBox gendercombo,comopanycombo,modelcombo,availablecombo ;
	
	AddDrivers() {
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(330,280,940,470);
		
		JLabel heading = new JLabel("ADD DRIVERS");
		heading.setBounds(150,10,200,20);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahona", Font.BOLD, 20));
		add(heading);
		
		JLabel lblname = new JLabel("Add Name");
		lblname.setBounds(60,70,120,30);
		lblname.setForeground(Color.BLACK);
		lblname.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(200,70, 150,30);
		add(tfname);
		
		JLabel lblage = new JLabel("Age");
		lblage.setBounds(60,110,120,30);
		lblage.setForeground(Color.BLACK);
		lblage.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblage);
		
		 tfage = new JTextField();
		 tfage.setBounds(200,110, 150,30);
		add(tfage);
		
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60,150,120,30);
		lblgender.setForeground(Color.BLACK);
		lblgender.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblgender);
		
		String genderoptions[] = { "Male", "Female","Others" };
		 gendercombo = new JComboBox(genderoptions);
		 gendercombo.setBackground(Color.WHITE);
		 gendercombo.setBounds(200,150,150,30);
		add(gendercombo);
		
		JLabel lblcompany = new JLabel("Car Company");
		lblcompany.setBounds(60,190,120,30);
		lblcompany.setForeground(Color.BLACK);
		lblcompany.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblcompany);
		
		String companyoptions[] = { "Honda", "Mercedes", "Audi","Masarati","Hyndai","Renault" };
		 comopanycombo = new JComboBox(companyoptions);
		 comopanycombo.setBackground(Color.WHITE);
		 comopanycombo.setBounds(200,190,150,30);
		add(comopanycombo);
		
		
		JLabel lblmodel = new JLabel("Car Model");
		lblmodel.setBounds(60,230,120,30);
		lblmodel.setForeground(Color.BLACK);
		lblmodel.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblmodel);
		
		String modeloptions[] = { "Creta", "7series", "Limo","Kwid","Wagnor","Duster" };
		 modelcombo = new JComboBox(modeloptions);
		 modelcombo.setBackground(Color.WHITE);
		 modelcombo.setBounds(200,230,150,30);
		add(modelcombo);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setBounds(60,270,120,30);
		lblavailable.setForeground(Color.BLACK);
		lblavailable.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblavailable);
		
		String availableoptions[] = { "Available", "Busy"};
		 availablecombo = new JComboBox(availableoptions);
		 availablecombo.setBackground(Color.WHITE);
		 availablecombo.setBounds(200,270,150,30);
		add(availablecombo);
		
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setBounds(60,310,120,30);
		lbllocation.setForeground(Color.BLACK);
		lbllocation.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(200,310, 150,30);
		add(tflocation);
		
		 adddriver = new JButton("Add Driver");
		 adddriver.setBounds(60,370,130,30);
		 adddriver.setBackground(Color.BLACK);
		 adddriver.setForeground(Color.WHITE);
		 adddriver.addActionListener(this);
		add(adddriver);
		
		canceldriver = new JButton("Cancel Driver");
		canceldriver.setBounds(220,370,130,30);
		canceldriver.setBackground(Color.BLACK);
		canceldriver.setForeground(Color.WHITE);
		canceldriver.addActionListener(this);
		add(canceldriver);

		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/eleven.jpg"));
		Image i2 = li.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,30,500,300);
		add(image);

		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == adddriver) {
			String name = tfname.getText();
			String age = tfage.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String company = (String) comopanycombo.getSelectedItem();
			String brand = (String) modelcombo.getSelectedItem();
			String available = (String) availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			try {
				Conn c =new Conn();
				String strdriver = "Insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"','"+available+"', '"+location+"') " ;
				
				c.s.executeUpdate(strdriver);
				JOptionPane.showMessageDialog(null,"New Driver added successfully !!");
				setVisible(false);
				
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddDrivers();
	}

}
