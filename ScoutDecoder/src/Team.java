import java.util.ArrayList;


public class Team {

	 final int teamNumber;
	    ArrayList<Match> matches;

	    public Team(int number) {
	        teamNumber = number;
	        matches = new ArrayList<>();
	    }

	    public void addMatch(Match match) {
	        matches.add(match);
	    }
	    
	    public String toString() {
	        return "" + teamNumber;
	    }
	    




	}
