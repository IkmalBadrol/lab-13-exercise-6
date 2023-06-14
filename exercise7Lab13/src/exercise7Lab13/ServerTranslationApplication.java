package exercise7Lab13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = null;
		
		try {
			// Bind Serversocket to a port
			int portNo = 4155;
			serverSocket = new ServerSocket (portNo);
			
			
					while (true) {
						// Accept client request for connection
						Socket clientSocket = serverSocket.accept ();
						
						// Create stream to read data on the client
						BufferedReader bufferedReader = new BufferedReader (
								new InputStreamReader(clientSocket.getInputStream()));
						
						PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
						
						// Receive input from client
						String inputClient = bufferedReader.readLine();
						String targetedLanguage = bufferedReader.readLine();
						
						
						//Print input from client
						System.out.println("Text to be translated : " + inputClient);
						System.out.println("Targeted language : " +targetedLanguage);
						
						// Call method 
						String translator = textTranslator(inputClient, targetedLanguage);
						
						
						printWriter.println(translator);
						System.out.println(translator);
						
				// Close everything
						bufferedReader.close();
						printWriter.close();
						clientSocket.close();
					}
		
					
		} catch (IOException ioe) {
			
			if (serverSocket != null)
				serverSocket.close ();
			
			ioe.printStackTrace();
			}
		}

// Method to translate text from client
public static String textTranslator(String inputClient, String targetedLanguage) {
	
	String translatedText;
	
	if(targetedLanguage.equals("Bahasa Melayu")) {
		
		if(inputClient.equals("Thank You")) {
			translatedText = "Translated Text : Terima Kasih";
		}
		else {
			translatedText = "Text cannot be translated";
		}		
	}
	else if(targetedLanguage.equals("Arabic")) {
		if(inputClient.equals("Thank You")) {
			translatedText = "Translated Text : شكرًا لك ";
		}
		else {
			translatedText = "Text cannot be translated";
		}	
	}
	else if(targetedLanguage.equals("Korea")) {
		if(inputClient.equals("Thank You")) {
			translatedText = "Translated Text : 감사합니다";
		}
		else {
			translatedText = "Text cannot be translated";
		}	
	}
	else {
		translatedText = "Invalid language";
	}
	
	return translatedText;
}

}

