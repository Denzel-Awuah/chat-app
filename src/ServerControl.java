import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerControl implements Runnable {

	//The client Socket 
	private Socket theClient;
	
	private BufferedReader din; 
	
	public Boolean encrypt;//are we encrypting right now
	public String key;//what key are we using?
			
	String msgin = "", username;
	
	//Constructor
	public ServerControl(Socket server) throws IOException {
		theClient = server;	//Getting the client socket
		din = new BufferedReader(new InputStreamReader(theClient.getInputStream())); //input reader for reading client input
	}
	
	/*  
	  Name:	run
	  
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
					if(encrypt){//if we are encrypting we also have to do some other stuff
					//same as encrypting really

						if(msgin.indexOf(":")>0){//if its badly formed, dont try to de encrypt
							String target=msgin.substring(0,msgin.indexOf(":")+1);//split 
							//message into sender and message
							//we have to add 2 to also miss the space
							
							String msg=msgin.substring(msgin.indexOf(":")+1,msgin.length());
							msg=msg.trim();//any whitespace at all attatched to this will break the decryption
							msg=AES.decrypt(msg,key);//decryp just the message
							//if you dont want to do aes here you can apply ROT instead by making a ROT.decrypt function
							msgin=target+"  "+msg;//rebuild the message packet, remember we didnt encrypt target or the server wouldnt know who to send it to
						}//everything else as normal
						// if there wasnt a : we didnt even try to decrypt it so it should look fine for server messages
					}
		    		System.out.println(msgin); 	//printing server msg
		    	}//end while
		    	
			} catch (IOException e) {
				System.out.println("");
			}					
			
	}//end run

	

}//end class
