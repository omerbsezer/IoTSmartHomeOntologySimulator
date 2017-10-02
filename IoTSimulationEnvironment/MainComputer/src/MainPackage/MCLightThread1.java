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

public class MCLightThread1 extends MyMainScreen  implements Runnable {

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
		       
				session_room1_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room1_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room2_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room2_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room3_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room3_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room4_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_room4_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
		        dest_room1_light = session_room1_light.createQueue("ROOM1_LIGHT.FOO");
		        dest_room1_il = session_room1_il.createQueue("ROOM1_IL.FOO");
		        dest_room2_light = session_room2_light.createQueue("ROOM2_LIGHT.FOO");
		        dest_room2_il = session_room2_il.createQueue("ROOM2_IL.FOO");
		        dest_room3_light = session_room3_light.createQueue("ROOM3_LIGHT.FOO");
		        dest_room3_il = session_room3_il.createQueue("ROOM3_IL.FOO");
		        dest_room4_light = session_room4_light.createQueue("ROOM4_LIGHT.FOO");
		        dest_room4_il = session_room4_il.createQueue("ROOM4_IL.FOO");
		       
		        
		        
		        consumer_room1_light = session_room1_light.createConsumer(dest_room1_light);
		        consumer_room1_il = session_room1_il.createConsumer(dest_room1_il);
		        consumer_room2_light = session_room2_light.createConsumer(dest_room2_light);
		        consumer_room2_il = session_room2_il.createConsumer(dest_room2_il);
		        consumer_room3_light = session_room3_light.createConsumer(dest_room3_light);
		        consumer_room3_il = session_room3_il.createConsumer(dest_room3_il);
		        consumer_room4_light = session_room4_light.createConsumer(dest_room4_light);
		        consumer_room4_il = session_room4_il.createConsumer(dest_room4_il);
		       
		       
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	       
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_room1_light = null,message_room1_il = null;
	    		Message message_room2_light = null,message_room2_il = null;
	    		Message message_room3_light = null,message_room3_il = null;
	    		Message message_room4_light = null,message_room4_il = null;
	    		
				try {
					message_room1_light  = consumer_room1_light.receive(1000);
					message_room1_il  = consumer_room1_il.receive(1000);
					message_room2_light  = consumer_room2_light.receive(1000);
					message_room2_il  = consumer_room2_il.receive(1000);
					message_room3_light  = consumer_room3_light.receive(1000);
					message_room3_il  = consumer_room3_il.receive(1000);
					message_room4_light  = consumer_room4_light.receive(1000);
					message_room4_il  = consumer_room4_il.receive(1000);
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_room1_light == null || message_room1_il ==  null ||
	    			message_room2_light == null || message_room2_il ==  null ||
	    			message_room3_light == null || message_room3_il ==  null ||
	    			message_room4_light == null || message_room4_il ==  null 
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_room1_light instanceof TextMessage || message_room1_il instanceof TextMessage) {
			    		TextMessage textMessage_room1_light = (TextMessage) message_room1_light;
			    		TextMessage textMessage_room1_il= (TextMessage) message_room1_il;
			    		TextMessage textMessage_room2_light = (TextMessage) message_room2_light;
			    		TextMessage textMessage_room2_il= (TextMessage) message_room2_il;
			    		TextMessage textMessage_room3_light = (TextMessage) message_room3_light;
			    		TextMessage textMessage_room3_il= (TextMessage) message_room3_il;
			    		TextMessage textMessage_room4_light = (TextMessage) message_room4_light;
			    		TextMessage textMessage_room4_il= (TextMessage) message_room4_il;
			    		
						try {
							text_room1_light = textMessage_room1_light.getText();
							text_room1_il = textMessage_room1_il.getText();
							text_room2_light = textMessage_room2_light.getText();
							text_room2_il = textMessage_room2_il.getText();
							text_room3_light = textMessage_room3_light.getText();
							text_room3_il = textMessage_room3_il.getText();
							text_room4_light = textMessage_room4_light.getText();
							text_room4_il = textMessage_room4_il.getText();
							
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						//************for time measurement-In Queue Time
						long stopTimeRoom2IL = System.currentTimeMillis();	
						difTimeRoom2IL=stopTimeRoom2IL-Long.valueOf(text_room2_il);
						if(difTimeRoom2IL>maxDifTimeRoom2IL){
							maxDifTimeRoom2IL=difTimeRoom2IL;
						}
						totalRoom2IL=difTimeRoom2IL+totalRoom2IL;
						counterRoom2IL++;
						
						//************for time measurement-In Queue Time
						
						//long startTimeProcess = System.currentTimeMillis();	
						//**Processing Part
						/*if(Integer.valueOf(text_room1_il)<40){
							UpdateInfo(display,lblInfo,"Lights On!");
							ChangeColorRed(display,room1_light);
							ChangeColorRed(display,room1_il);
							
							SendCommand("LS","Room1","Light","On");
							UpdateInfo(display,lblInfo,"Sending Command to LS: Room1 Light On");
							ls_command_send=1;
							long stopTimeProcess = System.currentTimeMillis();	
							processTime=stopTimeProcess-startTimeProcess;
							//counter_ref_temp++;	
						}
						else if(Integer.valueOf(text_room1_il)>350 && ls_command_send==1){
							UpdateInfo(display,lblInfo,"Lights Off!");
							SendCommand("LS","Room1","Light","Off");
							UpdateInfo(display,lblInfo,"Sending Command to LS: Room1 Light Off");
							ls_command_send=0;
							ChangeColorWhite(display,room1_light);
							ChangeColorWhite(display,room1_il);
						}*/
						//**Processing Part
						
						//totalProcess=processTime+totalProcess;
						
						//time measurement mode
						doUpdate(display,room1_light,text_room1_light);
			    		doUpdate(display,room1_il,text_room1_il);
			    		doUpdate(display,room2_light,String.valueOf(processTime)); //time measurement
			    		doUpdate(display,room2_il,String.valueOf(totalRoom2IL));  //time measurement
			    		//doUpdate(display,room2_light,text_room2_light); 
			    		//doUpdate(display,room2_il,text_room2_il);
			    		doUpdate(display,room3_light,String.valueOf(counterRoom2IL));
			    		//doUpdate(display,room3_il,String.valueOf(maxDifTimeRoom2IL));
			    		//doUpdate(display,room3_light,text_room3_light);
			    		doUpdate(display,room3_il,text_room3_il);
			    		doUpdate(display,room4_light,text_room4_light);
			    		doUpdate(display,room4_il,text_room4_il);
						
						//normal mode
			    		/*doUpdate(display,room1_light,text_room1_light);
			    		doUpdate(display,room1_il,text_room1_il);
			    		doUpdate(display,room2_light,text_room2_light);
			    		doUpdate(display,room2_il,text_room2_il);
			    		doUpdate(display,room3_light,text_room3_light);
			    		doUpdate(display,room3_il,text_room3_il);
			    		doUpdate(display,room4_light,text_room4_light);
			    		doUpdate(display,room4_il,text_room4_il);*/
			    		
			    		
			    		
			    		
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
