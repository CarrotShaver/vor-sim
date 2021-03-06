package ics314;

import java.util.Random;

public class Radio {
	private int OBS_ANGLE;
	private int GOOD_BAD;
	private int RADIO_ANGLE;

	public Radio()
	{
		initRadio();
	}
	
	public int getGoodBad()
	{
		return GOOD_BAD;
	}
	
	private void initRadio()
	{
		OBS_ANGLE = Vor_Const.START_ANGLE;
		generateRandomGoodBad();
		generateRandomRadio();
	}
	
	public void setOBSAngle(int angle)
	{
		OBS_ANGLE = angle;
	}
	
	public void generateRandomRadio()
	{
		Random rand = new Random();
		int obs = rand.nextInt(360);
		RADIO_ANGLE = obs;
	}
	
	public int getRadioAngle() 
	{
		int temp = RADIO_ANGLE;
		return temp;
	}
	
	public int getOBSAngle()
	{
		int temp = OBS_ANGLE;
		return temp;
	}
	
	public void generateRandomGoodBad()
	{
		Random rand = new Random();
		int gb = rand.nextInt(2);
		GOOD_BAD = gb;
	}
	
	//Debug + Testing
	public void setRadioAngle(int angle)
	{
		RADIO_ANGLE = angle;
	}
	
}
