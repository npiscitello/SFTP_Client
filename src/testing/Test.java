package testing;

import java.util.Vector;

import com.jcraft.jsch.*;

public class Test {
	
	public static void main(String args[])	{
		
			// login credentials
		String host = "192.168.1.100";	int port = 222;
		String user = "npiscitello_sftp";	String pass = "pass";
		
		try	{
				// new session config object
			JSch ssh = new JSch();
				// new session object
			Session session = ssh.getSession(user, host, port);
			session.setPassword(pass);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
				// open a comms channel
	        Channel channel = session.openChannel("sftp");
	        channel.connect();
	        
	        	// open a sftp-specific comms channel
	        ChannelSftp sftp = (ChannelSftp) channel;
	        	// store the list of files returned by ls
	        Vector<ChannelSftp.LsEntry> files = sftp.ls("/home/*");
	        	// get the first entry in the list of files
	        ChannelSftp.LsEntry object = files.get(0);
	        	// print the filename of the returned file
	        System.out.println(object.getFilename());
	        sftp.exit();
	        channel.disconnect();
		}
		catch(Exception e)	{
			System.out.println(e);
		}
	}
}
