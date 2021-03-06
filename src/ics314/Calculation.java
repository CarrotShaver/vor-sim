package ics314;

public class Calculation {
	
	public Calculation()
	{
		//Constructor
	}
	
	public int calculateBad(Radio vor)
	{
		/* First Case is when VOR says BAD (too close)*/
		if(vor.getGoodBad() == Vor_Const.BAD) {
			return Vor_Const.BAD;
		} else {
			return checkAbeam(vor.getRadioAngle(), vor.getOBSAngle());
		}
	}
	
	private int checkAbeam(int intercept, int course)
	{
		if((intercept-course)%Vor_Const.PERPENDICULAR == 0) {
			return Vor_Const.BAD;
		} else {
			return Vor_Const.GOOD;
		}
	}
	
	public int calculateToFrom(Radio vor)
	{
		int interceptedRadial = vor.getRadioAngle();
		int Course = vor.getOBSAngle();
		System.out.println("C: " + Course + " - i: " + interceptedRadial);
		int firstangle = ((Course+Vor_Const.HALF_PI)%Vor_Const.TWO_PI);
		System.out.println("Fir Angle: " + firstangle);
		int secondangle = ((Course-Vor_Const.HALF_PI)%Vor_Const.TWO_PI);
		if(secondangle < 0) {
			/* If Negative, Wrap Around */
			secondangle = secondangle + Vor_Const.TWO_PI;
		}
		
		System.out.println("Sec Angle: " + secondangle);
        if(interceptedRadial < ((Course+Vor_Const.HALF_PI)%Vor_Const.TWO_PI) 
        		&& interceptedRadial > secondangle) {
            return Vor_Const.TO;
        } else if (interceptedRadial==((Course+Vor_Const.HALF_PI)%Vor_Const.TWO_PI) 
        		|| interceptedRadial==((Course-Vor_Const.HALF_PI)%Vor_Const.TWO_PI)) {
            return Vor_Const.OFF;
        } else {
           return Vor_Const.FROM;
        }
    }

	public int calculateDeflection(Radio vor)
	{
		return (vor.getRadioAngle() - vor.getOBSAngle());

	}
	
}
