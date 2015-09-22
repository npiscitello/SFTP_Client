package guidev;

import javax.swing.*;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class LayoutDev2 extends JFrame{
	public LayoutDev2() {
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JTree tree_1 = new JTree();
		scrollPane.setViewportView(tree_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		JTree tree = new JTree();
		scrollPane_1.setViewportView(tree);
		
		setVisible(true);
		this.setSize(200,200);
	}
	public static void main(String args[])	{
		new LayoutDev();
	}
	
}