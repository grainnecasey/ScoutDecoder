/* --------------------------------------------------------------------------
 * Scouting Decoder
 * --------------------------------------------------------------------------
 * Changelog: 
 * 1/14/2017 - Conversion to 2017 game, pit find data, and bug fixing
 * --------------------------------------------------------------------------
 * Bugs:
 * 1/14/2017 - Nothing
 * --------------------------------------------------------------------------
 * Planned Features:
 * • Make it look nicer
 * --------------------------------------------------------------------------
 * Notes:
 * 1/14/2017 - Started commenting
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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

public class GUI1
{
	private static String rawData = "";
	private static ArrayList<Team> Data = new ArrayList<Team>();
	
	// Grabs saved data
	private static void getData()
	{
			ArrayList<String> decoded = new ArrayList<String>();
			int index;
			Scanner fScan;
			try
			{
				fScan = new Scanner(new File("data.txt"));
				Match nMatch = new Match();
				Pit nPit = new Pit();
				rawData += fScan.nextLine();
				String[] d = rawData.split("]");
				for (int i = 1; i < d.length; i++)
				{
					decoded = decode(d[i]);
					index = Integer.parseInt(decoded.get(0));
					if (decoded.get(1).equals("true") || decoded.get(1).equals("false")) // Tell apart if it is pit or match
					{
						nPit.setData(decoded);
						if (Data.size() == 0 || Data.get(index) == null)
						{
							Team nTeam = new Team();
							nTeam.addPit(nPit);
							Data.set(index, nTeam);
						} else
						{
							Team tTeam = Data.get(index);
							tTeam.addPit(nPit);
							Data.set(index, tTeam);
						}	
					} else
					{
						nMatch.setData(decoded);
						if (Data.size() == 0 || Data.get(index) == null)
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
					}
				}
				
			}
			//catch (FileNotFoundException e1)
			//{}
			catch (Exception error)
			{}
			outData();
		}

	// Decodes the input
	private static ArrayList<String> decode(String in)
	{
		String[] decode = in.split("}");
		ArrayList<String> decoded = new ArrayList<String>();
		for (int i = 0; i < decode.length; i++)
		{
			decoded.add(decode[i]);
		}
		return decoded;
	}

	// Saves the data
	private static void outData()
	{
		PrintWriter writer;
		try
		{
			writer = new PrintWriter("data.txt");
			writer.println(rawData);
			for (int i = 0; i < Data.size(); i++)
			{
				if (Data.get(i) != null)
				{
					writer.println("Team: " + i);
					for (int j = 0; j < Data.get(i).MatchSize(); j++)
					{
						Match curr = Data.get(i).getMatch(j);
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
						Pit curr = Data.get(i).getPit(j);
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
		{
			txtOut.setText("Error writing to file");
		}
	}

	// GUI Stuff
	private JFrame frmMain;
	private JTextField txtInput;
	private JTextField txtTeam;
	private JTextField txtMatch;
	private JTextField txtData;
	private static JTextArea txtOut;
	private JButton btnFind;

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
	private int close()
	{
		outData();
		return JFrame.EXIT_ON_CLOSE;
	}
	private void initialize()
	{
		for (int i = 0; i < 10000; i++)
			Data.add(null);
		getData();
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
				input = txtInput.getText();
				try
				{
					Match nMatch = new Match();
					Pit nPit = new Pit();
					decoded = decode(input);
					index = Integer.parseInt(decoded.get(0));
					if (decoded.get(1).equals("true") || decoded.get(1).equals("false")) // Tell apart if it is pit or match
					{
						nPit.setData(decoded);
						rawData += "]" + input;
						if (Data.size() == 0 || Data.get(index) == null)
						{
							Team nTeam = new Team();
							nTeam.addPit(nPit);
							Data.set(index, nTeam);
						} else
						{
							Team tTeam = Data.get(index);
							tTeam.addPit(nPit);
							Data.set(index, tTeam);
						}
						txtOut.setText("Added Pit Data");
					} else
					{
						nMatch.setData(decoded);
						rawData += "]" + input;
						if (Data.size() == 0 || Data.get(index) == null)
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
				catch (Exception error)
				{
					//txtOut.setText("error");
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
		outData();
		frmMain.dispose();
	}});
		btnExit.setBounds(12,777,97,25);
		frmMain.getContentPane().add(btnExit);
		
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
				if (btnPit.isSelected())
				{
					int teamI = Integer.parseInt(txtTeam.getText());
					int pitI = Integer.parseInt(txtMatch.getText());
					Team team = Data.get(teamI);
					Pit curr = team.getPit(pitI - 1);
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
				} else {
					int teamI = Integer.parseInt(txtTeam.getText());
					int matchI = Integer.parseInt(txtMatch.getText());
					String dataI = txtData.getText();
					Team team = Data.get(teamI);
					Match curr = team.getMatch(matchI - 1);
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
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				try
				{
					Scanner inputFile = new Scanner(file);
					while(inputFile.hasNext())
					{
						ArrayList<String> decoded = new ArrayList<String>();
						String input;
						int index;
						input = inputFile.next();
						try
						{
							Match nMatch = new Match();
							Pit nPit = new Pit();
							decoded = decode(input);
							index = Integer.parseInt(decoded.get(0));
							if (decoded.get(1).equals("true") || decoded.get(1).equals("false")) // Tell apart if it is pit or match
							{
								nPit.setData(decoded);
								rawData += "]" + input;
								if (Data.size() == 0 || Data.get(index) == null)
								{
									Team nTeam = new Team();
									nTeam.addPit(nPit);
									Data.set(index, nTeam);
								} else
								{
									Team tTeam = Data.get(index);
									tTeam.addPit(nPit);
									Data.set(index, tTeam);
								}
								txtOut.setText("Added Pit Data");
							} else
							{
								nMatch.setData(decoded);
								rawData += "]" + input;
								if (Data.size() == 0 || Data.get(index) == null)
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
						catch (Exception error)
						{ 
							txtOut.setText("Invalid Input");
						}
					txtInput.setText("");
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
