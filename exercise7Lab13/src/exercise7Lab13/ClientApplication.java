package exercise7Lab13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientApplication {

public static void main(String[] args) {
		
		try {
			
		// Connect to the server at localhost
		Socket socket = new Socket(InetAddress.getLocalHost(), 4155);
		
		// Create input stream
		BufferedReader bufferedReader = new BufferedReader (
		new InputStreamReader(socket.getInputStream()));
		
		 System.out.println(socket.isConnected());
		
		 // Create input data to be send to the server
		String inputClient = "Thank You";		
		String targetedLanguage = "Korea";
		
		 // Write text and target language to the server
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		
		printWriter.println(inputClient);
		printWriter.println(targetedLanguage);
		
	
		// Read from the network and display data
		String translatedText = bufferedReader.readLine();

		
		// Close everything
		bufferedReader.close();
		printWriter.flush();
		printWriter.close();
		socket.close();
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace ();
		}
	}
}
