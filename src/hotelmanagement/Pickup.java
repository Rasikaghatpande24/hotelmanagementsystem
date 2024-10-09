package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Pickup extends JFrame implements ActionListener{
	JTable table;
	JButton back,submit; 
	Choice typecar;
	JCheckBox available ;
	
	Pickup(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Pick up Service");
		text.setFont(new Font("Tahona", Font.PLAIN,20));
		text.setBounds(400,10,200,30);
		add(text);
		
		JLabel lblbed = new JLabel("Type of Car");
		lblbed.setBounds(50,100,100,30);
		add(lblbed);
		
		typecar = new Choice();
		typecar.setBounds(150,100,200,25);
		typecar.setBackground(Color.WHITE);
		add(typecar);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				typecar.add(rs.getString("brand"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(50,160,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(200,160,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(330,160,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Company");
		l4.setBounds(480,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Brand");
		l5.setBounds(620,160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(740,160,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Loaction");
		l7.setBounds(870,160,100,20);
		add(l7);
		
		table = new JTable() ;
		table.setBounds(0,200,1000,300);
		add(table);
		
		try {
			Conn c =new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
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
				String query = "select * from driver where brand = '"+typecar.getSelectedItem()+"'";
				
				Conn c = new Conn();
				ResultSet rs;
				rs = c.s.executeQuery(query);
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
		new Pickup();
	}

}
