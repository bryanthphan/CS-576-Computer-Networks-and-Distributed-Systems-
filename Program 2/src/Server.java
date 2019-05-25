import java.io.*;
import java.net.*; 

@SuppressWarnings("unused")
public class Server {
	public static void main(String arg[]) { 
		try { 
			@SuppressWarnings("resource")
			//creates a socket on port 5432 
			DatagramSocket datagramSocket = new DatagramSocket(5432);
			byte b[] = new byte[1024]; 
			//creates a datagram packet to receive data 
			DatagramPacket dp = new DatagramPacket(b,b.length);
			datagramSocket.receive(dp);
			//concatenates original message with humorous message as an ASCII string 
			String response = data(b).toString() + " work hard, play hard";	
			byte b1[] = new byte[1024]; 
			b1 = response.getBytes();
			//sends the concatenated message to the client 
			DatagramPacket dp1 = new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(),5433);
			datagramSocket.send(dp1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//used for printing the data that was received 
	public static StringBuilder data(byte[] a) {
		if (a == null) 
			return null; 
		StringBuilder sb = new StringBuilder(); 
		int i = 0; 
		while(a[i] != 0 ) {
			sb.append((char) a[i]);
			i++;
		}
		return sb;
	}

}
