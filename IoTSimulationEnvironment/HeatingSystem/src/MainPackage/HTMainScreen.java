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

public class HTMainScreen {

	protected Shell shlHeatingSystem;
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
	public static Button btnStart;
	public static Button btnStop;
	public static Button btnScenario;
	public static Label lblInfo;
	
	public static String string_room1_temp;
	public static String string_room1_mode;
	public static String string_room1_status;
	public static String string_room2_temp;
	public static String string_room2_mode;
	public static String string_room2_status;
	public static String string_room3_temp;
	public static String string_room3_mode;
	public static String string_room3_status;
	public static String string_room4_status;
	public static String string_room4_mode;
	public static String string_room4_temp;
	public static String string_kitchen_temp;
	public static String string_kitchen_mode;
	public static String string_kitchen_status;
	public static String string_hall_temp;
	public static String string_hall_mode;
	public static String string_hall_status;
	public static String string_bathroom_temp;
	public static String string_bathroom_mode;
	public static String string_bathroom_status;
	public static String isRunning;
	public static String isScenario;
	public static int i;
	public static int stat=1;
	
	public static StringTokenizer st = null;
	public static String module=null;
    public static String command=null;
    public static String parameter=null;
    public static String total=null;
    
    public static int room2_temp_value=0;
    public static String room2_mode_value=null;
    public static String room2_status_value=null;
    public static int room2_electric_value=0;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HTMainScreen window = new HTMainScreen();
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
		        	  HeatingThread1 HThread1 = new HeatingThread1();
		      	      Thread t = new Thread(HThread1);
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
		        	  HeatingThread1 HThread2 = new HeatingThread1();
		      	      Thread t2 = new Thread(HThread2);
		      	      t2.start();
		      	      ListeningThread listeningThread3 = new ListeningThread();
		        	  Thread t3 = new Thread(listeningThread3);
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
		
		
		
		shlHeatingSystem.open();
		shlHeatingSystem.layout();
		while (!shlHeatingSystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHeatingSystem = new Shell();
		shlHeatingSystem.setSize(555, 561);
		shlHeatingSystem.setText("Heating System");
		
		Group grpHeatingSystem = new Group(shlHeatingSystem, SWT.NONE);
		grpHeatingSystem.setText("Heating System");
		grpHeatingSystem.setBounds(10, 10, 519, 448);
		
		Label label_20 = new Label(grpHeatingSystem, SWT.NONE);
		label_20.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_20.setText("Equipments");
		
		label_20.setBounds(10, 20, 76, 15);
		
		Label label_25 = new Label(grpHeatingSystem, SWT.NONE);
		label_25.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_25.setText("Values");
		label_25.setBounds(168, 20, 76, 15);
		
		Label lblRoom_4 = new Label(grpHeatingSystem, SWT.NONE);
		lblRoom_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_4.setText("Room1");
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
		lblRoom_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_5.setText("Room2");
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
		lblRoom_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_6.setText("Room3");
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
		lblRoom_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRoom_7.setText("Room4");
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
		label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_14.setText("Equipments");
		label_14.setBounds(265, 20, 76, 15);
		
		Label label_36 = new Label(grpHeatingSystem, SWT.NONE);
		label_36.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_36.setText("Values");
		label_36.setBounds(423, 20, 76, 15);
		
		Label lblKitchen_1 = new Label(grpHeatingSystem, SWT.NONE);
		lblKitchen_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblKitchen_1.setText("Kitchen");
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
		lblHall_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblHall_1.setText("Hall");
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
		lblBathroom_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBathroom_1.setText("Bathroom");
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
		
		btnStop = new Button(shlHeatingSystem, SWT.NONE);
		btnStop.setBounds(454, 470, 75, 25);
		btnStop.setText("Stop");
		
		btnStart = new Button(shlHeatingSystem, SWT.NONE);
		btnStart.setBounds(373, 470, 75, 25);
		btnStart.setText("Start");
		
		btnScenario = new Button(shlHeatingSystem, SWT.NONE);
		btnScenario.setBounds(292, 470, 75, 25);
		btnScenario.setText("Scenario");
		
		lblInfo = new Label(shlHeatingSystem, SWT.NONE);
		lblInfo.setBounds(10, 498, 519, 15);

	}

}
