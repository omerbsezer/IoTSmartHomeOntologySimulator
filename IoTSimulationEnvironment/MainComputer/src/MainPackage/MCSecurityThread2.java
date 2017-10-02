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

public class MCSecurityThread2 extends MyMainScreen  implements Runnable {

		public  Destination dest_room1_sstatus,dest_room1_smode;
		public  Destination dest_room2_sstatus,dest_room2_smode;
		public  Destination dest_room3_sstatus,dest_room3_smode;
		public  Destination dest_room4_sstatus,dest_room4_smode;
		public  Destination dest_kitchen_sstatus,dest_kitchen_smode;
		public  Destination dest_hall_sstatus,dest_hall_smode;
		public  Destination dest_bathroom_sstatus,dest_bathroom_smode;
		public  Destination dest_water_sstatus,dest_water_smode;
		public  Destination dest_gas_sstatus,dest_gas_smode;
		public  Destination dest_elec_sstatus,dest_elec_smode;
		
		
		public  MessageConsumer consumer_room1_sstatus,consumer_room1_smode;
		public  MessageConsumer consumer_room2_sstatus,consumer_room2_smode;
		public  MessageConsumer consumer_room3_sstatus,consumer_room3_smode;
		public  MessageConsumer consumer_room4_sstatus,consumer_room4_smode;
		public  MessageConsumer consumer_kitchen_sstatus,consumer_kitchen_smode;
		public  MessageConsumer consumer_hall_sstatus,consumer_hall_smode;
		public  MessageConsumer consumer_bathroom_sstatus,consumer_bathroom_smode;
		public  MessageConsumer consumer_water_sstatus,consumer_water_smode;
		public  MessageConsumer consumer_gas_sstatus,consumer_gas_smode;
		public  MessageConsumer consumer_elec_sstatus,consumer_elec_smode;
		
		
		public  String user=null,password=null,host=null;
		public  String text_room1_sstatus = null,text_room1_smode = null;
		public  String text_room2_sstatus = null,text_room2_smode = null;
		public  String text_room3_sstatus = null,text_room3_smode = null;
		public  String text_room4_sstatus = null,text_room4_smode = null;
		public  String text_kitchen_sstatus = null,text_kitchen_smode = null;
		public  String text_hall_sstatus = null,text_hall_smode = null;
		public  String text_bathroom_sstatus= null,text_bathroom_smode = null;
		public  String text_water_sstatus= null,text_water_smode = null;
		public  String text_gas_sstatus= null,text_gas_smode = null;
		public  String text_elec_sstatus= null,text_elec_smode = null;
		
		
		public int port;
		
		public Session session_room1_sstatus,session_room1_smode;
		public Session session_room2_sstatus,session_room2_smode;
		public Session session_room3_sstatus,session_room3_smode;
		public Session session_room4_sstatus,session_room4_smode;
		public Session session_kitchen_sstatus,session_kitchen_smode;
		public Session session_hall_sstatus,session_hall_smode;
		public Session session_bathroom_sstatus,session_bathroom_smode;
		public Session session_water_sstatus,session_water_smode;
		public Session session_gas_sstatus,session_gas_smode;
		public Session session_elec_sstatus,session_elec_smode;
		
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
		       
				session_kitchen_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_kitchen_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_hall_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_hall_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_bathroom_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_bathroom_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
			   
		        dest_kitchen_sstatus = session_kitchen_sstatus.createQueue("KITCHEN_SSTATUS.FOO");
		        dest_kitchen_smode = session_kitchen_smode.createQueue("KITCHEN_SMODE.FOO");
		        dest_hall_sstatus = session_hall_sstatus.createQueue("HALL_SSTATUS.FOO");
		        dest_hall_smode = session_hall_smode.createQueue("HALL_SMODE.FOO");
		        dest_bathroom_sstatus = session_bathroom_sstatus.createQueue("BATHROOM_SSTATUS.FOO");
		        dest_bathroom_smode = session_bathroom_smode.createQueue("BATHROOM_SMODE.FOO");
		        
		   
		        consumer_kitchen_sstatus = session_kitchen_sstatus.createConsumer(dest_kitchen_sstatus);
		        consumer_kitchen_smode = session_kitchen_smode.createConsumer(dest_kitchen_smode);
		        consumer_hall_sstatus = session_hall_sstatus.createConsumer(dest_hall_sstatus);
		        consumer_hall_smode = session_hall_smode.createConsumer(dest_hall_smode);
		        consumer_bathroom_sstatus = session_bathroom_sstatus.createConsumer(dest_bathroom_sstatus);
		        consumer_bathroom_smode = session_bathroom_smode.createConsumer(dest_bathroom_smode);
		        

		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_kitchen_sstatus = null,message_kitchen_smode = null;
	    		Message message_hall_sstatus = null,message_hall_smode = null;
	    		Message message_bathroom_sstatus = null,message_bathroom_smode = null;
	    		
	    		
				try {
					message_kitchen_sstatus  = consumer_kitchen_sstatus.receive(1000);
					message_kitchen_smode  = consumer_kitchen_smode.receive(1000);
					message_hall_sstatus  = consumer_hall_sstatus.receive(1000);
					message_hall_smode  = consumer_hall_smode.receive(1000);
					message_bathroom_sstatus  = consumer_bathroom_sstatus.receive(1000);
					message_bathroom_smode  = consumer_bathroom_smode.receive(1000);
					
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_kitchen_sstatus == null || message_kitchen_smode ==  null ||
	    			message_hall_sstatus == null || message_hall_smode ==  null ||
	    			message_bathroom_sstatus == null || message_bathroom_smode ==  null
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_kitchen_sstatus instanceof TextMessage || message_kitchen_smode instanceof TextMessage) {
			    		TextMessage textMessage_kitchen_sstatus = (TextMessage) message_kitchen_sstatus;
			    		TextMessage textMessage_kitchen_smode= (TextMessage) message_kitchen_smode;
			    		TextMessage textMessage_hall_sstatus = (TextMessage) message_hall_sstatus;
			    		TextMessage textMessage_hall_smode= (TextMessage) message_hall_smode;
			    		TextMessage textMessage_bathroom_sstatus = (TextMessage) message_bathroom_sstatus;
			    		TextMessage textMessage_bathroom_smode= (TextMessage) message_bathroom_smode;
			    		
						try {
							text_kitchen_sstatus = textMessage_kitchen_sstatus.getText();
							text_kitchen_smode = textMessage_kitchen_smode.getText();
							text_hall_sstatus = textMessage_hall_sstatus.getText();
							text_hall_smode = textMessage_hall_smode.getText();
							text_bathroom_sstatus = textMessage_bathroom_sstatus.getText();
							text_bathroom_smode = textMessage_bathroom_smode.getText();
							
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
			    		doUpdate(display,kitchen_sstatus,text_kitchen_sstatus);
			    		doUpdate(display,kitchen_smode,text_kitchen_smode);
			    		doUpdate(display,hall_sstatus,text_hall_sstatus);
			    		doUpdate(display,hall_smode,text_hall_smode);
			    		doUpdate(display,bathroom_sstatus,text_bathroom_sstatus);
			    		doUpdate(display,bathroom_smode,text_bathroom_smode);
			    
			    		
			    		
			    		
			    		
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
