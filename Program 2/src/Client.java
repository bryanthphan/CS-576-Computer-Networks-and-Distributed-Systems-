import java.io.*;
import java.net.*;

public class Client {
	public static void main(String arg[]) {
		try { 
			@SuppressWarnings("resource")
			//creates a socket for port 5433
			DatagramSocket datagramSocket = new DatagramSocket(5433); 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//asks for user to enter message 
			System.out.println("Please enter a message: ");
			String num = br.readLine();
			byte b[] = new byte[1024];
			b = num.getBytes();
			DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getLocalHost(),5432);
			datagramSocket.send(dp);
			byte b1[] = new byte [1024]; 
			DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
			datagramSocket.receive(dp1);
			String str = new String(dp1.getData(),0,dp1.getLength());
			System.out.println(str);	
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
