import java.util.ArrayList;

public class Pit
{
	boolean autoGear;
	boolean autoHigh;
	boolean autoLow;
	boolean autoHopper;
	boolean specStart;
	boolean gear;
	boolean high;
	boolean low;
	int roboSpeed;
	int shootSpeed;
	int acc;
	boolean climb;
	int climbSpeed;
	String endStrat;
	String strat;
	String ally;
	int capacity;
	String fieldUsage;
	String scouter;
	String comment;
	String intake;
	ArrayList<String> data = new ArrayList<String>();
	
	public void setData(ArrayList<String> myData)
	{
		autoGear = myData.get(1).equals(true);
		autoHigh = myData.get(2).equals(true);
		autoLow = myData.get(3).equals(true);
		autoHopper = myData.get(4).equals(true);
		specStart = myData.get(5).equals(true);
		gear = myData.get(6).equals(true);
		high = myData.get(7).equals(true);
		low = myData.get(8).equals(true);
		roboSpeed = Integer.parseInt(myData.get(9));
		shootSpeed = Integer.parseInt(myData.get(10));
		acc = Integer.parseInt(myData.get(11));
		climb = myData.get(12).equals(true);
		climbSpeed = Integer.parseInt(myData.get(13));
		endStrat = myData.get(14);
		strat = myData.get(15);
		ally = myData.get(16);
		capacity = Integer.parseInt(myData.get(17));
		fieldUsage = myData.get(18);
		scouter = myData.get(19);
		comment = myData.get(20);
		intake = myData.get(21);
	}
	public boolean getAutoGear() { return autoGear; }
	public boolean getAutoHigh() { return autoHigh; }
	public boolean getAutoLow() { return autoLow; }
	public boolean getAutoHopper() { return autoHopper; }
	public boolean getSpecStart() { return specStart; }
	public boolean getGear() { return gear; }
	public boolean getHigh() { return high; }
	public boolean getLow() { return low; }
	public int getRoboSpeed() { return roboSpeed; }
	public int getShootSpeed() { return shootSpeed; }
	public int getAcc() { return acc; }
	public boolean getClimb() { return climb; }
	public int getClimbSpeed() { return climbSpeed; }
	public String getEndStrategy() { return endStrat; }
	public String getStrategy() { return strat; }
	public String getIdealAlly() { return ally; }
	public int getCapacity() { return capacity; }
	public String getFieldUsage() { return fieldUsage; }
	public String getComment() { return comment; }
	public String getScouter() { return scouter; }
	/*boolean autoHighGoals;
	boolean autoLowGoals;
	boolean autoPort;
	boolean autoCDF;
	boolean autoRamp;
	boolean autoMoat;
	boolean autoDraw;
	boolean autoSally;
	boolean autoRock;
	boolean autoRough;
	boolean autoLowBar;
	boolean highGoals;
	boolean lowGoals;
	boolean scale;
	boolean surround;
	boolean Port;
	boolean CDF;
	boolean Ramp;
	boolean Moat;
	boolean Draw;
	boolean Sally;
	boolean Rock;
	boolean Rough;
	boolean LowBar;
	String comment;
	String scouter;
	public void setData(ArrayList<String> myData)
	{
		autoHighGoals = myData.get(1).equals("true");
		autoLowGoals = myData.get(2).equals("true");
		autoPort = myData.get(3).equals("true");
		autoCDF = myData.get(4).equals("true");
		autoRamp = myData.get(5).equals("true");
		autoMoat =myData.get(6).equals("true");
		autoDraw = myData.get(7).equals("true");
		autoSally = myData.get(8).equals("true");
		autoRock = myData.get(9).equals("true");
		autoRough = myData.get(10).equals("true");
		autoLowBar = myData.get(11).equals("true");
		Port = myData.get(12).equals("true");
		CDF = myData.get(13).equals("true");
		Ramp = myData.get(14).equals("true");
		Moat = myData.get(15).equals("true");
		Draw = myData.get(16).equals("true");
		Sally = myData.get(17).equals("true");
		Rock = myData.get(18).equals("true");
		Rough = myData.get(19).equals("true");
		LowBar = myData.get(20).equals("true");
		highGoals = myData.get(21).equals("true");
		lowGoals = myData.get(22).equals("true");
		scale = myData.get(23).equals("true");
		surround = myData.get(24).equals("true");
		comment = myData.get(25);
		scouter = myData.get(26);
	}
	public boolean getAutoHighGoals()
	{
		return autoHighGoals;
	}

	public boolean getAutoLowGoals()
	{
		return autoLowGoals;
	}

	public boolean getAutoPort()
	{
		return autoPort;
	}

	public boolean getAutoCDF()
	{
		return autoCDF;
	}

	public boolean getAutoRamp()
	{
		return autoRamp;
	}

	public boolean getAutoMoat()
	{
		return autoMoat;
	}

	public boolean getAutoDraw()
	{
		return autoDraw;
	}

	public boolean getAutoSally()
	{
		return autoSally;
	}

	public boolean getAutoRock()
	{
		return autoRock;
	}

	public boolean getAutoRough()
	{
		return autoRough;
	}

	public boolean getAutoLowBar()
	{
		return autoLowBar;
	}

	public boolean getHighGoals()
	{
		return highGoals;
	}

	public boolean getLowGoals()
	{
		return lowGoals;
	}

	public boolean getPort()
	{
		return Port;
	}

	public boolean getCDF()
	{
		return CDF;
	}

	public boolean getRamp()
	{
		return Ramp;
	}

	public boolean getMoat()
	{
		return Moat;
	}

	public boolean getDraw()
	{
		return Draw;
	}

	public boolean getSally()
	{
		return Sally;
	}

	public boolean getRock()
	{
		return Rock;
	}

	public boolean getRough()
	{
		return Rough;
	}

	public boolean getLowBar()
	{
		return LowBar;
	}

	public boolean getScaled()
	{
		return scale;
	}

	public boolean getSurround()
	{
		return surround;
	}
	public String getComment()
	{
		return comment;
	}
	public String getScouter()
	{
		return scouter;
	}*/
}
