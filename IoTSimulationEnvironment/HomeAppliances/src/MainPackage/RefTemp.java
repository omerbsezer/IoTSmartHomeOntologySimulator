package MainPackage;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RefTemp extends HAMainScreen  implements Runnable {
	
	public  Destination dest_ref_temp,dest_ref_mode,dest_ref_status,dest_ref_electric;
	public  Destination dest_wm_temp,dest_wm_mode,dest_wm_status,dest_wm_electric;
	public  Destination dest_dw_temp,dest_dw_mode,dest_dw_status,dest_dw_electric;
	public  Destination dest_tv_temp,dest_tv_mode,dest_tv_status,dest_tv_electric;
	public  Destination dest_om_temp,dest_om_mode,dest_om_status,dest_om_electric;
	public  Destination dest_comp_temp,dest_comp_mode,dest_comp_status,dest_comp_electric;
	
	public  MessageProducer producer_ref_temp,producer_ref_mode,producer_ref_status,producer_ref_electric;
	public  MessageProducer producer_wm_temp,producer_wm_mode,producer_wm_status,producer_wm_electric;
	public  MessageProducer producer_dw_temp,producer_dw_mode,producer_dw_status,producer_dw_electric;
	public  MessageProducer producer_tv_temp,producer_tv_mode,producer_tv_status,producer_tv_electric;
	public  MessageProducer producer_om_temp,producer_om_mode,producer_om_status,producer_om_electric;
	public  MessageProducer producer_comp_temp,producer_comp_mode,producer_comp_status,producer_comp_electric;
	
	
	public  String user=null,password=null,host=null,text = null;
	public int port;
	public Session session_ref_temp,session_ref_mode,session_ref_status,session_ref_electric;
	public Session session_wm_temp,session_wm_mode,session_wm_status,session_wm_electric;
	public Session session_dw_temp,session_dw_mode,session_dw_status,session_dw_electric;
	public Session session_tv_temp,session_tv_mode,session_tv_status,session_tv_electric;
	public Session session_om_temp,session_om_mode,session_om_status,session_om_electric;
	public Session session_comp_temp,session_comp_mode,session_comp_status,session_comp_electric;
 	

	@Override
	public void run() {
		//while (isRunning) {
		// TODO Auto-generated method stub
		String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "password");
        String host = env("ACTIVEMQ_HOST", "localhost");
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
        
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);

        Connection connection = null;
		try {
			connection = factory.createConnection(user, password);
			connection.start();
	        session_ref_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_ref_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_ref_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_ref_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_wm_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_wm_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_wm_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_wm_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_dw_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_dw_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_dw_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_dw_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_tv_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_tv_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_tv_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_tv_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_om_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_om_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_om_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_om_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_comp_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_comp_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_comp_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_comp_electric = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        
	        
	        dest_ref_temp = session_ref_temp.createQueue("REF_TEMP.FOO");
	        dest_ref_mode = session_ref_mode.createQueue("REF_MODE.FOO");
	        dest_ref_status = session_ref_status.createQueue("REF_STATUS.FOO");
	        dest_ref_electric = session_ref_electric.createQueue("REF_ELECTRIC.FOO"); 
	        dest_wm_temp = session_wm_temp.createQueue("WM_TEMP.FOO");
	        dest_wm_mode = session_wm_mode.createQueue("WM_MODE.FOO");
	        dest_wm_status = session_wm_status.createQueue("WM_STATUS.FOO");
	        dest_wm_electric = session_wm_electric.createQueue("WM_ELECTRIC.FOO");
	        dest_dw_temp = session_dw_temp.createQueue("DW_TEMP.FOO");
	        dest_dw_mode = session_dw_mode.createQueue("DW_MODE.FOO");
	        dest_dw_status = session_dw_status.createQueue("DW_STATUS.FOO");
	        dest_dw_electric = session_dw_electric.createQueue("DW_ELECTRIC.FOO"); 
	        dest_tv_temp = session_tv_temp.createQueue("TV_TEMP.FOO");
	        dest_tv_mode = session_tv_mode.createQueue("TV_MODE.FOO");
	        dest_tv_status = session_tv_status.createQueue("TV_STATUS.FOO");
	        dest_tv_electric = session_tv_electric.createQueue("TV_ELECTRIC.FOO");
	        dest_om_temp = session_om_temp.createQueue("OM_TEMP.FOO");
	        dest_om_mode = session_om_mode.createQueue("OM_MODE.FOO");
	        dest_om_status = session_om_status.createQueue("OM_STATUS.FOO");
	        dest_om_electric = session_om_electric.createQueue("OM_ELECTRIC.FOO"); 
	        dest_comp_temp = session_comp_temp.createQueue("COMP_TEMP.FOO");
	        dest_comp_mode = session_comp_mode.createQueue("COMP_MODE.FOO");
	        dest_comp_status = session_comp_status.createQueue("COMP_STATUS.FOO");
	        dest_comp_electric = session_comp_electric.createQueue("COMP_ELECTRIC.FOO");
	        
	        producer_ref_temp = session_ref_temp.createProducer(dest_ref_temp);
	        producer_ref_mode = session_ref_mode.createProducer(dest_ref_mode);
	        producer_ref_status = session_ref_status.createProducer(dest_ref_status);
	        producer_ref_electric = session_ref_electric.createProducer(dest_ref_electric);
	        producer_wm_temp = session_wm_temp.createProducer(dest_wm_temp);
	        producer_wm_mode = session_wm_mode.createProducer(dest_wm_mode);
	        producer_wm_status = session_wm_status.createProducer(dest_wm_status);
	        producer_wm_electric = session_wm_electric.createProducer(dest_wm_electric);
	        producer_dw_temp = session_dw_temp.createProducer(dest_dw_temp);
	        producer_dw_mode = session_dw_mode.createProducer(dest_dw_mode);
	        producer_dw_status = session_dw_status.createProducer(dest_dw_status);
	        producer_dw_electric = session_dw_electric.createProducer(dest_dw_electric);
	        producer_tv_temp = session_tv_temp.createProducer(dest_tv_temp);
	        producer_tv_mode = session_tv_mode.createProducer(dest_tv_mode);
	        producer_tv_status = session_tv_status.createProducer(dest_tv_status);
	        producer_tv_electric = session_tv_electric.createProducer(dest_tv_electric);
	        producer_om_temp = session_om_temp.createProducer(dest_om_temp);
	        producer_om_mode = session_om_mode.createProducer(dest_om_mode);
	        producer_om_status = session_om_status.createProducer(dest_om_status);
	        producer_om_electric = session_om_electric.createProducer(dest_om_electric);
	        producer_comp_temp = session_comp_temp.createProducer(dest_comp_temp);
	        producer_comp_mode = session_comp_mode.createProducer(dest_comp_mode);
	        producer_comp_status = session_comp_status.createProducer(dest_comp_status);
	        producer_comp_electric = session_comp_electric.createProducer(dest_comp_electric);
	        
	        
	        
	        
	        producer_ref_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_ref_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_ref_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_ref_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_wm_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_wm_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_wm_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_wm_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_dw_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_dw_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_dw_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_dw_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_tv_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_tv_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_tv_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_tv_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_om_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_om_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_om_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_om_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_comp_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_comp_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_comp_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_comp_electric.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //Destination dest = new ActiveMQTopic(destination);
       

    	// Create a messages
		HomeAppliances newHomeAppliances=new HomeAppliances();
        while(true){
        	
        	if(isScenario=="false"){ 
        		newHomeAppliances.SetSonsors();
           	} 
        	else{
        		newHomeAppliances.Scenario();
        			// newHomeAppliances.DosyadanOku();
        			
        	}
        	
        	
        	
        	String text_ref_temp = string_ref_temp;
        	String text_ref_mode = string_ref_mode;
        	String text_ref_status = string_ref_status;
        	String text_ref_electric = string_ref_electric;
        	String text_wm_temp = string_wm_temp;
        	String text_wm_mode = string_wm_mode;
        	String text_wm_status = string_wm_status;
        	String text_wm_electric = string_wm_electric;
        	String text_dw_temp = string_dw_temp;
        	String text_dw_mode = string_dw_mode ;
        	String text_dw_status = string_dw_status;
        	String text_dw_electric = string_dw_status;
        	String text_tv_temp = string_tv_temp;
        	String text_tv_mode = string_tv_mode;
        	String text_tv_status = string_tv_status;
        	String text_tv_electric = string_tv_electric;
        	String text_om_temp = string_om_temp;
        	String text_om_mode = string_om_mode;
        	String text_om_status = string_om_status;
        	String text_om_electric = string_om_electric;
        	String text_comp_temp = string_comp_temp;
        	String text_comp_mode = string_comp_temp;
        	String text_comp_status = string_comp_status;
        	String text_comp_electric = string_comp_electric;
        	
        	if(isRunning=="false"){ 
        		i=0;
        		break;
        	 
        	} 
        	
        //for(int k=0;k<100;k++){
        	/*String text_ref_temp = "ref_t "+Integer.toString(k);
        	String text_ref_mode = "ref_m "+Integer.toString(k/2);
        	String text_ref_status = "ref_s "+Integer.toString(k); //((k % 2) ?"ON":"OFF");
        	String text_ref_electric = "ref_e "+Integer.toString(k/3);
        	String text_wm_temp = "wm_t "+Integer.toString(k);
        	String text_wm_mode = "wm_m "+Integer.toString(k/2);
        	String text_wm_status = "wm_s "+Integer.toString(k-1);
        	String text_wm_electric = "wm_e "+Integer.toString(k/3);
        	String text_dw_temp = "dw_t "+Integer.toString(k);
        	String text_dw_mode = "dw_m "+Integer.toString(k/2);
        	String text_dw_status = "dw_s "+Integer.toString(k); //((k % 2) ?"ON":"OFF");
        	String text_dw_electric = "dw_e "+Integer.toString(k/3);
        	String text_tv_temp = "tv_t "+Integer.toString(k);
        	String text_tv_mode = "tv_m "+Integer.toString(k/2);
        	String text_tv_status = "tv_s "+Integer.toString(k-1);
        	String text_tv_electric = "tv_e "+Integer.toString(k/3);
        	String text_om_temp = "om_t "+Integer.toString(k);
        	String text_om_mode = "om_m "+Integer.toString(k/2);
        	String text_om_status = "om_s "+Integer.toString(k); //((k % 2) ?"ON":"OFF");
        	String text_om_electric = "om_e "+Integer.toString(k/3);
        	String text_comp_temp = "comp_t "+Integer.toString(k);
        	String text_comp_mode = "comp_m "+Integer.toString(k/2);
        	String text_comp_status = "comp_s "+Integer.toString(k-1);
        	String text_comp_electric = "comp_e "+Integer.toString(k/3);*/
        	
        	TextMessage message_ref_temp,message_ref_mode,message_ref_status,message_ref_electric;
        	TextMessage message_wm_temp,message_wm_mode,message_wm_status,message_wm_electric;
        	TextMessage message_dw_temp,message_dw_mode,message_dw_status,message_dw_electric;
        	TextMessage message_tv_temp,message_tv_mode,message_tv_status,message_tv_electric;
        	TextMessage message_om_temp,message_om_mode,message_om_status,message_om_electric;
        	TextMessage message_comp_temp,message_comp_mode,message_comp_status,message_comp_electric;
			
        	try {
        		message_ref_temp = session_ref_temp.createTextMessage(text_ref_temp);
        		message_ref_mode = session_ref_mode.createTextMessage(text_ref_mode);
        		message_ref_status = session_ref_status.createTextMessage(text_ref_status);
        		message_ref_electric = session_ref_electric.createTextMessage(text_ref_electric);
        		message_wm_temp = session_wm_temp.createTextMessage(text_wm_temp);
        		message_wm_mode = session_wm_mode.createTextMessage(text_wm_mode);
        		message_wm_status = session_wm_status.createTextMessage(text_wm_status);
        		message_wm_electric = session_wm_electric.createTextMessage(text_wm_electric);
        		message_dw_temp = session_dw_temp.createTextMessage(text_dw_temp);
        		message_dw_mode = session_dw_mode.createTextMessage(text_dw_mode);
        		message_dw_status = session_dw_status.createTextMessage(text_dw_status);
        		message_dw_electric = session_dw_electric.createTextMessage(text_dw_electric);
        		message_tv_temp = session_tv_temp.createTextMessage(text_tv_temp);
        		message_tv_mode = session_tv_mode.createTextMessage(text_tv_mode);
        		message_tv_status = session_tv_status.createTextMessage(text_tv_status);
        		message_tv_electric = session_tv_electric.createTextMessage(text_tv_electric);
        		message_om_temp = session_om_temp.createTextMessage(text_om_temp);
        		message_om_mode = session_om_mode.createTextMessage(text_om_mode);
        		message_om_status = session_om_status.createTextMessage(text_om_status);
        		message_om_electric = session_om_electric.createTextMessage(text_om_electric);
        		message_comp_temp = session_comp_temp.createTextMessage(text_comp_temp);
        		message_comp_mode = session_comp_mode.createTextMessage(text_comp_mode);
        		message_comp_status = session_comp_status.createTextMessage(text_comp_status);
        		message_comp_electric = session_comp_electric.createTextMessage(text_comp_electric);
        		
				producer_ref_temp.send(message_ref_temp);
				producer_ref_mode.send(message_ref_mode);
				producer_ref_status.send(message_ref_status);
				producer_ref_electric.send(message_ref_electric);
				producer_wm_temp.send(message_wm_temp);
				producer_wm_mode.send(message_wm_mode);
				producer_wm_status.send(message_wm_status);
				producer_wm_electric.send(message_wm_electric);
				producer_dw_temp.send(message_dw_temp);
				producer_dw_mode.send(message_dw_mode);
				producer_dw_status.send(message_dw_status);
				producer_dw_electric.send(message_dw_electric);
				producer_tv_temp.send(message_tv_temp);
				producer_tv_mode.send(message_tv_mode);
				producer_tv_status.send(message_tv_status);
				producer_tv_electric.send(message_tv_electric);
				producer_om_temp.send(message_om_temp);
				producer_om_mode.send(message_om_mode);
				producer_om_status.send(message_om_status);
				producer_om_electric.send(message_om_electric);
				producer_comp_temp.send(message_comp_temp);
				producer_comp_mode.send(message_comp_mode);
				producer_comp_status.send(message_comp_status);
				producer_comp_electric.send(message_comp_electric);
				
	            //System.out.println("Send1: " + text);
	            doUpdate(display,ref_temp,text_ref_temp);
	            doUpdate(display,ref_mode,text_ref_mode);
	            doUpdate(display,ref_status,text_ref_status);
	            doUpdate(display,ref_electric,text_ref_electric);
	            doUpdate(display,wm_temp,text_wm_temp);
	            doUpdate(display,wm_mode,text_wm_mode);
	            doUpdate(display,wm_status,text_wm_status);
	            doUpdate(display,wm_electric,text_wm_electric);
	            doUpdate(display,dw_temp,text_dw_temp);
	            doUpdate(display,dw_mode,text_dw_mode);
	            doUpdate(display,dw_status,text_dw_status);
	            doUpdate(display,dw_electric,text_dw_electric);
	            doUpdate(display,tv_temp,text_tv_temp);
	            doUpdate(display,tv_mode,text_tv_mode);
	            doUpdate(display,tv_status,text_tv_status);
	            doUpdate(display,tv_electric,text_tv_electric);
	            doUpdate(display,om_temp,text_om_temp);
	            doUpdate(display,om_mode,text_om_mode);
	            doUpdate(display,om_status,text_om_status);
	            doUpdate(display,om_electric,text_om_electric);
	            doUpdate(display,comp_temp,text_comp_temp);
	            doUpdate(display,comp_mode,text_comp_mode);
	            doUpdate(display,comp_status,text_comp_status);
	            doUpdate(display,comp_electric,text_comp_electric);
	            
	            try {
	            	 Random r=new Random(); //Gaussian Distro
	            	 double val = r.nextGaussian() * 10 + 50;
	            	 int delay = (int) Math.round(val);
	            	 //System.out.println("delay: " +delay);
			         Thread.sleep(delay);
			        } catch(InterruptedException e) {
			        }
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            
			
        //}
        
        //producer.send(session.createTextMessage("SHUTDOWN"));
        /*try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}
        
        	
	}
	private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

   
    
    

}
