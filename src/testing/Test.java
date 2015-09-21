package testing;

import java.util.Vector;

import com.jcraft.jsch.*;

public class Test {
	
	public static void main(String args[])	{
		
		String host = "192.168.1.100";	int port = 222;
		String user = "npiscitello_sftp";	String pass = "pass";
		
		try	{
			JSch ssh = new JSch();
			Session session = ssh.getSession(user, host, port);
			session.setPassword(pass);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
	        Channel channel = session.openChannel("sftp");
	        channel.connect();
	        
	        ChannelSftp sftp = (ChannelSftp) channel;
	        Vector<ChannelSftp.LsEntry> files = sftp.ls("/home/*");
	        ChannelSftp.LsEntry object = files.get(0);
	        System.out.println(object.getFilename());
	        sftp.exit();
	        channel.disconnect();
		}
		catch(Exception e)	{
			System.out.println(e);
		}
	}
}
