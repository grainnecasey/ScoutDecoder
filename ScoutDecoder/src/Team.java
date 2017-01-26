import java.util.ArrayList;

public class Team
{
	ArrayList<Match> mData = new ArrayList<Match>();
	ArrayList<Pit> pData = new ArrayList<Pit>();
	public void addMatch(Match match)
	{
		mData.add(match);
	}
	public int MatchSize()
	{
		return mData.size();
	}
	public Match getMatch(int index)
	{
		return mData.get(index);
	}
	public void addPit(Pit pit)
	{
		pData.add(pit);
	}
	public int PitSize()
	{
		return pData.size();
	}
	public Pit getPit(int index)
	{
		return pData.get(index);
	}
	
	public boolean useAutoGear() { //checks to see if the team has placed a gear in auto
		boolean temp = false;
		for(int i = 0; i < mData.size();i++) {
			if(mData.get(i).getAutoGear()) {
				temp = true;
				break;
			}
		}
		return temp;
	}
	
	public int frqAutoGearPos() { //checks to see what the most common auto gear position is
		int[] valCheck = new int[4];
		int temp = 0;
		
		for(int i = 0; i < mData.size(); i++) {
			valCheck[mData.get(i).getAutoGearPos()]++;
		}
		for(int i = 0; i < valCheck.length; i++) {
			if(valCheck[i] > temp) {
				temp = valCheck[i];
			}
		}
		return valCheck[temp];
	}
	
	public boolean useAutoBase() {//checks to see if the team can cross the baseline during auto
		boolean temp = false;
		for(int i = 0; i < mData.size();i++) {
			if(mData.get(i).getAutoBase()) {
				temp = true;
				break;
			}
		}
		return temp;
	}
	
	public int avgAutoLow() {//checks to see how many balls a team puts into the low goal in auto on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getAutoLow();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgAutoHigh() {//checks to see how many balls a team puts into the high goal in auto on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getAutoHigh();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgLowGoal() {//checks to see low goal on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getLow();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgHighGoal() {//checks to see high goal on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getHigh();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgGear() {//checks to see how many gears a team deposits on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getGear();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgCycleT() { //checks to see how long the cycle time is on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getCycleTime();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgClearT() { //checks to see how long the clear time is on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getClearTime();
		}
		temp /= mData.size();
		return temp;
	}
	
	public int avgQuality() { //checks to see what the quality is on average
		int temp = 0;
		for(int i = 0; i < mData.size();i++) {
			temp += mData.get(i).getQuality();
		}
		temp /= mData.size();
		return temp;
	} 
	
	public boolean useClimb() {//checks to see if the team can climb during auto
		boolean temp = false;
		for(int i = 0; i < mData.size();i++) {
			if(mData.get(i).getClimb()) {
				temp = true;
				break;
			}
		}
		return temp;
	}
	
	
	public int didDie() {//checks to see how many times a robot died
		int temp = 0;
		for(int i  = 0; i < mData.size(); i++) {
			if(!mData.get(i).getSurvived()) {
				temp++;
			}
		}
		return temp;
	}
	
}
