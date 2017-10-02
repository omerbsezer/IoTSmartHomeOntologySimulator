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

public class Thread3 extends MyMainScreen  implements Runnable {

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
		       
		       
		        session_dw_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_dw_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_dw_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        session_dw_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        
		        
		        //Destination dest = new ActiveMQTopic(destination);
		       
		        dest_dw_temp = session_dw_temp.createQueue("DW_TEMP.FOO");
		        dest_dw_mode = session_dw_mode.createQueue("DW_MODE.FOO");
		        dest_dw_status = session_dw_status.createQueue("DW_STATUS.FOO");
		        dest_dw_electric = session_dw_electric.createQueue("DW_ELECTRIC.FOO"); 
		        
		        
		        
		        
		      
		        consumer_dw_temp = session_dw_temp.createConsumer(dest_dw_temp);
		        consumer_dw_mode = session_dw_mode.createConsumer(dest_dw_mode);
		        consumer_dw_status = session_dw_status.createConsumer(dest_dw_status);
		        consumer_dw_electric = session_dw_electric.createConsumer(dest_dw_electric);
		       
		        
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        

	        System.out.println("Waiting for messages...");
	        
	    	while (true) {
	    		// Wait for a message
	    		
	    		
	    		Message message_dw_temp = null,message_dw_mode = null,message_dw_status = null,message_dw_electric = null;
	    		
				try {
					
					message_dw_temp  = consumer_dw_temp.receive(1000);
					message_dw_status  = consumer_dw_status.receive(1000);
					message_dw_mode  = consumer_dw_mode.receive(1000);
					message_dw_electric  = consumer_dw_electric.receive(1000);
					
					
					
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
	    		
	    		if (message_dw_temp == null || message_dw_mode ==  null || message_dw_status ==  null || message_dw_electric ==  null){
	    			continue;
	    		}
	    		
	    		 
	    		if (message_dw_temp instanceof TextMessage || message_dw_status instanceof TextMessage) {
			    		
			    		TextMessage textMessage_dw_temp = (TextMessage) message_dw_temp;
			    		TextMessage textMessage_dw_status= (TextMessage) message_dw_status;
			    		TextMessage textMessage_dw_mode = (TextMessage) message_dw_mode;
			    		TextMessage textMessage_dw_electric= (TextMessage) message_dw_electric;
			    		
						try {
							
							text_dw_temp = textMessage_dw_temp.getText();
							text_dw_mode = textMessage_dw_mode.getText();
							text_dw_status = textMessage_dw_status.getText();
							text_dw_electric = textMessage_dw_electric.getText();
							
							
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		//System.out.println("Received1: " + text);
			    		
			    		doUpdate(display,dw_temp,text_dw_temp);
			    		doUpdate(display,dw_mode,text_dw_mode);
			    		doUpdate(display,dw_status,text_dw_status);
			    		doUpdate(display,dw_electric,text_dw_electric);
			    		
			    		
			    		
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
