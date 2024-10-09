package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

	HotelManagementSystem() {
		setBounds(100,100,1366,565);
//		setLayout(null) ;
		
		
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("Icons/first.jpg"));
		JLabel image = new JLabel(li);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,60);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		image.add(text);
		
		JButton next = new JButton("NEXT");
		next.setBounds(1150,450,150,50);
		next.setBackground(Color.WHITE);
		next.setFont(new Font("serif",Font.PLAIN,24));
		next.addActionListener(this);
		image.add(next);
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(700);
			} catch (Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}
