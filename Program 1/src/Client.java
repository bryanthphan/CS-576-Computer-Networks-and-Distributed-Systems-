import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws UnknownHostException, IOException {
		String message, temp;
		/**reads in user input*/
		Scanner scan = new Scanner(System.in);
		/**communicates with the server and connects to the localhost(running on the same machine [127.0.0.1])
		 * if you wanted to run on another machine you would write in it's IP address 
		 * 1342 refers to the port number 
		 */
		Socket s = new Socket("127.0.0.1",1342); 
		/**used to get the input stream*/
		Scanner scan1 = new Scanner(s.getInputStream()); 
		/**ask the user to enter a message*/
		System.out.println("Enter any message:");
		message = scan.nextLine();
		/**checks to see if the user input is more than 256 characters
		 * if it does produces an error message and asks the user to try again
		 */
		if(message.length() > 255) {
			System.out.println("Sorry, this text has more than 256 characters");
			System.out.println("Please try again: ");
			message = scan.nextLine();
		}
		/**passes over to the server*/
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(message);
		/**stores the result*/
		temp=scan1.nextLine();
		System.out.println(temp);		
	}
}
