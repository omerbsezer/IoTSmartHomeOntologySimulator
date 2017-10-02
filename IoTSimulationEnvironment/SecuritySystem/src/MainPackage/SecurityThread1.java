package MainPackage;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SecurityThread1 extends SSMainScreen  implements Runnable {
	
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

	
	public  MessageProducer producer_room1_sstatus,producer_room1_smode;
	public  MessageProducer producer_room2_sstatus,producer_room2_smode;
	public  MessageProducer producer_room3_sstatus,producer_room3_smode;
	public  MessageProducer producer_room4_sstatus,producer_room4_smode;
	public  MessageProducer producer_kitchen_sstatus,producer_kitchen_smode;
	public  MessageProducer producer_hall_sstatus,producer_hall_smode;
	public  MessageProducer producer_bathroom_sstatus,producer_bathroom_smode;
	public  MessageProducer producer_water_sstatus,producer_water_smode;
	public  MessageProducer producer_gas_sstatus,producer_gas_smode;
	public  MessageProducer producer_elec_sstatus,producer_elec_smode;
	
	
	public  String user=null,password=null,host=null,text = null;
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
			
	        session_room1_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room1_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room2_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room3_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_room4_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_kitchen_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_hall_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_bathroom_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_water_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_water_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_gas_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_gas_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_elec_sstatus = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        session_elec_smode = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	       
	        
	        
	        dest_room1_sstatus = session_room1_sstatus.createQueue("ROOM1_SSTATUS.FOO");
	        dest_room1_smode = session_room1_smode.createQueue("ROOM1_SMODE.FOO");
	        dest_room2_sstatus = session_room2_sstatus.createQueue("ROOM2_SSTATUS.FOO");
	        dest_room2_smode = session_room2_smode.createQueue("ROOM2_SMODE.FOO");
	        dest_room3_sstatus = session_room3_sstatus.createQueue("ROOM3_SSTATUS.FOO");
	        dest_room3_smode = session_room3_smode.createQueue("ROOM3_SMODE.FOO");
	        dest_room4_sstatus = session_room4_sstatus.createQueue("ROOM4_SSTATUS.FOO");
	        dest_room4_smode = session_room4_smode.createQueue("ROOM4_SMODE.FOO");
	        dest_kitchen_sstatus = session_kitchen_sstatus.createQueue("KITCHEN_SSTATUS.FOO");
	        dest_kitchen_smode = session_kitchen_smode.createQueue("KITCHEN_SMODE.FOO");
	        dest_hall_sstatus = session_hall_sstatus.createQueue("HALL_SSTATUS.FOO");
	        dest_hall_smode = session_hall_smode.createQueue("HALL_SMODE.FOO");
	        dest_bathroom_sstatus = session_bathroom_sstatus.createQueue("BATHROOM_SSTATUS.FOO");
	        dest_bathroom_smode = session_bathroom_smode.createQueue("BATHROOM_SMODE.FOO");
	        dest_water_sstatus = session_bathroom_sstatus.createQueue("WATER_SSTATUS.FOO");
	        dest_water_smode = session_bathroom_smode.createQueue("WATER_SMODE.FOO");
	        dest_gas_sstatus = session_bathroom_sstatus.createQueue("GAS_SSTATUS.FOO");
	        dest_gas_smode = session_bathroom_smode.createQueue("GAS_SMODE.FOO");
	        dest_elec_sstatus = session_bathroom_sstatus.createQueue("ELEC_SSTATUS.FOO");
	        dest_elec_smode = session_bathroom_smode.createQueue("ELEC_SMODE.FOO");
	        
	        
	        producer_room1_sstatus = session_room1_sstatus.createProducer(dest_room1_sstatus);
	        producer_room1_smode = session_room1_smode.createProducer(dest_room1_smode);
	        producer_room2_sstatus = session_room2_sstatus.createProducer(dest_room2_sstatus);
	        producer_room2_smode = session_room2_smode.createProducer(dest_room2_smode);
	        producer_room3_sstatus = session_room3_sstatus.createProducer(dest_room3_sstatus);
	        producer_room3_smode = session_room3_smode.createProducer(dest_room3_smode);
	        producer_room4_sstatus = session_room4_sstatus.createProducer(dest_room4_sstatus);
	        producer_room4_smode = session_room4_smode.createProducer(dest_room4_smode);
	        producer_kitchen_sstatus = session_kitchen_sstatus.createProducer(dest_kitchen_sstatus);
	        producer_kitchen_smode = session_kitchen_smode.createProducer(dest_kitchen_smode);
	        producer_hall_sstatus = session_hall_sstatus.createProducer(dest_hall_sstatus);
	        producer_hall_smode = session_hall_smode.createProducer(dest_hall_smode);
	        producer_bathroom_sstatus = session_bathroom_sstatus.createProducer(dest_bathroom_sstatus);
	        producer_bathroom_smode = session_bathroom_smode.createProducer(dest_bathroom_smode);
	        producer_water_sstatus = session_water_sstatus.createProducer(dest_water_sstatus);
	        producer_water_smode = session_water_smode.createProducer(dest_water_smode);
	        producer_gas_sstatus = session_gas_sstatus.createProducer(dest_gas_sstatus);
	        producer_gas_smode = session_gas_smode.createProducer(dest_gas_smode);
	        producer_elec_sstatus = session_elec_sstatus.createProducer(dest_elec_sstatus);
	        producer_elec_smode = session_bathroom_smode.createProducer(dest_elec_smode);
	       
	        
	        
	        
	        
	        producer_room1_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room1_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room2_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room3_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_room4_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_kitchen_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_hall_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_bathroom_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_water_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_water_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_gas_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_gas_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_elec_sstatus.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        producer_elec_smode.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        
	        
	        
	        
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //Destination dest = new ActiveMQTopic(destination);
       

    	// Create a messages
        
		SecuritySystem newSecuritySystem=new SecuritySystem();
        while(true){
        	
        	if(isScenario=="false"){ 
        		newSecuritySystem.SetSonsors();
           	} 
        	else{
        		newSecuritySystem.Scenario();
        			// newHomeAppliances.DosyadanOku();
        			
        	}
        	String text_room1_sstatus = string_room1_sstatus;
        	String text_room1_smode = string_room1_smode;
        	String text_room2_sstatus = string_room2_sstatus;
        	String text_room2_smode = string_room2_smode;
        	String text_room3_sstatus = string_room3_sstatus;
        	String text_room3_smode = string_room3_smode;
        	String text_room4_sstatus = string_room4_sstatus;
        	String text_room4_smode = string_room4_smode;
        	String text_kitchen_sstatus = string_kitchen_sstatus;
        	String text_kitchen_smode = string_kitchen_smode;
        	String text_hall_sstatus = string_hall_sstatus;
        	String text_hall_smode = string_hall_smode;
        	String text_bathroom_sstatus = string_bathroom_sstatus;
        	String text_bathroom_smode = string_bathroom_smode;
        	String text_water_sstatus = string_water_sstatus;
        	String text_water_smode = string_water_smode;
        	String text_gas_sstatus = string_gas_sstatus;
        	String text_gas_smode = string_gas_smode;
        	String text_elec_sstatus = string_elec_sstatus;
        	String text_elec_smode = string_elec_smode;
        	
        	if(isRunning=="false"){ 
        		i=0;
        		break;
        	 
        	} 
        	
        	
        	TextMessage message_room1_sstatus,message_room1_smode;
        	TextMessage message_room2_sstatus,message_room2_smode;
        	TextMessage message_room3_sstatus,message_room3_smode;
        	TextMessage message_room4_sstatus,message_room4_smode;
        	TextMessage message_kitchen_sstatus,message_kitchen_smode;
        	TextMessage message_hall_sstatus,message_hall_smode;
        	TextMessage message_bathroom_sstatus,message_bathroom_smode;
        	TextMessage message_water_sstatus,message_water_smode;
        	TextMessage message_gas_sstatus,message_gas_smode;
        	TextMessage message_elec_sstatus,message_elec_smode;
        	
			
        	try {
        		message_room1_sstatus = session_room1_sstatus.createTextMessage(text_room1_sstatus);
        		message_room1_smode  = session_room1_smode.createTextMessage(text_room1_smode);
        		message_room2_sstatus = session_room1_sstatus.createTextMessage(text_room2_sstatus);
        		message_room2_smode  = session_room1_smode.createTextMessage(text_room2_smode);
        		message_room3_sstatus = session_room1_sstatus.createTextMessage(text_room3_sstatus);
        		message_room3_smode  = session_room1_smode.createTextMessage(text_room3_smode);
        		message_room4_sstatus = session_room1_sstatus.createTextMessage(text_room4_sstatus);
        		message_room4_smode  = session_room1_smode.createTextMessage(text_room4_smode);
        		message_kitchen_sstatus = session_kitchen_sstatus.createTextMessage(text_kitchen_sstatus);
        		message_kitchen_smode  = session_kitchen_smode.createTextMessage(text_kitchen_smode);
        		message_hall_sstatus = session_hall_sstatus.createTextMessage(text_hall_sstatus);
        		message_hall_smode  = session_hall_smode.createTextMessage(text_hall_smode);
        		message_bathroom_sstatus = session_bathroom_sstatus.createTextMessage(text_bathroom_sstatus);
        		message_bathroom_smode  = session_bathroom_smode.createTextMessage(text_bathroom_smode);
        		message_water_sstatus = session_water_sstatus.createTextMessage(text_water_sstatus);
        		message_water_smode  = session_water_smode.createTextMessage(text_water_smode);
        		message_gas_sstatus = session_gas_sstatus.createTextMessage(text_gas_sstatus);
        		message_gas_smode  = session_gas_smode.createTextMessage(text_gas_smode);
        		message_elec_sstatus = session_elec_sstatus.createTextMessage(text_elec_sstatus);
        		message_elec_smode  = session_elec_smode.createTextMessage(text_elec_smode);
        		
        		
				producer_room1_sstatus.send(message_room1_sstatus);
				producer_room1_smode.send(message_room1_smode);
				producer_room2_sstatus.send(message_room2_sstatus);
				producer_room2_smode.send(message_room2_smode);
				producer_room3_sstatus.send(message_room3_sstatus);
				producer_room3_smode.send(message_room3_smode);
				producer_room4_sstatus.send(message_room4_sstatus);
				producer_room4_smode.send(message_room4_smode);
				producer_kitchen_sstatus.send(message_kitchen_sstatus);
				producer_kitchen_smode.send(message_kitchen_smode);
				producer_hall_sstatus.send(message_hall_sstatus);
				producer_hall_smode.send(message_hall_smode);
				producer_bathroom_sstatus.send(message_bathroom_sstatus);
				producer_bathroom_smode.send(message_bathroom_smode);
				producer_water_sstatus.send(message_water_sstatus);
				producer_water_smode.send(message_water_smode);
				producer_gas_sstatus.send(message_gas_sstatus);
				producer_gas_smode.send(message_gas_smode);
				producer_elec_sstatus.send(message_elec_sstatus);
				producer_elec_smode.send(message_elec_smode);
				
				
	            //System.out.println("Send1: " + text);
	            doUpdate(display,room1_sstatus,text_room1_sstatus);
	            doUpdate(display,room1_smode,text_room1_smode);
	            doUpdate(display,room2_sstatus,text_room2_sstatus);
	            doUpdate(display,room2_smode,text_room2_smode);
	            doUpdate(display,room3_sstatus,text_room3_sstatus);
	            doUpdate(display,room3_smode,text_room3_smode);
	            doUpdate(display,room4_sstatus,text_room4_sstatus);
	            doUpdate(display,room4_smode,text_room4_smode);
	            doUpdate(display,kitchen_sstatus,text_kitchen_sstatus);
	            doUpdate(display,kitchen_smode,text_kitchen_smode);
	            doUpdate(display,hall_sstatus,text_hall_sstatus);
	            doUpdate(display,hall_smode,text_hall_smode);
	            doUpdate(display,bathroom_sstatus,text_bathroom_sstatus);
	            doUpdate(display,bathroom_smode,text_bathroom_smode);
	            doUpdate(display,water_sstatus,text_water_sstatus);
	            doUpdate(display,water_smode,text_water_smode);
	            doUpdate(display,gas_sstatus,text_gas_sstatus);
	            doUpdate(display,gas_smode,text_gas_smode);
	            doUpdate(display,electricity_sstatus,text_elec_sstatus);
	            doUpdate(display,electricity_smode,text_elec_smode);
	           
	            
	            try {
			          Thread.sleep(500);
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
