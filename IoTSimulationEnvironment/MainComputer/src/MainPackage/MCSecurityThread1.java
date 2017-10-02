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

public class MCSecurityThread1 extends MyMainScreen  implements Runnable {

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
		       
				session_room1_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room1_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room2_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room2_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room3_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room3_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room4_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			    session_room4_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
			    dest_room1_sstatus = session_room1_sstatus.createQueue("ROOM1_SSTATUS.FOO");
		        dest_room1_smode = session_room1_smode.createQueue("ROOM1_SMODE.FOO");
		        dest_room2_sstatus = session_room2_sstatus.createQueue("ROOM2_SSTATUS.FOO");
		        dest_room2_smode = session_room2_smode.createQueue("ROOM2_SMODE.FOO");
		        dest_room3_sstatus = session_room3_sstatus.createQueue("ROOM3_SSTATUS.FOO");
		        dest_room3_smode = session_room3_smode.createQueue("ROOM3_SMODE.FOO");
		        dest_room4_sstatus = session_room4_sstatus.createQueue("ROOM4_SSTATUS.FOO");
		        dest_room4_smode = session_room4_smode.createQueue("ROOM4_SMODE.FOO");
		       
		        
		        
		        consumer_room1_sstatus = session_room1_sstatus.createConsumer(dest_room1_sstatus);
		        consumer_room1_smode = session_room1_smode.createConsumer(dest_room1_smode);
		        consumer_room2_sstatus = session_room2_sstatus.createConsumer(dest_room2_sstatus);
		        consumer_room2_smode = session_room2_smode.createConsumer(dest_room2_smode);
		        consumer_room3_sstatus = session_room3_sstatus.createConsumer(dest_room3_sstatus);
		        consumer_room3_smode = session_room3_smode.createConsumer(dest_room3_smode);
		        consumer_room4_sstatus = session_room4_sstatus.createConsumer(dest_room4_sstatus);
		        consumer_room4_smode = session_room4_smode.createConsumer(dest_room4_smode);
		        
		       
		       
		       
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	    
	        off_command_send=0;
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_room1_sstatus = null,message_room1_smode = null;
	    		Message message_room2_sstatus = null,message_room2_smode = null;
	    		Message message_room3_sstatus = null,message_room3_smode = null;
	    		Message message_room4_sstatus = null,message_room4_smode = null;
	    		
