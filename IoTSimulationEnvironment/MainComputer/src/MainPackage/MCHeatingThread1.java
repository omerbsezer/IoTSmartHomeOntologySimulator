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

public class MCHeatingThread1 extends MyMainScreen  implements Runnable {

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
				session_room1_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room1_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room1_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room2_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room2_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room2_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    
		        
			    dest_room1_temp = session_room1_temp.createQueue("ROOM1_TEMP.FOO");
		        dest_room1_mode = session_room1_mode.createQueue("ROOM1_MODE.FOO");
		        dest_room1_status = session_room1_status.createQueue("ROOM1_STATUS.FOO");
		        dest_room2_temp = session_room2_temp.createQueue("ROOM2_TEMP.FOO");
		        dest_room2_mode = session_room2_mode.createQueue("ROOM2_MODE.FOO");
		        dest_room2_status = session_room2_status.createQueue("ROOM2_STATUS.FOO");
		        
		        consumer_room1_temp = session_room1_temp.createConsumer(dest_room1_temp);
		        consumer_room1_mode = session_room1_mode.createConsumer(dest_room1_mode);
		        consumer_room1_status = session_room1_status.createConsumer(dest_room1_status);
		        consumer_room2_temp = session_room2_temp.createConsumer(dest_room2_temp);
		        consumer_room2_mode = session_room2_mode.createConsumer(dest_room2_mode);
		        consumer_room2_status = session_room2_status.createConsumer(dest_room2_status);
		        
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        

	        
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_room1_temp = null,message_room1_mode = null,message_room1_status = null;
	    		Message message_room2_temp = null,message_room2_mode = null,message_room2_status = null;
	    	
				try {
					message_room1_temp  = consumer_room1_temp.receive(1000);
					message_room1_status  = consumer_room1_status.receive(1000);
					message_room1_mode  = consumer_room1_mode.receive(1000);
					message_room2_temp  = consumer_room2_temp.receive(1000);
					message_room2_status  = consumer_room2_status.receive(1000);
					message_room2_mode  = consumer_room2_mode.receive(1000);
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_room1_temp == null || message_room1_mode ==  null || message_room1_status ==  null ||
	    			message_room2_temp == null || message_room2_mode ==  null || message_room2_status ==  null 	
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_room1_temp instanceof TextMessage || message_room1_status instanceof TextMessage) {
			    		TextMessage textMessage_room1_temp = (TextMessage) message_room1_temp;
			    		TextMessage textMessage_room1_status= (TextMessage) message_room1_status;
			    		TextMessage textMessage_room1_mode = (TextMessage) message_room1_mode;
			    		TextMessage textMessage_room2_temp = (TextMessage) message_room2_temp;
			    		TextMessage textMessage_room2_status= (TextMessage) message_room2_status;
			    		TextMessage textMessage_room2_mode = (TextMessage) message_room2_mode;
			    		
						try {
							text_room1_temp = textMessage_room1_temp.getText();
							text_room1_mode = textMessage_room1_mode.getText();
							text_room1_status = textMessage_room1_status.getText();
							text_room2_temp = textMessage_room2_temp.getText();
							text_room2_mode = textMessage_room2_mode.getText();
							text_room2_status = textMessage_room2_status.getText();
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						ChangeColorWhite(display,room2_mode);
						ChangeColorWhite(display,room2_temp);
						ChangeColorWhite(display,room2_status);
						
						
						//************for time measurement-In Queue Time
						long stopTimeRoom1Temp = System.currentTimeMillis();	
						difTimeRoom1Temp=stopTimeRoom1Temp-Long.valueOf(text_room1_temp);
						
						if(difTimeRoom1Temp>maxDifTimeRoom1Temp){
							maxDifTimeRoom1Temp=difTimeRoom1Temp;
						}
						totalRoom1Temp=difTimeRoom1Temp+totalRoom1Temp;
						counterWm_temp++;
						
						//************for time measurement-In Queue Time
						long startTimeProcess = System.currentTimeMillis();	
						//**Processing Part
						
						string_ref_temp=String.valueOf(text_room2_temp);
						string_ref_mode=text_room2_mode;
						string_ref_status=text_room2_status;
					
						//lblInfo.setText(""+string_ref_temp);
						//UpdateInfo(display,lblInfo,"Incoming Data!");
						
						if(Integer.valueOf(text_room2_temp)>35){
							UpdateInfo(display,lblInfo,"Warning Room2 Temp Exceed 35 Celcius");
							ChangeColorRed(display,room2_mode);
							ChangeColorRed(display,room2_temp);
							ChangeColorRed(display,room2_status);
							SendCommand("HS","Room2","Mode","Safe");
							UpdateInfo(display,lblInfo,"Sending Command to HS: Room2 Mode Safe");
							
							long stopTimeProcess = System.currentTimeMillis();	
							processTimeHeat=stopTimeProcess-startTimeProcess;
							
							counter_ref_temp++;
							if(counter_ref_temp>3){
								counter_ref_temp=0;
								SendCommand("HS","Room2","Status","Off");
								ChangeColorRed(display,room2_mode);
								ChangeColorRed(display,room2_temp);
								ChangeColorRed(display,room2_status);
								UpdateInfo(display,lblInfo,"Sending Command to HS: Room2 Status Off");
							}
						}
						if(Integer.valueOf(text_room2_temp)==0){
							ChangeColorRed(display,room2_mode);
							ChangeColorRed(display,room2_temp);
							ChangeColorRed(display,room2_status);
						}
						//**Processing Part
						
			    		//System.out.println("Received1: " + text);
			    		doUpdate(display,room1_temp,String.valueOf(totalRoom1Temp)); // time measurement
			    		//doUpdate(display,room1_temp,text_room1_temp);
			    		//doUpdate(display,room1_mode,text_room2_mode);
			    		doUpdate(display,room1_mode,String.valueOf(processTimeHeat)); // process time measurement
			    		doUpdate(display,room1_status,String.valueOf(counterWm_temp));
			    		//doUpdate(display,room1_status,String.valueOf(maxDifTimeRoom1Temp));
			    		//doUpdate(display,room1_status,text_room1_status);
			    		doUpdate(display,room2_temp,text_room2_temp);
			    		doUpdate(display,room2_mode,text_room2_mode);
			    		doUpdate(display,room2_status,String.valueOf(maxDifTimeRoom1Temp));
			    		//doUpdate(display,room2_status,text_room2_status);
			    		
			    		
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
