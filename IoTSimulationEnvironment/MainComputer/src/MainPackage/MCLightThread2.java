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

public class MCLightThread2 extends MyMainScreen  implements Runnable {

		public  Destination dest_room1_light,dest_room1_il;
		public  Destination dest_room2_light,dest_room2_il;
		public  Destination dest_room3_light,dest_room3_il;
		public  Destination dest_room4_light,dest_room4_il;
		public  Destination dest_kitchen_light,dest_kitchen_il;
		public  Destination dest_hall_light,dest_hall_il;
		public  Destination dest_bathroom_light,dest_bathroom_il;
		
		public  MessageConsumer consumer_room1_light,consumer_room1_il;
		public  MessageConsumer consumer_room2_light,consumer_room2_il;
		public  MessageConsumer consumer_room3_light,consumer_room3_il;
		public  MessageConsumer consumer_room4_light,consumer_room4_il;
		public  MessageConsumer consumer_kitchen_light,consumer_kitchen_il;
		public  MessageConsumer consumer_hall_light,consumer_hall_il;
		public  MessageConsumer consumer_bathroom_light,consumer_bathroom_il;
			
		
		
		public  String user=null,password=null,host=null;
		public  String text_room1_light = null,text_room1_il = null;
		public  String text_room2_light = null,text_room2_il = null;
		public  String text_room3_light = null,text_room3_il = null;
		public  String text_room4_light = null,text_room4_il = null;
		public  String text_kitchen_light = null,text_kitchen_il = null;
		public  String text_hall_light = null,text_hall_il = null;
		public  String text_bathroom_light = null,text_bathroom_il = null;
		
		
		public int port;
		
		public Session session_room1_light,session_room1_il;
		public Session session_room2_light,session_room2_il;
		public Session session_room3_light,session_room3_il;
		public Session session_room4_light,session_room4_il;
		public Session session_kitchen_light,session_kitchen_il;
		public Session session_hall_light,session_hall_il;
		public Session session_bathroom_light,session_bathroom_il;
		
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
		       
				session_kitchen_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_kitchen_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_hall_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_hall_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_bathroom_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_bathroom_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		      
				
		        dest_kitchen_light = session_kitchen_light.createQueue("KITCHEN_LIGHT.FOO");
		        dest_kitchen_il = session_kitchen_il.createQueue("KITCHEN_IL.FOO");
		        dest_hall_light = session_hall_light.createQueue("HALL_LIGHT.FOO");
		        dest_hall_il = session_hall_il.createQueue("HALL_IL.FOO");
		        dest_bathroom_light = session_bathroom_light.createQueue("BATHROOM_LIGHT.FOO");
		        dest_bathroom_il = session_bathroom_il.createQueue("BATHROOM_IL.FOO");
		        
		       
		        
		        
		        consumer_kitchen_light = session_kitchen_light.createConsumer(dest_kitchen_light);
		        consumer_kitchen_il = session_kitchen_il.createConsumer(dest_kitchen_il);
		        consumer_hall_light = session_hall_light.createConsumer(dest_hall_light);
		        consumer_hall_il = session_hall_il.createConsumer(dest_hall_il);
		        consumer_bathroom_light = session_bathroom_light.createConsumer(dest_bathroom_light);
		        consumer_bathroom_il = session_bathroom_il.createConsumer(dest_bathroom_il);
		        
		       
		       
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	      
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_kitchen_light = null,message_kitchen_il = null;
	    		Message message_hall_light = null,message_hall_il = null;
	    		Message message_bathroom_light = null,message_bathroom_il = null;
	    		
	    		
				try {
					message_kitchen_light  = consumer_kitchen_light.receive(1000);
					message_kitchen_il  = consumer_kitchen_il.receive(1000);
					message_hall_light  = consumer_hall_light.receive(1000);
					message_hall_il  = consumer_hall_il.receive(1000);
					message_bathroom_light  = consumer_bathroom_light.receive(1000);
					message_bathroom_il  = consumer_bathroom_il.receive(1000);
					
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_kitchen_light == null || message_kitchen_il ==  null ||
	    			message_hall_light == null || message_hall_il ==  null ||
	    			message_bathroom_light == null || message_bathroom_il ==  null 
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_kitchen_light instanceof TextMessage || message_kitchen_il instanceof TextMessage) {
			    		TextMessage textMessage_kitchen_light = (TextMessage) message_kitchen_light;
			    		TextMessage textMessage_kitchen_il= (TextMessage) message_kitchen_il;
			    		TextMessage textMessage_hall_light = (TextMessage) message_hall_light;
			    		TextMessage textMessage_hall_il= (TextMessage) message_hall_il;
			    		TextMessage textMessage_bathroom_light = (TextMessage) message_bathroom_light;
			    		TextMessage textMessage_bathroom_il= (TextMessage) message_bathroom_il;
			    		
			    		
						try {
							text_kitchen_light = textMessage_kitchen_light.getText();
							text_kitchen_il = textMessage_kitchen_il.getText();
							text_hall_light = textMessage_hall_light.getText();
							text_hall_il = textMessage_hall_il.getText();
							text_bathroom_light = textMessage_bathroom_light.getText();
							text_bathroom_il = textMessage_bathroom_il.getText();
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
			    		doUpdate(display,kitchen_light,text_kitchen_light);
			    		doUpdate(display,kitchen_il,text_kitchen_il);
			    		doUpdate(display,hall_light,text_hall_light);
			    		doUpdate(display,hall_il,text_hall_il);
			    		doUpdate(display,bathroom_light,text_bathroom_light);
			    		doUpdate(display,bathroom_il,text_bathroom_il);
			    		
			    		
			    		
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
