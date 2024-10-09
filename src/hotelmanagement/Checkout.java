package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
	Choice customer;
	JLabel lblroom,lblroomnumber,lblcheckin,lblcheckintime,lblcheckout,lblcheckouttime;
	JButton checkout,back;
	
	Checkout(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Checkout");
		text.setBounds(100,20,100,30);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Tahuna", Font.PLAIN,20));
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		

		customer = new Choice();
		customer.setBounds(150,80,100,25);
		customer.setBackground(Color.WHITE);
		add(customer);
		
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/tick.png"));
		Image i2 = li.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(260,75,25,25);
		add(image);
		
		 lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,130,100,20);
		add(lblroom);
		
		 lblroomnumber = new JLabel();
		lblroomnumber.setBounds(150,130,100,20);
		add(lblroomnumber);
		
		
		lblcheckin = new JLabel("Checkin Time");
		lblcheckin.setBounds(30,180,100,20);
		add(lblcheckin);
		
		 lblcheckintime = new JLabel();
		 lblcheckintime.setBounds(150,180,150,20);
		add(lblcheckintime);		
		
		lblcheckout = new JLabel("Checkout Time");
		lblcheckout.setBounds(30,230,100,20);
		add(lblcheckout);
		
		Date date = new Date();
		 lblcheckouttime = new JLabel("" + date);
		 lblcheckouttime.setBounds(150,230,150,20);
		add(lblcheckouttime);
		
		checkout = new JButton("Checkout");
		checkout.setBounds(30,280,120,30);
		checkout.setForeground(Color.WHITE);
		checkout.setBackground(Color.BLACK);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBounds(170,280,120,30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		add(back);
		
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				customer.add(rs.getString("number"));
			}
			ResultSet rs2 = c.s.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");
			while(rs2.next()) {
				lblroomnumber.setText(rs2.getString("room"));
				lblcheckintime.setText(rs2.getString("checkintime"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		ImageIcon l4 = new ImageIcon(ClassLoader.getSystemResource("Icons/sixth.jpg"));
		Image i5 = l4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(350,50,400,250);
		add(image2);
		
		
		setBounds(300,200,800,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == checkout) {
			String query1 = "delete from customer where number = '"+customer.getSelectedItem()+"'";
			String query2 = "update room set availability = 'Available' where roomnum = '"+lblroomnumber.getText()+"'";
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"Checkout done!");
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
			
		}else if (ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
		
	}
	public static void main(String []args) {
		new Checkout();
	}
}
