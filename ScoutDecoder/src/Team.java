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
}
