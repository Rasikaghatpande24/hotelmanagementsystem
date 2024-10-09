package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener{

	Choice customer;
	JTextField tfroom,tfavailable,tfcleaning;
	JButton check,update,back;
	
	UpdateRoomStatus(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tahona", Font.PLAIN,25));
		text.setBounds(30,20,250,30);
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
		
		
		JLabel lblavailable = new JLabel("Availability");
		lblavailable.setBounds(30,160,100,20);
		add(lblavailable);
		
		tfavailable = new JTextField();
		tfavailable.setBounds(200,160,120,25);
		add(tfavailable);
		
		JLabel lblcleaning = new JLabel("Cleaning Status");
		lblcleaning.setBounds(30,200,100,20);
		add(lblcleaning);
		
		tfcleaning = new JTextField();
		tfcleaning.setBounds(200,200,120,25);
		add(tfcleaning);
		
		check = new JButton("Check");
		check.setBounds(30,300,100,30);
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBounds(150,300,100,30);
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(270,300,100,30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/seventh.jpg"));
		JLabel image = new JLabel(li);
		image.setBounds(400,50,500,300);
		add(image);
		
		
		setBounds(300,200,980,450);
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
				}
				ResultSet rs2 =c.s.executeQuery("select * from room where roomnum = '"+tfroom.getText()+"'");
				
				while(rs2.next()) {
					tfavailable.setText(rs2.getString("availability"));
					tfcleaning.setText(rs2.getString("claening_status"));
				}
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == update) {
			String number = customer.getSelectedItem();
			String available = tfavailable.getText();
			String status = tfcleaning.getText();
			
			try {
				Conn c =new Conn();
				 c.s.executeUpdate("Update room set availability = '"+available+"',claening_status = '"+status+"' where roomnum =  '"+number+"'");
				JOptionPane.showMessageDialog(null,"Data updated Scuccesfully");
				setVisible(false);
			}catch(Exception e ) {
				e.printStackTrace();
			}
						
		}else if (ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new UpdateRoomStatus();
	}

}
