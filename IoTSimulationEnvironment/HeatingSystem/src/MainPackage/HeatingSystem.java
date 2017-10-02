package MainPackage;

import java.util.Random;

public class HeatingSystem extends HTMainScreen  {

	public HeatingSystem() {
		// TODO Auto-generated constructor stub
		string_room1_temp=null;
		string_room1_mode=null;
		string_room1_status=null;
		string_room2_temp=null;
		string_room2_mode=null;
		string_room2_status=null;
		string_room3_temp=null;
		string_room3_mode=null;
		string_room3_status=null;
		string_room4_status=null;
		string_room4_mode=null;
		string_room4_temp=null;
		string_kitchen_temp=null;
		string_kitchen_mode=null;
		string_kitchen_status=null;
		string_hall_temp=null;
		string_hall_mode=null;
		string_hall_status=null;
		string_bathroom_temp=null;
		string_bathroom_mode=null;
		string_bathroom_status=null;
		
	}
	public void SetSonsors(){
		
		ChangeColorWhite(display,room2_mode);
		ChangeColorWhite(display,room2_temp);
		ChangeColorWhite(display,room2_status);
		Random randTemp = new Random();
		int n = randTemp.nextInt(2) + 1;

		
		long startTime = System.currentTimeMillis(); // Zaman mili saniye olarak ölçülmüþtür.
		
		string_room1_temp=String.valueOf(startTime); //time measurement
		//string_room2_temp=String.valueOf(n+22);
		string_room1_mode="Economic";
		string_room1_status="On";
		string_room2_temp=String.valueOf(n+23);
		string_room2_mode="Economic";
		string_room2_status="On";
		string_room3_temp=String.valueOf(n+24);
		string_room3_mode="Economic";
		string_room3_status="On";
		string_room4_status=String.valueOf(n+24);
		string_room4_mode="Economic";
		string_room4_temp="On";
		string_kitchen_temp=String.valueOf(n+25);
		string_kitchen_mode="Economic";
		string_kitchen_status="On";
		string_hall_temp=String.valueOf(n+21);
		string_hall_mode="Economic";
		string_hall_status="On";
		string_bathroom_temp=String.valueOf(n+20);
		string_bathroom_mode="Economic";
		string_bathroom_status="On";
		
		
		
	}
	public void Scenario(){
		Random randTemp = new Random();
		int n = randTemp.nextInt(2) + 1;

		i++;
		
		room2_temp_value=20;
		room2_mode_value="Economic";
		room2_status_value="On";
		
		ChangeColorWhite(display,room2_mode);
		ChangeColorWhite(display,room2_temp);
		ChangeColorWhite(display,room2_status);
		
		if(module!=null){
			if(module.equalsIgnoreCase("Room2")){
				if(command.equalsIgnoreCase("Mode")){
					if(parameter.equalsIgnoreCase("Safe")){ 
						room2_temp_value=20;
						ChangeColorRed(display,room2_mode);
						ChangeColorRed(display,room2_temp);
						ChangeColorRed(display,room2_status);
						room2_mode_value="Safe";
						i=0;
						module=null;
						command=null;
						parameter=null;
					}
					else if(parameter.equalsIgnoreCase("Economic")){
						room2_temp_value=20;
						room2_mode_value="Economic";
						i=0;
						ChangeColorWhite(display,room2_mode);
						ChangeColorWhite(display,room2_temp);
						ChangeColorWhite(display,room2_status);
						
					}
					else {
						room2_temp_value=30;
						room2_mode_value="Advance";
						i=0;
						
					
					}
				}
				else if(command.equalsIgnoreCase("Status")){
					if(parameter.equalsIgnoreCase("Off")){
						room2_temp_value=0;
						room2_mode_value="--";
						room2_status_value="Off";
						stat=0;
						ChangeColorRed(display,room2_mode);
						ChangeColorRed(display,room2_temp);
						ChangeColorRed(display,room2_status);
					}
					
				}
			}
		}
		else{
			
			
		}
		
		//total="Module: "+module+" Com: "+command+" Param: "+parameter;
		//lblInfo.setText(""+string_ref_temp);
		//UpdateInfo(display,lblInfo,"Incoming Message: "+total);
		
		if(stat==0){
			string_room2_temp=String.valueOf(room2_temp_value);
			string_room2_mode=room2_mode_value;
			string_room2_status=room2_status_value;
		}
		else{
			string_room2_temp=String.valueOf(n+room2_temp_value+i);
			string_room2_mode=room2_mode_value;
			string_room2_status=room2_status_value;
			
		}
		
		string_room1_temp=String.valueOf(n+22);
		string_room1_mode="Economic";
		string_room1_status="On";
		
		string_room3_temp=String.valueOf(n+24);
		string_room3_mode="Economic";
		string_room3_status="On";
		string_room4_status=String.valueOf(n+24);
		string_room4_mode="Economic";
		string_room4_temp="On";
		string_kitchen_temp=String.valueOf(n+25);
		string_kitchen_mode="Economic";
		string_kitchen_status="On";
		string_hall_temp=String.valueOf(n+21);
		string_hall_mode="Economic";
		string_hall_status="On";
		string_bathroom_temp=String.valueOf(n+20);
		string_bathroom_mode="Economic";
		string_bathroom_status="On";
	}
	
	
	
}
