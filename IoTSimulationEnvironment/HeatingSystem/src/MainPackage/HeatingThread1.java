package MainPackage;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HeatingThread1 extends HTMainScreen  implements Runnable {
	
	public  Destination dest_room1_temp,dest_room1_mode,dest_room1_status;
	public  Destination dest_room2_temp,dest_room2_mode,dest_room2_status;
	public  Destination dest_room3_temp,dest_room3_mode,dest_room3_status;
	public  Destination dest_room4_temp,dest_room4_mode,dest_room4_status;
	public  Destination dest_kitchen_temp,dest_kitchen_mode,dest_kitchen_status;
	public  Destination dest_hall_temp,dest_hall_mode,dest_hall_status;
	public  Destination dest_bathroom_temp,dest_bathroom_mode,dest_bathroom_status;
	
	public  MessageProducer producer_room1_temp,producer_room1_mode,producer_room1_status;
	public  MessageProducer producer_room2_temp,producer_room2_mode,producer_room2_status;
	public  MessageProducer producer_room3_temp,producer_room3_mode,producer_room3_status;
	public  MessageProducer producer_room4_temp,producer_room4_mode,producer_room4_status;
	public  MessageProducer producer_kitchen_temp,producer_kitchen_mode,producer_kitchen_status;
	public  MessageProducer producer_hall_temp,producer_hall_mode,producer_hall_status;
	public  MessageProducer producer_bathroom_temp,producer_bathroom_mode,producer_bathroom_status;
	
	
	public  String user=null,password=null,host=null,text = null;
	public int port;
	public Session session_room1_temp,session_room1_mode,session_room1_status;
	public Session session_room2_temp,session_room2_mode,session_room2_status;
	public Session session_room3_temp,session_room3_mode,session_room3_status;
	public Session session_room4_temp,session_room4_mode,session_room4_status;
	public Session session_kitchen_temp,session_kitchen_mode,session_kitchen_status;
	public Session session_hall_temp,session_hall_mode,session_hall_status;
	public Session session_bathroom_temp,session_bathroom_mode,session_bathroom_status;
 	

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
	        session_room1_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room1_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room1_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_temp = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_mode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_status = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        
	        
	        dest_room1_temp = session_room1_temp.createQueue("ROOM1_TEMP.FOO");
	        dest_room1_mode = session_room1_mode.createQueue("ROOM1_MODE.FOO");
	        dest_room1_status = session_room1_status.createQueue("ROOM1_STATUS.FOO");
	        dest_room2_temp = session_room2_temp.createQueue("ROOM2_TEMP.FOO");
	        dest_room2_mode = session_room2_mode.createQueue("ROOM2_MODE.FOO");
	        dest_room2_status = session_room2_status.createQueue("ROOM2_STATUS.FOO");
	        dest_room3_temp = session_room3_temp.createQueue("ROOM3_TEMP.FOO");
	        dest_room3_mode = session_room3_mode.createQueue("ROOM3_MODE.FOO");
	        dest_room3_status = session_room3_status.createQueue("ROOM3_STATUS.FOO");
	        dest_room4_temp = session_room4_temp.createQueue("ROOM4_TEMP.FOO");
	        dest_room4_mode = session_room4_mode.createQueue("ROOM4_MODE.FOO");
	        dest_room4_status = session_room4_status.createQueue("ROOM4_STATUS.FOO");
	        dest_kitchen_temp = session_kitchen_temp.createQueue("KITCHEN_TEMP.FOO");
	        dest_kitchen_mode = session_kitchen_mode.createQueue("KITCHEN_MODE.FOO");
	        dest_kitchen_status = session_kitchen_status.createQueue("KITCHEN_STATUS.FOO");
	        dest_hall_temp = session_hall_temp.createQueue("HALL_TEMP.FOO");
	        dest_hall_mode = session_hall_mode.createQueue("HALL_MODE.FOO");
	        dest_hall_status = session_hall_status.createQueue("HALL_STATUS.FOO");
	        dest_bathroom_temp = session_bathroom_temp.createQueue("BATHROOM_TEMP.FOO");
	        dest_bathroom_mode = session_bathroom_mode.createQueue("BATHROOM_MODE.FOO");
	        dest_bathroom_status = session_bathroom_status.createQueue("BATHROOM_STATUS.FOO");

	        
	        producer_room1_temp = session_room1_temp.createProducer(dest_room1_temp);
	        producer_room1_mode = session_room1_mode.createProducer(dest_room1_mode);
	        producer_room1_status = session_room1_status.createProducer(dest_room1_status);
	        producer_room2_temp = session_room2_temp.createProducer(dest_room2_temp);
	        producer_room2_mode = session_room2_mode.createProducer(dest_room2_mode);
	        producer_room2_status = session_room2_status.createProducer(dest_room2_status);
	        producer_room3_temp = session_room3_temp.createProducer(dest_room3_temp);
	        producer_room3_mode = session_room3_mode.createProducer(dest_room3_mode);
	        producer_room3_status = session_room3_status.createProducer(dest_room3_status);
	        producer_room4_temp = session_room4_temp.createProducer(dest_room4_temp);
	        producer_room4_mode = session_room4_mode.createProducer(dest_room4_mode);
	        producer_room4_status = session_room4_status.createProducer(dest_room4_status);
	        producer_kitchen_temp = session_kitchen_temp.createProducer(dest_kitchen_temp);
	        producer_kitchen_mode = session_kitchen_mode.createProducer(dest_kitchen_mode);
	        producer_kitchen_status = session_kitchen_status.createProducer(dest_kitchen_status);
	        producer_hall_temp = session_hall_temp.createProducer(dest_hall_temp);
	        producer_hall_mode = session_hall_mode.createProducer(dest_hall_mode);
	        producer_hall_status = session_hall_status.createProducer(dest_hall_status);
	        producer_bathroom_temp = session_bathroom_temp.createProducer(dest_bathroom_temp);
	        producer_bathroom_mode = session_bathroom_mode.createProducer(dest_bathroom_mode);
	        producer_bathroom_status = session_bathroom_status.createProducer(dest_bathroom_status);

	        
	        
	        
	        
	        producer_room1_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room1_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room1_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_temp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_mode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_status.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //Destination dest = new ActiveMQTopic(destination);
       

    	// Create a messages
        
		HeatingSystem newHeatingSystem=new HeatingSystem();
        while(true){
        	
        	if(isScenario=="false"){ 
        		newHeatingSystem.SetSonsors();
           	} 
        	else{
        		newHeatingSystem.Scenario();
        	}
        	
        	String text_room1_temp = string_room1_temp;
        	String text_room1_mode = string_room1_mode;
        	String text_room1_status = string_room1_status;
        	String text_room2_temp = string_room2_temp;
        	String text_room2_mode = string_room2_mode;
        	String text_room2_status = string_room2_status;
        	String text_room3_temp = string_room3_temp;
        	String text_room3_mode = string_room3_mode;
        	String text_room3_status = string_room3_status;
        	String text_room4_temp = string_room4_temp;
        	String text_room4_mode = string_room4_mode;
        	String text_room4_status = string_room4_status;
        	String text_kitchen_temp = string_kitchen_temp;
        	String text_kitchen_mode = string_kitchen_mode;
        	String text_kitchen_status = string_kitchen_status;
        	String text_hall_temp = string_hall_temp;
        	String text_hall_mode = string_hall_mode;
        	String text_hall_status = string_hall_status;
        	String text_bathroom_temp = string_bathroom_temp;
        	String text_bathroom_mode = string_bathroom_mode;
        	String text_bathroom_status = string_bathroom_status;
        	

        	if(isRunning=="false"){ 
        		i=0;
        		break;
        	 
        	} 
        	
        	TextMessage message_room1_temp,message_room1_mode,message_room1_status;
        	TextMessage message_room2_temp,message_room2_mode,message_room2_status;
        	TextMessage message_room3_temp,message_room3_mode,message_room3_status;
        	TextMessage message_room4_temp,message_room4_mode,message_room4_status;
        	TextMessage message_kitchen_temp,message_kitchen_mode,message_kitchen_status;
        	TextMessage message_hall_temp,message_hall_mode,message_hall_status;
        	TextMessage message_bathroom_temp,message_bathroom_mode,message_bathroom_status;
			
        	try {
        		message_room1_temp = session_room1_temp.createTextMessage(text_room1_temp);
        		message_room1_mode = session_room1_mode.createTextMessage(text_room1_mode);
        		message_room1_status = session_room1_status.createTextMessage(text_room1_status);
        		message_room2_temp = session_room2_temp.createTextMessage(text_room2_temp);
        		message_room2_mode = session_room2_mode.createTextMessage(text_room2_mode);
        		message_room2_status = session_room2_status.createTextMessage(text_room2_status);
        		message_room3_temp = session_room3_temp.createTextMessage(text_room3_temp);
        		message_room3_mode = session_room3_mode.createTextMessage(text_room3_mode);
        		message_room3_status = session_room3_status.createTextMessage(text_room3_status);
        		message_room4_temp = session_room4_temp.createTextMessage(text_room4_temp);
        		message_room4_mode = session_room4_mode.createTextMessage(text_room4_mode);
        		message_room4_status = session_room4_status.createTextMessage(text_room4_status);
        		message_kitchen_temp = session_kitchen_temp.createTextMessage(text_kitchen_temp);
        		message_kitchen_mode = session_kitchen_mode.createTextMessage(text_kitchen_mode);
        		message_kitchen_status = session_kitchen_status.createTextMessage(text_kitchen_status);
        		message_hall_temp = session_hall_temp.createTextMessage(text_hall_temp);
        		message_hall_mode = session_hall_mode.createTextMessage(text_hall_mode);
        		message_hall_status = session_hall_status.createTextMessage(text_hall_status);
        		message_bathroom_temp = session_bathroom_temp.createTextMessage(text_bathroom_temp);
        		message_bathroom_mode = session_bathroom_mode.createTextMessage(text_bathroom_mode);
        		message_bathroom_status = session_bathroom_status.createTextMessage(text_bathroom_status);
        		
				producer_room1_temp.send(message_room1_temp);
				producer_room1_mode.send(message_room1_mode);
				producer_room1_status.send(message_room1_status);
				producer_room2_temp.send(message_room2_temp);
				producer_room2_mode.send(message_room2_mode);
				producer_room2_status.send(message_room2_status);
				producer_room3_temp.send(message_room3_temp);
				producer_room3_mode.send(message_room3_mode);
				producer_room3_status.send(message_room3_status);
				producer_room4_temp.send(message_room4_temp);
				producer_room4_mode.send(message_room4_mode);
				producer_room4_status.send(message_room4_status);
				producer_kitchen_temp.send(message_kitchen_temp);
				producer_kitchen_mode.send(message_kitchen_mode);
				producer_kitchen_status.send(message_kitchen_status);
				producer_hall_temp.send(message_hall_temp);
				producer_hall_mode.send(message_hall_mode);
				producer_hall_status.send(message_hall_status);
				producer_bathroom_temp.send(message_bathroom_temp);
				producer_bathroom_mode.send(message_bathroom_mode);
				producer_bathroom_status.send(message_bathroom_status);
				
	            //System.out.println("Send1: " + text);
	            doUpdate(display,room1_temp,text_room1_temp);
	            doUpdate(display,room1_mode,text_room1_mode);
	            doUpdate(display,room1_status,text_room1_status);
	            doUpdate(display,room2_temp,text_room2_temp);
	            doUpdate(display,room2_mode,text_room2_mode);
	            doUpdate(display,room2_status,text_room2_status);
	            doUpdate(display,room3_temp,text_room3_temp);
	            doUpdate(display,room3_mode,text_room3_mode);
	            doUpdate(display,room3_status,text_room3_status);
	            doUpdate(display,room4_temp,text_room4_temp);
	            doUpdate(display,room4_mode,text_room4_mode);
	            doUpdate(display,room4_status,text_room4_status);
	            doUpdate(display,kitchen_temp,text_kitchen_temp);
	            doUpdate(display,kitchen_mode,text_kitchen_mode);
	            doUpdate(display,kitchen_status,text_kitchen_status);
	            doUpdate(display,hall_temp,text_hall_temp);
	            doUpdate(display,hall_mode,text_hall_mode);
	            doUpdate(display,hall_status,text_hall_status);
	            doUpdate(display,bathroom_temp,text_bathroom_temp);
	            doUpdate(display,bathroom_mode,text_bathroom_mode);
	            doUpdate(display,bathroom_status,text_bathroom_status);
	            
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
