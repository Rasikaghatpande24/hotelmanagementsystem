package hotelmanagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddRooms extends JFrame implements ActionListener {

	JButton addroom, cancelroom;
	JTextField tfroomno,tfprice ;
	JComboBox availablecombo,cleaningcombo,typecombo ;
	
	AddRooms() {
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(330,280,940,470);
		
		JLabel heading = new JLabel("ADD ROOMS");
		heading.setBounds(150,20,200,20);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahona", Font.BOLD, 20));
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setBounds(60,80,120,30);
		lblroomno.setForeground(Color.BLACK);
		lblroomno.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblroomno);
		
		 tfroomno = new JTextField();
		tfroomno.setBounds(200,80, 150,30);
		add(tfroomno);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setBounds(60,130,120,30);
		lblavailable.setForeground(Color.BLACK);
		lblavailable.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblavailable);
		
		String availableoptions[] = { "Available", "Occupied" };
		 availablecombo = new JComboBox(availableoptions);
		availablecombo.setBackground(Color.WHITE);
		availablecombo.setBounds(200,130,150,30);
		add(availablecombo);
		
		
		JLabel lblcleaning = new JLabel("Cleaning");
		lblcleaning.setBounds(60,180,120,30);
		lblcleaning.setForeground(Color.BLACK);
		lblcleaning.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblcleaning);
		
		String cleaningoptions[] = { "Cleaned", "Dirty" };
		 cleaningcombo = new JComboBox(cleaningoptions);
		cleaningcombo.setBackground(Color.WHITE);
		cleaningcombo.setBounds(200,180,150,30);
		add(cleaningcombo);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setBounds(60,230,120,30);
		lblprice.setForeground(Color.BLACK);
		lblprice.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lblprice);
		
		 tfprice = new JTextField();
		tfprice.setBounds(200,230, 150,30);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Bed Type");
		lbltype.setBounds(60,280,120,30);
		lbltype.setForeground(Color.BLACK);
		lbltype.setFont(new Font("Tahona", Font.PLAIN, 16));
		add(lbltype);
		
		String typeoptions[] = { "Singl Bed", "Double Bed" };
		 typecombo = new JComboBox(typeoptions);
		typecombo.setBackground(Color.WHITE);
		typecombo.setBounds(200,280,150,30);
		add(typecombo);
		
		 addroom = new JButton("Add Room");
		addroom.setBounds(60,350,130,30);
		addroom.setBackground(Color.BLACK);
		addroom.setForeground(Color.WHITE);
		addroom.addActionListener(this);
		add(addroom);
		
		 cancelroom = new JButton("Cancel Room");
		cancelroom.setBounds(220,350,130,30);
		cancelroom.setBackground(Color.BLACK);
		cancelroom.setForeground(Color.WHITE);
		cancelroom.addActionListener(this);
		add(cancelroom);

		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/twelve.jpg"));
		JLabel image = new JLabel(li);
		image.setBounds(400,30,500,300);
		add(image);

		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addroom) {
			String roomnum = tfroomno.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String status = (String) cleaningcombo.getSelectedItem();
			String price = tfprice.getText();
			String type = (String) typecombo.getSelectedItem();
			
			try {
				Conn c =new Conn();
				String str = "Insert into room values('"+roomnum+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"') " ;
				
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New room added successfully !!");
				setVisible(false);
				
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddRooms();
	}

}
