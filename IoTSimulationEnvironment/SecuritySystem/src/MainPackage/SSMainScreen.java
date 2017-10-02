package MainPackage;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;


public class SSMainScreen {

	protected Shell shlSecuritySystem;
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
	public static Display display;
	public static Button btnStart;
	public static Button btnStop;
	public static Button btnScenario;
	public static Label lblInfo;
	
	public static String string_room1_sstatus;
	public static String string_room1_smode;
	public static String string_room2_sstatus;
	public static String string_room2_smode;
	public static String string_room3_sstatus;
	public static String string_room3_smode;
	public static String string_room4_sstatus;
	public static String string_room4_smode;
	public static String string_kitchen_sstatus;
	public static String string_kitchen_smode;
	public static String string_hall_sstatus;
	public static String string_hall_smode;
	public static String string_bathroom_sstatus;
	public static String string_bathroom_smode;
	public static String string_water_sstatus;
	public static String string_water_smode;
	public static String string_gas_sstatus;
	public static String string_gas_smode;
	public static String string_elec_sstatus;
	public static String string_elec_smode;

	public static String isRunning;
	public static String isScenario;
	public static int i;
	public static int stat=1;
	
	
	public static StringTokenizer st = null;
	public static String module=null;
    public static String command=null;
    public static String parameter=null;
    public static String total=null;
    
   
    
   

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SSMainScreen window = new SSMainScreen();
			window.open();
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
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		 Listener listener = new Listener() {
		        public void handleEvent(Event event) {
		          if (event.widget == btnStart) {
		            //response[0] = true;
		        	  isScenario="false";
		        	  lblInfo.setText("Home Appliance System started!");
		        	  isRunning="true";
		        	  SecurityThread1 SThread1 = new SecurityThread1();
		      	      Thread t = new Thread(SThread1);
		      	      t.start();
		          } else if (event.widget == btnStop) {
		        	  lblInfo.setText("Home Appliance System stopped!");
		        	  isRunning="false";
		        	  isScenario="false";
		        	  module=null;
					  command=null;
					  parameter=null;
					  stat=1;
		            //response[0] = false;
		          }else if (event.widget == btnScenario) {
		        	  lblInfo.setText("Scenario is started!");
		        	  isRunning="true";
		        	  isScenario="true";
		        	  SecurityThread1 SThread2 = new SecurityThread1();
		      	      Thread t2 = new Thread(SThread2);
		      	      t2.start();
		      	      ListeningThread listeningThread5 = new ListeningThread();
		        	  Thread t3 = new Thread(listeningThread5);
		      	      t3.start();
		          }
		          else{
		        	  
		          }
		          //dialog.close();
		        }
		      };
		      
		    btnStart.addListener(SWT.Selection, listener);
		    btnStop.addListener(SWT.Selection, listener);
		    btnScenario.addListener(SWT.Selection, listener);
		
		
		shlSecuritySystem.open();
		shlSecuritySystem.layout();
		while (!shlSecuritySystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSecuritySystem = new Shell();
		shlSecuritySystem.setSize(568, 510);
		shlSecuritySystem.setText("Security System");
		
		Group grpSecuritySystem = new Group(shlSecuritySystem, SWT.NONE);
		grpSecuritySystem.setText("Security System");
		grpSecuritySystem.setBounds(10, 10, 537, 395);
		
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
		
		btnStop = new Button(shlSecuritySystem, SWT.NONE);
		btnStop.setBounds(472, 411, 75, 25);
		btnStop.setText("Stop");
		
		btnStart = new Button(shlSecuritySystem, SWT.NONE);
		btnStart.setBounds(391, 411, 75, 25);
		btnStart.setText("Start");
		
		btnScenario = new Button(shlSecuritySystem, SWT.NONE);
		btnScenario.setBounds(310, 411, 75, 25);
		btnScenario.setText("Scenario");
		
		lblInfo = new Label(shlSecuritySystem, SWT.NONE);
		lblInfo.setBounds(10, 447, 532, 15);


	}

}
