package sftpclient;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public GUI() {
		JPanel settings = new JPanel();
		
		JTree localDir = new JTree();
		JTree remoteDir = new JTree();
		
		JScrollPane localPane = new JScrollPane(localDir);
		JScrollPane remotePane = new JScrollPane(remoteDir);
		
		JSplitPane dirViewer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, localPane, remotePane);
		dirViewer.setDividerLocation(150);
		
		Dimension minimumSize = new Dimension(150,50);
		localPane.setMinimumSize(minimumSize);
		remotePane.setMinimumSize(minimumSize);
		
		tabbedPane.addTab("Directories", null, dirViewer, null);
		tabbedPane.addTab("Settings", null, settings, null);
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		setVisible(true);
		this.setSize(350,200);
	}
	
	public static void main(String args[])	{
		new GUI();
	}
	
}