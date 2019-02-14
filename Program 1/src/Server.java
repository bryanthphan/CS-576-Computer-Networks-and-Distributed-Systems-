import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		String message;
		/**creates the server socket*/
		ServerSocket ss = new ServerSocket(1342);
		/**creates the simple socket
		 * accepts - accepts the incoming requests to the socket 
		 */
		Socket so = ss.accept();
		/**takes in the message that the client receives from the user*/
		Scanner scan = new Scanner(so.getInputStream());
		/**reads in next line of the String message*/
		message = scan.nextLine();
		
		/**stores the String into a char array */ 
		char[] character = new char[message.length()];
		char newChar[] = (char[]) character;
		/**for loops that passes each character that then converts the char into an int
		 * adds 1 to that int in order to get the next character in the ASCII sequence 
		 * puts the int into a new char array 
		 */
		for(int i = 0; i <message.length(); i++) {
			character[i] = message.charAt(i);
			int ascii = (int) character[i] + 1;
			newChar[i] = (char) ascii; 
		}
		/**puts the char array into a string 
		 * that way we can print out the contents
		 */
		String newstring = new String(newChar);
		/**gets the results of the conversion and passes it back to the Client*/
		PrintStream p = new PrintStream(so.getOutputStream());
		p.println(newstring);
	}
}