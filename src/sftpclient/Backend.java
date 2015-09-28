package sftpclient;

import java.awt.Dimension;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Backend {
	
	static GUI MainWindow = new GUI("SFTP Client", new Dimension(800,500), new Dimension(500,300));
	private static String username, password, host;
	private static int port;
	private static boolean readyToConnect = false;
	
		// make the window visible
	public static void main(String[] args){
		MainWindow.setVisible(true);
	}
		
		// try to update the credentials, and post the exit status to the status bar
	public static void updateCredentials(String un, String pw, String ip, String pt)	{
		try {
			username = un; password = pw; host = ip; port = Integer.parseInt(pt);
			readyToConnect = true;
			MainWindow.updateStatus(true, "credentials saved successfully!");
		} catch(NumberFormatException e)	{
			readyToConnect = false;
			MainWindow.updateStatus(false, "error in credential input! is your port a number?");
		}
	}
	
		// try to connect to the server; output the exit status to the status bar
	public static void connectionTest()	{
		if(readyToConnect){
			try	{
					// new session config object
				JSch ssh = new JSch();
					// new session object
				Session session = ssh.getSession(username, host, port);
				session.setPassword(password);
				session.setConfig("StrictHostKeyChecking", "no");
				session.connect();
					// open a comms channel
				Channel channel = session.openChannel("sftp");
				channel.connect();
        
					// open a sftp-specific comms channel
				ChannelSftp sftp = (ChannelSftp) channel;
					// store the list of files returned by ls
				@SuppressWarnings("unchecked")
				Vector<ChannelSftp.LsEntry> files = sftp.ls("/home/*");
        			// get the first entry in the list of files
				files.get(0);
        			// tell the user that the connection attempt was successful
				MainWindow.updateStatus(true, "connection attempt successful!");
				sftp.exit();
				channel.disconnect();
			}
			catch(Exception e)	{
				MainWindow.updateStatus(false, "connection failed! error message: " + e.getMessage());
			}
		} else {
			MainWindow.updateStatus(false, "not ready to connect! were your credentials input successfully?");
		}
	}
}
