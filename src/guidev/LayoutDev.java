package guidev;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LayoutDev extends JFrame{
	public static void main(String args[])	{
		new LayoutDev();
	}
	LayoutDev()	{
		
		JButton btnYaaasss = new JButton("YAAASSSBITCH");
		btnYaaasss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnYaaasss, BorderLayout.NORTH);
		
		JToggleButton tglbtnYesOrNo = new JToggleButton("Yes. Or no. Doesn't matter.");
		getContentPane().add(tglbtnYesOrNo, BorderLayout.CENTER);
		
		JTree tree = new JTree();
		getContentPane().add(tree, BorderLayout.EAST);
		
		JScrollPane scrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollBar, BorderLayout.WEST);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, BorderLayout.SOUTH);
		
		this.setSize(501,200);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStuff = new JMenu("Stuff");
		menuBar.add(mnStuff);
		
		JCheckBoxMenuItem chckbxmntmHello = new JCheckBoxMenuItem("hello");
		mnStuff.add(chckbxmntmHello);
		
		JMenu mnMoreStuff = new JMenu("More Stuff");
		menuBar.add(mnMoreStuff);
		
		JCheckBoxMenuItem chckbxmntmGoodbye = new JCheckBoxMenuItem("goodbye");
		mnMoreStuff.add(chckbxmntmGoodbye);
		setVisible(true);
	}
}