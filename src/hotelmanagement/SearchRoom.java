package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton back,submit; 
	JComboBox bedtype;
	JCheckBox available ;
	
	SearchRoom(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Search for Rooms");
		text.setFont(new Font("Tahona", Font.PLAIN,20));
		text.setBounds(400,10,200,30);
		add(text);
		
		JLabel lblbed = new JLabel("Bed type ");
		lblbed.setBounds(50,100,200,30);
		add(lblbed);
		
		bedtype = new JComboBox(new String[] {"Singl bed", "Double bed"});
		bedtype.setBounds(170,100,150,25);
		bedtype.setBackground(Color.WHITE);
		add(bedtype);
		
		available = new JCheckBox("Only display Available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(50,160,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(270,160,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Cleaning Status");
		l3.setBounds(450,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(670,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(870,160,100,20);
		add(l5);
		
		table = new JTable() ;
		table.setBounds(0,200,1000,300);
		add(table);
		
		try {
			Conn c =new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(350,500,120,30);
		submit.addActionListener(this);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200,500,120,30);
		back.addActionListener(this);
		add(back);
		
		setBounds(350,200,1050,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			
			try {
				String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
				String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
				
				Conn c = new Conn();
				ResultSet rs;
				if(available.isSelected()) {
					rs = c.s.executeQuery(query2);
				}else {
					rs = c.s.executeQuery(query1);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Reception();
		}	
	}
	public static void main(String[] args) {
		new SearchRoom();
	}

}
