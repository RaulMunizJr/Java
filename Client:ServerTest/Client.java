
import java.io.*;
import java.net.*;
public class Client {

	public static void main(String[] args) throws IOException
	{
		String serverName = /*Insert IP ADD here*/;
		int port = 9090;
		
		try 
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getLocalSocketAddress());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());//message to server
			out.writeUTF("Hello from the other side(RS) " + client.getLocalSocketAddress());
			DataInputStream in = new DataInputStream(client.getInputStream());//message from server
			System.out.println("Server says " + in.readUTF());
			client.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
