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

public class GUI1
{
	private static String rawData = "";
	private static ArrayList<Team> Data = new ArrayList<Team>();

	private static void getData()
	{
		/*
		ArrayList<String> decoded = new ArrayList<String>();
		try
		{
			
			rawData += fScan.nextLine();
			txtOut.setText(rawData);
			String[] d = rawData.split("]");
			for (int i = 1; i < d.length; i++)
			{
				Match nMatch = new Match();
				decoded = decode(d[i]);
				int index = Integer.parseInt(decoded.get(0));
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
			fScan.close();
			outData();
		} catch (Exception e) {}*/
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
			catch (FileNotFoundException e1)
			{}
			//catch (Exception error)
			//{}
			outData();
		}

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
						writer.println("\t\tAuto High Goals: " + curr.getAutoHighGoals());
						writer.println("\t\tAuto Low Goals: " + curr.getAutoLowGoals());
						if (curr.getAutoPort() != -1)
							writer.println("\t\tAuto Port: " + curr.getAutoPort());
						if (curr.getAutoCDF() != -1)
							writer.println("\t\tAuto CDF: " + curr.getAutoCDF());
						if (curr.getAutoRamp() != -1)
							writer.println("\t\tAuto Ramp: " + curr.getAutoRamp());
						if (curr.getAutoMoat() != -1)
							writer.println("\t\tAuto Moat: " + curr.getAutoMoat());
						if (curr.getAutoDraw() != -1)
							writer.println("\t\tAuto Draw: " + curr.getAutoDraw());
						if (curr.getAutoSally() != -1)
							writer.println("\t\tAuto Sally: " + curr.getAutoSally());
						if (curr.getAutoRock() != -1)
							writer.println("\t\tAuto Rock: " + curr.getAutoRock());
						if (curr.getAutoRough() != -1)
							writer.println("\t\tAuto Rough: " + curr.getAutoRough());
						if (curr.getAutoLowBar() != -1)
							writer.println("\t\tAuto Low Bar: " + curr.getAutoLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						if (curr.getPort() != -1)
							writer.println("\t\tPort: " + curr.getPort());
						if (curr.getCDF() != -1)
							writer.println("\t\tCDF: " + curr.getCDF());
						if (curr.getRamp() != -1)
							writer.println("\t\tRamp: " + curr.getRamp());
						if (curr.getMoat() != -1)
							writer.println("\t\tMoat: " + curr.getMoat());
						if (curr.getDraw() != -1)
							writer.println("\t\tDraw: " + curr.getDraw());
						if (curr.getSally() != -1)
							writer.println("\t\tSally: " + curr.getSally());
						if (curr.getRock() != -1)
							writer.println("\t\tRock: " + curr.getRock());
						if (curr.getRough() != -1)
							writer.println("\t\tRough: " + curr.getRough());
						if (curr.getLowBar() != -1)
							writer.println("\t\tLow Bar: " + curr.getLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tScale: " + curr.getScaled());
						writer.println("\t\tSurround: " + curr.getSurround());
						writer.println("\t\tComment: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());
						double SP = ((curr.getHighGoals() + 0.4 * curr.getLowGoals())
								/ (curr.getHighGoals() + curr.getLowGoals() + curr.getMisses()));
						writer.println("\t\tShot %: " + SP * 100 + "%");
					}
					for (int j = 0; j < Data.get(i).PitSize(); j++)
					{
						Pit curr = Data.get(i).getPit(j);
						writer.println("\tPit: " + (j + 1));
						writer.println("\t\tAuto High Goals: " + curr.getAutoHighGoals());
						writer.println("\t\tAuto Low Goals: " + curr.getAutoLowGoals());
						writer.println("\t\tAuto Port: " + curr.getAutoPort());
						writer.println("\t\tAuto CDF: " + curr.getAutoCDF());
						writer.println("\t\tAuto Ramp: " + curr.getAutoRamp());
						writer.println("\t\tAuto Moat: " + curr.getAutoMoat());
						writer.println("\t\tAuto Draw: " + curr.getAutoDraw());
						writer.println("\t\tAuto Sally: " + curr.getAutoSally());
						writer.println("\t\tAuto Rock: " + curr.getAutoRock());
						writer.println("\t\tAuto Rough: " + curr.getAutoRough());
						writer.println("\t\tAuto Low Bar: " + curr.getAutoLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tPort: " + curr.getPort());
						writer.println("\t\tCDF: " + curr.getCDF());
						writer.println("\t\tRamp: " + curr.getRamp());
						writer.println("\t\tMoat: " + curr.getMoat());
						writer.println("\t\tDraw: " + curr.getDraw());
						writer.println("\t\tSally: " + curr.getSally());
						writer.println("\t\tRock: " + curr.getRock());
						writer.println("\t\tRough: " + curr.getRough());
						writer.println("\t\tLow Bar: " + curr.getLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tScale: " + curr.getScaled());
						writer.println("\t\tSurround: " + curr.getSurround());
						writer.println("\t\tComment: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());
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

	btnFind = new JButton("Find");
	btnFind.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int teamI = Integer.parseInt(txtTeam.getText());
				int matchI = Integer.parseInt(txtMatch.getText());
				String dataI = txtData.getText();
				Team team = Data.get(teamI);
				Match curr = team.getMatch(matchI - 1);
				switch(dataI)
				{
					case "all":
						double SP = ((curr.getHighGoals() + 0.4 * curr.getLowGoals()) / (curr.getHighGoals() + curr.getLowGoals() + curr.getMisses()));
						txtOut.setText("Auto High Goals: " + curr.getAutoHighGoals() + "\nAuto Low Goals: " + curr.getAutoLowGoals());
						if (curr.getAutoPort() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Port: " + curr.getAutoPort());
						if (curr.getAutoCDF() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto CDF: " + curr.getAutoCDF());
						if (curr.getAutoRamp() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Ramp: " + curr.getAutoRamp());
						if (curr.getAutoMoat() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Moat: " + curr.getAutoMoat());
						if (curr.getAutoDraw() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Draw: " + curr.getAutoDraw());
						if (curr.getAutoSally() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Sally: " + curr.getAutoSally());
						if (curr.getAutoRock() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Rock: " + curr.getAutoRock());
						if (curr.getAutoRough() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Rough: " + curr.getAutoRough());
						if (curr.getAutoLowBar() != -1)
							txtOut.setText(txtOut.getText() + "\nAuto Low Bar: " + curr.getAutoLowBar());
						if (curr.getPort() != -1)
							txtOut.setText(txtOut.getText() + "\nPort: " + curr.getPort());
						if (curr.getCDF() != -1)
							txtOut.setText(txtOut.getText() + "\nCDF: " + curr.getCDF());
						if (curr.getRamp() != -1)
							txtOut.setText(txtOut.getText() + "\nRamp: " + curr.getRamp());
						if (curr.getMoat() != -1)
							txtOut.setText(txtOut.getText() + "\nMoat: " + curr.getMoat());
						if (curr.getDraw() != -1)
							txtOut.setText(txtOut.getText() + "\nDraw: " + curr.getDraw());
						if (curr.getSally() != -1)
							txtOut.setText(txtOut.getText() + "\nSally: " + curr.getSally());
						if (curr.getRock() != -1)
							txtOut.setText(txtOut.getText() + "\nRock: " + curr.getRock());
						if (curr.getRough() != -1)
							txtOut.setText(txtOut.getText() + "\nRough: " + curr.getRough());
						if (curr.getLowBar() != -1)
							txtOut.setText(txtOut.getText() + "\nLow Bar: " + curr.getLowBar());
						txtOut.setText(txtOut.getText() + "\nHigh Goals: " + curr.getHighGoals() + "\nLow Goals: " + curr.getLowGoals() + 
								"\nScale: " + curr.getScaled() + "\nSurround: " + curr.getSurround() + "\nComment: " + curr.getComment() +
								"\nScouter: " + curr.getScouter() + "\nShot %: " + SP * 100 + "%");	
						break;
					case "auto high goal":
						txtOut.setText("Auto High Goals: " + curr.getAutoHighGoals());
						break;
					case "auto low goal":
						txtOut.setText("Auto Low Goals: " + curr.getAutoLowGoals());
						break;
					case "auto port":
						if (curr.getAutoPort() != -1)
							txtOut.setText("Auto Port: " + curr.getAutoPort());
						break;
					case "auto cdf":
						if (curr.getAutoCDF() != -1)
							txtOut.setText("Auto CDF: " + curr.getAutoCDF());
						break;
					case "auto ramp":
						if (curr.getAutoRamp() != -1)
							txtOut.setText("Auto Ramp: " + curr.getAutoRamp());
						break;
					case "auto moat":
						if (curr.getAutoMoat() != -1)
							txtOut.setText("Auto Moat: " + curr.getAutoMoat());
						break;
					case "auto draw":
						if (curr.getAutoDraw() != -1)
							txtOut.setText("Auto Draw: " + curr.getAutoDraw());
						break;
					case "auto sally":
						if (curr.getAutoSally() != -1)
							txtOut.setText("Auto Sally: " + curr.getAutoSally());
						break;
					case "auto rock":
						if (curr.getAutoRock() != -1)
							txtOut.setText("Auto Rock: " + curr.getAutoRock());
						break;
					case "auto rough":
						if (curr.getAutoRough() != -1)
							txtOut.setText("Auto Rough: " + curr.getAutoRough());
						break;
					case "auto lowbar":
						if (curr.getAutoLowBar() != -1)
							txtOut.setText("Auto Low Bar: " + curr.getAutoLowBar());
						break;
					case "port":
						if (curr.getPort() != -1)
							txtOut.setText("Port: " + curr.getPort());
						break;
					case "cdf":
						if (curr.getCDF() != -1)
							txtOut.setText("CDF: " + curr.getCDF());
						break;
					case "ramp":
						if (curr.getRamp() != -1)
							txtOut.setText("Ramp: " + curr.getRamp());
						break;
					case "moat":
						if (curr.getMoat() != -1)
							txtOut.setText("Moat: " + curr.getMoat());
						break;
					case "draw":
						if (curr.getDraw() != -1)
							txtOut.setText("Draw: " + curr.getDraw());
						break;
					case "sally":
						if (curr.getSally() != -1)
							txtOut.setText("Sally: " + curr.getSally());
						break;
					case "rock":
						if (curr.getRock() != -1)
							txtOut.setText("Rock: " + curr.getRock());
						break;
					case "rough":
						if (curr.getRough() != -1)
							txtOut.setText("Rough: " + curr.getRough());
						break;
					case "lowbar":
						if (curr.getLowBar() != -1)
							txtOut.setText("Low Bar: " + curr.getLowBar());
						break;
					case "high goals":
						txtOut.setText("High Goals: " + curr.getHighGoals());
						break;
					case "low goals":
						txtOut.setText("Low Goals: " + curr.getLowGoals());
						break;
					case "scale":
						txtOut.setText("Scale: " + curr.getScaled());
						break;
					case "surround":
						txtOut.setText("Surround: " + curr.getSurround());
						break;
					case "sp":
						SP = ((curr.getHighGoals() + 0.4 * curr.getLowGoals()) / (curr.getHighGoals() + curr.getLowGoals() + curr.getMisses()));
						txtOut.setText("Shot Percentage: " + SP + "%");
						break;
				}

			} catch (Exception error) {txtOut.setText("invalid input");}
	}});
	btnFind.setBounds(1019,738,97,25);
	frmMain.getContentPane().add(btnFind);
	
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
