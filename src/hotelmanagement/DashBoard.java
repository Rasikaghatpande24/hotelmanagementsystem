package hotelmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener{

	DashBoard(){
		setBounds(-10,0,1600,900);
		setLayout(null);
		
		ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("Icons/third.jpg"));
		Image a2 = a1.getImage().getScaledInstance(1600,900,Image.SCALE_DEFAULT);
		ImageIcon a3 = new ImageIcon(a2);
		JLabel image = new JLabel(a3);
		image.setBounds(0,0,1600,900);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1600,30);
		image.add(mb);		
		JMenu hotelmanagement = new JMenu("HOTEL MANAGEMENT");
		hotelmanagement.setForeground(Color.BLUE);
		mb.add(hotelmanagement);
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotelmanagement.add(reception);
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		
		JMenuItem adminemployee = new JMenuItem("ADD EMPlOYEE");
		adminemployee.addActionListener(this);
		admin.add(adminemployee);
		
		JMenuItem adminrooms = new JMenuItem("ADD ROOMS");
		adminrooms.addActionListener(this);
		admin.add(adminrooms);
		
		JMenuItem admindrivers = new JMenuItem("ADD DRIVERS");
		admindrivers.addActionListener(this);
		admin.add(admindrivers);
		
		
		JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU...");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Italic",Font.BOLD,46));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPlOYEE")) {
			new AddEmployee();
		}else if (ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}else if (ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers();
		}else if(ae.getActionCommand().equals("RECEPTION")) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new DashBoard();
	}

}
