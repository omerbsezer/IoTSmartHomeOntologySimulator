package MainPackage;



public class SecuritySystem extends SSMainScreen {

	String point;
	int x=0;
	public static String room1_sstatus_value="On";
    public static String room1_smode_value="Safe";
    public static String room2_sstatus_value="On";
    public static String room2_smode_value="Safe";
    public static String room3_sstatus_value="On";
    public static String room3_smode_value="Safe";
    public static String room4_sstatus_value="On";
    public static String room4_smode_value="Safe";
    public static String kitchen_sstatus_value="On";
    public static String kitchen_smode_value="Safe";
    public static String hall_sstatus_value="On";
    public static String hall_smode_value="Safe";
    public static String bathroom_sstatus_value="On";
    public static String bathroom_smode_value="Safe";
    public static String water_sstatus_value="On";
    public static String water_smode_value="Safe";
    public static String gas_sstatus_value="On";
    public static String gas_smode_value="Safe";
    public static String elec_sstatus_value="On";
    public static String elec_smode_value="Safe";
	
	
	
	
	public SecuritySystem() {
		// TODO Auto-generated constructor stub
		string_room1_sstatus=null;
		string_room1_smode=null;
		string_room2_sstatus=null;
		string_room2_smode=null;
		string_room3_sstatus=null;
		string_room3_smode=null;
		string_room4_sstatus=null;
		string_room4_smode=null;
		string_kitchen_sstatus=null;
		string_kitchen_smode=null;
		string_hall_sstatus=null;
		string_hall_smode=null;
		string_bathroom_sstatus=null;
		string_bathroom_smode=null;
		string_water_sstatus=null;
	    string_water_smode=null;
		string_gas_sstatus=null;
		string_gas_smode=null;
		string_elec_sstatus=null;
		string_elec_smode=null;
		
	}
	public void SetSonsors(){
		ChangeColorWhite(display,room1_sstatus);
		ChangeColorWhite(display,room1_smode);
		ChangeColorWhite(display,room2_sstatus);
		ChangeColorWhite(display,room2_smode);
		ChangeColorWhite(display,room3_sstatus);
		ChangeColorWhite(display,room3_smode);
		ChangeColorWhite(display,room4_sstatus);
		ChangeColorWhite(display,room4_smode);
		ChangeColorWhite(display,kitchen_sstatus);
		ChangeColorWhite(display,kitchen_smode);
		ChangeColorWhite(display,hall_sstatus);
		ChangeColorWhite(display,hall_smode);
		ChangeColorWhite(display,bathroom_sstatus);
		ChangeColorWhite(display,bathroom_smode);
		x++;
			if(x==1)
				point=".";
			else if(x==2)
				point="..";
			else if(x==3)
				point="...";
			else if(x==4)
				point="....";
			else if(x==5){
				point=".....";
				x=0;
			}
				
		long startTime = System.currentTimeMillis(); // Zaman mili saniye olarak ölçülmüþtür.
		
		string_room1_sstatus="On"+point;
		string_room1_smode="Safe"+point;
		string_room2_sstatus=String.valueOf(startTime); //time measurement
		//string_room2_sstatus="On"+point;
		string_room2_smode="Safe"+point;
		string_room3_sstatus="On"+point;
		string_room3_smode="Safe"+point;
		string_room4_sstatus="On"+point;
		string_room4_smode="Safe"+point;
		string_kitchen_sstatus="On"+point;
		string_kitchen_smode="Safe"+point;
		string_hall_sstatus="On"+point;
		string_hall_smode="Safe"+point;
		string_bathroom_sstatus="On"+point;
		string_bathroom_smode="Safe"+point;
		string_water_sstatus="On"+point;
	    string_water_smode="Safe"+point;
		string_gas_sstatus="On"+point;
		string_gas_smode="Safe"+point;
		string_elec_sstatus="On"+point;
		string_elec_smode="Safe"+point;
		
	}
	public void Scenario(){
		x++;
		if(x==1)
			point=".";
		else if(x==2)
			point="..";
		else if(x==3)
			point="...";
		else if(x==4)
			point="....";
		else if(x==5){
			point=".....";
			x=0;
		}
		if(i<17)
			i++;
		
		ChangeColorWhite(display,room1_sstatus);
		ChangeColorWhite(display,room1_smode);
		ChangeColorWhite(display,room2_sstatus);
		ChangeColorWhite(display,room2_smode);
		ChangeColorWhite(display,room3_sstatus);
		ChangeColorWhite(display,room3_smode);
		ChangeColorWhite(display,room4_sstatus);
		ChangeColorWhite(display,room4_smode);
		ChangeColorWhite(display,kitchen_sstatus);
		ChangeColorWhite(display,kitchen_smode);
		ChangeColorWhite(display,hall_sstatus);
		ChangeColorWhite(display,hall_smode);
		ChangeColorWhite(display,bathroom_sstatus);
		ChangeColorWhite(display,bathroom_smode);
		/*ref_temp_value=20;
		ref_mode_value="Economic";
		ref_status_value="On";
		ref_electric_value=300;
		ChangeColorWhite(display,ref_mode);
		ChangeColorWhite(display,ref_temp);
		ChangeColorWhite(display,ref_electric);
		ChangeColorWhite(display,ref_status);*/
		
		if(module!=null){
			if(module.equalsIgnoreCase("All")){
				if(command.equalsIgnoreCase("Alarm")){
					if(parameter.equalsIgnoreCase("On")){ 
						AlarmOn();
						stat=2;
						//i=0;
						module=null;
						command=null;
						parameter=null;
					}
					else if(parameter.equalsIgnoreCase("Off")){ 
						AlarmOff();
						stat=3;
						//i=0;
						module=null;
						command=null;
						parameter=null;
					}
					else {
						/*ref_temp_value=30;
						ref_mode_value="Safe";
						i=0;*/
						
					
					}
				}
			}
		}
		else{
			
			
		}
		
		//total="Module: "+module+" Com: "+command+" Param: "+parameter;
		//lblInfo.setText(""+string_ref_temp);
		//UpdateInfo(display,lblInfo,"Incoming Message: "+total);

		 if (stat==1){
			if(i>15){
				room1_sstatus_value="Motion";
				room1_smode_value="Safe";
			}	
		 }
		 else if (stat==2){
			 room1_sstatus_value="Motion";
			 room1_smode_value="Alarm";
			 room2_smode_value="Alarm";
			 room3_smode_value="Alarm";
			 room4_smode_value="Alarm";
			 kitchen_smode_value="Alarm";
			 hall_smode_value="Alarm";
			 bathroom_smode_value="Alarm";
			/* water_smode_value="Alarm";
			 gas_smode_value="Alarm";
			 elec_smode_value="Alarm";*/
			 
		 }
		 else if (stat==3){
			 room1_sstatus_value="On";
			 room1_smode_value="Safe";
			 room1_smode_value="Safe";
			 room2_smode_value="Safe";
			 room3_smode_value="Safe";
			 room4_smode_value="Safe";
			 kitchen_smode_value="Safe";
			 hall_smode_value="Safe";
			 bathroom_smode_value="Safe";
		 }

		string_room1_sstatus=room1_sstatus_value;
		string_room1_smode=room1_smode_value;
		string_room2_sstatus="On"+point;
		string_room2_smode=room2_smode_value;
		string_room3_sstatus="On"+point;
		string_room3_smode=room3_smode_value;
		string_room4_sstatus="On"+point;
		string_room4_smode=room4_smode_value;
		string_kitchen_sstatus="On"+point;
		string_kitchen_smode=kitchen_smode_value;
		string_hall_sstatus="On"+point;
		string_hall_smode=hall_smode_value;
		string_bathroom_sstatus="On"+point;
		string_bathroom_smode=bathroom_smode_value;
		string_water_sstatus="On"+point;
	    string_water_smode="Safe"+point;
		string_gas_sstatus="On"+point;
		string_gas_smode="Safe"+point;
		string_elec_sstatus="On"+point;
		string_elec_smode="Safe"+point;
		
		
		
	}
	public void AlarmOn() {
		ChangeColorRed(display,room1_sstatus);
		ChangeColorRed(display,room1_smode);
		ChangeColorRed(display,room2_sstatus);
		ChangeColorRed(display,room2_smode);
		ChangeColorRed(display,room3_sstatus);
		ChangeColorRed(display,room3_smode);
		ChangeColorRed(display,room4_sstatus);
		ChangeColorRed(display,room4_smode);
		ChangeColorRed(display,kitchen_sstatus);
		ChangeColorRed(display,kitchen_smode);
		ChangeColorRed(display,hall_sstatus);
		ChangeColorRed(display,hall_smode);
		ChangeColorRed(display,bathroom_sstatus);
		ChangeColorRed(display,bathroom_smode);
		
		
		/*room2_smode_value="Alarm";
		room3_smode_value="Alarm";
		room4_smode_value="Alarm";
		kitchen_smode_value="Alarm";
		hall_smode_value="Alarm";
		bathroom_smode_value="Alarm";
		water_smode_value="Alarm";
		gas_smode_value="Alarm";
		elec_smode_value="Alarm";*/
	}
	public void AlarmOff() {
		ChangeColorWhite(display,room1_sstatus);
		ChangeColorWhite(display,room1_smode);
		ChangeColorWhite(display,room2_sstatus);
		ChangeColorWhite(display,room2_smode);
		ChangeColorWhite(display,room3_sstatus);
		ChangeColorWhite(display,room3_smode);
		ChangeColorWhite(display,room4_sstatus);
		ChangeColorWhite(display,room4_smode);
		ChangeColorWhite(display,kitchen_sstatus);
		ChangeColorWhite(display,kitchen_smode);
		ChangeColorWhite(display,hall_sstatus);
		ChangeColorWhite(display,hall_smode);
		ChangeColorWhite(display,bathroom_sstatus);
		ChangeColorWhite(display,bathroom_smode);
		
		
		/*room2_smode_value="Safe";
		room3_smode_value="Safe";
		room4_smode_value="Safe";
		kitchen_smode_value="Safe";
		hall_smode_value="Safe";
		bathroom_smode_value="Safe";
		water_smode_value="Safe";
		gas_smode_value="Safe";
		elec_smode_value="Safe";*/
	}
	
	
}
