package guidev;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HelloWorld extends JFrame{
	public static void main(String args[])	{
		new HelloWorld();
	}
	HelloWorld()	{
		JLabel jlbHelloWorld = new JLabel("Hello World");
		getContentPane().add(jlbHelloWorld, BorderLayout.SOUTH);
		
		JButton btnYaaasss = new JButton("YAAASSSBITCH");
		btnYaaasss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnYaaasss, BorderLayout.NORTH);
		
		this.setSize(200,200);
		setVisible(true);
	}
}