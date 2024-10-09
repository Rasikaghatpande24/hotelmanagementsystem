package hotelmanagement;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

	JComboBox idcombo;
	JTextField tfnum,tfname,tfcountry, tfdeposit;
	JRadioButton rmale,rfemale,rother;
	JLabel lbltime,checkintime;
	Choice croom;
	JButton addcust,back;
	
	AddCustomer(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("New Customer Form");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Railway", Font.PLAIN,20));
		add(text);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(35,80,300,30);
		lblid.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblid);
		
		String idoptions[]= {"Aadhar Card", "Passport", "Driving License", "Vtore Id"};
		idcombo = new JComboBox(idoptions);
		idcombo.setBounds(200,80,150,25);
		idcombo.setBackground(Color.WHITE);
		add(idcombo);
		
		JLabel lblnum = new JLabel("Number");
		lblnum.setBounds(35,120,100,20);
		lblnum.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblnum);
		
		tfnum = new JTextField();
		tfnum.setBounds(200,120,150,25);
		add(tfnum);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35,160,100,20);
		lblname.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(35,200,100,20);
		lblgender.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblgender);
		
		rmale = new JRadioButton("Male");
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(200,200,60,25);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(260,200,75,25);
		add(rfemale);
		
		rother = new JRadioButton("Others");
		rother.setBackground(Color.WHITE);
		rother.setBounds(335,200,80,25);
		add(rother);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		bg.add(rother);
		
		rother = new JRadioButton("Others");
		rother.setBackground(Color.WHITE);
		rother.setBounds(200,200,60,25);
		add(rother);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(35,240,100,25);
		lblcountry.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200,240,150,25);
		add(tfcountry);
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(35,280,150,20);
		lblroom.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblroom);
		
		croom = new Choice();
		
		try {
			Conn c = new Conn();
			String query = "select * from room where availability = 'Available' ";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roomnum"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		croom.setBounds(200,280,150,25);
		add(croom);
		
		lbltime = new JLabel("CheckIn Time");
		lbltime.setBounds(35,320,150,25);
		lbltime.setFont(new Font("Railway", Font.PLAIN,20));
		add(lbltime);
		
		Date date = new Date();
		
		 checkintime = new JLabel("" + date);
		checkintime.setBounds(200,320,200,25);
		checkintime.setFont(new Font("Railway", Font.PLAIN,15));
		add(checkintime);
		
		JLabel lbldeposit = new JLabel("Deposit");
		lbldeposit.setBounds(35,360,120,25);
		lbldeposit.setFont(new Font("Railway", Font.PLAIN,20));
		add(lbldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);
		
		addcust = new JButton("Add");
		addcust.setBackground(Color.BLACK);
		addcust.setForeground(Color.WHITE);
		addcust.setBounds(50,410,120,30);
		addcust.addActionListener(this);
		add(addcust);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200,410,120,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon li =new ImageIcon(ClassLoader.getSystemResource("Icons/fifth.png"));
		Image l2 =  li.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
		ImageIcon l3 =new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(400,50,300,400);
		add(image);
		
		
		
		setBounds(350,200,800,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addcust) {
			String id = (String) idcombo.getSelectedItem();
			String number = tfnum.getText();
			String name = tfname.getText();
			String gender = null;
			
			if(rmale.isSelected()) {
				gender = "Male";
			}else if (rfemale.isSelected()) {
				gender = "Female";
			}else if (rother.isSelected()) {
				gender = "Others";
			}
			
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();
			
			try {
				String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
				String query2 = "update room set availability = 'Occupied' where roomnum = '"+room+"' ";
				
				Conn c = new Conn();
				
				c.s.executeUpdate(query);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "New Customer added succesfully");
				
				setVisible(false);
				new Reception();
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();
	}

}
