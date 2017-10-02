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

public class Thread1 extends MyMainScreen  implements Runnable {

		public  Destination dest_ref_temp,dest_ref_mode,dest_ref_status,dest_ref_electric;
		public  Destination dest_wm_temp,dest_wm_mode,dest_wm_status,dest_wm_electric;
		public  Destination dest_dw_temp,dest_dw_mode,dest_dw_status,dest_dw_electric;
		public  Destination dest_tv_temp,dest_tv_mode,dest_tv_status,dest_tv_electric;
		public  Destination dest_om_temp,dest_om_mode,dest_om_status,dest_om_electric;
		public  Destination dest_comp_temp,dest_comp_mode,dest_comp_status,dest_comp_electric;
		
		public  MessageConsumer consumer_ref_temp,consumer_ref_mode,consumer_ref_status,consumer_ref_electric;
		public  MessageConsumer consumer_wm_temp,consumer_wm_mode,consumer_wm_status,consumer_wm_electric;
		public  MessageConsumer consumer_dw_temp,consumer_dw_mode,consumer_dw_status,consumer_dw_electric;
		public  MessageConsumer consumer_tv_temp,consumer_tv_mode,consumer_tv_status,consumer_tv_electric;
		public  MessageConsumer consumer_om_temp,consumer_om_mode,consumer_om_status,consumer_om_electric;
		public  MessageConsumer consumer_comp_temp,consumer_comp_mode,consumer_comp_status,consumer_comp_electric;
		
		
		public  String user=null,password=null,host=null;
		public  String text_ref_temp = null,text_ref_mode = null,text_ref_status = null,text_ref_electric = null;
		public  String text_wm_temp = null,text_wm_mode = null,text_wm_status = null,text_wm_electric = null;
		public  String text_dw_temp = null,text_dw_mode = null,text_dw_status = null,text_dw_electric = null;
		public  String text_tv_temp = null,text_tv_mode = null,text_tv_status = null,text_tv_electric = null;
		public  String text_om_temp = null,text_om_mode = null,text_om_status = null,text_om_electric = null;
		public  String text_comp_temp = null,text_comp_mode = null,text_comp_status = null,text_comp_electric = null;
		public int port;
		public Session session_ref_temp,session_ref_mode,session_ref_status,session_ref_electric;
		public Session session_wm_temp,session_wm_mode,session_wm_status,session_wm_electric;
		public Session session_dw_temp,session_dw_mode,session_dw_status,session_dw_electric;
		public Session session_tv_temp,session_tv_mode,session_tv_status,session_tv_electric;
		public Session session_om_temp,session_om_mode,session_om_status,session_om_electric;
		public Session session_comp_temp,session_comp_mode,session_comp_status,session_comp_electric;
		
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
		       
		        session_ref_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_ref_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_ref_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_ref_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		      
		        
		        //Destination dest = new ActiveMQTopic(destination);
		        dest_ref_temp = session_ref_temp.createQueue("REF_TEMP.FOO");
		        dest_ref_mode = session_ref_mode.createQueue("REF_MODE.FOO");
		        dest_ref_status = session_ref_status.createQueue("REF_STATUS.FOO");
		        dest_ref_electric = session_ref_electric.createQueue("REF_ELECTRIC.FOO"); 
		       
		        
		        
		        
		        consumer_ref_temp = session_ref_temp.createConsumer(dest_ref_temp);
		        consumer_ref_mode = session_ref_mode.createConsumer(dest_ref_mode);
		        consumer_ref_status = session_ref_status.createConsumer(dest_ref_status);
		        consumer_ref_electric = session_ref_electric.createConsumer(dest_ref_electric);
		       
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	
	        System.out.println("Waiting for messages...");
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		Message message_ref_temp = null,message_ref_mode = null,message_ref_status = null,message_ref_electric = null;
	    		
				try {
					message_ref_temp  = consumer_ref_temp.receive(1000);
					message_ref_status  = consumer_ref_status.receive(1000);
					message_ref_mode  = consumer_ref_mode.receive(1000);
					message_ref_electric  = consumer_ref_electric.receive(1000);
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		if (message_ref_temp == null || message_ref_mode ==  null || message_ref_status ==  null || message_ref_electric ==  null){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_ref_temp instanceof TextMessage || message_ref_status instanceof TextMessage) {
			    		TextMessage textMessage_ref_temp = (TextMessage) message_ref_temp;
			    		TextMessage textMessage_ref_status= (TextMessage) message_ref_status;
			    		TextMessage textMessage_ref_mode = (TextMessage) message_ref_mode;
			    		TextMessage textMessage_ref_electric= (TextMessage) message_ref_electric;
			    		
						try {
							text_ref_temp = textMessage_ref_temp.getText();
							text_ref_mode = textMessage_ref_mode.getText();
							text_ref_status = textMessage_ref_status.getText();
							text_ref_electric = textMessage_ref_electric.getText();
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		//System.out.println("Received1: " + text);
						ChangeColorWhite(display,ref_mode);
						ChangeColorWhite(display,ref_temp);
						ChangeColorWhite(display,ref_electric);
						ChangeColorWhite(display,ref_status);
						
						
						string_ref_temp=String.valueOf(text_ref_temp);
						string_ref_mode=text_ref_mode;
						string_ref_status=text_ref_status;
						string_ref_electric=text_ref_electric;
						//lblInfo.setText(""+string_ref_temp);
						//UpdateInfo(display,lblInfo,"Incoming Data!");
						
						long startTimeProcess = System.currentTimeMillis(); //time measurement
						//**Processing Part
						if(Integer.valueOf(text_ref_temp)>40){
							UpdateInfo(display,lblInfo,"Warning Ref Temp Exceed 40 Celcius");
							ChangeColorRed(display,ref_mode);
							ChangeColorRed(display,ref_temp);
							ChangeColorRed(display,ref_electric);
							ChangeColorRed(display,ref_status);
							SendCommand("HA","Ref","Mode","Safe");
							UpdateInfo(display,lblInfo,"Sending Command to HA: Ref Mode Safe");
							
							long stopTimeProcess = System.currentTimeMillis();	 //time measurement
							processTimeRef=stopTimeProcess-startTimeProcess;  //time measurement
							
							counter_ref_temp++;
							if(counter_ref_temp>3){
								counter_ref_temp=0;
								SendCommand("HA","Ref","Status","Off");
								ChangeColorRed(display,ref_mode);
								ChangeColorRed(display,ref_temp);
								ChangeColorRed(display,ref_electric);
								ChangeColorRed(display,ref_status);
								UpdateInfo(display,lblInfo,"Sending Command to HA: Ref Status Off");
							}
						}
						if(Integer.valueOf(text_ref_temp)==0){
							ChangeColorRed(display,ref_mode);
							ChangeColorRed(display,ref_temp);
							ChangeColorRed(display,ref_electric);
							ChangeColorRed(display,ref_status);
						}
						//**Processing Part
			    		doUpdate(display,ref_temp,text_ref_temp);
			    		doUpdate(display,ref_mode,text_ref_mode);
			    		doUpdate(display,ref_status,text_ref_status);
			    		
			    		doUpdate(display,ref_electric,String.valueOf(processTimeRef)); // time measurement
			    		//doUpdate(display,ref_electric,text_ref_electric);
			    		
			    		
			    		
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
