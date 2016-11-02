import java.util.ArrayList;

public class Match
{
	int autoHighGoals;
	int autoLowGoals;
	int autoPort;
	int autoCDF;
	int autoRamp;
	int autoMoat;
	int autoDraw;
	int autoSally;
	int autoRock;
	int autoRough;
	int autoLowBar;
	int highGoals;
	int lowGoals;
	boolean scale;
	boolean surround;
	int Port;
	int CDF;
	int Ramp;
	int Moat;
	int Draw;
	int Sally;
	int Rock;
	int Rough;
	int LowBar;
	String comment;
	String scouter;
	int miss;
	ArrayList<String> data = new ArrayList<String>();

	public void setData(ArrayList<String> myData)
	{
		autoHighGoals = Integer.parseInt(myData.get(1));
		autoLowGoals = Integer.parseInt(myData.get(2));
		autoPort = Integer.parseInt(myData.get(3));
		autoCDF = Integer.parseInt(myData.get(4));
		autoRamp = Integer.parseInt(myData.get(5));
		autoMoat = Integer.parseInt(myData.get(6));
		autoDraw = Integer.parseInt(myData.get(7));
		autoSally = Integer.parseInt(myData.get(8));
		autoRock = Integer.parseInt(myData.get(9));
		autoRough = Integer.parseInt(myData.get(10));
		autoLowBar = Integer.parseInt(myData.get(11));
		Port = Integer.parseInt(myData.get(12));
		CDF = Integer.parseInt(myData.get(13));
		Ramp = Integer.parseInt(myData.get(14));
		Moat = Integer.parseInt(myData.get(15));
		Draw = Integer.parseInt(myData.get(16));
		Sally = Integer.parseInt(myData.get(17));
		Rock = Integer.parseInt(myData.get(18));
		Rough = Integer.parseInt(myData.get(19));
		LowBar = Integer.parseInt(myData.get(20));
		highGoals = Integer.parseInt(myData.get(21));
		lowGoals = Integer.parseInt(myData.get(22));
		scale = myData.get(23).equals("true");
		surround = myData.get(24).equals("true");
		comment = myData.get(25);
		scouter = myData.get(26);
		miss = Integer.parseInt(myData.get(27));
	}

	public int getAutoHighGoals()
	{
		return autoHighGoals;
	}

	public int getAutoLowGoals()
	{
		return autoLowGoals;
	}

	public int getAutoPort()
	{
		return autoPort;
	}

	public int getAutoCDF()
	{
		return autoCDF;
	}

	public int getAutoRamp()
	{
		return autoRamp;
	}

	public int getAutoMoat()
	{
		return autoMoat;
	}

	public int getAutoDraw()
	{
		return autoDraw;
	}

	public int getAutoSally()
	{
		return autoSally;
	}

	public int getAutoRock()
	{
		return autoRock;
	}

	public int getAutoRough()
	{
		return autoRough;
	}

	public int getAutoLowBar()
	{
		return autoLowBar;
	}

	public int getHighGoals()
	{
		return highGoals;
	}

	public int getLowGoals()
	{
		return lowGoals;
	}

	public int getPort()
	{
		return Port;
	}

	public int getCDF()
	{
		return CDF;
	}

	public int getRamp()
	{
		return Ramp;
	}

	public int getMoat()
	{
		return Moat;
	}

	public int getDraw()
	{
		return Draw;
	}

	public int getSally()
	{
		return Sally;
	}

	public int getRock()
	{
		return Rock;
	}

	public int getRough()
	{
		return Rough;
	}

	public int getLowBar()
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
	}
	public int getMisses()
	{
		return miss;
	}
}