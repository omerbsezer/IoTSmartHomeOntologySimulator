package MainPackage;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class HAMainScreen {

	protected Shell shlHomeAppliances;
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
	public static Button btnStart;
	public static Button btnStop;
	public static Button btnScenario;
	public static Label lblInfo;
	
	public static String string_ref_temp;
	public static String string_ref_mode;
	public static String string_ref_status;
	public static String string_ref_electric;
	public static String string_wm_temp;
	public static String string_wm_mode;
	public static String string_wm_status;
	public static String string_wm_electric;
	public static String string_dw_temp;
	public static String string_dw_mode;
	public static String string_dw_status;
	public static String string_dw_electric;
	public static String string_tv_electric;
	public static String string_tv_status;
	public static String string_tv_mode;
	public static String string_tv_temp;
	public static String string_om_temp;
	public static String string_om_mode;
	public static String string_om_status;
	public static String string_om_electric;
	public static String string_comp_temp;
	public static String string_comp_mode;
	public static String string_comp_status;
	public static String string_comp_electric;
	public static String isRunning;
	public static String isScenario;
	public static int i;
	public static int stat=1;
	
	
	public static StringTokenizer st = null;
	public static String module=null;
    public static String command=null;
    public static String parameter=null;
    public static String total=null;
    
    public static int ref_temp_value=0;
    public static String ref_mode_value=null;
    public static String ref_status_value=null;
    public static int ref_electric_value=0;
    
    

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HAMainScreen window = new HAMainScreen();
			//publisher();
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
	        	  RefTemp HAref = new RefTemp();
	        	  Thread t = new Thread(HAref);
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
	        	  RefTemp HAref2 = new RefTemp();
	        	  Thread t2 = new Thread(HAref2);
	      	      t2.start();
	      	      ListeningThread listeningThread = new ListeningThread();
	        	  Thread t3 = new Thread(listeningThread);
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
	      
		shlHomeAppliances.open();
		shlHomeAppliances.layout();
		while (!shlHomeAppliances.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHomeAppliances = new Shell();
		shlHomeAppliances.setSize(569, 546);
		shlHomeAppliances.setText("Home Appliances");
		
		Group group = new Group(shlHomeAppliances, SWT.NONE);
		group.setText("Home Appliances");
		group.setBounds(10, 10, 533, 437);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setText("Values");
		label_1.setBounds(168, 21, 76, 15);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_2.setText("Refrigerator");
		label_2.setBounds(10, 42, 76, 15);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("Temperature :");
		label_3.setBounds(31, 63, 76, 15);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setText("Mode :");
		label_4.setBounds(31, 90, 76, 15);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setText("Status :");
		label_5.setBounds(31, 116, 76, 15);
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setText("Electric Consumption :");
		label_6.setBounds(31, 140, 131, 15);
		
		ref_temp = new Text(group, SWT.BORDER);
		ref_temp.setText("-");
		ref_temp.setBounds(168, 60, 76, 21);
		
		ref_mode = new Text(group, SWT.BORDER);
		ref_mode.setText("-");
		ref_mode.setBounds(168, 87, 76, 21);
		
		ref_status = new Text(group, SWT.BORDER);
		ref_status.setText("-");
		ref_status.setBounds(168, 113, 76, 21);
		
		ref_electric = new Text(group, SWT.BORDER);
		ref_electric.setText("-");
		ref_electric.setBounds(168, 137, 76, 21);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Equipments");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setBounds(10, 21, 76, 15);
		
		Label lblWashingMachine = new Label(group, SWT.NONE);
		lblWashingMachine.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblWashingMachine.setText("Washing Machine");
		lblWashingMachine.setBounds(10, 164, 131, 15);
		
		Label label_8 = new Label(group, SWT.NONE);
		label_8.setText("Temperature :");
		label_8.setBounds(31, 185, 76, 15);
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setText("Mode :");
		label_9.setBounds(31, 212, 76, 15);
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setText("Status :");
		label_10.setBounds(31, 238, 76, 15);
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setText("Electric Consumption :");
		label_11.setBounds(31, 262, 131, 15);
		
		wm_electric = new Text(group, SWT.BORDER);
		wm_electric.setText("-");
		wm_electric.setBounds(168, 259, 76, 21);
		
		wm_status = new Text(group, SWT.BORDER);
		wm_status.setText("-");
		wm_status.setBounds(168, 235, 76, 21);
		
		wm_mode = new Text(group, SWT.BORDER);
		wm_mode.setText("-");
		wm_mode.setBounds(168, 209, 76, 21);
		
		wm_temp = new Text(group, SWT.BORDER);
		wm_temp.setText("-");
		wm_temp.setBounds(168, 182, 76, 21);
		
		Label lblDishWasher = new Label(group, SWT.NONE);
		lblDishWasher.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDishWasher.setText("Dish Washer");
		lblDishWasher.setBounds(10, 286, 76, 15);
		
		Label label_13 = new Label(group, SWT.NONE);
		label_13.setText("Temperature :");
		label_13.setBounds(31, 307, 76, 15);
		
		Label label_14 = new Label(group, SWT.NONE);
		label_14.setText("Mode :");
		label_14.setBounds(31, 334, 76, 15);
		
		Label label_15 = new Label(group, SWT.NONE);
		label_15.setText("Status :");
		label_15.setBounds(31, 360, 76, 15);
		
		Label label_16 = new Label(group, SWT.NONE);
		label_16.setText("Electric Consumption :");
		label_16.setBounds(31, 384, 131, 15);
		
		dw_electric = new Text(group, SWT.BORDER);
		dw_electric.setText("-");
		dw_electric.setBounds(168, 381, 76, 21);
		
		dw_status = new Text(group, SWT.BORDER);
		dw_status.setText("-");
		dw_status.setBounds(168, 357, 76, 21);
		
		dw_mode = new Text(group, SWT.BORDER);
		dw_mode.setText("-");
		dw_mode.setBounds(168, 331, 76, 21);
		
		dw_temp = new Text(group, SWT.BORDER);
		dw_temp.setText("-");
		dw_temp.setBounds(168, 304, 76, 21);
		
		Label lblTelevision = new Label(group, SWT.NONE);
		lblTelevision.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblTelevision.setText("Television");
		lblTelevision.setBounds(272, 42, 76, 15);
		
		Label label_19 = new Label(group, SWT.NONE);
		label_19.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_19.setText("Values");
		label_19.setBounds(430, 21, 76, 15);
		
		tv_temp = new Text(group, SWT.BORDER);
		tv_temp.setText("-");
		tv_temp.setBounds(430, 60, 76, 21);
		
		tv_mode = new Text(group, SWT.BORDER);
		tv_mode.setText("-");
		tv_mode.setBounds(430, 87, 76, 21);
		
		tv_status = new Text(group, SWT.BORDER);
		tv_status.setText("-");
		tv_status.setBounds(430, 113, 76, 21);
		
		tv_electric = new Text(group, SWT.BORDER);
		tv_electric.setText("-");
		tv_electric.setBounds(430, 137, 76, 21);
		
		Label label_20 = new Label(group, SWT.NONE);
		label_20.setText("Electric Consumption :");
		label_20.setBounds(293, 140, 131, 15);
		
		Label label_21 = new Label(group, SWT.NONE);
		label_21.setText("Status :");
		label_21.setBounds(293, 116, 76, 15);
		
		Label label_22 = new Label(group, SWT.NONE);
		label_22.setText("Mode :");
		label_22.setBounds(293, 90, 76, 15);
		
		Label label_23 = new Label(group, SWT.NONE);
		label_23.setText("Temperature :");
		label_23.setBounds(293, 63, 76, 15);
		
		Label lblOvenMicrovawe = new Label(group, SWT.NONE);
		lblOvenMicrovawe.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblOvenMicrovawe.setText("Oven / Microvawe");
		lblOvenMicrovawe.setBounds(272, 164, 131, 15);
		
		Label label_25 = new Label(group, SWT.NONE);
		label_25.setText("Temperature :");
		label_25.setBounds(293, 185, 76, 15);
		
		Label label_26 = new Label(group, SWT.NONE);
		label_26.setText("Mode :");
		label_26.setBounds(293, 212, 76, 15);
		
		Label label_27 = new Label(group, SWT.NONE);
		label_27.setText("Status :");
		label_27.setBounds(293, 238, 76, 15);
		
		Label label_28 = new Label(group, SWT.NONE);
		label_28.setText("Electric Consumption :");
		label_28.setBounds(293, 262, 131, 15);
		
		om_electric = new Text(group, SWT.BORDER);
		om_electric.setText("-");
		om_electric.setBounds(430, 259, 76, 21);
		
		om_status = new Text(group, SWT.BORDER);
		om_status.setText("-");
		om_status.setBounds(430, 235, 76, 21);
		
		om_mode = new Text(group, SWT.BORDER);
		om_mode.setText("-");
		om_mode.setBounds(430, 209, 76, 21);
		
		om_temp = new Text(group, SWT.BORDER);
		om_temp.setText("-");
		om_temp.setBounds(430, 182, 76, 21);
		
		comp_temp = new Text(group, SWT.BORDER);
		comp_temp.setText("-");
		comp_temp.setBounds(430, 304, 76, 21);
		
		comp_mode = new Text(group, SWT.BORDER);
		comp_mode.setText("-");
		comp_mode.setBounds(430, 331, 76, 21);
		
		comp_status = new Text(group, SWT.BORDER);
		comp_status.setText("-");
		comp_status.setBounds(430, 357, 76, 21);
		
		comp_electric = new Text(group, SWT.BORDER);
		comp_electric.setText("-");
		comp_electric.setBounds(430, 381, 76, 21);
		
		Label label_29 = new Label(group, SWT.NONE);
		label_29.setText("Electric Consumption :");
		label_29.setBounds(293, 384, 131, 15);
		
		Label label_30 = new Label(group, SWT.NONE);
		label_30.setText("Status :");
		label_30.setBounds(293, 360, 76, 15);
		
		Label label_31 = new Label(group, SWT.NONE);
		label_31.setText("Mode :");
		label_31.setBounds(293, 334, 76, 15);
		
		Label label_32 = new Label(group, SWT.NONE);
		label_32.setText("Temperature :");
		label_32.setBounds(293, 307, 76, 15);
		
		Label lblComputer = new Label(group, SWT.NONE);
		lblComputer.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblComputer.setText("Computer");
		lblComputer.setBounds(272, 286, 76, 15);
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setText("Equipments");
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_7.setBounds(272, 21, 76, 15);
		
		btnStart = new Button(shlHomeAppliances, SWT.NONE);
		btnStart.setBounds(387, 453, 75, 25);
		btnStart.setText("Start");
		
		btnScenario = new Button(shlHomeAppliances, SWT.NONE);
		btnScenario.setBounds(306, 453, 75, 25);
		btnScenario.setText("Scenario");
		
		lblInfo = new Label(shlHomeAppliances, SWT.NONE);
		lblInfo.setBounds(10, 483, 395, 15);
		lblInfo.setText("");
		
		btnStop = new Button(shlHomeAppliances, SWT.NONE);
		btnStop.setBounds(468, 453, 75, 25);
		btnStop.setText("Stop");

	}
}
