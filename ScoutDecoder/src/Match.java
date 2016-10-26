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
	ArrayList<String> data = new ArrayList<String>();

	public void setData(ArrayList<String> myData)
	{
		autoHighGoals = Integer.parseInt(myData.get(0));
		autoLowGoals = Integer.parseInt(myData.get(1));
		autoPort = Integer.parseInt(myData.get(2));
		autoCDF = Integer.parseInt(myData.get(3));
		autoRamp = Integer.parseInt(myData.get(4));
		autoMoat = Integer.parseInt(myData.get(5));
		autoDraw = Integer.parseInt(myData.get(6));
		autoSally = Integer.parseInt(myData.get(7));
		autoRock = Integer.parseInt(myData.get(8));
		autoRough = Integer.parseInt(myData.get(9));
		autoLowBar = Integer.parseInt(myData.get(10));
		Port = Integer.parseInt(myData.get(11));
		CDF = Integer.parseInt(myData.get(12));
		Ramp = Integer.parseInt(myData.get(13));
		Moat = Integer.parseInt(myData.get(14));
		Draw = Integer.parseInt(myData.get(15));
		Sally = Integer.parseInt(myData.get(16));
		Rock = Integer.parseInt(myData.get(17));
		Rough = Integer.parseInt(myData.get(18));
		LowBar = Integer.parseInt(myData.get(19));
		highGoals = Integer.parseInt(myData.get(20));
		lowGoals = Integer.parseInt(myData.get(21));
		scale = myData.get(22).equals("true");
		surround = myData.get(23).equals("true");
		comment = myData.get(24);
		scouter = myData.get(25);
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
}

// Old Code
/*
 * public class Match {
 * 
 * 
 * 
 * 
 * //uses default constructor public Match (int autohighgoals, int autolowgoals,
 * int autoport, int autocdf, int autoramp, int autodraw, int autosally, int
 * autorock, int autorough, int autolowbar, int highgoals, int lowgoals, int
 * port, int cdf, int ramp, int moat, int draw, int sally, int rock, int rough,
 * int lowbar, boolean scale, boolean surround) {
 * 
 * }
 * 
 * //accessor methods
 * 
 * 
 * //autonomous score incrementation public void addAutoHighGoal() {
 * autoHighGoals +=1; } public void addAutoLowGoal() { autoLowGoals +=1; }
 * public void addAutoPort() { autoPort +=1; } public void addAutoCDF() {
 * autoCDF +=1; } public void addAutoRamp() { autoRamp +=1; } public void
 * addAutoMoat() { autoMoat +=1; } public void addAutoDraw() { autoDraw +=1; }
 * public void addAutoSally() { autoSally +=1; } public void addAutoRock() {
 * autoRock +=1; } public void addAutoRough() { autoRough +=1; } public void
 * addAutoLowBar() { autoLowBar +=1; }
 * 
 * //teleop score incrementation public void addHighGoal() { highGoals +=1; }
 * public void addLowGoal() { lowGoals +=1; } public void addPort() { Port +=1;
 * } public void addCDF() { CDF +=1; } public void addRamp() { Ramp +=1; }
 * public void addMoat() { Moat +=1; } public void addDraw() { Draw +=1; }
 * public void addSally() { Sally +=1; } public void addRock() { Rock +=1; }
 * public void addRough() { Rough +=1; } public void addLowBar() { LowBar +=1; }
 * public void setScale(boolean a) { scale = a; } public void
 * setSurround(boolean a) { surround = a; }
 * 
 * public String toString() { return "insert match data here"; }
 * 
 * }
 */