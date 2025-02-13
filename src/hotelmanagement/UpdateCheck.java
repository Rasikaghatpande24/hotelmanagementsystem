package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{

	Choice customer;
	JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
	JButton check,update,back;
	
	UpdateCheck(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tahona", Font.PLAIN,20));
		text.setBounds(50,20,200,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
		customer = new Choice();
		customer.setBounds(200,80,100,25);
		add(customer);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()){
				customer.add(rs.getString("number"));
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,120,100,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,120,120,25);
		add(tfroom);
		
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,160,100,20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,120,25);
		add(tfname);
		
		JLabel lblcheckin = new JLabel("Check-in time");
		lblcheckin.setBounds(30,200,100,20);
		add(lblcheckin);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,120,25);
		add(tfcheckin);
		
		JLabel lblpaid = new JLabel("Amount Paid");
		lblpaid.setBounds(30,240,100,20);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200,240,120,25);
		add(tfpaid);
		
		JLabel lblpending = new JLabel("Amount Pending");
		lblpending.setBounds(30,280,100,20);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200,280,120,25);
		add(tfpending);
		
		check = new JButton("Check");
		check.setBounds(30,340,100,30);
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBounds(150,340,100,30);
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(270,340,100,30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/nine.jpg"));
		JLabel image = new JLabel(li);
		image.setBounds(400,50,500,300);
		add(image);
		
		
		setBounds(300,200,980,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == check) {
			String id = customer.getSelectedItem();
			String query = "select * from customer where number = '"+id+"'";
			try {
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));
					tfname.setText(rs.getString("name"));
					tfcheckin.setText(rs.getString("checkintime"));
					tfpaid.setText(rs.getString("deposit"));	
				}
				ResultSet rs2 =c.s.executeQuery("select * from room where roomnum = '"+tfroom.getText()+"'");
				
				while(rs2.next()) {
					String price = rs2.getString("price");
					int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
					tfpending.setText("" + amountpaid);
				}
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == update) {
			String number = customer.getSelectedItem();
			String name = tfname.getText();
			String room = tfroom.getText();
			String checkin = tfcheckin.getText();
			String deposit = tfpaid.getText();
			
			try {
				Conn c =new Conn();
				 c.s.executeUpdate("Update customer set room = '"+room+"',name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number =  '"+number+"'");
				JOptionPane.showMessageDialog(null,"Data updated Scuccesfully");
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
			
		}else if (ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new UpdateCheck();
	}

}
