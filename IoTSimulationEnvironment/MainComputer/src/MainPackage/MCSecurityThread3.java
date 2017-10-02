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

public class MCSecurityThread3 extends MyMainScreen  implements Runnable {

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
		       
				session_water_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_water_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_gas_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_gas_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_elec_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_elec_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
			   
		        dest_water_sstatus = session_water_sstatus.createQueue("WATER_SSTATUS.FOO");
		        dest_water_smode = session_water_smode.createQueue("WATER_SMODE.FOO");
		        dest_gas_sstatus = session_gas_sstatus.createQueue("GAS_SSTATUS.FOO");
		        dest_gas_smode = session_gas_smode.createQueue("GAS_SMODE.FOO");
		        dest_elec_sstatus = session_elec_sstatus.createQueue("ELEC_SSTATUS.FOO");
		        dest_elec_smode = session_elec_smode.createQueue("ELEC_SMODE.FOO");
		        
		   
		        consumer_water_sstatus = session_water_sstatus.createConsumer(dest_water_sstatus);
		        consumer_water_smode = session_water_smode.createConsumer(dest_water_smode);
		        consumer_gas_sstatus = session_gas_sstatus.createConsumer(dest_gas_sstatus);
		        consumer_gas_smode = session_gas_smode.createConsumer(dest_gas_smode);
		        consumer_elec_sstatus = session_elec_sstatus.createConsumer(dest_elec_sstatus);
		        consumer_elec_smode = session_elec_smode.createConsumer(dest_elec_smode);
		        
		        

		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_water_sstatus = null,message_water_smode = null;
	    		Message message_gas_sstatus = null,message_gas_smode = null;
	    		Message message_elec_sstatus = null,message_elec_smode = null;
	    		
	    		
				try {
					message_water_sstatus  = consumer_water_sstatus.receive(1000);
					message_water_smode  = consumer_water_smode.receive(1000);
					message_gas_sstatus  = consumer_gas_sstatus.receive(1000);
					message_gas_smode  = consumer_gas_smode.receive(1000);
					message_elec_sstatus  = consumer_elec_sstatus.receive(1000);
					message_elec_smode  = consumer_elec_smode.receive(1000);
					
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_water_sstatus == null || message_water_smode ==  null ||
	    			message_gas_sstatus == null || message_gas_smode ==  null ||
	    			message_elec_sstatus == null || message_elec_smode ==  null
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_water_sstatus instanceof TextMessage || message_water_smode instanceof TextMessage) {
			    		TextMessage textMessage_water_sstatus = (TextMessage) message_water_sstatus;
			    		TextMessage textMessage_water_smode= (TextMessage) message_water_smode;
			    		TextMessage textMessage_gas_sstatus = (TextMessage) message_gas_sstatus;
			    		TextMessage textMessage_gas_smode= (TextMessage) message_gas_smode;
			    		TextMessage textMessage_elec_sstatus = (TextMessage) message_elec_sstatus;
			    		TextMessage textMessage_elec_smode= (TextMessage) message_elec_smode;
			    		
						try {
							text_water_sstatus = textMessage_water_sstatus.getText();
							text_water_smode = textMessage_water_smode.getText();
							text_gas_sstatus = textMessage_gas_sstatus.getText();
							text_gas_smode = textMessage_gas_smode.getText();
							text_elec_sstatus = textMessage_elec_sstatus.getText();
							text_elec_smode = textMessage_elec_smode.getText();
							
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
			    		doUpdate(display,water_sstatus,text_water_sstatus);
			    		doUpdate(display,water_smode,text_water_smode);
			    		doUpdate(display,gas_sstatus,text_gas_sstatus);
			    		doUpdate(display,gas_smode,text_gas_smode);
			    		doUpdate(display,electricity_sstatus,text_elec_sstatus);
			    		doUpdate(display,electricity_smode,text_elec_smode);
			    
			    		
			    		
			    		
			    		
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
