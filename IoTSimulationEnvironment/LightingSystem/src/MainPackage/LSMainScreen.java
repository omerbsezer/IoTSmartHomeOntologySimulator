package MainPackage;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class LSMainScreen {

	protected Shell shlLightingSystem;
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
	public static Display display;
	public static Button btnStart;
	public static Button btnStop;
	public static Button btnScenario;
	public static Label lblInfo;
	
	public static String string_room1_light;
	public static String string_room1_il;
	public static String string_room2_light;
	public static String string_room2_il;
	public static String string_room3_light;
	public static String string_room3_il;
	public static String string_room4_light;
	public static String string_room4_il;
	public static String string_kitchen_light;
	public static String string_kitchen_il;
	public static String string_hall_light;
	public static String string_hall_il;
	public static String string_bathroom_light;
	public static String string_bathroom_il;
	
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
			LSMainScreen window = new LSMainScreen();
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
	        	  lblInfo.setText("Lighting System started!");
	        	  isRunning="true";
	        	  LightThread1 LThread1 = new LightThread1();
	        	  Thread t = new Thread(LThread1);
	      	      t.start();
	          } else if (event.widget == btnStop) {
	        	  lblInfo.setText("Lighting System stopped!");
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
	        	  LightThread1 LThread2 = new LightThread1();
	        	  Thread t2 = new Thread(LThread2);
	      	      t2.start();
	      	      ListeningThread listeningThread2 = new ListeningThread();
	        	  Thread t3 = new Thread(listeningThread2);
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
		
		
		
		shlLightingSystem.open();
		shlLightingSystem.layout();
		while (!shlLightingSystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLightingSystem = new Shell();
		shlLightingSystem.setSize(571, 501);
		shlLightingSystem.setText("Lighting System");
		
		Group grpLightingSystem = new Group(shlLightingSystem, SWT.NONE);
		grpLightingSystem.setText("Lighting System");
		grpLightingSystem.setBounds(10, 10, 538, 386);
		
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
		
		btnStop = new Button(shlLightingSystem, SWT.NONE);
		btnStop.setBounds(473, 402, 75, 25);
		btnStop.setText("Stop");
		
		btnStart = new Button(shlLightingSystem, SWT.NONE);
		btnStart.setBounds(395, 402, 75, 25);
		btnStart.setText("Start");
		
		btnScenario = new Button(shlLightingSystem, SWT.NONE);
		btnScenario.setBounds(314, 402, 75, 25);
		btnScenario.setText("Scenario");
		
		lblInfo = new Label(shlLightingSystem, SWT.NONE);
		lblInfo.setBounds(10, 438, 535, 15);

	}
}
