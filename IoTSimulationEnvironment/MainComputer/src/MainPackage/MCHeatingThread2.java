package MainPackage;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.eclipse.swt.widgets.Display;

public class MCHeatingThread2 extends MyMainScreen  implements Runnable {

		public  Destination dest_room1_temp,dest_room1_mode,dest_room1_status;
		public  Destination dest_room2_temp,dest_room2_mode,dest_room2_status;
		public  Destination dest_room3_temp,dest_room3_mode,dest_room3_status;
		public  Destination dest_room4_temp,dest_room4_mode,dest_room4_status;
		public  Destination dest_kitchen_temp,dest_kitchen_mode,dest_kitchen_status;
		public  Destination dest_hall_temp,dest_hall_mode,dest_hall_status;
		public  Destination dest_bathroom_temp,dest_bathroom_mode,dest_bathroom_status;
		
		public  MessageConsumer consumer_room1_temp,consumer_room1_mode,consumer_room1_status;
		public  MessageConsumer consumer_room2_temp,consumer_room2_mode,consumer_room2_status;
		public  MessageConsumer consumer_room3_temp,consumer_room3_mode,consumer_room3_status;
		public  MessageConsumer consumer_room4_temp,consumer_room4_mode,consumer_room4_status;
		public  MessageConsumer consumer_kitchen_temp,consumer_kitchen_mode,consumer_kitchen_status;
		public  MessageConsumer consumer_hall_temp,consumer_hall_mode,consumer_hall_status;
		public  MessageConsumer consumer_bathroom_temp,consumer_bathroom_mode,consumer_bathroom_status;
			
		
		public  String user=null,password=null,host=null;
		public  String text_room1_temp = null,text_room1_mode = null,text_room1_status = null;
		public  String text_room2_temp = null,text_room2_mode = null,text_room2_status = null;
		public  String text_room3_temp = null,text_room3_mode = null,text_room3_status = null;
		public  String text_room4_temp = null,text_room4_mode = null,text_room4_status = null;
		public  String text_kitchen_temp = null,text_kitchen_mode = null,text_kitchen_status = null;
		public  String text_hall_temp = null,text_hall_mode = null,text_hall_status = null;
		public  String text_bathroom_temp = null,text_bathroom_mode = null,text_bathroom_status = null;
		public int port;
		
		public Session session_room1_temp,session_room1_mode,session_room1_status;
		public Session session_room2_temp,session_room2_mode,session_room2_status;
		public Session session_room3_temp,session_room3_mode,session_room3_status;
		public Session session_room4_temp,session_room4_mode,session_room4_status;
		public Session session_kitchen_temp,session_kitchen_mode,session_kitchen_status;
		public Session session_hall_temp,session_hall_mode,session_hall_status;
		public Session session_bathroom_temp,session_bathroom_mode,session_bathroom_status;
	 	
		
	 	private Display display;
	    
	    public Display getDisplay(){
	        return display;
	    }
	    public void run() 
	    {
	    	user = env("ACTIVEMQ_USER", "admin");
	        password = env("ACTIVEMQ_PASSWORD", "password");
	        host = env("ACTIVEMQ_HOST", "localhost");
	        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
	        //String destination = arg(args, 0, "event");

	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);

	        Connection connection = null;
			try {
				connection = factory.createConnection(user, password);
				connection.start();
				session_room3_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room3_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room3_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room4_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room4_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room4_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    
		        
			    dest_room3_temp = session_room3_temp.createQueue("ROOM3_TEMP.FOO");
		        dest_room3_mode = session_room3_mode.createQueue("ROOM3_MODE.FOO");
		        dest_room3_status = session_room3_status.createQueue("ROOM3_STATUS.FOO");
		        dest_room4_temp = session_room4_temp.createQueue("ROOM4_TEMP.FOO");
		        dest_room4_mode = session_room4_mode.createQueue("ROOM4_MODE.FOO");
		        dest_room4_status = session_room4_status.createQueue("ROOM4_STATUS.FOO");
		        
		        consumer_room3_temp = session_room3_temp.createConsumer(dest_room3_temp);
		        consumer_room3_mode = session_room3_mode.createConsumer(dest_room3_mode);
		        consumer_room3_status = session_room3_status.createConsumer(dest_room3_status);
		        consumer_room4_temp = session_room4_temp.createConsumer(dest_room4_temp);
		        consumer_room4_mode = session_room4_mode.createConsumer(dest_room4_mode);
		        consumer_room4_status = session_room4_status.createConsumer(dest_room4_status);
		        
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	       
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_room3_temp = null,message_room3_mode = null,message_room3_status = null;
	    		Message message_room4_temp = null,message_room4_mode = null,message_room4_status = null;
	    	
				try {
					message_room3_temp  = consumer_room3_temp.receive(1000);
					message_room3_status  = consumer_room3_status.receive(1000);
					message_room3_mode  = consumer_room3_mode.receive(1000);
					message_room4_temp  = consumer_room4_temp.receive(1000);
					message_room4_status  = consumer_room4_status.receive(1000);
					message_room4_mode  = consumer_room4_mode.receive(1000);
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_room3_temp == null || message_room3_mode ==  null || message_room3_status ==  null ||
	    			message_room4_temp == null || message_room4_mode ==  null || message_room4_status ==  null 	
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_room3_temp instanceof TextMessage || message_room3_status instanceof TextMessage) {
			    		TextMessage textMessage_room3_temp = (TextMessage) message_room3_temp;
			    		TextMessage textMessage_room3_status= (TextMessage) message_room3_status;
			    		TextMessage textMessage_room3_mode = (TextMessage) message_room3_mode;
			    		TextMessage textMessage_room4_temp = (TextMessage) message_room4_temp;
			    		TextMessage textMessage_room4_status= (TextMessage) message_room4_status;
			    		TextMessage textMessage_room4_mode = (TextMessage) message_room4_mode;
			    		
						try {
							text_room3_temp = textMessage_room3_temp.getText();
							text_room3_mode = textMessage_room3_mode.getText();
							text_room3_status = textMessage_room3_status.getText();
							text_room4_temp = textMessage_room4_temp.getText();
							text_room4_mode = textMessage_room4_mode.getText();
							text_room4_status = textMessage_room4_status.getText();
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		//System.out.println("Received1: " + text);
			    		doUpdate(display,room3_temp,text_room3_temp);
			    		doUpdate(display,room3_mode,text_room3_mode);
			    		doUpdate(display,room3_status,text_room3_status);
			    		doUpdate(display,room4_temp,text_room4_temp);
			    		doUpdate(display,room4_mode,text_room4_mode);
			    		doUpdate(display,room4_status,text_room4_status);
			    		
			    		
	    			} else {
	    			//System.out.println("Received2: " + message);
	    			
	    			
	    			}
	    	} 
	    	/*try {
				consumer.close();
				session.close(); 
		    	connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	    	
	    }

	    private static String env(String key, String defaultValue) {
	        String rc = System.getenv(key);
	        if( rc== null )
	            return defaultValue;
	        return rc;
	    }


}
