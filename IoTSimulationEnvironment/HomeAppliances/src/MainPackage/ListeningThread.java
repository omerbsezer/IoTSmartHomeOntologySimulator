package MainPackage;

import java.util.StringTokenizer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.eclipse.swt.widgets.Display;

public class ListeningThread extends HAMainScreen  implements Runnable {

	public  Destination dest_mc_ha;
	
	
	public  MessageConsumer consumer_mc_ha;
	
	
	public  String user=null,password=null,host=null;
	public  String text_mc_ha = null;
	public int port;
	public Session session_mc_ha;
	
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
	       
	        session_mc_ha = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	        dest_mc_ha = session_mc_ha.createQueue("MC_HA.FOO");

	        consumer_mc_ha = session_mc_ha.createConsumer(dest_mc_ha);
	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

        System.out.println("Waiting for messages...");
        
    	while (true) {
    		// Wait for a message
    		Message message_mc_ha = null;
    		
			try {
				message_mc_ha  = consumer_mc_ha.receive(1000);
				
				
				
				
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 
    		if (message_mc_ha == null ){
    			continue;
    		}
    		
    		 
    		if (message_mc_ha instanceof TextMessage ) {
		    		TextMessage textMessage_mc_ha = (TextMessage) message_mc_ha;
		    		
		    		
					try {
						text_mc_ha = textMessage_mc_ha.getText();
						
						
						
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		
					
					st = new StringTokenizer(text_mc_ha, " ");
					module=st.nextToken();
				    command=st.nextToken();
				    parameter=st.nextToken();
				    //total="Module: "+module+" Com: "+command+" Param: "+parameter;
					//lblInfo.setText(""+string_ref_temp);
				    UpdateInfo(display,lblInfo,"Incoming Message: "+module+" "+command+" "+" "+parameter);
					
					
		    		
		    		
		    		
    			} else {
    			
    			
    			
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
