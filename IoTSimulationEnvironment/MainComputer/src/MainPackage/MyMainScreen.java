package MainPackage;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;



public class MyMainScreen {

	protected Shell shlMainComputer;
	public static Text ref_temp;
	public static Text ref_mode;
	public static Text ref_status;
	public static Text ref_electric;
	public static Text wm_temp;
	public static Text wm_mode;
	public static Text wm_status;
	public static Text wm_electric;
	public static Text dw_temp;
	public static Text dw_mode;
	public static Text dw_status;
	public static Text dw_electric;
	public static Text tv_electric;
	public static Text tv_status;
	public static Text tv_mode;
	public static Text tv_temp;
	public static Text om_temp;
	public static Text om_mode;
	public static Text om_status;
	public static Text om_electric;
	public static Text comp_temp;
	public static Text comp_mode;
	public static Text comp_status;
	public static Text comp_electric;
	public static Display display;
	public static Text room1_temp;
	public static Text room1_mode;
	public static Text room1_status;
	public static Text room2_temp;
	public static Text room2_mode;
	public static Text room2_status;
	public static Text room3_temp;
	public static Text room3_mode;
	public static Text room3_status;
	public static Text room4_temp;
	public static Text room4_mode;
	public static Text room4_status;
	public static Text kitchen_temp;
	public static Text kitchen_mode;
	public static Text kitchen_status;
	public static Text hall_temp;
	public static Text hall_mode;
	public static Text hall_status;
	public static Text bathroom_status;
	public static Text bathroom_mode;
	public static Text bathroom_temp;
	public static Text room1_light;
	public static Text room1_il;
	public static Text room2_light;
	public static Text room2_il;
	public static Text room3_light;
	public static Text room3_il;
	public static Text room4_light;
	public static Text room4_il;
	public static Text kitchen_light;
	public static Text kitchen_il;
	public static Text hall_light;
	public static Text hall_il;
	public static Text bathroom_light;
	public static Text bathroom_il;
	public static Text room1_sstatus;
	public static Text room1_smode;
	public static Text room2_sstatus;
	public static Text room2_smode;
	public static Text room3_sstatus;
	public static Text room3_smode;
	public static Text room4_sstatus;
	public static Text room4_smode;
	public static Text water_sstatus;
	public static Text water_smode;
	public static Text kitchen_sstatus;
	public static Text kitchen_smode;
	public static Text hall_sstatus;
	public static Text hall_smode;
	public static Text bathroom_sstatus;
	public static Text bathroom_smode;
	public static Text electricity_sstatus;
	public static Text electricity_smode;
	public static Text gas_sstatus;
	public static Text gas_smode;
	public static Label lblInfo;
	
	public static String string_ref_temp=null;
	public static String string_ref_mode;
	public static String string_ref_status;
	public static String string_ref_electric;
	
	
	public  Destination dest_mc_ha, dest_mc_ls, dest_mc_hs, dest_mc_ss;
	public  MessageProducer producer_mc_ha,producer_mc_ls,producer_mc_hs,producer_mc_ss;
	public  String user=null,password=null,host=null,text = null;
	public int port;
	public Session session_mc_ha,session_mc_ls,session_mc_hs,session_mc_ss;
	public String text_mc_ha,text_mc_ls,text_mc_hs,text_mc_ss;
	
	public static int counter_ref_temp=0;
	public static int ls_command_send=0;
	public static int off_command_send=0;
	
	//for time measurement
	public static long maxDifTimeRoom2IL=0;
	public static long difTimeRoom2IL=0;
	public static long totalRoom2IL=0;
	public static long processTime=0;
	public static long totalProcess=0;
	public static int counterRoom2IL=0;
	
	public static long maxDifTimeWm_temp=0;
	public static long difTimeWm_temp=0;
	public static long totalWm_temp=0;
	public static long processTimeRef=0;
	public static int counterWm_temp=0;
	
	public static long maxDifTimeRoom1Temp=0;
	public static long difTimeRoom1Temp=0;
	public static long totalRoom1Temp=0;
	public static long processTimeHeat=0;
	public static int counterRoom1Temp=0;
	
	public static long maxDifTimeRoom2Sstatus=0;
	public static long difTimeRoom2Sstatus=0;
	public static long totalRoom2Sstatus=0;
	public static long processTimeSecurity=0;
	public static int counterRoom2Sstatus=0;
	//for time measurement
	
