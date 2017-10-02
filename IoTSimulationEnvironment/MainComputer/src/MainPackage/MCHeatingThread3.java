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

public class MCHeatingThread3 extends MyMainScreen  implements Runnable {

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
				session_kitchen_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_kitchen_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_kitchen_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_hall_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_hall_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_hall_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_bathroom_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_bathroom_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_bathroom_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    
		        
			    dest_kitchen_temp = session_kitchen_temp.createQueue("KITCHEN_TEMP.FOO");
		        dest_kitchen_mode = session_kitchen_mode.createQueue("KITCHEN_MODE.FOO");
		        dest_kitchen_status = session_kitchen_status.createQueue("KITCHEN_STATUS.FOO");
		        dest_hall_temp = session_hall_temp.createQueue("HALL_TEMP.FOO");
		        dest_hall_mode = session_hall_mode.createQueue("HALL_MODE.FOO");
		        dest_hall_status = session_hall_status.createQueue("HALL_STATUS.FOO");
		        dest_bathroom_temp = session_bathroom_temp.createQueue("BATHROOM_TEMP.FOO");
		        dest_bathroom_mode = session_bathroom_mode.createQueue("BATHROOM_MODE.FOO");
		        dest_bathroom_status = session_bathroom_status.createQueue("BATHROOM_STATUS.FOO");
		        
		        consumer_kitchen_temp = session_kitchen_temp.createConsumer(dest_kitchen_temp);
		        consumer_kitchen_mode = session_kitchen_mode.createConsumer(dest_kitchen_mode);
		        consumer_kitchen_status = session_kitchen_status.createConsumer(dest_kitchen_status);
		        consumer_hall_temp = session_hall_temp.createConsumer(dest_hall_temp);
		        consumer_hall_mode = session_hall_mode.createConsumer(dest_hall_mode);
		        consumer_hall_status = session_hall_status.createConsumer(dest_hall_status);
		        consumer_bathroom_temp = session_bathroom_temp.createConsumer(dest_bathroom_temp);
		        consumer_bathroom_mode = session_bathroom_mode.createConsumer(dest_bathroom_mode);
		        consumer_bathroom_status = session_bathroom_status.createConsumer(dest_bathroom_status);
		        
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	     
	        
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_kitchen_temp = null,message_kitchen_mode = null,message_kitchen_status = null;
	    		Message message_hall_temp = null,message_hall_mode = null,message_hall_status = null;
	    		Message message_bathroom_temp = null,message_bathroom_mode = null,message_bathroom_status = null;
	    	
				try {
					message_kitchen_temp  = consumer_kitchen_temp.receive(1000);
					message_kitchen_status  = consumer_kitchen_status.receive(1000);
					message_kitchen_mode  = consumer_kitchen_mode.receive(1000);
					message_hall_temp  = consumer_hall_temp.receive(1000);
					message_hall_status  = consumer_hall_status.receive(1000);
					message_hall_mode  = consumer_hall_mode.receive(1000);
					message_bathroom_temp  = consumer_bathroom_temp.receive(1000);
					message_bathroom_status  = consumer_bathroom_status.receive(1000);
					message_bathroom_mode  = consumer_bathroom_mode.receive(1000);
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_kitchen_temp == null || message_kitchen_mode ==  null || message_kitchen_status ==  null ||
	    			message_hall_temp == null || message_hall_mode ==  null || message_hall_status ==  null ||
	    			message_bathroom_temp == null || message_bathroom_mode ==  null || message_bathroom_status ==  null
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_kitchen_temp instanceof TextMessage || message_kitchen_status instanceof TextMessage) {
			    		TextMessage textMessage_kitchen_temp = (TextMessage) message_kitchen_temp;
			    		TextMessage textMessage_kitchen_status= (TextMessage) message_kitchen_status;
			    		TextMessage textMessage_kitchen_mode = (TextMessage) message_kitchen_mode;
			    		TextMessage textMessage_hall_temp = (TextMessage) message_hall_temp;
			    		TextMessage textMessage_hall_status= (TextMessage) message_hall_status;
			    		TextMessage textMessage_hall_mode = (TextMessage) message_hall_mode;
			    		TextMessage textMessage_bathroom_temp = (TextMessage) message_bathroom_temp;
			    		TextMessage textMessage_bathroom_status= (TextMessage) message_bathroom_status;
			    		TextMessage textMessage_bathroom_mode = (TextMessage) message_bathroom_mode;
			    		
						try {
							text_kitchen_temp = textMessage_kitchen_temp.getText();
							text_kitchen_mode = textMessage_kitchen_mode.getText();
							text_kitchen_status = textMessage_kitchen_status.getText();
							text_hall_temp = textMessage_hall_temp.getText();
							text_hall_mode = textMessage_hall_mode.getText();
							text_hall_status = textMessage_hall_status.getText();
							text_bathroom_temp = textMessage_bathroom_temp.getText();
							text_bathroom_mode = textMessage_bathroom_mode.getText();
							text_bathroom_status = textMessage_bathroom_status.getText();
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		//System.out.println("Received1: " + text);
			    		doUpdate(display,kitchen_temp,text_kitchen_temp);
			    		doUpdate(display,kitchen_mode,text_kitchen_mode);
			    		doUpdate(display,kitchen_status,text_kitchen_status);
			    		doUpdate(display,hall_temp,text_hall_temp);
			    		doUpdate(display,hall_mode,text_hall_mode);
			    		doUpdate(display,hall_status,text_hall_status);
			    		doUpdate(display,bathroom_temp,text_hall_temp);
			    		doUpdate(display,bathroom_mode,text_hall_mode);
			    		doUpdate(display,bathroom_status,text_hall_status);
			    		
			    		
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
