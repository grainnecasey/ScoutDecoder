/* --------------------------------------------------------------------------
 * Scouting Decoder
 * --------------------------------------------------------------------------
 * Changelog: 
 * 1/14/2017 - Conversion to 2017 game, pit find data, and bug fixing
 * 1/16/2017 - UTF-8 BOM watermark workaround
 * --------------------------------------------------------------------------
 * Bugs:
 * 1/14/2017 - Nothing
 * --------------------------------------------------------------------------
 * Planned Features:
 * • Make it look nicer
 * --------------------------------------------------------------------------
 * Notes:
 * 1/14/2017 - Started commenting
 * --------------------------------------------------------------------------
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

//import org.apache.commons.io.input.BOMInputStream;

/* Database for all scouting done inserted by file or manual input
 * Takes the file, seperates it into an array and stores it into an arraylist of teams
 * Saves all the raw data into a text file named data.txt with all the raw data so data is not lost
 * Sarch feature to access the data in the arraylist of teams
 */

public class GUI1
{
	// Variables 
	private static String rawData = "";
	private static ArrayList<Team> Data = new ArrayList<Team>();
	private JFrame frmMain;
	private JTextField txtInput;
	private JTextField txtTeam;
	private JTextField txtMatch;
	private JTextField txtData;
	private static JTextArea txtOut;
	private JButton btnFind;
	private JButton btnSort;
	private JTextField txtSortFrom;//either Pit or Match
	private JTextField txtSortBy; //the condition to sort by
	
private ArrayList<Team> sorted = new ArrayList<Team>();
	
