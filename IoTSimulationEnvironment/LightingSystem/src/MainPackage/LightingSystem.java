package MainPackage;

import java.util.Random;

public class LightingSystem extends LSMainScreen {
	public static String room1_light_value="Off";
    public static int room1_il_value=400;
    
    
	public LightingSystem() {
		// TODO Auto-generated constructor stub
		
		string_room1_light=null;
    	string_room1_il=null;
    	string_room2_light=null;
    	string_room2_il=null;
    	string_room3_light=null;
    	string_room3_il=null;
    	string_room4_light=null;
    	string_room4_il=null;
    	string_kitchen_light=null;
    	string_kitchen_il=null;
    	string_hall_light=null;
    	string_hall_il=null;
    	string_bathroom_light=null;
    	string_bathroom_il=null;
		
	}
	public void SetSonsors(){
		/*ChangeColorWhite(display,ref_mode);
		ChangeColorWhite(display,ref_temp);
		ChangeColorWhite(display,ref_electric);
		ChangeColorWhite(display,ref_status);*/

		Random randElec = new Random();
		int m = randElec.nextInt(20) + 1;
		
		ChangeColorWhite(display,room1_light);
		ChangeColorWhite(display,room1_il);
		
		long startTime = System.currentTimeMillis(); // Zaman mili saniye olarak ölçülmüþtür.
		
		//for time measurement mode
		string_room1_light="Off";
		string_room1_il=String.valueOf(m+400);
		string_room2_light="Off";
    	string_room2_il=String.valueOf(startTime); //time measurement
    	string_room3_light="Off";
    	string_room3_il=String.valueOf(m+320);
    	string_room4_light="Off";
    	string_room4_il=String.valueOf(m+360);
    	string_kitchen_light="Off";
    	string_kitchen_il=String.valueOf(m+390);
    	string_hall_light="Off";
    	string_hall_il=String.valueOf(m+200);
    	string_bathroom_light="On";
    	string_bathroom_il=String.valueOf(m);
    	
    	//for normal mode
    	/*string_room1_light="Off";
    	string_room1_il=String.valueOf(m+400);
    	string_room2_light="Off";
    	string_room2_il=String.valueOf(m+354);
    	string_room3_light="Off";
    	string_room3_il=String.valueOf(m+320);
    	string_room4_light="Off";
    	string_room4_il=String.valueOf(m+360);
    	string_kitchen_light="Off";
    	string_kitchen_il=String.valueOf(m+390);
    	string_hall_light="Off";
    	string_hall_il=String.valueOf(m+200);
    	string_bathroom_light="On";
    	string_bathroom_il=String.valueOf(m);*/
    	
		
	}
	public void Scenario(){

		
		Random randElec = new Random();
		int m = randElec.nextInt(20) + 1;
		
		i=20;
		
		
		
		
		
		ChangeColorWhite(display,room1_light);
		ChangeColorWhite(display,room1_il);
		
		
		if(module!=null){
			if(module.equalsIgnoreCase("Room1")){
				if(command.equalsIgnoreCase("Light")){
					if(parameter.equalsIgnoreCase("On")){ 
						room1_light_value="On";
				    	
						ChangeColorRed(display,room1_light);
						ChangeColorRed(display,room1_il);
						//module=null;
						//command=null;
						//parameter=null;
						stat=2;
						
					}
					else if(parameter.equalsIgnoreCase("Off")){
						room1_light_value="Off";
						stat=1;
						ChangeColorWhite(display,room1_light);
						ChangeColorWhite(display,room1_il);
						//i=0;
						
						
					}
				}
			}
		}
		else{
			
			stat=1;
		}
		
		//total="Module: "+module+" Com: "+command+" Param: "+parameter;
		//lblInfo.setText(""+string_ref_temp);
		//UpdateInfo(display,lblInfo,"Incoming Message: "+total);
		
		if(stat==0){
			string_room1_light=room1_light_value;
			string_room1_il=String.valueOf(room1_il_value);
		}
		else if (stat==1){
			string_room1_light=room1_light_value;
			if(room1_il_value>0){
				room1_il_value=room1_il_value-i;}
			string_room1_il=String.valueOf(room1_il_value);	
		}
		else if (stat==2){
			string_room1_light=room1_light_value;
			if(room1_il_value<420){
				room1_il_value=room1_il_value+i;}
			string_room1_il=String.valueOf(room1_il_value);
		
		}
		
		
		
		//string_room1_light="Off";
    	//string_room1_il=String.valueOf(m+400);
		string_room2_light="Off";
    	string_room2_il=String.valueOf(m+350);
    	string_room3_light="Off";
    	string_room3_il=String.valueOf(m+320);
    	string_room4_light="Off";
    	string_room4_il=String.valueOf(m+360);
    	string_kitchen_light="Off";
    	string_kitchen_il=String.valueOf(m+390);
    	string_hall_light="Off";
    	string_hall_il=String.valueOf(m+200);
    	string_bathroom_light="On";
    	string_bathroom_il=String.valueOf(m);
	}
}