				try {
					message_room1_sstatus  = consumer_room1_sstatus.receive(1000);
					message_room1_smode  = consumer_room1_smode.receive(1000);
					message_room2_sstatus  = consumer_room2_sstatus.receive(1000);
					message_room2_smode  = consumer_room2_smode.receive(1000);
					message_room3_sstatus  = consumer_room3_sstatus.receive(1000);
					message_room3_smode  = consumer_room3_smode.receive(1000);
					message_room4_sstatus  = consumer_room4_sstatus.receive(1000);
					message_room4_smode  = consumer_room4_smode.receive(1000);
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_room1_sstatus == null || message_room1_smode ==  null ||
	    			message_room2_sstatus == null || message_room2_smode ==  null ||
	    			message_room3_sstatus == null || message_room3_smode ==  null ||
	    			message_room4_sstatus == null || message_room4_smode ==  null 
	    				){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_room1_sstatus instanceof TextMessage || message_room1_smode instanceof TextMessage) {
			    		TextMessage textMessage_room1_sstatus = (TextMessage) message_room1_sstatus;
			    		TextMessage textMessage_room1_smode= (TextMessage) message_room1_smode;
			    		TextMessage textMessage_room2_sstatus = (TextMessage) message_room2_sstatus;
			    		TextMessage textMessage_room2_smode= (TextMessage) message_room2_smode;
			    		TextMessage textMessage_room3_sstatus = (TextMessage) message_room3_sstatus;
			    		TextMessage textMessage_room3_smode= (TextMessage) message_room3_smode;
			    		TextMessage textMessage_room4_sstatus = (TextMessage) message_room4_sstatus;
			    		TextMessage textMessage_room4_smode= (TextMessage) message_room4_smode;
			    		
						try {
							text_room1_sstatus = textMessage_room1_sstatus.getText();
							text_room1_smode = textMessage_room1_smode.getText();
							text_room2_sstatus = textMessage_room2_sstatus.getText();
							text_room2_smode = textMessage_room2_smode.getText();
							text_room3_sstatus = textMessage_room3_sstatus.getText();
							text_room3_smode = textMessage_room3_smode.getText();
							text_room4_sstatus = textMessage_room4_sstatus.getText();
							text_room4_smode = textMessage_room4_smode.getText();
							
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//************for time measurement-In Queue Time
						long stopTimeRoom2Sstatus = System.currentTimeMillis();	
						difTimeRoom2Sstatus=stopTimeRoom2Sstatus-Long.valueOf(text_room2_sstatus);
						totalRoom2Sstatus=difTimeRoom2Sstatus+totalRoom2Sstatus;
						
						//************for time measurement-In Queue Time
						
						long startTimeProcessS = System.currentTimeMillis();	
						//**Processing Part
						
						if(text_room1_sstatus.equalsIgnoreCase("On.")){
							off_command_send=0;
						}
						if(text_room1_sstatus.equalsIgnoreCase("Motion") && off_command_send==0 ){
							UpdateInfo(display,lblInfo,"Warning Motion Detected!");
							ChangeColorRed(display,room1_sstatus);
							ChangeColorRed(display,room1_smode);
							ChangeColorRed(display,room2_sstatus);
							ChangeColorRed(display,room2_smode);
							ChangeColorRed(display,room3_sstatus);
							ChangeColorRed(display,room3_smode);
							ChangeColorRed(display,room4_sstatus);
							ChangeColorRed(display,room4_smode);
							ChangeColorRed(display,kitchen_sstatus);
							ChangeColorRed(display,kitchen_smode);
							ChangeColorRed(display,hall_sstatus);
							ChangeColorRed(display,hall_smode);
							ChangeColorRed(display,bathroom_sstatus);
							ChangeColorRed(display,bathroom_smode);

							SendCommand("SS","All","Alarm","On");
							UpdateInfo(display,lblInfo,"Sending Command to SS: All Alarm On");
							
							long stopTimeProcessS = System.currentTimeMillis();	//time measurement
						    processTimeSecurity=stopTimeProcessS-startTimeProcessS;
							
							counter_ref_temp++;
							ls_command_send=1;
						}
						if(counter_ref_temp>10 && ls_command_send==1){
								counter_ref_temp=0;
								off_command_send=1;
								SendCommand("SS","All","Alarm","Off");
								ChangeColorWhite(display,room1_sstatus);
								ChangeColorWhite(display,room1_smode);
								ChangeColorWhite(display,room2_sstatus);
								ChangeColorWhite(display,room2_smode);
								ChangeColorWhite(display,room3_sstatus);
								ChangeColorWhite(display,room3_smode);
								ChangeColorWhite(display,room4_sstatus);
								ChangeColorWhite(display,room4_smode);
								ChangeColorWhite(display,kitchen_sstatus);
								ChangeColorWhite(display,kitchen_smode);
								ChangeColorWhite(display,hall_sstatus);
								ChangeColorWhite(display,hall_smode);
								ChangeColorWhite(display,bathroom_sstatus);
								ChangeColorWhite(display,bathroom_smode);
								UpdateInfo(display,lblInfo,"Sending Command to SS: All Alarm Off");
						}
						
						
			    		doUpdate(display,room1_sstatus,text_room1_sstatus);
			    		doUpdate(display,room1_smode,text_room1_smode);
			    		doUpdate(display,room2_sstatus,String.valueOf(totalRoom2Sstatus)); // time measurement
			    		doUpdate(display,room2_smode,String.valueOf(processTimeSecurity)); // time measurement
			    		//doUpdate(display,room2_sstatus,text_room2_sstatus);
			    		//doUpdate(display,room2_smode,text_room2_smode);
			    		doUpdate(display,room3_sstatus,text_room3_sstatus);
			    		doUpdate(display,room3_smode,text_room3_smode);
			    		doUpdate(display,room4_sstatus,text_room4_sstatus);
			    		doUpdate(display,room4_smode,text_room4_smode);
			    		
			    		
			    		
			    		
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