	public void sortByPit(String dataType) { //sortBy for any items in pit scouting, WIP
		for(int i = 0; i < Data.size(); i++) {
			sorted.add(Data.get(i)); //sets ArrayList sorted to be equal to Data
		}
	
		switch (dataType) {	
		case "Auto Gear": // referring to Pit autoGear
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getAutoGear() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getAutoGear()) {
							Team temp = sorted.get(i); //moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
							break;
						}
					}
				}
			}
			break;
		case "Auto High": //referring to Pit autoHigh 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getAutoHigh() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getAutoHigh()) {
							Team temp = sorted.get(i); //moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Auto Low": //referring to Pit autoLow 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getAutoLow() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getAutoLow()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Auto Hopper": //referring to Pit autoHopper 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getAutoHopper() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getAutoHopper()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				} 
				
			}
			break;
		case "Auto Spec Start": //referring to Pit specStart 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getSpecStart() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getSpecStart()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Gear": //referring to Pit gear 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getGear() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getGear()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "High": //referring to Pit High 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getHigh() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getHigh()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Low": //referring to Pit Low 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getLow() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getLow()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Climb": //referring to Pit climb 
			for(int i = 0;i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getClimb() == false) {
					for(int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getClimb()) {
							Team temp = sorted.get(i);//moves 'true's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Robo Speed": //referring to Pit roboSpeed
			for(int i = 0;i < sorted.size();i++) {
				for(int j = i + 1;j < sorted.size();j++) {
					if(sorted.get(i).getPit(0).getRoboSpeed() < sorted.get(j).getPit(0).getRoboSpeed()) {
						Team temp = sorted.get(i); //moves higher #s to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		case "Shoot Speed": //referring to Pit shootSpeed
			for(int i = 0;i < sorted.size();i++) {
				for(int j = i + 1;j < sorted.size();j++) {
					if(sorted.get(i).getPit(0).getShootSpeed() < sorted.get(j).getPit(0).getShootSpeed()) {
						Team temp = sorted.get(i);//moves higher #s to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		case "Climb Speed": //referring to Pit climbSpeed
			for(int i = 0;i < sorted.size();i++) {
				for(int j = i + 1;j < sorted.size();j++) {
					if(sorted.get(i).getPit(0).getClimbSpeed() < sorted.get(j).getPit(0).getClimbSpeed()) {
						Team temp = sorted.get(i);//moves higher #s to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		case "Intake":
			for(int i = 0; i < sorted.size();i++) {
				if(sorted.get(i).getPit(0).getIntake().equals("floor")) {
					for (int j = i + 1;j < sorted.size();j++) {
						if(sorted.get(j).getPit(0).getIntake().equals("top")) {
							Team temp = sorted.get(i);//moves 'top's to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
							break;
						}
					}
				}
			}
			break;
		default:
			txtOut.setText("Invalid target");
		}
		
	}
	
	public void sortByMatch(String dataType) { //sortBy for any items in match scouting WIP
		switch (dataType) {
		case "Auto Gear": //referring to match autoGear
			for(int i = 0; i < sorted.size();i++) {
				if(!sorted.get(i).useAutoGear()) {
					for(int j = i + 1;j < sorted.size(); j++) {
						if (sorted.get(j).useAutoGear()) {
							Team temp = sorted.get(i); // moves all true values to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
		case "Auto Gear Position": //referring to match autoGearPos
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).frqAutoGearPos() > sorted.get(j).frqAutoGearPos()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		case "Auto Baseline": //referring to match autoBase
			for(int i = 0; i < sorted.size();i++) {
				if(!sorted.get(i).useAutoBase()) {
					for(int j = i + 1;j < sorted.size(); j++) {
						if (sorted.get(j).useAutoBase()) {
							Team temp = sorted.get(i); // moves all true values to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
			
		case "Auto Low": //referring to match autoLow
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgAutoLow() > sorted.get(j).avgAutoLow()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		
		
		case "Auto High": //referring to match autoHgih
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgAutoHigh() > sorted.get(j).avgAutoHigh()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
			
		case "Low Goal": //referring to match low
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgLowGoal() > sorted.get(j).avgLowGoal()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
			
		case "High Goal": //referring to match high
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgHighGoal() > sorted.get(j).avgHighGoal()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		
		case "Gear": //referring to match gear
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgGear() > sorted.get(j).avgGear()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		
		case "Cycle Time": //referring to match cycle time
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgCycleT() > sorted.get(j).avgCycleT()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
			
		case "Clear Time": //referring to match clear time
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgClearT() > sorted.get(j).avgClearT()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
			
		case "Quality": //referring to match quality
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).avgQuality() > sorted.get(j).avgQuality()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
			
		case "Climb": //referring to match climb
			for(int i = 0; i < sorted.size();i++) {
				if(!sorted.get(i).useClimb()) {
					for(int j = i + 1;j < sorted.size(); j++) {
						if (sorted.get(j).useClimb()) {
							Team temp = sorted.get(i); // moves all true values to the front
							sorted.set(i, sorted.get(j));
							sorted.set(j, temp);
						}
					}
				}
			}
			break;
			
		case "Die": //referring to match survive
			for(int i = 0; i < sorted.size(); i++) {
				for(int j = i + 1; j < sorted.size(); j++) {
					if(sorted.get(j).didDie() > sorted.get(j).didDie()) {
						Team temp = sorted.get(i); //moves the highest number to the front
						sorted.set(i, sorted.get(j));
						sorted.set(j, temp);
					}
				}
			}
			break;
		}
	}
	
	
	// Grabs saved data from database file
	
	private static void getData()
	{
			ArrayList<String> decoded = new ArrayList<String>();
			int index;
			Scanner fScan;
			try
			{
				fScan = new Scanner(new File("data.txt")); // Grabs file
				Match nMatch = new Match();
				Pit nPit = new Pit();
				rawData += fScan.nextLine();
				String[] d = rawData.split("]"); // Splits database rawdata into seperate inputs
				for (int i = 1; i < d.length; i++) // Read all inputs and adds them to the Arraylist of teams
				{
					decoded = decode(d[i]);
					index = Integer.parseInt(decoded.get(0));
					if (decoded.get(2).equals("true") || decoded.get(2).equals("false")) // Tell apart if it is pit or match
					{ // Adding pit data
						nPit.setData(decoded);
						if (Data.size() == 0 || Data.get(index) == null) // Creates a new team if there is no team/no data
						{
							Team nTeam = new Team();
							nTeam.addPit(nPit);
							Data.set(index, nTeam);
						} else // Adds data to existing teams
						{
							Team tTeam = Data.get(index);
							tTeam.addPit(nPit);
							Data.set(index, tTeam);
						}	
					} else
					{ // Adding match data
						nMatch.setData(decoded);
						if (Data.size() == 0 || Data.get(index) == null) // Creates a new team if there is no team/no data
						{
							Team nTeam = new Team();
							nTeam.addMatch(nMatch);
							Data.set(index, nTeam);
						} else // Adds data to existing teams
						{
							Team tTeam = Data.get(index);
							tTeam.addMatch(nMatch);
							Data.set(index, tTeam);
						}
					}
				}
				
			}
			//catch (FileNotFoundException e1)
			//{}
			catch (Exception error)
			{}
			outData(); // Saves the file
		}

	// Decodes the input
	private static ArrayList<String> decode(String in)
	{
		String[] decode = in.split("}");
		ArrayList<String> decoded = new ArrayList<String>();
		for (int i = 0; i < decode.length; i++) // Creates an arraylist from the string
		{
			decoded.add(decode[i]);
		}
		return decoded;
	}

	// Saves the data into the file
	// Rawdata on first line
	// Organized data on rest
	private static void outData()
	{
		PrintWriter writer;
		try
		{
			writer = new PrintWriter("data.txt"); // Creates new file
			writer.println(rawData); // sets the first line to all the inputs for later usage
			for (int i = 0; i < Data.size(); i++)
			{
				if (Data.get(i) != null) // Ignores all teams without data
				{ // Writes out all the data to the file
					writer.println("Team: " + i); 
					for (int j = 0; j < Data.get(i).MatchSize(); j++)
					{
						Match curr = Data.get(i).getMatch(j); // Grabs the requested team and match
						writer.println("\tMatch: " + (j + 1));
						writer.println("\t\tAuto Gear: " + curr.getAutoGear());
						writer.println("\t\tAuto Gear Position: " + curr.getAutoGearPos());
						writer.println("\t\tAuto Baseline: " + curr.getAutoBase());
						writer.println("\t\tAuto Low Goal: " + curr.getAutoLow());
						writer.println("\t\tAuto High Goal: " + curr.getAutoHigh());
						writer.println("\t\tAuto Hopper: " + curr.getAutoHopper());
						writer.println("\t\tLow Goal: " + curr.getLow());
						writer.println("\t\tHigh Goal: " + curr.getHigh());
						writer.println("\t\tGear: " + curr.getGear());
						writer.println("\t\tCycle Time: " + curr.getCycleTime());
						writer.println("\t\tClear Time: " + curr.getClearTime());
						writer.println("\t\tClimb: " + curr.getClimb());
						writer.println("\t\tSurvival: " + curr.getSurvived());
						writer.println("\t\tQuality: " + curr.getQuality());
						writer.println("\t\tStrategic: " + curr.getStrategy());
						writer.println("\t\tDrivers: " + curr.getDriver());
						writer.println("\t\tComments: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());
						
					}
					for (int j = 0; j < Data.get(i).PitSize(); j++)
					{
						Pit curr = Data.get(i).getPit(j); // Grabs the requested team and pit
						writer.println("\tPit: " + (j + 1));
						writer.println("\t\tAuto Gear: " + curr.getAutoGear());
						writer.println("\t\tAuto Baseline: " + curr.getAutoHigh());
						writer.println("\t\tAuto Low Goal: " + curr.getAutoLow());
						writer.println("\t\tAuto Hopper: " + curr.getAutoHopper());
						writer.println("\t\tGear: " + curr.getGear());
						writer.println("\t\tLow Goal: " + curr.getLow());
						writer.println("\t\tHigh Goal: " + curr.getHigh());
						writer.println("\t\tRobot Speed: " + curr.getRoboSpeed());
						writer.println("\t\tShoot Speed: " + curr.getShootSpeed());
						writer.println("\t\tAccuracy: " + curr.getAcc());
						writer.println("\t\tClimb: " + curr.getClimb());
						writer.println("\t\tClimbSpeed: " + curr.getClimbSpeed());
						writer.println("\t\tEnding Strategy: " + curr.getEndStrategy());
						writer.println("\t\tStrategy: " + curr.getStrategy());
						writer.println("\t\tIdeal Allies: " + curr.getIdealAlly());
						writer.println("\t\tBall Capacity: " + curr.getCapacity());
						writer.println("\t\tField Usage: " + curr.getFieldUsage());
						writer.println("\t\tScouter: " + curr.getScouter());
						writer.println("\t\tComments: " + curr.getComment());
					}
				}
			}
			writer.close();
		} catch (FileNotFoundException e)
		{ // If the file fails to save
			txtOut.setText("Error writing to file");
		}
	}

	// GUI Stuff
	// Most of it is unimportant
	
	// Starts the GUI
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI1 window = new GUI1();
					window.frmMain.setVisible(true);
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public GUI1()
	{
		initialize();
	}
	
	// When program closes, it saves to file before closing just in case
	private int close()
	{
		outData();
		return JFrame.EXIT_ON_CLOSE;
	}
	
	// When the app starts
	private void initialize()
	{
		for (int i = 0; i < 10000; i++) // Fills the arraylist full of nulls to give it size
			Data.add(null);
		getData(); // Grabs the data file and adds it to the team arraylist
		frmMain = new JFrame();
		frmMain.setTitle("Scouting Decoder");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 1146, 850);
		frmMain.setDefaultCloseOperation(close());
		frmMain.getContentPane().setLayout(null);
		
		// Enters values and saves to a file
		JButton btnSave = new JButton("Enter/Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> decoded = new ArrayList<String>();
				String input;
				int index;
				input = txtInput.getText(); // Grabs input text from top
				try
				{
					Match nMatch = new Match();
					Pit nPit = new Pit();
					decoded = decode(input);
					index = Integer.parseInt(decoded.get(0));
					if (decoded.get(2).equals("true") || decoded.get(2).equals("false")) // Tell apart if it is pit or match
					{
						nPit.setData(decoded);
						rawData += "]" + input; // Adds input data to rawData
						if (Data.size() == 0 || Data.get(index) == null) // Creates new team if there is no team/no data
						{ // Adding pit data
							Team nTeam = new Team();
							nTeam.addPit(nPit);
							Data.set(index, nTeam);
						} else // Adds data to existing teams
						{ 
							Team tTeam = Data.get(index);
							tTeam.addPit(nPit);
							Data.set(index, tTeam);
						}
						txtOut.setText("Added Pit Data");
					} else
					{ // Adding match data
						nMatch.setData(decoded);
						rawData += "]" + input;
						if (Data.size() == 0 || Data.get(index) == null) // Creates new team if there is no team/no data
						{
							Team nTeam = new Team();
							nTeam.addMatch(nMatch);
							Data.set(index, nTeam);
						} else
						{
							Team tTeam = Data.get(index);
							tTeam.addMatch(nMatch);
							Data.set(index, tTeam);
						}
						txtOut.setText("Added Match Data");
					}
				}
				catch (Exception error) // Wrong input
				{
					txtOut.setText("error");
				}
			txtInput.setText("");
			outData();
			//txtOut.setText(txtOut.getText() + rawData);
			}
		});
		btnSave.setBounds(496, 75, 123, 49);
		frmMain.getContentPane().add(btnSave);
		
		// Exit button that also saves
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			outData(); // Saves to data.txt
			frmMain.dispose();
		}});
		btnExit.setBounds(12,777,97,25);
		frmMain.getContentPane().add(btnExit);
		
		//Sorting Stuff
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (txtSortFrom.getText().equals("Pit")) {
					sortByPit(txtSortBy.getText());
				} else if (txtSortFrom.getText().equals("Match")) {
					sortByMatch(txtSortBy.getText());
				} else {
					txtOut.setText("ERROR: Please re check your \"Sort By\" parameters. Make sure the first letter of every word is capitalized.");
				}
			}});
		btnSort.setBounds(12,700,97,25);
		frmMain.getContentPane().add(btnSort);
		
		txtSortFrom = new JTextField();
		txtSortFrom.setToolTipText("Sort From Pit/Match");
		txtSortFrom.setBounds(115,700,97,25);
		frmMain.getContentPane().add(txtSortFrom);
		
		txtSortBy = new JTextField();
		txtSortBy.setToolTipText("Sort By");
		txtSortBy.setBounds(221,700,97,25);
		frmMain.getContentPane().add(txtSortBy);
		
		// Unimportant GUI stuff
		txtInput = new JTextField();
		txtInput.setToolTipText("Input");
		txtInput.setBounds(12,13,1104,49);
		frmMain.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		txtOut = new JTextArea();
		txtOut.setEditable(false);
		txtOut.setBounds(24,137,1104,539);
		frmMain.getContentPane().add(txtOut);
		txtTeam = new JTextField();
		txtTeam.setToolTipText("Insert Team # In Here");
		txtTeam.setBounds(856,704,116,22);
		frmMain.getContentPane().add(txtTeam);
		txtTeam.setColumns(10);
		txtMatch = new JTextField();
		txtMatch.setToolTipText("Insert Match");
		txtMatch.setBounds(856,739,116,22);
		frmMain.getContentPane().add(txtMatch);
		txtMatch.setColumns(10);
		txtData = new JTextField();
		txtData.setToolTipText("Insert which data you want (add \"avg\" or type \"all\" for all data)");
		txtData.setBounds(856,778,116,22);
		frmMain.getContentPane().add(txtData);
		txtData.setColumns(10);
		JRadioButton btnPit = new JRadioButton("Pit Data");
		btnPit.setHorizontalAlignment(SwingConstants.TRAILING);
		btnPit.setBounds(694, 738, 127, 25);
		frmMain.getContentPane().add(btnPit);
	
		// Outputs data to UI
		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if (btnPit.isSelected()) // If pit radio button is selected, user is looking for pit data instead of match
				{
					int teamI = Integer.parseInt(txtTeam.getText());
					int pitI = Integer.parseInt(txtMatch.getText());
					Team team = Data.get(teamI);
					Pit curr = team.getPit(pitI - 1); // Grabs the requested team and pit
					txtOut.setText(txtOut.getText() + "\nAuto Gear: " + curr.getAutoGear());
					txtOut.setText(txtOut.getText() + "\nAuto High Goal: " + curr.getAutoHigh());
					txtOut.setText(txtOut.getText() + "\nAuto Low Goal: " + curr.getAutoLow());
					txtOut.setText(txtOut.getText() + "\nAuto Hopper: " + curr.getAutoHopper());
					txtOut.setText(txtOut.getText() + "\nGear: " + curr.getGear());
					txtOut.setText(txtOut.getText() + "\nLow Goal: " + curr.getLow());
					txtOut.setText(txtOut.getText() + "\nHigh Goal: " + curr.getHigh());
					txtOut.setText(txtOut.getText() + "\nRobot Speed: " + curr.getRoboSpeed());
					txtOut.setText(txtOut.getText() + "\nShoot Speed: " + curr.getShootSpeed());
					txtOut.setText(txtOut.getText() + "\nAccuracy: " + curr.getAcc());
					txtOut.setText(txtOut.getText() + "\nClimb: " + curr.getClimb());
					txtOut.setText(txtOut.getText() + "\nClimbing Speed: " + curr.getClimbSpeed());
					txtOut.setText(txtOut.getText() + "\nEnding Strategy: " + curr.getEndStrategy());
					txtOut.setText(txtOut.getText() + "\nStrategy: " + curr.getStrategy());
					txtOut.setText(txtOut.getText() + "\nIdeal Allies: " + curr.getIdealAlly());
					txtOut.setText(txtOut.getText() + "\nBall Capacity: " + curr.getCapacity());
					txtOut.setText(txtOut.getText() + "\nField Usage: " + curr.getFieldUsage());
					txtOut.setText(txtOut.getText() + "\nScouter: " + curr.getScouter());
					txtOut.setText(txtOut.getText() + "\nComments: " + curr.getComment());
				} else 
				{ // Else user is looking for match data, outputs match data
					int teamI = Integer.parseInt(txtTeam.getText());
					int matchI = Integer.parseInt(txtMatch.getText());
					String dataI = txtData.getText();
					Team team = Data.get(teamI);
					Match curr = team.getMatch(matchI - 1); // Grabs the requested team and match
					switch(dataI)
					{
						case "":
						case "all":
							txtOut.setText(txtOut.getText() + "\nAuto Gear: " + curr.getAutoGear());
							txtOut.setText(txtOut.getText() + "\nAuto Gear Position" + curr.getAutoGearPos());
							txtOut.setText(txtOut.getText() + "\nAuto Base: " + curr.getAutoBase());
							txtOut.setText(txtOut.getText() + "\nAuto Low Goal: " + curr.getAutoLow());
							txtOut.setText(txtOut.getText() + "\nAuto High Goal: " + curr.getAutoHigh());
							txtOut.setText(txtOut.getText() + "\nAuto Hopper: " + curr.getAutoHopper());
							txtOut.setText(txtOut.getText() + "\nLow Goal: " + curr.getLow());
							txtOut.setText(txtOut.getText() + "\nHigh Goal: " + curr.getHigh());
							txtOut.setText(txtOut.getText() + "\nGear: " + curr.getGear());
							txtOut.setText(txtOut.getText() + "\nCycle Time: " + curr.getCycleTime());
							txtOut.setText(txtOut.getText() + "\nClear Time: " + curr.getClearTime());
							txtOut.setText(txtOut.getText() + "\nClimb: " + curr.getClimb());
							txtOut.setText(txtOut.getText() + "\nSurvived: " + curr.getSurvived());
							txtOut.setText(txtOut.getText() + "\nQuality: " + curr.getQuality());
							txtOut.setText(txtOut.getText() + "\nStrategic: " + curr.getStrategy());
							txtOut.setText(txtOut.getText() + "\nDriver: " + curr.getDriver());
							txtOut.setText(txtOut.getText() + "\nComments: " + curr.getComment());
							txtOut.setText(txtOut.getText() + "\nScouter: " + curr.getScouter());						
							break;
						case "auto gear":
							txtOut.setText("Auto Gear: " + curr.getAutoGear());
							break;
						case "auto gearpos":
							txtOut.setText("Auto Gear Position: " + curr.getAutoGearPos());
						case "auto base":
							txtOut.setText("Auto Base: " + curr.getAutoBase());
							break;
						case "auto low goal":
							txtOut.setText("Auto Low Goal: " + curr.getAutoLow());
							break;
						case "auto high goal":
							txtOut.setText("Auto High Goal: " + curr.getAutoHigh());
							break;
						case "auto hopper":
							txtOut.setText("Auto Hopper: " + curr.getAutoHopper());
							break;
						case "low goal":
							txtOut.setText("Low Goal: " + curr.getLow());
							break;
						case "high goal":
							txtOut.setText("High Goal: " + curr.getHigh());
							break;
						case "gear":
							txtOut.setText("Gear: " + curr.getGear());
							break;
						case "clear":
							txtOut.setText("Clear Time: " + curr.getClearTime());
							break;
						case "climb":
							txtOut.setText("Cycle Time: " + curr.getCycleTime());
							break;
						case "survived":
							txtOut.setText("Survived: " + curr.getSurvived());
							break;
						case "quality":
							txtOut.setText("Quality: " + curr.getQuality());
							break;
						case "strategy":
							txtOut.setText("Strategy: " + curr.getStrategy());
							break;
						case "driver":
							txtOut.setText("Driver: " + curr.getDriver());
							break;
						case "comment":
							txtOut.setText("Comment: " + curr.getComment());
							break;
						case "scouter":
							txtOut.setText("Scouter: " + curr.getScouter());
							break;
					}
				}
			} catch (Exception error) {txtOut.setText("invalid input");}
		}});
		btnFind.setBounds(1019,738,97,25);
		frmMain.getContentPane().add(btnFind);
	
		// Finds the file
		JButton btnFindFile = new JButton("Find File");
		btnFindFile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			boolean workaround = true;
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) // Shows user file chooser 
			{
				File file = fc.getSelectedFile(); // Sets file to the file that the user selected
				try
				{
					Scanner inputFile = new Scanner(file);
					while(inputFile.hasNext()) // Does until there is no more data
					{
						ArrayList<String> decoded = new ArrayList<String>();
						String input;
						int index;
						input = inputFile.next(); // Grabs string from file
						if(!input.split("}")[2].equals("true") || !input.split("}")[2].equals("false")) // Accounts for the new line bug error in scouting app 
							if (workaround)
							{
								inputFile.next();
								workaround = false;
							}
							input += inputFile.next();
							if (inputFile.hasNext())
								inputFile.next();
						if (input.startsWith("\uFEFF")) { // Workaround for UTF-8 BOM encoding 
					        input = input.substring(1);
					    }
						System.out.println(input);
						try
						{
							Match nMatch = new Match();
							Pit nPit = new Pit();
							decoded = decode(input);
							index = Integer.parseInt(decoded.get(0));
							if (decoded.get(2).equals("true") || decoded.get(2).equals("false")) // Tell apart if it is pit or match
							{ // Pit data
								nPit.setData(decoded);
								rawData += "]" + input;
								if (Data.size() == 0 || Data.get(index) == null) // Creates a new team if there is no team/no data
								{
									Team nTeam = new Team();
									nTeam.addPit(nPit);
									Data.set(index, nTeam);
								} else // Adds data to existing team
								{
									Team tTeam = Data.get(index);
									tTeam.addPit(nPit);
									Data.set(index, tTeam);
								}
								txtOut.setText("Added Pit Data");
							} else
							{ // Match data
								nMatch.setData(decoded);
								rawData += "]" + input;
								if (Data.size() == 0 || Data.get(index) == null) // Creates a new team if there is no team/no data
								{ 
									Team nTeam = new Team();
									nTeam.addMatch(nMatch);
									Data.set(index, nTeam);
								} else // Adds data to existing team
								{
									Team tTeam = Data.get(index);
									tTeam.addMatch(nMatch);
									Data.set(index, tTeam);
								}
								txtOut.setText("Added Match Data");
							}
						}
						catch (Exception error) // File is wrong or formating is wrong
						{ 
							txtOut.setText("Invalid Input");
						}
					outData();
					}
					inputFile.close();
				} catch (FileNotFoundException e1){}
				
			}
		}
		});
		btnFindFile.setBounds(424, 738, 97, 25);
		frmMain.getContentPane().add(btnFindFile);
	}	
}
