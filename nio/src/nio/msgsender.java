package nio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import nio.Message.MessageType;


public class msgsender {
	
public static Socket request;




	public static void main(String[] args) 
	{

		ObjectOutputStream oos = null;
		int count = 0;
	    
		while(true){
		
			try
				{
					request = new Socket("localhost",8080);
				}
			catch (IOException e) 
				{
					e.printStackTrace();
				}
	
	
			try
				{
					oos = new ObjectOutputStream(request.getOutputStream());
				} 
			catch (IOException e1)
				{
					e1.printStackTrace();
				}
	      
			count++;
			
			if(count == 10)
			{				
				break;
			}

			
			Random rand = new Random();
			Message msg = new Message();
		
			
		int next = rand.nextInt(3);
		msg.setMessageId(count);
		
		switch (next)
				{
						case 0: msg.setType(MessageType.HELLO);
								break;
						case 1: msg.setType(MessageType.REQUEST);
								break;
						case 2: msg.setType(MessageType.REPLY);
								break;	
						default: msg.setType(MessageType.REQUEST);
								break;
				}
		
			try 
				{
				//System.out.println(msg.getMsg());
					oos.writeObject(msg);
					oos.close();
				}
			catch (IOException e) 
				{
					e.printStackTrace();
				}
			
			
				}
	}



}