	//static Message messageRef=new Message();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			MyMainScreen window = new MyMainScreen();
			//listener();
			window.open();
			
			
			/*Thread1 HAref = new Thread1();
	        Thread t = new Thread(HAref);
	        t.start();
	
	        Thread.sleep(1000); // POINT OF FOCUS*/
	        //Display d = ref_temp.getDisplay();
			//for(int i=0;i<10000;i++){}
			

	        
	       
	        
			

	     
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static void doUpdate(final Display display, final Text target,
		      final String value) {
		 
		 	Display.getDefault().asyncExec(new Runnable() {
		      @Override
		      public void run() {
		        if (!target.isDisposed()) {
		          target.setText(value);
		          target.getParent().layout();
		        }
		      }
		    });
		  }
	 public static void UpdateInfo(final Display display, final Label target,
		      final String value) {
		 
		 	Display.getDefault().asyncExec(new Runnable() {
		      @Override
		      public void run() {
		        if (!target.isDisposed()) {
		          target.setText(value);
		          target.getParent().layout();
		        }
		      }
		    });
		  }
	 public static void ChangeColorRed(final Display display, final Text target) {
		 
		 	Display.getDefault().asyncExec(new Runnable() {
		      @Override
		      public void run() {
		        if (!target.isDisposed()) {
		          target.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		          target.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		          target.getParent().layout();
		        }
		      }
		    });
		  }
	 public static void ChangeColorWhite(final Display display, final Text target) {
		 
		 	Display.getDefault().asyncExec(new Runnable() {
		      @Override
		      public void run() {
		        if (!target.isDisposed()) {
		          target.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		          target.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		          target.getParent().layout();
		        }
		      }
		    });
		  }
	/**
	 * Open the window.
	 * @throws InterruptedException 
	 */
	public void open() throws InterruptedException {
		display = Display.getDefault();
		createContents();
		
		/*Thread2 HAref2 = new Thread2();
	    Thread t2 = new Thread(HAref2);
	    t2.start();*/
		/*ThreadController TC = new ThreadController();
        Thread t100 = new Thread(TC);
        t100.start();
        
        synchronized(t100){
            try{
                System.out.println("Waiting for ref_temp...");
                t100.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            //System.out.println("Total is: " + b.total);
        }*/
        
        
	    Thread1 HAref = new Thread1();
        Thread t = new Thread(HAref);
        t.start();
        Thread2 HAref2 = new Thread2();
        Thread t2 = new Thread(HAref2);
        t2.start();
        Thread3 HAref3 = new Thread3();
        Thread t3 = new Thread(HAref3);
        t3.start();
        Thread4 HAref4 = new Thread4();
        Thread t4 = new Thread(HAref4);
        t4.start();
        Thread5 HAref5 = new Thread5();
        Thread t5 = new Thread(HAref5);
        t5.start();
        Thread6 HAref6 = new Thread6();
        Thread t6 = new Thread(HAref6);
        t6.start();
        MCLightThread1 MCLThread1 = new MCLightThread1();
        Thread t7 = new Thread(MCLThread1);
        t7.start();
        MCLightThread2 MCLThread2 = new MCLightThread2();
        Thread t8 = new Thread(MCLThread2);
        t8.start();
        MCHeatingThread1 MCHThread1 = new MCHeatingThread1();
        Thread t9 = new Thread(MCHThread1);
        t9.start();
        MCHeatingThread2 MCHThread2 = new MCHeatingThread2();
        Thread t10 = new Thread(MCHThread2);
        t10.start();
        MCHeatingThread3 MCHThread3 = new MCHeatingThread3();
        Thread t11 = new Thread(MCHThread3);
        t11.start();
        MCSecurityThread1 MCSThread1 = new MCSecurityThread1 ();
        Thread t12 = new Thread(MCSThread1);
        t12.start();
        MCSecurityThread2 MCSThread2 = new MCSecurityThread2 ();
        Thread t13 = new Thread(MCSThread2);
        t13.start();
        MCSecurityThread3 MCSThread3 = new MCSecurityThread3 ();
        Thread t14 = new Thread(MCSThread3);
        t14.start();
        UpdateInfo(display,lblInfo,"Main Computer is in Listening Mode!");
        
        
        
        
        //lblInfo.setText("q");
		shlMainComputer.open();
		shlMainComputer.layout();
		while (!shlMainComputer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
				
			}
		}
		
		
	}

	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMainComputer = new Shell();
		shlMainComputer.setSize(564, 586);
		shlMainComputer.setText("Main Computer");
		
		lblInfo = new Label(shlMainComputer, SWT.NONE);
        lblInfo.setBounds(20, 523, 489, 15);
		
		TabFolder tabFolder = new TabFolder(shlMainComputer, SWT.NONE);
		tabFolder.setBounds(10, 10, 528, 505);
		
		TabItem tbtmHomeAppliances_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmHomeAppliances_1.setText("Home Appliances");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmHomeAppliances_1.setControl(group);
		group.setText("Home Appliances");
		
		
		
		Label label = new Label(group, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setText("Equipments");
		label.setBounds(10, 21, 76, 15);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setText("Values");
		label_1.setBounds(168, 21, 76, 15);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_2.setText("Refrigerator");
		label_2.setBounds(10, 42, 76, 15);
		
		Label lblTemperature = new Label(group, SWT.NONE);
		lblTemperature.setText("Temperature :");
		lblTemperature.setBounds(31, 63, 76, 15);
		
		Label lblMode = new Label(group, SWT.NONE);
		lblMode.setText("Mode :");
		lblMode.setBounds(31, 90, 76, 15);
		
		Label lblStatus = new Label(group, SWT.NONE);
		lblStatus.setText("Status :");
		lblStatus.setBounds(31, 116, 76, 15);
		
		Label lblElectricConsumption = new Label(group, SWT.NONE);
		lblElectricConsumption.setText("Electric Consumption :");
		lblElectricConsumption.setBounds(31, 140, 131, 15);
		
		ref_temp = new Text(group, SWT.BORDER);
		ref_temp.setBounds(168, 60, 76, 21);
		ref_temp.setText("-");
		
		
		ref_mode = new Text(group, SWT.BORDER);
		ref_mode.setBounds(168, 87, 76, 21);
		ref_mode.setText("-");
		
		ref_status = new Text(group, SWT.BORDER);
		ref_status.setBounds(168, 113, 76, 21);
		ref_status.setText("-");
		
		ref_electric = new Text(group, SWT.BORDER);
		ref_electric.setBounds(168, 137, 76, 21);
		ref_electric.setText("-");
		
		Label lblWashingMachine = new Label(group, SWT.NONE);
		lblWashingMachine.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblWashingMachine.setText("Washing Machine");
		lblWashingMachine.setBounds(10, 163, 119, 15);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setText("Temperature :");
		label_4.setBounds(31, 184, 76, 15);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setText("Mode :");
		label_5.setBounds(31, 211, 76, 15);
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setText("Status :");
		label_6.setBounds(31, 237, 76, 15);
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setText("Electric Consumption :");
		label_7.setBounds(31, 261, 131, 15);
		
		wm_temp = new Text(group, SWT.BORDER);
		wm_temp.setText("-");
		wm_temp.setBounds(168, 181, 76, 21);
		
		wm_mode = new Text(group, SWT.BORDER);
		wm_mode.setText("-");
		wm_mode.setBounds(168, 208, 76, 21);
		
		wm_status = new Text(group, SWT.BORDER);
		wm_status.setText("-");
		wm_status.setBounds(168, 234, 76, 21);
		
		wm_electric = new Text(group, SWT.BORDER);
		wm_electric.setText("-");
		wm_electric.setBounds(168, 258, 76, 21);
		
		Label lblDishWasher = new Label(group, SWT.NONE);
		lblDishWasher.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDishWasher.setText("Dish Washer");
		lblDishWasher.setBounds(10, 291, 76, 15);
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setText("Temperature :");
		label_9.setBounds(31, 312, 76, 15);
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setText("Mode :");
		label_10.setBounds(31, 339, 76, 15);
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setText("Status :");
		label_11.setBounds(31, 365, 76, 15);
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setText("Electric Consumption :");
		label_12.setBounds(31, 389, 131, 15);
		
		dw_temp = new Text(group, SWT.BORDER);
		dw_temp.setText("-");
		dw_temp.setBounds(168, 309, 76, 21);
		
		dw_mode = new Text(group, SWT.BORDER);
		dw_mode.setText("-");
		dw_mode.setBounds(168, 336, 76, 21);
		
		dw_status = new Text(group, SWT.BORDER);
		dw_status.setText("-");
		dw_status.setBounds(168, 362, 76, 21);
		
		dw_electric = new Text(group, SWT.BORDER);
		dw_electric.setText("-");
		dw_electric.setBounds(168, 386, 76, 21);
		
		Label label_13 = new Label(group, SWT.NONE);
		label_13.setText("Equipments");
		label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_13.setBounds(265, 18, 76, 15);
		
		Label lblTelevision = new Label(group, SWT.NONE);
		lblTelevision.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblTelevision.setText("Television");
		lblTelevision.setBounds(265, 39, 76, 15);
		
		Label label_15 = new Label(group, SWT.NONE);
		label_15.setText("Temperature :");
		label_15.setBounds(286, 60, 76, 15);
		
		Label label_16 = new Label(group, SWT.NONE);
		label_16.setText("Mode :");
		label_16.setBounds(286, 87, 76, 15);
		
		Label label_17 = new Label(group, SWT.NONE);
		label_17.setText("Status :");
		label_17.setBounds(286, 113, 76, 15);
		
		Label label_18 = new Label(group, SWT.NONE);
		label_18.setText("Electric Consumption :");
		label_18.setBounds(286, 137, 131, 15);
		
		tv_electric = new Text(group, SWT.BORDER);
		tv_electric.setText("-");
		tv_electric.setBounds(423, 134, 76, 21);
		
		tv_status = new Text(group, SWT.BORDER);
		tv_status.setText("-");
		tv_status.setBounds(423, 110, 76, 21);
		
		tv_mode = new Text(group, SWT.BORDER);
		tv_mode.setText("-");
		tv_mode.setBounds(423, 84, 76, 21);
		
		tv_temp = new Text(group, SWT.BORDER);
		tv_temp.setText("-");
		tv_temp.setBounds(423, 57, 76, 21);
		
		Label label_19 = new Label(group, SWT.NONE);
		label_19.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_19.setText("Values");
		label_19.setBounds(423, 18, 76, 15);
		
		Label lblOvenmicrowave = new Label(group, SWT.NONE);
		lblOvenmicrowave.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblOvenmicrowave.setText("Oven/Microwave");
		lblOvenmicrowave.setBounds(265, 160, 119, 15);
		
		Label label_21 = new Label(group, SWT.NONE);
		label_21.setText("Temperature :");
		label_21.setBounds(286, 181, 76, 15);
		
		Label label_22 = new Label(group, SWT.NONE);
		label_22.setText("Mode :");
		label_22.setBounds(286, 208, 76, 15);
		
		Label label_23 = new Label(group, SWT.NONE);
		label_23.setText("Status :");
		label_23.setBounds(286, 234, 76, 15);
		
		Label label_24 = new Label(group, SWT.NONE);
		label_24.setText("Electric Consumption :");
		label_24.setBounds(286, 258, 131, 15);
		
		om_temp = new Text(group, SWT.BORDER);
		om_temp.setText("-");
		om_temp.setBounds(423, 178, 76, 21);
		
		om_mode = new Text(group, SWT.BORDER);
		om_mode.setText("-");
		om_mode.setBounds(423, 205, 76, 21);
		
		om_status = new Text(group, SWT.BORDER);
		om_status.setText("-");
		om_status.setBounds(423, 231, 76, 21);
		
		om_electric = new Text(group, SWT.BORDER);
		om_electric.setText("-");
		om_electric.setBounds(423, 255, 76, 21);
		
		Label lblComputer = new Label(group, SWT.NONE);
		lblComputer.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblComputer.setText("Computer ");
		lblComputer.setBounds(265, 288, 76, 15);
		
		Label label_26 = new Label(group, SWT.NONE);
		label_26.setText("Temperature :");
		label_26.setBounds(286, 309, 76, 15);
		
		Label label_27 = new Label(group, SWT.NONE);
		label_27.setText("Mode :");
		label_27.setBounds(286, 336, 76, 15);
		
		Label label_28 = new Label(group, SWT.NONE);
		label_28.setText("Status :");
		label_28.setBounds(286, 362, 76, 15);
		
		Label label_29 = new Label(group, SWT.NONE);
		label_29.setText("Electric Consumption :");
		label_29.setBounds(286, 386, 131, 15);
		
		comp_temp = new Text(group, SWT.BORDER);
		comp_temp.setText("-");
		comp_temp.setBounds(423, 306, 76, 21);
		
		comp_mode = new Text(group, SWT.BORDER);
		comp_mode.setText("-");
		comp_mode.setBounds(423, 333, 76, 21);
		
		comp_status = new Text(group, SWT.BORDER);
		comp_status.setText("-");
		comp_status.setBounds(423, 359, 76, 21);
		
		comp_electric = new Text(group, SWT.BORDER);
		comp_electric.setText("-");
		comp_electric.setBounds(423, 383, 76, 21);

		
		TabItem tbtmLightingSystem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmLightingSystem_1.setText("Lighting System");
		
		Group grpLightingSystem = new Group(tabFolder, SWT.NONE);
		grpLightingSystem.setText("Lighting System");
		tbtmLightingSystem_1.setControl(grpLightingSystem);
		
		Label label_3 = new Label(grpLightingSystem, SWT.NONE);
		label_3.setText("Equipments");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setBounds(10, 21, 76, 15);
		
		Label label_8 = new Label(grpLightingSystem, SWT.NONE);
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_8.setText("Values");
		label_8.setBounds(168, 21, 76, 15);
		
		Label lblRoom = new Label(grpLightingSystem, SWT.NONE);
		lblRoom.setText("Room1");
		lblRoom.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom.setBounds(10, 42, 76, 15);
		
		Label lblLightSensor = new Label(grpLightingSystem, SWT.NONE);
		lblLightSensor.setText("Status :");
		lblLightSensor.setBounds(31, 63, 76, 15);
		
		room1_light = new Text(grpLightingSystem, SWT.BORDER);
		room1_light.setText("-");
		room1_light.setBounds(168, 60, 76, 21);
		
		Label label_33 = new Label(grpLightingSystem, SWT.NONE);
		label_33.setText("Equipments");
		label_33.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_33.setBounds(276, 21, 76, 15);
		
		Label label_34 = new Label(grpLightingSystem, SWT.NONE);
		label_34.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_34.setText("Values");
		label_34.setBounds(434, 21, 76, 15);
		
		Label lblNewLabel = new Label(grpLightingSystem, SWT.NONE);
		lblNewLabel.setBounds(31, 90, 76, 15);
		lblNewLabel.setText("Illuminance :");
		
		room1_il = new Text(grpLightingSystem, SWT.BORDER);
		room1_il.setText("-");
		room1_il.setBounds(168, 87, 76, 21);
		
		Label lblRoom_1 = new Label(grpLightingSystem, SWT.NONE);
		lblRoom_1.setText("Room2");
		lblRoom_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_1.setBounds(10, 120, 76, 15);
		
		Label label_76 = new Label(grpLightingSystem, SWT.NONE);
		label_76.setText("Status :");
		label_76.setBounds(31, 141, 76, 15);
		
		Label label_77 = new Label(grpLightingSystem, SWT.NONE);
		label_77.setText("Illuminance :");
		label_77.setBounds(31, 168, 76, 15);
		
		room2_light = new Text(grpLightingSystem, SWT.BORDER);
		room2_light.setText("-");
		room2_light.setBounds(168, 138, 76, 21);
		
		room2_il = new Text(grpLightingSystem, SWT.BORDER);
		room2_il.setText("-");
		room2_il.setBounds(168, 165, 76, 21);
		
		Label lblRoom_2 = new Label(grpLightingSystem, SWT.NONE);
		lblRoom_2.setText("Room3");
		lblRoom_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_2.setBounds(10, 200, 76, 15);
		
		Label label_79 = new Label(grpLightingSystem, SWT.NONE);
		label_79.setText("Status :");
		label_79.setBounds(31, 221, 76, 15);
		
		Label label_80 = new Label(grpLightingSystem, SWT.NONE);
		label_80.setText("Illuminance :");
		label_80.setBounds(31, 248, 76, 15);
		
		room3_light = new Text(grpLightingSystem, SWT.BORDER);
		room3_light.setText("-");
		room3_light.setBounds(168, 218, 76, 21);
		
		room3_il = new Text(grpLightingSystem, SWT.BORDER);
		room3_il.setText("-");
		room3_il.setBounds(168, 245, 76, 21);
		
		Label lblRoom_3 = new Label(grpLightingSystem, SWT.NONE);
		lblRoom_3.setText("Room4");
		lblRoom_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_3.setBounds(10, 289, 76, 15);
		
		Label label_82 = new Label(grpLightingSystem, SWT.NONE);
		label_82.setText("Status :");
		label_82.setBounds(31, 310, 76, 15);
		
		Label label_83 = new Label(grpLightingSystem, SWT.NONE);
		label_83.setText("Illuminance :");
		label_83.setBounds(31, 337, 76, 15);
		
		room4_light = new Text(grpLightingSystem, SWT.BORDER);
		room4_light.setText("-");
		room4_light.setBounds(168, 307, 76, 21);
		
		room4_il = new Text(grpLightingSystem, SWT.BORDER);
		room4_il.setText("-");
		room4_il.setBounds(168, 334, 76, 21);
		
		Label lblKitchen = new Label(grpLightingSystem, SWT.NONE);
		lblKitchen.setText("Kitchen");
		lblKitchen.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblKitchen.setBounds(263, 42, 76, 15);
		
		Label label_78 = new Label(grpLightingSystem, SWT.NONE);
		label_78.setText("Status :");
		label_78.setBounds(284, 63, 76, 15);
		
		kitchen_light = new Text(grpLightingSystem, SWT.BORDER);
		kitchen_light.setText("-");
		kitchen_light.setBounds(421, 60, 76, 21);
		
		kitchen_il = new Text(grpLightingSystem, SWT.BORDER);
		kitchen_il.setText("-");
		kitchen_il.setBounds(421, 87, 76, 21);
		
		Label label_81 = new Label(grpLightingSystem, SWT.NONE);
		label_81.setText("Illuminance :");
		label_81.setBounds(284, 90, 76, 15);
		
		Label lblHall = new Label(grpLightingSystem, SWT.NONE);
		lblHall.setText("Hall");
		lblHall.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblHall.setBounds(263, 120, 76, 15);
		
		Label label_85 = new Label(grpLightingSystem, SWT.NONE);
		label_85.setText("Status :");
		label_85.setBounds(284, 141, 76, 15);
		
		Label label_86 = new Label(grpLightingSystem, SWT.NONE);
		label_86.setText("Illuminance :");
		label_86.setBounds(284, 168, 76, 15);
		
		hall_light = new Text(grpLightingSystem, SWT.BORDER);
		hall_light.setText("-");
		hall_light.setBounds(421, 138, 76, 21);
		
		hall_il = new Text(grpLightingSystem, SWT.BORDER);
		hall_il.setText("-");
		hall_il.setBounds(421, 165, 76, 21);
		
		bathroom_light = new Text(grpLightingSystem, SWT.BORDER);
		bathroom_light.setText("-");
		bathroom_light.setBounds(421, 218, 76, 21);
		
		bathroom_il = new Text(grpLightingSystem, SWT.BORDER);
		bathroom_il.setText("-");
		bathroom_il.setBounds(421, 245, 76, 21);
		
		Label label_87 = new Label(grpLightingSystem, SWT.NONE);
		label_87.setText("Illuminance :");
		label_87.setBounds(284, 248, 76, 15);
		
		Label label_88 = new Label(grpLightingSystem, SWT.NONE);
		label_88.setText("Status :");
		label_88.setBounds(284, 221, 76, 15);
		
		Label lblBathroom = new Label(grpLightingSystem, SWT.NONE);
		lblBathroom.setText("Bathroom");
		lblBathroom.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBathroom.setBounds(263, 200, 76, 15);
		
		TabItem tbtmHeatingSystem = new TabItem(tabFolder, SWT.NONE);
		tbtmHeatingSystem.setText("Heating System");
		
		Group grpHeatingSystem = new Group(tabFolder, SWT.NONE);
		grpHeatingSystem.setText("Heating System");
		tbtmHeatingSystem.setControl(grpHeatingSystem);
		
		Label label_20 = new Label(grpHeatingSystem, SWT.NONE);
		label_20.setText("Equipments");
		label_20.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_20.setBounds(10, 20, 76, 15);
		
		Label label_25 = new Label(grpHeatingSystem, SWT.NONE);
		label_25.setText("Values");
		label_25.setBounds(168, 20, 76, 15);
		
		Label lblRoom_4 = new Label(grpHeatingSystem, SWT.NONE);
		lblRoom_4.setText("Room1");
		lblRoom_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_4.setBounds(10, 41, 76, 15);
		
		Label label_35 = new Label(grpHeatingSystem, SWT.NONE);
		label_35.setText("Temperature :");
		label_35.setBounds(31, 62, 76, 15);
		
		room1_temp = new Text(grpHeatingSystem, SWT.BORDER);
		room1_temp.setText("-");
		room1_temp.setBounds(168, 59, 76, 21);
		
		Label label_38 = new Label(grpHeatingSystem, SWT.NONE);
		label_38.setText("Mode :");
		label_38.setBounds(31, 89, 76, 15);
		
		room1_mode = new Text(grpHeatingSystem, SWT.BORDER);
		room1_mode.setText("-");
		room1_mode.setBounds(168, 86, 76, 21);
		
		Label label_39 = new Label(grpHeatingSystem, SWT.NONE);
		label_39.setText("Status :");
		label_39.setBounds(31, 115, 76, 15);
		
		room1_status = new Text(grpHeatingSystem, SWT.BORDER);
		room1_status.setText("-");
		room1_status.setBounds(168, 112, 76, 21);
		
		Label lblRoom_5 = new Label(grpHeatingSystem, SWT.NONE);
		lblRoom_5.setText("Room2");
		lblRoom_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_5.setBounds(10, 136, 76, 15);
		
		Label label_30 = new Label(grpHeatingSystem, SWT.NONE);
		label_30.setText("Temperature :");
		label_30.setBounds(31, 157, 76, 15);
		
		room2_temp = new Text(grpHeatingSystem, SWT.BORDER);
		room2_temp.setText("-");
		room2_temp.setBounds(168, 154, 76, 21);
		
		room2_mode = new Text(grpHeatingSystem, SWT.BORDER);
		room2_mode.setText("-");
		room2_mode.setBounds(168, 181, 76, 21);
		
		room2_status = new Text(grpHeatingSystem, SWT.BORDER);
		room2_status.setText("-");
		room2_status.setBounds(168, 207, 76, 21);
		
		Label label_31 = new Label(grpHeatingSystem, SWT.NONE);
		label_31.setText("Status :");
		label_31.setBounds(31, 210, 76, 15);
		
		Label label_32 = new Label(grpHeatingSystem, SWT.NONE);
		label_32.setText("Mode :");
		label_32.setBounds(31, 184, 76, 15);
		
		Label lblRoom_6 = new Label(grpHeatingSystem, SWT.NONE);
		lblRoom_6.setText("Room3");
		lblRoom_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_6.setBounds(10, 234, 76, 15);
		
		Label label_37 = new Label(grpHeatingSystem, SWT.NONE);
		label_37.setText("Temperature :");
		label_37.setBounds(31, 255, 76, 15);
		
		room3_temp = new Text(grpHeatingSystem, SWT.BORDER);
		room3_temp.setText("-");
		room3_temp.setBounds(168, 252, 76, 21);
		
		room3_mode = new Text(grpHeatingSystem, SWT.BORDER);
		room3_mode.setText("-");
		room3_mode.setBounds(168, 279, 76, 21);
		
		room3_status = new Text(grpHeatingSystem, SWT.BORDER);
		room3_status.setText("-");
		room3_status.setBounds(168, 305, 76, 21);
		
		Label label_40 = new Label(grpHeatingSystem, SWT.NONE);
		label_40.setText("Status :");
		label_40.setBounds(31, 308, 76, 15);
		
		Label label_41 = new Label(grpHeatingSystem, SWT.NONE);
		label_41.setText("Mode :");
		label_41.setBounds(31, 282, 76, 15);
		
		Label lblRoom_7 = new Label(grpHeatingSystem, SWT.NONE);
		lblRoom_7.setText("Room4");
		lblRoom_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_7.setBounds(10, 332, 76, 15);
		
		Label label_43 = new Label(grpHeatingSystem, SWT.NONE);
		label_43.setText("Temperature :");
		label_43.setBounds(31, 353, 76, 15);
		
		room4_temp = new Text(grpHeatingSystem, SWT.BORDER);
		room4_temp.setText("-");
		room4_temp.setBounds(168, 350, 76, 21);
		
		room4_mode = new Text(grpHeatingSystem, SWT.BORDER);
		room4_mode.setText("-");
		room4_mode.setBounds(168, 377, 76, 21);
		
		room4_status = new Text(grpHeatingSystem, SWT.BORDER);
		room4_status.setText("-");
		room4_status.setBounds(168, 403, 76, 21);
		
		Label label_44 = new Label(grpHeatingSystem, SWT.NONE);
		label_44.setText("Status :");
		label_44.setBounds(31, 406, 76, 15);
		
		Label label_45 = new Label(grpHeatingSystem, SWT.NONE);
		label_45.setText("Mode :");
		label_45.setBounds(31, 380, 76, 15);
		
		Label label_14 = new Label(grpHeatingSystem, SWT.NONE);
		label_14.setText("Equipments");
		label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_14.setBounds(265, 20, 76, 15);
		
		Label label_36 = new Label(grpHeatingSystem, SWT.NONE);
		label_36.setText("Values");
		label_36.setBounds(423, 20, 76, 15);
		
		Label lblKitchen_1 = new Label(grpHeatingSystem, SWT.NONE);
		lblKitchen_1.setText("Kitchen");
		lblKitchen_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblKitchen_1.setBounds(265, 41, 76, 15);
		
		Label label_46 = new Label(grpHeatingSystem, SWT.NONE);
		label_46.setText("Temperature :");
		label_46.setBounds(286, 62, 76, 15);
		
		kitchen_temp = new Text(grpHeatingSystem, SWT.BORDER);
		kitchen_temp.setText("-");
		kitchen_temp.setBounds(423, 59, 76, 21);
		
		kitchen_mode = new Text(grpHeatingSystem, SWT.BORDER);
		kitchen_mode.setText("-");
		kitchen_mode.setBounds(423, 86, 76, 21);
		
		Label label_47 = new Label(grpHeatingSystem, SWT.NONE);
		label_47.setText("Mode :");
		label_47.setBounds(286, 89, 76, 15);
		
		kitchen_status = new Text(grpHeatingSystem, SWT.BORDER);
		kitchen_status.setText("-");
		kitchen_status.setBounds(423, 112, 76, 21);
		
		Label label_48 = new Label(grpHeatingSystem, SWT.NONE);
		label_48.setText("Status :");
		label_48.setBounds(286, 115, 76, 15);
		
		hall_temp = new Text(grpHeatingSystem, SWT.BORDER);
		hall_temp.setText("-");
		hall_temp.setBounds(423, 154, 76, 21);
		
		Label lblHall_1 = new Label(grpHeatingSystem, SWT.NONE);
		lblHall_1.setText("Hall");
		lblHall_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblHall_1.setBounds(265, 136, 76, 15);
		
		Label label_50 = new Label(grpHeatingSystem, SWT.NONE);
		label_50.setText("Temperature :");
		label_50.setBounds(286, 157, 76, 15);
		
		Label label_51 = new Label(grpHeatingSystem, SWT.NONE);
		label_51.setText("Mode :");
		label_51.setBounds(286, 184, 76, 15);
		
		hall_mode = new Text(grpHeatingSystem, SWT.BORDER);
		hall_mode.setText("-");
		hall_mode.setBounds(423, 181, 76, 21);
		
		hall_status = new Text(grpHeatingSystem, SWT.BORDER);
		hall_status.setText("-");
		hall_status.setBounds(423, 207, 76, 21);
		
		Label label_52 = new Label(grpHeatingSystem, SWT.NONE);
		label_52.setText("Status :");
		label_52.setBounds(286, 210, 76, 15);
		
		Label lblBathroom_1 = new Label(grpHeatingSystem, SWT.NONE);
		lblBathroom_1.setText("Bathroom");
		lblBathroom_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBathroom_1.setBounds(265, 234, 76, 15);
		
		Label label_54 = new Label(grpHeatingSystem, SWT.NONE);
		label_54.setText("Temperature :");
		label_54.setBounds(286, 255, 76, 15);
		
		Label label_55 = new Label(grpHeatingSystem, SWT.NONE);
		label_55.setText("Mode :");
		label_55.setBounds(286, 282, 76, 15);
		
		Label label_56 = new Label(grpHeatingSystem, SWT.NONE);
		label_56.setText("Status :");
		label_56.setBounds(286, 308, 76, 15);
		
		bathroom_status = new Text(grpHeatingSystem, SWT.BORDER);
		bathroom_status.setText("-");
		bathroom_status.setBounds(423, 305, 76, 21);
		
		bathroom_mode = new Text(grpHeatingSystem, SWT.BORDER);
		bathroom_mode.setText("-");
		bathroom_mode.setBounds(423, 279, 76, 21);
		
		bathroom_temp = new Text(grpHeatingSystem, SWT.BORDER);
		bathroom_temp.setText("-");
		bathroom_temp.setBounds(423, 252, 76, 21);
		
		TabItem tbtmLightingSystem = new TabItem(tabFolder, SWT.NONE);
		tbtmLightingSystem.setText("Security System");
		
		Group grpSecuritySystem = new Group(tabFolder, SWT.NONE);
		grpSecuritySystem.setText("Security System");
		tbtmLightingSystem.setControl(grpSecuritySystem);
		
		Label label_42 = new Label(grpSecuritySystem, SWT.NONE);
		label_42.setText("Equipments");
		label_42.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_42.setBounds(10, 24, 76, 15);
		
		Label label_49 = new Label(grpSecuritySystem, SWT.NONE);
		label_49.setText("Room1");
		label_49.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_49.setBounds(10, 45, 76, 15);
		
		Label label_53 = new Label(grpSecuritySystem, SWT.NONE);
		label_53.setText("Status :");
		label_53.setBounds(31, 66, 76, 15);
		
		room1_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		room1_sstatus.setText("-");
		room1_sstatus.setBounds(168, 63, 76, 21);
		
		Label label_57 = new Label(grpSecuritySystem, SWT.NONE);
		label_57.setText("Values");
		label_57.setBounds(168, 24, 76, 15);
		
		Label label_70 = new Label(grpSecuritySystem, SWT.NONE);
		label_70.setText("Equipments");
		label_70.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_70.setBounds(276, 24, 76, 15);
		
		Label label_71 = new Label(grpSecuritySystem, SWT.NONE);
		label_71.setText("Values");
		label_71.setBounds(434, 24, 76, 15);
		
		Label lblMode_1 = new Label(grpSecuritySystem, SWT.NONE);
		lblMode_1.setText("Mode :");
		lblMode_1.setBounds(31, 90, 76, 15);
		
		room1_smode = new Text(grpSecuritySystem, SWT.BORDER);
		room1_smode.setText("-");
		room1_smode.setBounds(168, 87, 76, 21);
		
		Label label_58 = new Label(grpSecuritySystem, SWT.NONE);
		label_58.setText("Status :");
		label_58.setBounds(31, 128, 76, 15);
		
		Label label_59 = new Label(grpSecuritySystem, SWT.NONE);
		label_59.setText("Mode :");
		label_59.setBounds(31, 152, 76, 15);
		
		room2_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		room2_sstatus.setText("-");
		room2_sstatus.setBounds(168, 125, 76, 21);
		
		room2_smode = new Text(grpSecuritySystem, SWT.BORDER);
		room2_smode.setText("-");
		room2_smode.setBounds(168, 149, 76, 21);
		
		Label lblRoom_8 = new Label(grpSecuritySystem, SWT.NONE);
		lblRoom_8.setText("Room2");
		lblRoom_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_8.setBounds(10, 107, 76, 15);
		
		Label label_61 = new Label(grpSecuritySystem, SWT.NONE);
		label_61.setText("Status :");
		label_61.setBounds(31, 195, 76, 15);
		
		Label label_62 = new Label(grpSecuritySystem, SWT.NONE);
		label_62.setText("Mode :");
		label_62.setBounds(31, 219, 76, 15);
		
		room3_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		room3_sstatus.setText("-");
		room3_sstatus.setBounds(168, 192, 76, 21);
		
		room3_smode = new Text(grpSecuritySystem, SWT.BORDER);
		room3_smode.setText("-");
		room3_smode.setBounds(168, 216, 76, 21);
		
		Label lblRoom_9 = new Label(grpSecuritySystem, SWT.NONE);
		lblRoom_9.setText("Room3");
		lblRoom_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_9.setBounds(10, 174, 76, 15);
		
		Label label_73 = new Label(grpSecuritySystem, SWT.NONE);
		label_73.setText("Status :");
		label_73.setBounds(31, 257, 76, 15);
		
		Label label_74 = new Label(grpSecuritySystem, SWT.NONE);
		label_74.setText("Mode :");
		label_74.setBounds(31, 281, 76, 15);
		
		room4_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		room4_sstatus.setText("-");
		room4_sstatus.setBounds(168, 254, 76, 21);
		
		room4_smode = new Text(grpSecuritySystem, SWT.BORDER);
		room4_smode.setText("-");
		room4_smode.setBounds(168, 278, 76, 21);
		
		Label lblRoom_10 = new Label(grpSecuritySystem, SWT.NONE);
		lblRoom_10.setText("Room4");
		lblRoom_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_10.setBounds(10, 236, 76, 15);
		
		Label label_89 = new Label(grpSecuritySystem, SWT.NONE);
		label_89.setText("Status :");
		label_89.setBounds(31, 328, 76, 15);
		
		Label label_90 = new Label(grpSecuritySystem, SWT.NONE);
		label_90.setText("Mode :");
		label_90.setBounds(31, 352, 76, 15);
		
		water_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		water_sstatus.setText("-");
		water_sstatus.setBounds(168, 325, 76, 21);
		
		water_smode = new Text(grpSecuritySystem, SWT.BORDER);
		water_smode.setText("-");
		water_smode.setBounds(168, 349, 76, 21);
		
		Label lblWater = new Label(grpSecuritySystem, SWT.NONE);
		lblWater.setText("Water");
		lblWater.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblWater.setBounds(10, 307, 76, 15);
		
		Label lblKitchen_2 = new Label(grpSecuritySystem, SWT.NONE);
		lblKitchen_2.setText("Kitchen");
		lblKitchen_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblKitchen_2.setBounds(263, 45, 76, 15);
		
		Label label_63 = new Label(grpSecuritySystem, SWT.NONE);
		label_63.setText("Status :");
		label_63.setBounds(284, 66, 76, 15);
		
		Label label_64 = new Label(grpSecuritySystem, SWT.NONE);
		label_64.setText("Mode :");
		label_64.setBounds(284, 90, 76, 15);
		
		kitchen_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		kitchen_sstatus.setText("-");
		kitchen_sstatus.setBounds(421, 63, 76, 21);
		
		kitchen_smode = new Text(grpSecuritySystem, SWT.BORDER);
		kitchen_smode.setText("-");
		kitchen_smode.setBounds(421, 87, 76, 21);
		
		Label lblHall_2 = new Label(grpSecuritySystem, SWT.NONE);
		lblHall_2.setText("Hall");
		lblHall_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblHall_2.setBounds(263, 107, 76, 15);
		
		Label label_66 = new Label(grpSecuritySystem, SWT.NONE);
		label_66.setText("Status :");
		label_66.setBounds(284, 128, 76, 15);
		
		Label label_67 = new Label(grpSecuritySystem, SWT.NONE);
		label_67.setText("Mode :");
		label_67.setBounds(284, 152, 76, 15);
		
		hall_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		hall_sstatus.setText("-");
		hall_sstatus.setBounds(421, 125, 76, 21);
		
		hall_smode = new Text(grpSecuritySystem, SWT.BORDER);
		hall_smode.setText("-");
		hall_smode.setBounds(421, 149, 76, 21);
		
		Label lblBathroom_2 = new Label(grpSecuritySystem, SWT.NONE);
		lblBathroom_2.setText("Bathroom");
		lblBathroom_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBathroom_2.setBounds(263, 174, 76, 15);
		
		Label label_69 = new Label(grpSecuritySystem, SWT.NONE);
		label_69.setText("Status :");
		label_69.setBounds(284, 195, 76, 15);
		
		bathroom_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		bathroom_sstatus.setText("-");
		bathroom_sstatus.setBounds(421, 192, 76, 21);
		
		bathroom_smode = new Text(grpSecuritySystem, SWT.BORDER);
		bathroom_smode.setText("-");
		bathroom_smode.setBounds(421, 216, 76, 21);
		
		Label label_72 = new Label(grpSecuritySystem, SWT.NONE);
		label_72.setText("Mode :");
		label_72.setBounds(284, 219, 76, 15);
		
		Label lblElectricity = new Label(grpSecuritySystem, SWT.NONE);
		lblElectricity.setText("Electricity");
		lblElectricity.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblElectricity.setBounds(263, 236, 76, 15);
		
		Label label_84 = new Label(grpSecuritySystem, SWT.NONE);
		label_84.setText("Status :");
		label_84.setBounds(284, 257, 76, 15);
		
		Label label_91 = new Label(grpSecuritySystem, SWT.NONE);
		label_91.setText("Mode :");
		label_91.setBounds(284, 281, 76, 15);
		
		electricity_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		electricity_sstatus.setText("-");
		electricity_sstatus.setBounds(421, 254, 76, 21);
		
		electricity_smode = new Text(grpSecuritySystem, SWT.BORDER);
		electricity_smode.setText("-");
		electricity_smode.setBounds(421, 278, 76, 21);
		
		gas_sstatus = new Text(grpSecuritySystem, SWT.BORDER);
		gas_sstatus.setText("-");
		gas_sstatus.setBounds(421, 325, 76, 21);
		
		gas_smode = new Text(grpSecuritySystem, SWT.BORDER);
		gas_smode.setText("-");
		gas_smode.setBounds(421, 349, 76, 21);
		
		Label label_92 = new Label(grpSecuritySystem, SWT.NONE);
		label_92.setText("Mode :");
		label_92.setBounds(284, 352, 76, 15);
		
		Label label_93 = new Label(grpSecuritySystem, SWT.NONE);
		label_93.setText("Status :");
		label_93.setBounds(284, 328, 76, 15);
		
		Label lblGas = new Label(grpSecuritySystem, SWT.NONE);
		lblGas.setText("Gas");
		lblGas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblGas.setBounds(263, 307, 76, 15);

	}
	
	public void SendCommand(final String system,final String module, final String command, final String parameter)
	{
		String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "password");
        String host = env("ACTIVEMQ_HOST", "localhost");
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
        
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);

        Connection connection = null;
		try {
			connection = factory.createConnection(user, password);
			connection.start();
	        
			if(system.equalsIgnoreCase("HA")){
				session_mc_ha = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        dest_mc_ha = session_mc_ha.createQueue("MC_HA.FOO");
		        producer_mc_ha = session_mc_ha.createProducer(dest_mc_ha);
		        producer_mc_ha.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
			else if(system.equalsIgnoreCase("LS")){
				session_mc_ls = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        dest_mc_ls = session_mc_ls.createQueue("MC_LS.FOO");
		        producer_mc_ls = session_mc_ls.createProducer(dest_mc_ls);
		        producer_mc_ls.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
			else if(system.equalsIgnoreCase("HS")){
				session_mc_hs = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        dest_mc_hs = session_mc_hs.createQueue("MC_HS.FOO");
		        producer_mc_hs = session_mc_hs.createProducer(dest_mc_hs);
		        producer_mc_hs.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
			else if(system.equalsIgnoreCase("SS")){
				session_mc_ss = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        dest_mc_ss = session_mc_ss.createQueue("MC_SS.FOO");
		        producer_mc_ss = session_mc_ss.createProducer(dest_mc_ss);
		        producer_mc_ss.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
   
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
       
       

    	// Create a messages
		//HomeAppliances newHomeAppliances=new HomeAppliances();
        //while(true){
        	
        	/*if(isScenario=="false"){ 
        		newHomeAppliances.SetSonsors();
           	} 
        	else{
        		newHomeAppliances.Scenario();
        			// newHomeAppliances.DosyadanOku();
        			
        	}*/
        	
			if(system.equalsIgnoreCase("HA")){
				text_mc_ha = module+" "+command+" "+parameter;
				UpdateInfo(display,lblInfo,"Sending Message: "+text_mc_ha);
	        	TextMessage message_mc_ha;
	        	try {
	        		message_mc_ha = session_mc_ha.createTextMessage(text_mc_ha);    		
	        		System.out.println("Message Sending");
					producer_mc_ha.send(message_mc_ha);
		            try {
				          Thread.sleep(10);
				        } catch(InterruptedException e) {
				        }
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else if(system.equalsIgnoreCase("LS")){
				text_mc_ls = module+" "+command+" "+parameter;
				UpdateInfo(display,lblInfo,"Sending Message: "+text_mc_ls);
	        	TextMessage message_mc_ls;
	        	try {
	        		message_mc_ls = session_mc_ls.createTextMessage(text_mc_ls);    		
	        		System.out.println("Message Sending");
					producer_mc_ls.send(message_mc_ls);
		            try {
				          Thread.sleep(10);
				        } catch(InterruptedException e) {
				        }
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else if(system.equalsIgnoreCase("HS")){
				text_mc_hs = module+" "+command+" "+parameter;
				UpdateInfo(display,lblInfo,"Sending Message: "+text_mc_hs);
	        	TextMessage message_mc_hs;
	        	try {
	        		message_mc_hs = session_mc_hs.createTextMessage(text_mc_hs);    		
	        		System.out.println("Message Sending");
					producer_mc_hs.send(message_mc_hs);
		            try {
				          Thread.sleep(10);
				        } catch(InterruptedException e) {
				        }
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else if(system.equalsIgnoreCase("SS")){
				text_mc_ss = module+" "+command+" "+parameter;
				UpdateInfo(display,lblInfo,"Sending Message: "+text_mc_ss);
	        	TextMessage message_mc_ss;
	        	try {
	        		message_mc_ss = session_mc_ss.createTextMessage(text_mc_ss);    		
	        		System.out.println("Message Sending");
					producer_mc_ss.send(message_mc_ss);
		            try {
				          Thread.sleep(10);
				        } catch(InterruptedException e) {
				        }
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			
        //}
        
        //producer.send(session.createTextMessage("SHUTDOWN"));
        /*try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//}
	}
	private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

    
}
