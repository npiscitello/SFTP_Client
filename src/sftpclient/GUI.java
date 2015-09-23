package sftpclient;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	public GUI(String name, Dimension size, Dimension minsize) {		
		
			// directory trees
		JTree localDir = new JTree();
		JTree remoteDir = new JTree();
		
			// scroll panes
		JScrollPane localPane = new JScrollPane(localDir);
		JScrollPane remotePane = new JScrollPane(remoteDir);
		
			// split pane; resize the sides dynamically
		JSplitPane dirViewer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, localPane, remotePane);
		dirViewer.setResizeWeight(0.5);
		
			// username/password labels
		JLabel userlabel = new JLabel("username: ");
		JLabel passlabel = new JLabel("password: ");
		
			// username/password entry windows
		JTextField username = new JTextField(18);
		JTextField password = new JTextField(18);
		
			// pack the settings into the settings panel
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel settings = new JPanel(new GridBagLayout());
		constraints.gridx=0;	constraints.gridy=0;	constraints.anchor=GridBagConstraints.WEST;
			constraints.fill=GridBagConstraints.BOTH;	constraints.weightx=0;	settings.add(userlabel, constraints);
		constraints.gridx=1;	constraints.gridy=0;	constraints.weightx=1;
			constraints.fill=GridBagConstraints.HORIZONTAL;	settings.add(username, constraints);
		constraints.gridx=0;	constraints.gridy=1;	constraints.anchor=GridBagConstraints.WEST;
			constraints.fill=GridBagConstraints.BOTH;	constraints.weightx=0;	settings.add(passlabel, constraints);
		constraints.gridx=1;	constraints.gridy=1;	constraints.weightx=1;
			constraints.fill=GridBagConstraints.HORIZONTAL;	settings.add(password, constraints);
		
			// icons
		ImageIcon folder = new ImageIcon(getClass().getResource("directory-icon.png"));
		ImageIcon gear = new ImageIcon(getClass().getResource("settings-icon.png"));
		
			// pack the split pane and the settings panel into tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD, 14));
		tabbedPane.addTab("Directories", folder, dirViewer, "browse local and remote directories");
		tabbedPane.addTab("Settings", gear, settings, "configure the application");
		
			// pack the tabbed pane into the window
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
			// window properties
		setTitle(name);
		setSize(size);
		setMinimumSize(minsize);
		setIconImage(folder.getImage());
		setVisible(true);
	}
	
	public static void main(String args[])	{
		new GUI("SFTP Client", new Dimension(500,300), new Dimension(300,200));
	}
}