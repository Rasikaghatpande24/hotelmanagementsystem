package hotelmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{

	JButton newcustomer,rooms,department,allemployee,allcustomer,manager,serchRoom,update,updateroomstatus,pickupstatus;
	
	Reception(){
	
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		 newcustomer = new JButton("New Customer Form");
		newcustomer.setBounds(10,30,200,30);
		newcustomer.setForeground(Color.WHITE);
		newcustomer.setBackground(Color.BLACK);
		newcustomer.addActionListener(this);
		add(newcustomer);
		
		 rooms = new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setForeground(Color.WHITE);
		rooms.setBackground(Color.BLACK);
		rooms.addActionListener(this);
		add(rooms);
		
		
		 department = new JButton("Department");
		department.setBounds(10,110,200,30);
		department.setForeground(Color.WHITE);
		department.setBackground(Color.BLACK);
		department.addActionListener(this);
		add(department);
		
		 allemployee = new JButton("All Employee");
		allemployee.setBounds(10,150,200,30);
		allemployee.setForeground(Color.WHITE);
		allemployee.setBackground(Color.BLACK);
		allemployee.addActionListener(this);
		add(allemployee);
		
		 allcustomer = new JButton("Customer Info");
		allcustomer.setBounds(10,190,200,30);
		allcustomer.setForeground(Color.WHITE);
		allcustomer.setBackground(Color.BLACK);
		allcustomer.addActionListener(this);
		add(allcustomer);
		
		 manager = new JButton("Manager Info");
		manager.setBounds(10,230,200,30);
		manager.setForeground(Color.WHITE);
		manager.setBackground(Color.BLACK);
		manager.addActionListener(this);
		add(manager);
		
		JButton checkout = new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.setForeground(Color.WHITE);
		checkout.setBackground(Color.BLACK);
		add(checkout);
		
		 update = new JButton("Update Status");
		update.setBounds(10,310,200,30);
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		update.addActionListener(this);
		add(update);
		
		 updateroomstatus = new JButton("Update Room Status");
		updateroomstatus.setBounds(10,350,200,30);
		updateroomstatus.setForeground(Color.WHITE);
		updateroomstatus.setBackground(Color.BLACK);
		updateroomstatus.addActionListener(this);
		add(updateroomstatus);
		
		pickupstatus = new JButton("Pick-Up Service");
		 pickupstatus.setBounds(10,390,200,30);
		pickupstatus.setForeground(Color.WHITE);
		pickupstatus.setBackground(Color.BLACK);
		pickupstatus.addActionListener(this);
		add(pickupstatus);
		
		 serchRoom = new JButton("Search Room");
		serchRoom.setBounds(10,430,200,30);
		serchRoom.setForeground(Color.WHITE);
		serchRoom.setBackground(Color.BLACK);
		serchRoom.addActionListener(this);
		add(serchRoom);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(10,470,200,30);
		logout.setForeground(Color.WHITE);
		logout.setBackground(Color.BLACK);
		add(logout);
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/fourth.jpg"));
		Image i2 = li.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250,30,500,470);
		add(image);
		
		
		setBounds(350,150,800,570);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == newcustomer) {
			setVisible(false);
			new AddCustomer();
		}else if (ae.getSource() == rooms ) {
			setVisible(false);
			new Room();
		}else if (ae.getSource() == department) {
			setVisible(false);
			new Department();
		}else if (ae.getSource() == allemployee) {
			setVisible(false);
			new EmployeeInfo();
		}else if (ae.getSource() == manager) {
			setVisible(false);
			new ManagerInfo();
		}else if (ae.getSource() == allcustomer) {
			setVisible(false);
			new CustomerInfo();
		}else if (ae.getSource() == serchRoom) {
			setVisible(false);
			new SearchRoom();
		}else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateCheck();
		}else if (ae.getSource() == updateroomstatus) {
			setVisible(false);
			new UpdateRoomStatus();
		}else if (ae.getSource() == pickupstatus) {
			setVisible(false);
			new Pickup();
		}
	}
	
	public static void main(String[] args) {
		new Reception();
	}

}
