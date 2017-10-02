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

public class ListeningThread extends SSMainScreen  implements Runnable {

	public  Destination dest_mc_ss;
	
	
	public  MessageConsumer consumer_mc_ss;
	
	
	public  String user=null,password=null,host=null;
	public  String text_mc_ss = null;
	public int port;
	public Session session_mc_ss;
	
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
	       
	        session_mc_ss = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	        dest_mc_ss = session_mc_ss.createQueue("MC_SS.FOO");

	        consumer_mc_ss = session_mc_ss.createConsumer(dest_mc_ss);
	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

        System.out.println("Waiting for messages...");
        
    	while (true) {
    		// Wait for a message
    		Message message_mc_ss = null;
    		
			try {
				message_mc_ss  = consumer_mc_ss.receive(1000);
				
				
				
				
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 
    		if (message_mc_ss == null ){
    			continue;
    		}
    		
    		 
    		if (message_mc_ss instanceof TextMessage ) {
		    		TextMessage textMessage_mc_ss = (TextMessage) message_mc_ss;
		    		
		    		
					try {
						text_mc_ss = textMessage_mc_ss.getText();
						
						
						
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		
					
					st = new StringTokenizer(text_mc_ss, " ");
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
