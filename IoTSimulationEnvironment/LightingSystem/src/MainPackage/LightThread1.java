package MainPackage;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class LightThread1 extends LSMainScreen  implements Runnable {
	
	public  Destination dest_room1_light,dest_room1_il;
	public  Destination dest_room2_light,dest_room2_il;
	public  Destination dest_room3_light,dest_room3_il;
	public  Destination dest_room4_light,dest_room4_il;
	public  Destination dest_kitchen_light,dest_kitchen_il;
	public  Destination dest_hall_light,dest_hall_il;
	public  Destination dest_bathroom_light,dest_bathroom_il;

	
	public  MessageProducer producer_room1_light,producer_room1_il;
	public  MessageProducer producer_room2_light,producer_room2_il;
	public  MessageProducer producer_room3_light,producer_room3_il;
	public  MessageProducer producer_room4_light,producer_room4_il;
	public  MessageProducer producer_kitchen_light,producer_kitchen_il;
	public  MessageProducer producer_hall_light,producer_hall_il;
	public  MessageProducer producer_bathroom_light,producer_bathroom_il;
	
	
	public  String user=null,password=null,host=null,text = null;
	public int port;
	public Session session_room1_light,session_room1_il;
	public Session session_room2_light,session_room2_il;
	public Session session_room3_light,session_room3_il;
	public Session session_room4_light,session_room4_il;
	public Session session_kitchen_light,session_kitchen_il;
	public Session session_hall_light,session_hall_il;
	public Session session_bathroom_light,session_bathroom_il;
	
 	

	@Override
	public void run() {
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
			
	        session_room1_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room1_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_light = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_il = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	       
	        
	        
	        dest_room1_light = session_room1_light.createQueue("ROOM1_LIGHT.FOO");
	        dest_room1_il = session_room1_il.createQueue("ROOM1_IL.FOO");
	        dest_room2_light = session_room2_light.createQueue("ROOM2_LIGHT.FOO");
	        dest_room2_il = session_room2_il.createQueue("ROOM2_IL.FOO");
	        dest_room3_light = session_room3_light.createQueue("ROOM3_LIGHT.FOO");
	        dest_room3_il = session_room3_il.createQueue("ROOM3_IL.FOO");
	        dest_room4_light = session_room4_light.createQueue("ROOM4_LIGHT.FOO");
	        dest_room4_il = session_room4_il.createQueue("ROOM4_IL.FOO");
	        dest_kitchen_light = session_kitchen_light.createQueue("KITCHEN_LIGHT.FOO");
	        dest_kitchen_il = session_kitchen_il.createQueue("KITCHEN_IL.FOO");
	        dest_hall_light = session_hall_light.createQueue("HALL_LIGHT.FOO");
	        dest_hall_il = session_hall_il.createQueue("HALL_IL.FOO");
	        dest_bathroom_light = session_bathroom_light.createQueue("BATHROOM_LIGHT.FOO");
	        dest_bathroom_il = session_bathroom_il.createQueue("BATHROOM_IL.FOO");
	        
	        
	        producer_room1_light = session_room1_light.createProducer(dest_room1_light);
	        producer_room1_il = session_room1_il.createProducer(dest_room1_il);
	        producer_room2_light = session_room2_light.createProducer(dest_room2_light);
	        producer_room2_il = session_room2_il.createProducer(dest_room2_il);
	        producer_room3_light = session_room3_light.createProducer(dest_room3_light);
	        producer_room3_il = session_room3_il.createProducer(dest_room3_il);
	        producer_room4_light = session_room4_light.createProducer(dest_room4_light);
	        producer_room4_il = session_room4_il.createProducer(dest_room4_il);
	        producer_kitchen_light = session_kitchen_light.createProducer(dest_kitchen_light);
	        producer_kitchen_il = session_kitchen_il.createProducer(dest_kitchen_il);
	        producer_hall_light = session_hall_light.createProducer(dest_hall_light);
	        producer_hall_il = session_hall_il.createProducer(dest_hall_il);
	        producer_bathroom_light = session_bathroom_light.createProducer(dest_bathroom_light);
	        producer_bathroom_il = session_bathroom_il.createProducer(dest_bathroom_il);
	       
	        
	        
	        
	        
	        producer_room1_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room1_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_light.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room1_il.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        
	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //Destination dest = new ActiveMQTopic(destination);
       

    	// Create a messages
        
		LightingSystem newLightingSystem=new LightingSystem();
        while(true){
        	
        	if(isScenario=="false"){ 
        		newLightingSystem.SetSonsors();
           	} 
        	else{
        		newLightingSystem.Scenario();
        			// newHomeAppliances.DosyadanOku();
        			
        	}
        	
        	String text_room1_light = string_room1_light;
        	String text_room1_il= string_room1_il;
        	String text_room2_light = string_room2_light;
        	String text_room2_il= string_room2_il;
        	String text_room3_light = string_room3_light;
        	String text_room3_il= string_room3_il;
        	String text_room4_light = string_room4_light;
        	String text_room4_il= string_room4_il;
        	String text_kitchen_light = string_kitchen_light;
        	String text_kitchen_il= string_kitchen_il;
        	String text_hall_light = string_hall_light;
        	String text_hall_il= string_hall_il;
        	String text_bathroom_light = string_bathroom_light;
        	String text_bathroom_il= string_bathroom_il;
        	
        	
        	
        	
        	if(isRunning=="false"){ 
        		i=0;
        		break;
        	 
        	} 
        	
        	TextMessage message_room1_light,message_room1_il;
        	TextMessage message_room2_light,message_room2_il;
        	TextMessage message_room3_light,message_room3_il;
        	TextMessage message_room4_light,message_room4_il;
        	TextMessage message_kitchen_light,message_kitchen_il;
        	TextMessage message_hall_light,message_hall_il;
        	TextMessage message_bathroom_light,message_bathroom_il;
			
        	try {
        		message_room1_light = session_room1_light.createTextMessage(text_room1_light);
        		message_room1_il  = session_room1_il.createTextMessage(text_room1_il);
        		message_room2_light = session_room1_light.createTextMessage(text_room2_light);
        		message_room2_il  = session_room1_il.createTextMessage(text_room2_il);
        		message_room3_light = session_room1_light.createTextMessage(text_room3_light);
        		message_room3_il  = session_room1_il.createTextMessage(text_room3_il);
        		message_room4_light = session_room1_light.createTextMessage(text_room4_light);
        		message_room4_il  = session_room1_il.createTextMessage(text_room4_il);
        		message_kitchen_light = session_kitchen_light.createTextMessage(text_kitchen_light);
        		message_kitchen_il  = session_kitchen_il.createTextMessage(text_kitchen_il);
        		message_hall_light = session_hall_light.createTextMessage(text_hall_light);
        		message_hall_il  = session_hall_il.createTextMessage(text_hall_il);
        		message_bathroom_light = session_bathroom_light.createTextMessage(text_bathroom_light);
        		message_bathroom_il  = session_bathroom_il.createTextMessage(text_bathroom_il);
        		
        		
				producer_room1_light.send(message_room1_light);
				producer_room1_il.send(message_room1_il);
				producer_room2_light.send(message_room2_light);
				producer_room2_il.send(message_room2_il);
				producer_room3_light.send(message_room3_light);
				producer_room3_il.send(message_room3_il);
				producer_room4_light.send(message_room4_light);
				producer_room4_il.send(message_room4_il);
				producer_kitchen_light.send(message_kitchen_light);
				producer_kitchen_il.send(message_kitchen_il);
				producer_hall_light.send(message_hall_light);
				producer_hall_il.send(message_hall_il);
				producer_bathroom_light.send(message_bathroom_light);
				producer_bathroom_il.send(message_bathroom_il);
				
				
	            //System.out.println("Send1: " + text);
	            doUpdate(display,room1_light,text_room1_light);
	            doUpdate(display,room1_il,text_room1_il);
	            doUpdate(display,room2_light,text_room2_light);
	            doUpdate(display,room2_il,text_room2_il);
	            doUpdate(display,room3_light,text_room3_light);
	            doUpdate(display,room3_il,text_room3_il);
	            doUpdate(display,room4_light,text_room4_light);
	            doUpdate(display,room4_il,text_room4_il);
	            doUpdate(display,kitchen_light,text_kitchen_light);
	            doUpdate(display,kitchen_il,text_kitchen_il);
	            doUpdate(display,hall_light,text_hall_light);
	            doUpdate(display,hall_il,text_hall_il);
	            doUpdate(display,bathroom_light,text_bathroom_light);
	            doUpdate(display,bathroom_il,text_bathroom_il);
	           
	            
	            try {
			          Thread.sleep(10);
			        } catch(InterruptedException e) {
			        }
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            
			
        }
        
        //producer.send(session.createTextMessage("SHUTDOWN"));
        try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

    

}
