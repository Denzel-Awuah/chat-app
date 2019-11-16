import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerControl implements Runnable {

	//The client Socket 
	private Socket theClient;
	
	private BufferedReader din; 
	
	
	String msgin = "", username;
	
	//Constructor
	public ServerControl(Socket server) throws IOException {
		theClient = server;	//Getting the client socket
		din = new BufferedReader(new InputStreamReader(theClient.getInputStream())); //input reader for reading client input
	}
	
	/*  
	  Name:	run
	  
	  Written By: Denzel Awuah - October 2019
	  
	  Purpose: Thread that is used for running the server and its functions 
	  
	  Usage: used to send clients packets to the server 
	  
	  Subroutines/libraries required:
	
	 */
	@Override
	public void run() {
		
		    try {
		    	//while client message is not "bye"
		    	while(true) {
		    		msgin = din.readLine();     //reads the input
		    		System.out.println(msgin); 	//printing server msg
		    	}//end while
		    	
			} catch (IOException e) {
				System.out.println("");
			}					
			
	}//end run

	

}//end class
