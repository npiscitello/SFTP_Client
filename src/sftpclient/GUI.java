package sftpclient;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
		// resources
	private ImageIcon folder = new ImageIcon(getClass().getResource("directory-icon.png"));
	private ImageIcon gear = new ImageIcon(getClass().getResource("settings-icon.png"));
	private ImageIcon checkmark = new ImageIcon(getClass().getResource("checkmark-icon.png"));
	private ImageIcon xmark = new ImageIcon(getClass().getResource("x-icon.png"));
	private JComponent info = new JLabel("9/2015 Release:      GUI v1.0       Backend v0.0");
	
		// dynamic values
	private JTree localDir = new JTree();
	private JTree remoteDir = new JTree();
	private JTextField username = new JTextField(18);
	private JTextField password = new JTextField(18);
	private JButton credenter = new JButton(checkmark);
	private JTextField default_dir = new JTextField(18);
	private JButton browse = new JButton("Browse...");
	
	public GUI(String name, Dimension size, Dimension minsize) {		
		
			// pack scrollable trees into a split pane; resize the sides dynamically
		JSplitPane dirViewer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(localDir), new JScrollPane(remoteDir));
		dirViewer.setResizeWeight(0.5);
		
			// pack the credential settings into a panel
		JPanel credentials = new JPanel(new GridBagLayout());
		GridBagConstraints cred_const = new GridBagConstraints();
		Insets pad = new Insets(0,5,0,5);	Insets zero = new Insets(0,0,0,0);
		cred_const.gridx=0; cred_const.weightx=0; cred_const.insets=pad; cred_const.anchor=GridBagConstraints.WEST;
			cred_const.gridy=0; credentials.add(new JLabel("username:"), cred_const);
			cred_const.gridy=1; credentials.add(new JLabel("password:"), cred_const);
		cred_const.gridx=1; cred_const.weightx=1; cred_const.insets=zero; cred_const.fill=GridBagConstraints.HORIZONTAL;
			cred_const.gridy=0; credentials.add(username, cred_const);
			cred_const.gridy=1; credentials.add(password, cred_const);
		cred_const.gridx=2; cred_const.weightx=0; cred_const.insets=pad; cred_const.anchor=GridBagConstraints.EAST;
			cred_const.gridy=0; cred_const.gridheight=2; credenter.setMargin(new Insets(0,2,0,2)); credentials.add(credenter, cred_const);
		
			// pack the default directory selector into a panel
		JPanel default_dir_sel = new JPanel(new GridBagLayout());
		GridBagConstraints defdir_const = new GridBagConstraints();
		defdir_const.gridx=0; defdir_const.anchor=GridBagConstraints.WEST; defdir_const.insets=pad;
			default_dir_sel.add(new JLabel("default directory:"), defdir_const);
		defdir_const.gridx=2; defdir_const.anchor=GridBagConstraints.EAST;
			default_dir_sel.add(browse, defdir_const);
		defdir_const.weightx=1; defdir_const.gridx=1; defdir_const.fill=GridBagConstraints.HORIZONTAL;
			defdir_const.insets=zero; default_dir_sel.add(default_dir, defdir_const);
			
			// pack all the individual settings into a panel
		JPanel settings = new JPanel();
		settings.setLayout(new BoxLayout(settings, BoxLayout.PAGE_AXIS));
		Dimension vertspace = new Dimension(0,10);
		settings.add(Box.createRigidArea(vertspace));
		credentials.setMaximumSize(new Dimension(Integer.MAX_VALUE, credentials.getPreferredSize().height)); 
			credentials.setAlignmentX(Component.LEFT_ALIGNMENT);settings.add(credentials);
		settings.add(Box.createRigidArea(vertspace));
		default_dir_sel.setMaximumSize(new Dimension(Integer.MAX_VALUE, default_dir_sel.getPreferredSize().height));
			default_dir_sel.setAlignmentX(Component.LEFT_ALIGNMENT);settings.add(default_dir_sel);
			// add glue to take up extra space
		settings.add(Box.createVerticalGlue());
		info.setAlignmentX(Component.LEFT_ALIGNMENT); settings.add(info); settings.add(Box.createRigidArea(vertspace));
		
			// pack the split pane and the settings panel into tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD, 14));
		tabbedPane.addTab("Directories", folder, dirViewer, "browse local and remote directories");
		tabbedPane.addTab("Settings", gear, settings, "configure the application");
		
			// pack components into the status bar
		JPanel status_bar = new JPanel(new GridBagLayout());
		GridBagConstraints status_const = new GridBagConstraints();
		status_const.gridx=0; status_bar.add(new JLabel(checkmark, JLabel.CENTER), status_const);
		status_const.gridx=1; status_bar.add(new JLabel(xmark, JLabel.CENTER), status_const);
		status_const.gridx=2; status_const.weightx=1; status_const.insets=pad; status_const.anchor=GridBagConstraints.WEST;
			status_bar.add(new JLabel("status bar placeholder", JLabel.LEFT), status_const);
		
			// pack the tabbed pane and status bar into the window
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(status_bar, BorderLayout.SOUTH);
		
			// set window properties
		setTitle(name);
		setSize(size);
		setMinimumSize(minsize);
		setIconImage(folder.getImage());
		setVisible(true);
	}
	
	public static void main(String args[])	{
		new GUI("SFTP Client", new Dimension(800,500), new Dimension(500,300));
	}
}