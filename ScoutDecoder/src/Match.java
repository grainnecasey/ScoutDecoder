import java.util.ArrayList;

public class Match
{
	boolean autoGear;
	int autoGearPos;
	boolean autoBase;
	int autoLow;
	int autoHigh;
	int autoHopper;
	int low;
	int high;
	int gear;
	int cycleT;
	int clearT;
	boolean climb;
	boolean survive;
	int quality;
	int strat;
	String driver;
	String comment;
	String scouter;
	ArrayList<String> data = new ArrayList<String>();
	
	public void setData(ArrayList<String> myData)
	{
		autoGear = myData.get(1).equals("true");
		autoGearPos = Integer.parseInt(myData.get(2));
		autoBase = myData.get(3).equals(true);
		autoLow = Integer.parseInt(myData.get(4));
		autoHigh = Integer.parseInt(myData.get(5));
		autoHopper = Integer.parseInt(myData.get(6));
		low = Integer.parseInt(myData.get(7));
		high = Integer.parseInt(myData.get(8));
		gear = Integer.parseInt(myData.get(9));
		cycleT = Integer.parseInt(myData.get(10));
		clearT = Integer.parseInt(myData.get(11));
		climb = myData.get(12).equals("true");
		survive = myData.get(13).equals("true");
		quality = Integer.parseInt(myData.get(14));
		strat = Integer.parseInt(myData.get(15));
		driver = myData.get(16);
		comment = myData.get(17);
		scouter = myData.get(18);
	}
	public boolean getAutoGear() { return autoGear; }
	public int getAutoGearPos() { return autoGearPos; }
	public boolean getAutoBase() { return autoBase; }
	public int getAutoLow() { return autoLow; }
	public int getAutoHigh() { return autoHigh; }
	public int getAutoHopper() { return autoHopper; }
	public int getLow() { return low; }
	public int getHigh() { return high; }
	public int getGear() { return gear; }
	public int getCycleTime() { return cycleT; }
	public int getClearTime() { return clearT; }
	public boolean getClimb() { return climb; }
	public boolean getSurvived() { return survive; }
	public int getQuality() { return quality; }
	public int getStrategy() { return strat; }
	public String getDriver() { return driver; }
	public String getComment() { return comment; }
	public String getScouter() { return scouter; }
 }
	
//	int autoHighGoals;
//	int autoLowGoals;
//	int autoPort;
//	int autoCDF;
//	int autoRamp;
//	int autoMoat;
//	int autoDraw;
//	int autoSally;
//	int autoRock;
//	int autoRough;
//	int autoLowBar;
//	int highGoals;
//	int lowGoals;
//	boolean scale;
//	boolean surround;
//	int Port;
//	int CDF;
//	int Ramp;
//	int Moat;
//	int Draw;
//	int Sally;
//	int Rock;
//	int Rough;
//	int LowBar;
//	String comment;
//	String scouter;
//	int miss;
//	ArrayList<String> data = new ArrayList<String>();
//
//	public void setData(ArrayList<String> myData)
//	{
//		autoHighGoals = Integer.parseInt(myData.get(1));
//		autoLowGoals = Integer.parseInt(myData.get(2));
//		autoPort = Integer.parseInt(myData.get(3));
//		autoCDF = Integer.parseInt(myData.get(4));
//		autoRamp = Integer.parseInt(myData.get(5));
//		autoMoat = Integer.parseInt(myData.get(6));
//		autoDraw = Integer.parseInt(myData.get(7));
//		autoSally = Integer.parseInt(myData.get(8));
//		autoRock = Integer.parseInt(myData.get(9));
//		autoRough = Integer.parseInt(myData.get(10));
//		autoLowBar = Integer.parseInt(myData.get(11));
//		Port = Integer.parseInt(myData.get(12));
//		CDF = Integer.parseInt(myData.get(13));
//		Ramp = Integer.parseInt(myData.get(14));
//		Moat = Integer.parseInt(myData.get(15));
//		Draw = Integer.parseInt(myData.get(16));
//		Sally = Integer.parseInt(myData.get(17));
//		Rock = Integer.parseInt(myData.get(18));
//		Rough = Integer.parseInt(myData.get(19));
//		LowBar = Integer.parseInt(myData.get(20));
//		highGoals = Integer.parseInt(myData.get(21));
//		lowGoals = Integer.parseInt(myData.get(22));
//		scale = myData.get(23).equals("true");
//		surround = myData.get(24).equals("true");
//		comment = myData.get(25);
//		scouter = myData.get(26);
//		miss = Integer.parseInt(myData.get(27));
//	}
//
//	public int getAutoHighGoals()
//	{
//		return autoHighGoals;
//	}
//
//	public int getAutoLowGoals()
//	{
//		return autoLowGoals;
//	}
//
//	public int getAutoPort()
//	{
//		return autoPort;
//	}
//
//	public int getAutoCDF()
//	{
//		return autoCDF;
//	}
//
//	public int getAutoRamp()
//	{
//		return autoRamp;
//	}
//
//	public int getAutoMoat()
//	{
//		return autoMoat;
//	}
//
//	public int getAutoDraw()
//	{
//		return autoDraw;
//	}
//
//	public int getAutoSally()
//	{
//		return autoSally;
//	}
//
//	public int getAutoRock()
//	{
//		return autoRock;
//	}
//
//	public int getAutoRough()
//	{
//		return autoRough;
//	}
//
//	public int getAutoLowBar()
//	{
//		return autoLowBar;
//	}
//
//	public int getHighGoals()
//	{
//		return highGoals;
//	}
//
//	public int getLowGoals()
//	{
//		return lowGoals;
//	}
//
//	public int getPort()
//	{
//		return Port;
//	}
//
//	public int getCDF()
//	{
//		return CDF;
//	}
//
//	public int getRamp()
//	{
//		return Ramp;
//	}
//
//	public int getMoat()
//	{
//		return Moat;
//	}
//
//	public int getDraw()
//	{
//		return Draw;
//	}
//
//	public int getSally()
//	{
//		return Sally;
//	}
//
//	public int getRock()
//	{
//		return Rock;
//	}
//
//	public int getRough()
//	{
//		return Rough;
//	}
//
//	public int getLowBar()
//	{
//		return LowBar;
//	}
//
//	public boolean getScaled()
//	{
//		return scale;
//	}
//
//	public boolean getSurround()
//	{
//		return surround;
//	}
//	public String getComment()
//	{
//		return comment;
//	}
//	public String getScouter()
//	{
//		return scouter;
//	}
//	public int getMisses()
//	{
//		return miss;
//	}