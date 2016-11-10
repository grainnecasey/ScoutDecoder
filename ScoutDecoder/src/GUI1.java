import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI1
{
	private static String rawData;
	private ArrayList<Team> Data = new ArrayList<Team>(10000);

	private ArrayList<Team> getData()
	{
		Scanner fScan;
		ArrayList<Team> Data = new ArrayList<Team>(10000);
		ArrayList<String> decoded = new ArrayList<String>();
		try
		{
			fScan = new Scanner(new File("data.txt"));
			rawData += fScan.nextLine();
			String[] d = rawData.split("○");
			for (int i = 0; i < 10000; i++)
				Data.add(null);
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
		} catch (Exception e) {}
		return Data;
	}

	private ArrayList<String> decode(String in)
	{
		String[] decode = in.split("•");
		ArrayList<String> decoded = new ArrayList<String>();
		for (int i = 0; i < decode.length; i++)
		{
			decoded.add(decode[i]);
		}
		return decoded;
	}

	private void outData()
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
	private JTextArea txtOut;
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
					rawData = "";
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

	private void initialize()
	{
		frmMain = new JFrame();
		frmMain.setTitle("Scouting Decoder");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 1146, 850);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		JButton btnSave = new JButton("Enter/Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> decoded = new ArrayList<String>();
				String input;
				int index;
				Data = getData();;
				for (int i = 0; i < 10000; i++)
					Data.add(null);
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
						rawData += "○" + input;
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
						rawData += "○" + input;
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
					Random r = new Random();
					switch (r.nextInt(5))
					{
					case 0:
						txtOut.setText("Invalid Beep Boop ur fucking dumb.");
						break;
					case 1:
						txtOut.setText("ITS NOT A PHASE DADDY PLEASE HARDER.");
						break;
					case 2:
						txtOut.setText("FEELSFUCKINGHORRIBLEMAN WITH A FUCKING GUN.");
						break;
					case 3:
						txtOut.setText("Error.jpeg");
						break;
					case 4:
						txtOut.setText("Jimmy loves big fat black potatoes.");
					}
				}
			txtInput.setText("");
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

	txtInput=new JTextField();
	txtInput.setToolTipText("Input");
	txtInput.setBounds(12,13,1104,49);
	frmMain.getContentPane().add(txtInput);
	txtInput.setColumns(10);

	txtOut = new JTextArea();
	txtOut.setBounds(24,137,1104,539);
	frmMain.getContentPane().add(txtOut);

	txtTeam=new JTextField();
	txtTeam.setToolTipText("Insert Team # In Here");
	txtTeam.setBounds(856,704,116,22);
	frmMain.getContentPane().add(txtTeam);
	txtTeam.setColumns(10);

	txtMatch=new JTextField();
	txtMatch.setToolTipText("Insert Match # (or use all)");
	txtMatch.setBounds(856,739,116,22);
	frmMain.getContentPane().add(txtMatch);
	txtMatch.setColumns(10);

	txtData=new JTextField();
	txtData.setToolTipText("Insert which data you want (add \"avg\" or type \"all\" for all data)");
	txtData.setBounds(856,778,116,22);
	frmMain.getContentPane().add(txtData);
	txtData.setColumns(10);

	btnFind = new JButton("Find");
	btnFind.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String team = txtTeam.getText();
			String match = txtMatch.getText();
			String data = txtData.getText();
	}});
	btnFind.setBounds(1019,738,97,25);
	frmMain.getContentPane().add(btnFind);
}}
