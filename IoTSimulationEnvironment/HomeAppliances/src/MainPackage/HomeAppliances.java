package MainPackage;

import java.util.Random;



public class HomeAppliances extends HAMainScreen {
	

	
	
	public HomeAppliances() {
		// TODO Auto-generated constructor stub
		string_ref_temp=null;
		string_ref_mode=null;
		string_ref_status=null;
		string_ref_electric=null;
		string_wm_temp=null;
		string_wm_mode=null;
		string_wm_status=null;
		string_wm_electric=null;
		string_dw_temp=null;
		string_dw_mode=null;
		string_dw_status=null;
		string_dw_electric=null;
		string_tv_electric=null;
		string_tv_status=null;
		string_tv_mode=null;
		string_tv_temp=null;
		string_om_temp=null;
		string_om_mode=null;
		string_om_status=null;
		string_om_electric=null;
		string_comp_temp=null;
		string_comp_mode=null;
		string_comp_status=null;
		string_comp_electric=null;
	}
	public void SetSonsors(){
		ChangeColorWhite(display,ref_mode);
		ChangeColorWhite(display,ref_temp);
		ChangeColorWhite(display,ref_electric);
		ChangeColorWhite(display,ref_status);
		Random randTemp = new Random();
		int n = randTemp.nextInt(2) + 1;
		Random randElec = new Random();
		int m = randElec.nextInt(20) + 1;
		
		
		long startTime = System.currentTimeMillis(); // Zaman mili saniye olarak ölçülmüþtür.
		
		string_ref_temp=String.valueOf(n+20);
		string_ref_mode="Economic";
		string_ref_status="On";
		string_ref_electric=String.valueOf(m+300);
		string_wm_temp=String.valueOf(startTime); //time measurement 
		//string_wm_temp=String.valueOf(n+21);
		string_wm_mode="Economic";
		string_wm_status="On";
		string_wm_electric=String.valueOf(m+410);
		string_dw_temp=String.valueOf(n+18);
		string_dw_mode="Economic";
		string_dw_status="On";
		string_dw_electric=String.valueOf(m+250);
		string_tv_electric=String.valueOf(m+170);
		string_tv_status="On";
		string_tv_mode="Economic";
		string_tv_temp=String.valueOf(n+23);
		string_om_temp=String.valueOf(n+25);
		string_om_mode="Economic";
		string_om_status="On";
		string_om_electric=String.valueOf(m+340);
		string_comp_temp=String.valueOf(n+19);
		string_comp_mode="Economic";
		string_comp_status="On";
		string_comp_electric=String.valueOf(m+140);
	}
	public void Scenario(){
		Random randTemp = new Random();
		int n = randTemp.nextInt(2) + 1;
		Random randElec = new Random();
		int m = randElec.nextInt(20) + 1;
		i++;
		
		ref_temp_value=20;
		ref_mode_value="Economic";
		ref_status_value="On";
		ref_electric_value=300;
		ChangeColorWhite(display,ref_mode);
		ChangeColorWhite(display,ref_temp);
		ChangeColorWhite(display,ref_electric);
		ChangeColorWhite(display,ref_status);
		
		if(module!=null){
			if(module.equalsIgnoreCase("Ref")){
				if(command.equalsIgnoreCase("Mode")){
					if(parameter.equalsIgnoreCase("Safe")){ 
						ref_temp_value=20;
						ChangeColorRed(display,ref_mode);
						ChangeColorRed(display,ref_temp);
						ChangeColorRed(display,ref_electric);
						ChangeColorRed(display,ref_status);
						ref_mode_value="Safe";
						i=0;
						module=null;
						command=null;
						parameter=null;
					}
					else if(parameter.equalsIgnoreCase("Economic")){
						ref_temp_value=20;
						ref_mode_value="Economic";
						i=0;
						ChangeColorWhite(display,ref_mode);
						ChangeColorWhite(display,ref_temp);
						ChangeColorWhite(display,ref_electric);
						ChangeColorWhite(display,ref_status);
						
					}
					else {
						ref_temp_value=30;
						ref_mode_value="Advance";
						i=0;
						
					
					}
				}
				else if(command.equalsIgnoreCase("Status")){
					if(parameter.equalsIgnoreCase("Off")){
						ref_temp_value=0;
						ref_mode_value="--";
						ref_status_value="Off";
						ref_electric_value=0;
						stat=0;
						ChangeColorRed(display,ref_mode);
						ChangeColorRed(display,ref_temp);
						ChangeColorRed(display,ref_electric);
						ChangeColorRed(display,ref_status);
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
			string_ref_temp=String.valueOf(ref_temp_value);
			string_ref_mode=ref_mode_value;
			string_ref_status=ref_status_value;
			string_ref_electric=String.valueOf(ref_electric_value);
		}
		else{
			string_ref_temp=String.valueOf(n+ref_temp_value+i);
			string_ref_mode=ref_mode_value;
			string_ref_status=ref_status_value;
			string_ref_electric=String.valueOf(m+ref_electric_value);
		}
		
		string_wm_temp=String.valueOf(n+21);
		string_wm_mode="Economic";
		string_wm_status="On";
		string_wm_electric=String.valueOf(m+410);
		string_dw_temp=String.valueOf(n+18);
		string_dw_mode="Economic";
		string_dw_status="On";
		string_dw_electric=String.valueOf(m+250);
		string_tv_electric=String.valueOf(m+170);
		string_tv_status="On";
		string_tv_mode="Economic";
		string_tv_temp=String.valueOf(n+23);
		string_om_temp=String.valueOf(n+25);
		string_om_mode="Economic";
		string_om_status="On";
		string_om_electric=String.valueOf(m+340);
		string_comp_temp=String.valueOf(n+19);
		string_comp_mode="Economic";
		string_comp_status="On";
		string_comp_electric=String.valueOf(m+140);
	}
	
	
}
